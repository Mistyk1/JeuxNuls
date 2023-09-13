#!/bin/bash

if [ -e $JAVA_HOME/jre/lib/javafx.properties ]; then
    javac -d classes */*.java
    java -cp classes Hub
else
    #javac exclude jeux/QuestionPourUnCarton.java -d classes */*.java
    for %%i in (*.java) do if /i not "%%~i" == "QuestionPourUnCarton.java" javac "%%~i"
    java -cp classes Hub noJavaFx
fi

read -p 'Clear? (y/n) ' cl
if [ "$cl" = "y" ]; then
    clear
fi