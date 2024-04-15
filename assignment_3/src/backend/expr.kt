package backend

abstract class Expr {
    abstract fun eval(runtime:Runtime):Data
}

class NoneExpr(): Expr() {
    override fun eval(runtime:Runtime) = None
}


class While(val cond:Expr, val body:Expr): Expr() {
    override fun eval(runtime:Runtime): Data {
        var flag = cond.eval(runtime) as BooleanData
        var result:Data = None
        var iter:Int = 1_000_000
        while(flag.value) {
            result = body.eval(runtime)
            flag = cond.eval(runtime) as BooleanData
            if(iter == 0) {
                println("MAX_ITER reached")
                println(runtime)
                return None
            }
            iter --
        }
        return result
    }
}



class Assign(val symbol:String, val expr:Expr): Expr() {
    override fun eval(runtime:Runtime): Data {
 
    var assignval =  expr.eval(runtime).apply {
        runtime.symbolTable.put(symbol, this)
    }
    
    return assignval
    }
}

class Deref(val name:String): Expr() {
    override fun eval(runtime:Runtime):Data {
        val data = runtime.symbolTable[name]
        if(data == null) {
            throw Exception("$name is not assigned.")
        }
        return data
    }
}

class Invoke(val name:String, val args:List<Expr>):Expr() {
    override fun eval(runtime:Runtime):Data {
        val func:Data? = runtime.symbolTable[name]
        if(func == null) {
            throw Exception("$name does not exist")
        }
        if(func !is FuncData) {
            throw Exception("$name is not a function.")
        }
        if(func.params.size != args.size) {
            throw Exception(
                "$name expects ${func.params.size} arguments "
                + "but received ${args.size}"
            )
        }
        
        val r = runtime.subscope(
            func.params.zip(args.map {it.eval(runtime)}).toMap()
        )
        
        return func.body.eval(r)
    }
}

class Declare(
    val name: String,
    val params: List<String>,
    val body: Expr
): Expr() {
    override fun eval(runtime:Runtime):Data
    = FuncData(name, params, body).also {
        runtime.symbolTable[name] = it
    }
    
}




class Block(val exprList: List<Expr>): Expr() {
    override fun eval(runtime:Runtime): Data {
        var result:Data = None
        exprList.forEach {
            result = it.eval(runtime)
        }
        return result
    }
}


enum class Operator {
    Add,
    Sub,
    Mul,
    Div,
    Concat
}


class Arithmetic(
    val op:Operator,
    val left:Expr,
    val right:Expr
): Expr() {
    override fun eval(runtime:Runtime): Data {
        val x = left.eval(runtime)
        val y = right.eval(runtime)
        
        if (op == Operator.Concat) {
            if (x is StringData && y is StringData) {
                return StringData(x.value + y.value)
            } 
        }
        
        if (op == Operator.Mul && x is StringData && y is IntData) {
            return StringData(x.value.repeat(y.value))
        }
        
        if(x !is IntData || y !is IntData) {
            throw Exception("cannot handle non-integer")
        }
        return IntData(
            when(op) {
                Operator.Add -> x.value + y.value
                Operator.Sub -> x.value - y.value
                Operator.Mul -> x.value * y.value
                Operator.Div -> {
                    if(y.value != 0) {
                        x.value / y.value
                    } else {
                        throw Exception("cannot divide by zero")
                    }
                }
                else -> throw Exception("Unknown operator")
            }
        )
    }
}


enum class Comparator {
    LT,
    LE,
    GT,
    GE,
    EQ,
    NE,
}

class Compare(
    val comparator: Comparator,
    val left: Expr,
    val right: Expr
): Expr() {
    override fun eval(runtime:Runtime): Data {
        val x = left.eval(runtime)
        val y = right.eval(runtime)
        if(x is IntData && y is IntData) {
            return BooleanData(
                when(comparator) {
                    Comparator.LT -> x.value < y.value
                    Comparator.LE -> x.value <= y.value
                    Comparator.GT -> x.value > y.value
                    Comparator.GE -> x.value >= y.value
                    Comparator.EQ -> x.value == y.value
                    Comparator.NE -> x.value != y.value
                }
            )
        } else {
            throw Exception("Non-integer data in comparison")
        }
    }
}

class IntLiteral(val lexeme:String): Expr() {
    override fun eval(runtime:Runtime): Data
    = IntData(Integer.parseInt(lexeme))
}

class StringLiteral(val lexeme:String): Expr() {
    override fun eval(runtime:Runtime): Data {
        val stringValue = lexeme.substring(1, lexeme.length - 1)
        return StringData(stringValue)
    }
}

class BooleanLiteral(val lexeme:String): Expr() {
    override fun eval(runtime:Runtime): Data
    = BooleanData(lexeme.equals("true"))
}

class Print(val expr: Expr) : Expr() {
    override fun eval(runtime: Runtime): Data {
        val printvalue = expr.eval(runtime)
        println(printvalue)
        return None
    }
}


class Loop(
    val idName: String, 
    val minRange: Expr,
    val maxRange: Expr,
    val body: Expr
) : Expr() {
    override fun eval(runtime: Runtime): Data {
        var result: Data = IntData(0)
        val startValue = (minRange.eval(runtime) as IntData).value
        val endValue = (maxRange.eval(runtime) as IntData).value
        for (i in startValue..endValue) {
            runtime.symbolTable[idName] = IntData(i)
            result = body.eval(runtime)
        }
        
        return result
    }
}

class ArrayLiteral(val elements: List<Expr>) : Expr() {
    override fun eval(runtime: Runtime): Data {
        val evaluatedElements = elements.map { it.eval(runtime) }.toMutableList() 
        return ArrayData(evaluatedElements)
    }
}

class ArrayAppend(val arrayName: String, val element: Expr) : Expr() {
    override fun eval(runtime: Runtime): Data {
        val arrayData = runtime.symbolTable[arrayName] as? ArrayData
        if (arrayData != null) {
            val value = element.eval(runtime)
            arrayData.elements.add(value)
        } else {
            println("error")
        }
        return None
    }
}

class ArrayDelete(val arrayName: String, val value: Expr) : Expr() {
    override fun eval(runtime: Runtime): Data {
        val arrayData = runtime.symbolTable[arrayName] as? ArrayData
        if (arrayData != null) {
            val elementValue = value.eval(runtime)
            val index = when (elementValue) {
                is IntData -> arrayData.elements.indexOfFirst { it is IntData && it.value == elementValue.value }
                is StringData -> arrayData.elements.indexOfFirst { it is StringData && it.value == elementValue.value }
                else -> 0
            }

            if (index != -1) {
                arrayData.elements.removeAt(index)
            } else {
                println("error no value in array")
            }
        } else {
            println("error")
        }
        return None
        
    
    }
}


class TypeExpr(val expr: Expr) : Expr() {
    override fun eval(runtime: Runtime): Data {
        val result = expr.eval(runtime)
        return StringData(when (result) {
            is IntData -> "<class 'int'>"
            is StringData -> "<class 'string'>"
            is ArrayData -> "<class 'array'>"
            is BooleanData -> "<class 'boolean'>"
            else -> "<unknown class>"
        })
    }
}
