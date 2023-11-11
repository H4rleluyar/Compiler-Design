grammar cpp;

//the ? just means that i can incldue it or not include it.

maintoRun: include* intMain* classDeclaration* functionDeclaration*;

include: '#include' '<' Identifier ('.' Identifier)? '>';

classDeclaration: 'class' Identifier '{' member* '};';

intMain: 'int' 'main' '(' ')' '{' statement* '}';

functionDeclaration: Identifier Identifier '(' parameterList? ')' '{' statement* '}';

member: Type Identifier ';';

parameterList: parameter (',' parameter)*;

parameter: Type Identifier;

statement: printStatement | variableDeclaration | assignment | functionCall | conditional | loop; // add more statements later

Type: 'int' | 'float' | 'char' | 'string'; //add more elements here later

variableDeclaration: Type Identifier '=' expression ';'; //NOT sure why this isnt working

assignment: Identifier '=' expression ';';

functionCall: Identifier '(' argumentList? ')' ';';

argumentList: expression (',' expression)*;

conditional: 'if' '(' condition ')' '{' statement* '}' ('else' statement)?;

loop: 'for' '(' expression? ';' condition? ';' expression? ')' '{' statement* '}'
    | 'while' '(' condition ')' '{' statement* '}';


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

String: '"' ~['"\r\n']* '"';

expression: Identifier | Number | String | '(' expression ')' | expression ('==' | '!=' | '<' | '<=' | '>' | '>=') expression;

Identifier: [a-zA-Z_][a-zA-Z0-9_]* ;
Number: [0-9]+;

condition: expression ('==' | '!=' | '<' | '<=' | '>' | '>=') expression;

//handle the basic print statement
printStatement: 'std::cout' '<<' expression ('<<' 'std::endl')? ';';

Comment: '//' ~[\r\n]* -> skip;  // use so the that // just means comment

//use this to ignore white line and spaces
NEWLINE : '\r'? '\n' -> skip  ;
WS      : [ \t]+ -> skip ;


