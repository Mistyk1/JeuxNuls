#!/bin/bash

if [ -e $JAVA_HOME/jre/lib/javafx.properties ]; then
    javac -d classes */*.java
    java -cp classes Hub
else
    javac -d classes */*.java excludesfile QuestionPourUnCarton.java
    java -cp classes exclude noJavaFx Hub
fi

read -p 'Clear? (y/n) ' cl
if [ "$cl" = "y" ]; then
    clear
fi