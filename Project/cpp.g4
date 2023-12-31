grammar cpp;

@header {
    package antlr4;
    import java.util.HashMap;
    import intermediate.symtab.SymtabEntry;
    import intermediate.type.Typespec;
}

program           : programHeader block ;
programHeader     : DIR_INCLUDE '<' programIdentifier '>' ;

programParameters : '(' IDENTIFIER ( ',' IDENTIFIER )* ')' ;

programIdentifier   locals [ SymtabEntry entry = null ]
    : IDENTIFIER ;

intMain       : MAIN '(' ')' compoundStatement;
block         : declarations intMain ;
declarations  : ( constantsPart ';' )? ( typesPart ';' )?
              ( variablesPart ';' )? ( routinesPart )? ;

variablesPart            : variableDeclarationsList ;
variableDeclarationsList : variableDeclarations ( ';' variableDeclarations )* ;
variableDeclarations     : typeSpecification variableIdentifierList  ;
variableIdentifierList   : variableIdentifier ( ',' variableIdentifier )* ;

variableIdentifier  locals [ Typespec type = null, SymtabEntry entry = null ]
    : IDENTIFIER ;


constantsPart           : CONST constantDefinitionsList ;
constantDefinitionsList : constantDefinition ( ';' constantDefinition )* ;
constantDefinition      : constantIdentifier '=' constant ;

constantIdentifier  locals [ Typespec type = null, SymtabEntry entry = null ]
    : IDENTIFIER ;

constant            locals [ Typespec type = null, Object value = null ]
    : sign? ( IDENTIFIER | unsignedNumber )
    | characterConstant
    | stringConstant
    ;

sign : '-' | '+' ;

typesPart           : TYPE typeDefinitionsList ;
typeDefinitionsList : typeDefinition ( ';' typeDefinition )* ;
typeDefinition      : typeIdentifier '=' typeSpecification ;

typeIdentifier      locals [ Typespec type = null, SymtabEntry entry = null ]
    : IDENTIFIER ;

typeSpecification   locals [ Typespec type = null ]
    : simpleType        # simpleTypespec
    | arrayType         # arrayTypespec
    | recordType        # recordTypespec
    ;

simpleType          locals [ Typespec type = null ]
    : typeIdentifier    # typeIdentifierTypespec
    | enumerationType   # enumerationTypespec
    | subrangeType      # subrangeTypespec
    ;

enumerationType     : '(' enumerationConstant ( ',' enumerationConstant )* ')' ;
enumerationConstant : constantIdentifier ;
subrangeType        : constant '..' constant ;

arrayType
    : ARRAY '[' arrayDimensionList ']' OF typeSpecification ;
arrayDimensionList : simpleType ( ',' simpleType )* ;

recordType          locals [ SymtabEntry entry = null ]
    : RECORD recordFields ';'? END ;
recordFields : variableDeclarationsList ;

routinesPart      : routineDefinition (  routineDefinition)* ;
routineDefinition : ( procedureHead | functionHead ) '{' ( variablesPart ';' )? statementList? (returnStatement ';')? '}' ;
procedureHead     : PROCEDURE routineIdentifier '(' parameters? ')' ;
functionHead      : typeIdentifier routineIdentifier '(' parameters? ')' ;

returnStatement  : RETURN rhs ;

routineIdentifier   locals [ Typespec type = null, SymtabEntry entry = null ]
    : IDENTIFIER ;

parameters                : parameterDeclarationsList ;
parameterDeclarationsList : parameterDeclarations ( ',' parameterDeclarations )* ;
parameterDeclarations     : VAR? typeIdentifier parameterIdentifierList;
parameterIdentifierList   : parameterIdentifier  ;

parameterIdentifier   locals [ Typespec type = null, SymtabEntry entry = null ]
    : IDENTIFIER ;

statement : ( assignmentStatement
          | writeStatement
          | writelnStatement
          | readStatement
          | readlnStatement
          | procedureCallStatement
          | emptyStatement) ';'
          | compoundStatement
          | ifStatement
          | whileStatement
          | forStatement
          ;

compoundStatement : '{' statementList '}' ;
emptyStatement : ;

statementList       : statement ( statement )* ;
assignmentStatement : lhs '=' rhs ; //temp c++ version

lhs locals [ Typespec type = null ]
    : variable ;
rhs : expression ;

ifStatement : IF '(' expression ')' trueStatement (ELSE falseStatement)? ;
trueStatement  : statement ;
falseStatement : statement ;

whileStatement : WHILE '(' expression ')' statement ;

forStatement : FOR '(' variableDeclarations '=' rhs ';' variable ( greaterOp | greaterEqOp
                       | lessOp | lessEqOp ) expression ';' variable ( incrementOp |
                       decrementOp ) ')' compoundStatement;
greaterOp   : '>'  ;
greaterEqOp : '>=' ;
lessOp      : '<'  ;
lessEqOp    : '<=' ;
incrementOp : '++' ;
decrementOp : '--' ;

procedureCallStatement : procedureName '(' argumentList? ')' ;

