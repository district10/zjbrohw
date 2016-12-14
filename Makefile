.PHONY: test

all: test README.docx
clean:
	rm -f *.class

test: Admin.class Person.class
	sh test.sh

%.class: %.java
	javac $<

%.docx: %.txt
	pandoc $< -o $@
