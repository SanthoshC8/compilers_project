grammar PL;

@header {
import backend.*;

}


@members {
}



program returns [Expr expr]
    : {List<Expr> statements = new ArrayList<Expr>();}
    (statement {statements.add($statement.statementExpr);})+ EOF
    { $expr = new Block(statements); } 
    ;
    

statement returns [Expr statementExpr]
    : assignment ';'? { $statementExpr = $assignment.var; }
    | expression ';' { $statementExpr = $expression.exprValue; }
    | loop { $statementExpr = $loop.loopResult; }
    | funDef { $statementExpr = $funDef.funcResult; }
    | printStmt ';'? { $statementExpr = $printStmt.printExpr; } 
    ;
    
    
printStmt returns [Expr printExpr]
    : 'print' '(' expression ')' { $printExpr = new Print($expression.exprValue); }
    ;

assignment returns [Expr var]
    : 'let'? ID '=' expression {$var = new Assign($ID.text,$expression.exprValue);}
    ;

expression returns [Expr exprValue]
    : '(' expression ')' {  $exprValue = $expression.exprValue; }
    | e1= expression '+' e2=expression { $exprValue = new Arithmetic(Operator.Add, $e1.exprValue, $e2.exprValue);}
    | e1= expression '-' e2=expression { $exprValue = new Arithmetic(Operator.Sub, $e1.exprValue, $e2.exprValue);}
    | e1= expression '*' e2=expression { $exprValue = new Arithmetic(Operator.Mul, $e1.exprValue, $e2.exprValue);}
    | e1= expression '/' e2=expression { $exprValue = new Arithmetic(Operator.Div, $e1.exprValue, $e2.exprValue);}
    | e1= expression '++' e2=expression { $exprValue = new Arithmetic(Operator.Concat, $e1.exprValue, $e2.exprValue);}
    | funCall { $exprValue = $funCall.funCallExpr; }
    | ID { $exprValue = new Deref($ID.text); }
    | NUMERIC {$exprValue = new IntLiteral($NUMERIC.text); }
    | STRING {$exprValue = new StringLiteral($STRING.text); }
    | BOOLEAN {$exprValue = new BooleanLiteral($BOOLEAN.text); }
    ;


loop returns [Expr loopResult]
    : 'for' '(' ID ' in ' val1=NUMERIC DOTS val2=NUMERIC ')' '{' body+=statement* '}' 
        {
            List<Expr> loopBodyExprs = new ArrayList<>();
            for (int i = 0; i < $body.size(); i++) {
                loopBodyExprs.add($body.get(i).statementExpr);
            }
            Block loopBody = new Block(loopBodyExprs);

            $loopResult = new Loop($ID.text, new IntLiteral($val1.text), new IntLiteral($val2.text), loopBody);
        }
    ;
    

funDef returns [Expr funcResult]
    : 'function' ID '(' params ')' '{' body+=statement* '}' 
        {
            List<Expr> bodyExprs = new ArrayList<>();
            for (int i = 0; i < $body.size(); i++) {
                bodyExprs.add($body.get(i).statementExpr);
            }
            $funcResult = new Declare($ID.text, $params.paramList, new Block(bodyExprs));
        }
    ;


params returns [List<String> paramList]
    : param=ID (',' nextParam+=ID)* {
        $paramList = new ArrayList<>();
        $paramList.add($param.text);
        for (Token token : $nextParam) {
            $paramList.add(token.getText());
        }
    };

argList returns [List<Expr> argListExpr]
    : firstArg=expression { $argListExpr = new ArrayList<>(); $argListExpr.add($firstArg.exprValue); } (',' nextArg=expression { $argListExpr.add($nextArg.exprValue); })*
    ;
    
 
funCall returns [Expr funCallExpr]
    : ID '(' argList ')' { $funCallExpr = new Invoke($ID.text, $argList.argListExpr); }
    ; 
    
NUMERIC : ('0' .. '9')+ ;

STRING : '"' ('\\"' | ~'"' )* '"' ;

BOOLEAN : 'true' | 'false' ;

ID : ('a'..'z' | 'A' .. 'Z' | '_') ('a'..'z' | 'A' .. 'Z'| '0' .. '9' | '_')* ;

COMMENT : '/*' .*? '*/' -> skip;

WHITESPACE : (' ' | '\t' | '\r' | '\n')+ -> skip;

DOTS : '..';