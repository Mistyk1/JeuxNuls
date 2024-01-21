#!/bin/bash

if [ -e $JAVA_HOME/jre/lib/javafx.properties ]; then
#    javac -d .classes src/java/fr/mistyk1/*/*.java
    javac -d .classes src/java/fr/mistyk1/util/*.java
#else
#    for i in src/java/fr/mistyk1/**/*.java; do
#        if [ $i != "jeux/QuestionPourUnCarton.java" ]; then
#            javac -d .classes $i
#        fi
#    done
fi

javac -d .classes src/java/fr/mistyk1/Main.java
