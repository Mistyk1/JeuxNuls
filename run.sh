#!/bin/bash

if [ ! -d "./classes" ]
then
    javac -d classes */*.java
fi
java -cp classes Hub
read -p 'Clear? (y/n) ' cl
if [ "$cl" = "y" ]
then
    clear
fi