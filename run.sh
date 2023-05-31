#!/bin/bash

java -cp /home/infoetu/maxime.blot.etu/dev/JeuxNuls/classes Hub
read -p 'Clear? (y/n) ' cl
if [ "$cl" = "y" ]
then
    clear
fi