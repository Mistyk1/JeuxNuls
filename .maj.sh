#!/bin/bash

if [ -e $JAVA_HOME/jre/lib/javafx.properties ]; then
    javac -d classes */*.java
else
    for i in */*.java; do
        if [ $i != "jeux/QuestionPourUnCarton.java" ]; then
            javac -d classes $i
        fi
    done
fi