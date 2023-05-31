#!/bin/bash

javac -d /home/infoetu/maxime.blot.etu/dev/JeuxNuls/classes /home/infoetu/maxime.blot.etu/dev/JeuxNuls/*/*.java
if [ $1 = c ]
then
	read -p 'Version: ' ver
	read -p 'Message: ' mess
	echo -n $ver >> changelog
	printf ': ' >> changelog
	echo $mess >> changelog
	clear
fi
