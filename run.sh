#!/bin/bash

if [ -e $JAVA_HOME/jre/lib/javafx.properties ]; then
    javac -d classes */*.java
    java -cp classes Hub
else
    javac -d classes */*.java excludesfile jeux/QuestionPourUnCarton.java
    java -cp classes Hub noJavaFx
fi

read -p 'Clear? (y/n) ' cl
if [ "$cl" = "y" ]; then
    clear
fi