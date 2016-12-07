.PHONY: test

all: test
test: target/zjbrohw.jar
	sh ./test.sh

target/zjbrohw.jar: src/main/java/com/tangzhixiong/zjbrohw/Main.java src/main/java/com/tangzhixiong/zjbrohw/Person.java
	mvn package
