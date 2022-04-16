TARGET=Print
JAVA=java
ANTLR4=-jar /usr/local/lib/antlr-4.10.1-complete.jar
GRUN=org.antlr.v4.gui.TestRig
SRC=src/com/less_bug/print
COMP_NAME=com.less_bug.print.Interpreter

default: build

build:
	@cd $(SRC) && $(JAVA) $(ANTLR4) $(TARGET).g4 -visitor &&\
		javac *.java

run: build
	    @cd ./src && java $(COMP_NAME) hello.print

debug: build
	    @cd ./src && java -Dprint.logLevel=FINEST $(COMP_NAME) hello.print