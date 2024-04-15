package backend

abstract class Data

object None:Data() {
    override fun toString() = "None"
}

class StringData(val value: String) : Data() {
    override fun toString(): String = value
}


class IntData(val value:Int): Data() {
    override fun toString(): String = "$value"
}


class BooleanData(val value:Boolean): Data() {
    override fun toString() = "$value"
}



class FuncData(
    val name: String,
    val params: List<String>,
    val body: Expr
): Data() {
    override fun toString()
    = params.joinToString(", ").let {
        "$name($it) { ... }"
    }
}


class ArrayData(val elements: MutableList<Data>) : Data() {
    override fun toString(): String = "$elements"
}

class TupleData(val elements: List<Data>) : Data() {
    override fun toString(): String{
        return elements.joinToString(separator = ", ", prefix = "(", postfix = ")") {
            it.toString()
        }
    }
}


class SetData(val elements: Set<Data>) : Data() {
    override fun toString(): String {
        return elements.joinToString(separator = ", ", prefix = "{", postfix = "}") {
            it.toString()
        }
    }
}





