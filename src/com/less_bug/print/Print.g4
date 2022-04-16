grammar Print;

@header {
    package com.less_bug.print;
}

/*
 * Tokens
 */

PRINT: 'print';

ID: [a-zA-Z_][a-zA-Z0-9_]*;
STRING: '"' (~["\n] | '""')* '"';
NUMBER: [0-9]+ | [0-9]* '.' [0-9]+;

WS: [ \t\n]+ -> skip;

/*
 * Rules
 */

program: statement*;

statement: printStatement | assignment;

printStatement: PRINT expression | PRINT ID;

assignment: ID '=' expression;

expression:
	ID
	| stringExpression
	| numberExpression
	| booleanExpression;

stringExpression: STRING;

numberExpression: NUMBER;

booleanExpression: 'true' | 'false';

