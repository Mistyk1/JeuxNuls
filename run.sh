#!/bin/bash

java JavaFXCheck
FX=#null

if [ ! -d ./.classes ]; then
    source ./.maj.sh
fi

if [[ $(< src/assets/javaFXVersion) != $FX ]]; then
    java -cp .classes/**/* Main
else
    java -cp .classes Main noJavaFx
fi

read -p 'Clear? (y/n) ' cl
if [ "$cl" = "y" ]; then
    clear
fi
