#!/bin/bash

java -cp classes Hub
read -p 'Clear? (y/n) ' cl
if [ "$cl" = "y" ]
then
    clear
fi