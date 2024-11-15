grammar LenguajeL2;

// Reglas principales
programa: declaraciones EOF;
declaraciones: (declaracion ';' declaraciones)? ;
declaracion: expresion
           | control_flujo
           | impresion;

// Reglas de control de flujo
control_flujo: if_stmt | while_stmt | for_stmt;

if_stmt: 'if' '(' expresion ')' '{' declaraciones '}'
       | 'if' '(' expresion ')' '{' declaraciones '}' 'else' '{' declaraciones '}';
while_stmt: 'while' '(' expresion ')' '{' declaraciones '}';
for_stmt: 'for' '(' expresion ';' expresion ';' expresion ')' '{' declaraciones '}';

// Regla de impresión
impresion: 'print' '(' identificador ')';

// Reglas de expresiones
expresion: identificador '=' expresion
         | identificador
         | numero
         | '(' expresion ')'
         | expresion operador_aditivo expresion
         | expresion operador_multiplicativo expresion
         | expresion operador_relacional expresion
         | '-' expresion;

// Operadores
operador_aditivo: '+' | '-';
operador_multiplicativo: '*' | '/';
operador_relacional: '<' | '>' | '==' | '<>' | '<=' | '>=';

// Terminales
numero          : digito+ ;
digito          : '0' | '1' | '2' | '3' | '4' | '5' | '6' | '7' | '8' | '9' ;

identificador   : letra (letra | digito)* ;
letra : 'a' | 'b' | 'c' | 'd' | 'e' | 'f' | 'g' | 'h' | 'i' | 'j' | 'k' | 'l' | 'm' | 'n' | 'o' | 'p' | 'q' | 'r' | 's' | 't' | 'u' | 'v' | 'w' | 'x' | 'y' | 'z' ;

// Ignorar espacios en blanco
WS: [ \t\r\n]+ -> skip;