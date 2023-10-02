#!/bin/bash

if [ ! -d ./classes ]; then
    source ./.maj.sh
fi

if [ !-e $JAVA_HOME/jre/lib/javafx.properties ]; then
    java -cp classes hub/Hub
else
    java -cp classes hub/Hub noJavaFx
fi

read -p 'Clear? (y/n) ' cl
if [ "$cl" = "y" ]; then
    clear
fi