procedureName   locals [ SymtabEntry entry = null ]
    : IDENTIFIER ;

argumentList : argument ( ',' argument )* ;
argument     : expression ;

writeStatement   : COUT writeArguments;
writelnStatement : WRITELN writeArguments? ;
writeArguments   : '<<' writeArgument (',' writeArgument)* ;
writeArgument    : expression (':' fieldWidth)? ;
fieldWidth       : sign? intConstant (':' decimalPlaces)? ;
decimalPlaces    : intConstant ;

readStatement   : READ readArguments ;
readlnStatement : READLN readArguments ;
readArguments   : '(' variable ( ',' variable )* ')' ;

expression          locals [ Typespec type = null ]
    : simpleExpression (relOp simpleExpression)? ;

simpleExpression    locals [ Typespec type = null ]
    : sign? term (addOp term)* ;

term                locals [ Typespec type = null ]
    : factor (mulOp factor)* ;

factor              locals [ Typespec type = null ]
    : variable             # variableFactor
    | number               # numberFactor
    | characterConstant    # characterFactor
    | stringConstant       # stringFactor
    | functionCall         # functionCallFactor
    | NOT factor           # notFactor
    | '(' expression ')'   # parenthesizedFactor
    ;

variable            locals [ Typespec type = null, SymtabEntry entry = null ]
    : variableIdentifier modifier* ;

modifier  : '[' indexList ']' | '.' field ;
indexList : index ( ',' index )* ;
index     : expression ;

field               locals [ Typespec type = null, SymtabEntry entry = null ]
    : IDENTIFIER ;

functionCall : functionName '(' argumentList? ')' ;
functionName        locals [ Typespec type = null, SymtabEntry entry = null ]
    : IDENTIFIER ;

number          : sign? unsignedNumber ;
unsignedNumber  : intConstant | doubleConstant ;
intConstant : INT ;
doubleConstant    : DOUBLE;
characterConstant : CHARACTER ;
stringConstant    : STRING ;

relOp : '==' | '!=' | '<' | '<=' | '>' | '>=';
addOp : '+' | '-' | OR ;
mulOp : '*' | '/' | DIV | MOD | AND ;

fragment A : ('a' | 'A') ;
fragment B : ('b' | 'B') ;
fragment C : ('c' | 'C') ;
fragment D : ('d' | 'D') ;
fragment E : ('e' | 'E') ;
fragment F : ('f' | 'F') ;
fragment G : ('g' | 'G') ;
fragment H : ('h' | 'H') ;
fragment I : ('i' | 'I') ;
fragment J : ('j' | 'J') ;
fragment K : ('k' | 'K') ;
fragment L : ('l' | 'L') ;
fragment M : ('m' | 'M') ;
fragment N : ('n' | 'N') ;
fragment O : ('o' | 'O') ;
fragment P : ('p' | 'P') ;
fragment Q : ('q' | 'Q') ;
fragment R : ('r' | 'R') ;
fragment S : ('s' | 'S') ;
fragment T : ('t' | 'T') ;
fragment U : ('u' | 'U') ;
fragment V : ('v' | 'V') ;
fragment W : ('w' | 'W') ;
fragment X : ('x' | 'X') ;
fragment Y : ('y' | 'Y') ;
fragment Z : ('z' | 'Z') ;

DIR_INCLUDE : '#' I N C L U D E ;
MAIN        : M A I N ;
CONST       : C O N S T ;
TYPE        : T Y P E ;
ARRAY       : A R R A Y ;
OF          : O F ;
RECORD      : R E C O R D ;
VAR         : V A R ;
END         : E N D ;
DIV         : D I V ;
MOD         : M O D ;
AND         : A N D ;
OR          : O R ;
NOT         : N O T ;
IF          : I F;
THEN        : T H E N ;
ELSE        : E L S E;
UNTIL       : U N T I L ;
WHILE       : W H I L E;
DO          : D O ;
FOR         : F O R;
COUT        : C O U T ;
WRITELN     : W R I T E L N ;
READ        : R E A D ;
READLN      : R E A D L N ;
PROCEDURE   : V O I D ;
FUNCTION    : F U N C T I O N ;
RETURN      : R E T U R N ;

IDENTIFIER : [a-zA-Z][a-zA-Z0-9]* ;
INT        : [0-9]+ ;

DOUBLE     : INT '.' INT
           | INT ('e' | 'E') ('+' | '-')? INT
           | INT '.' INT ('e' | 'E') ('+' | '-')? INT
           ;

NEWLINE : '\r'? '\n' -> skip  ;
WS      : [ \t]+ -> skip ;

QUOTE     : '"' ;
CHARACTER : QUOTE CHARACTER_CHAR QUOTE ;
STRING    : QUOTE STRING_CHAR* QUOTE ;

fragment CHARACTER_CHAR : ~('"')   // any non-quote character
                        ;

fragment STRING_CHAR : QUOTE QUOTE  // two consecutive quotes
                     | ~('"')      // any non-quote character
                     ;

COMMENT : '//' ~[\r\n]* -> skip;