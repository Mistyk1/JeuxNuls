#!/bin/bash

if [ ! -d ./classes ]; then
    source ./.maj.sh
fi

if [ !-e $JAVA_HOME/jre/lib/javafx.properties ]; then
    java -cp classes Main
else
    java -cp classes Main noJavaFx
fi

read -p 'Clear? (y/n) ' cl
if [ "$cl" = "y" ]; then
    clear
fi