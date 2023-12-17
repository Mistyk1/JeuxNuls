#!/bin/bash

if [ -e $JAVA_HOME/jre/lib/javafx.properties ]; then
    javac -d classes */*.java
else
    for i in src/java/fr/mistyk1/**/*.java; do
        if [ $i != "jeux/QuestionPourUnCarton.java" ]; then
            javac -d classes $i
        fi
    done
fi