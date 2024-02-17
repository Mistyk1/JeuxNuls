#!/bin/bash
FX=#null

javac -d .classes src/java/fr/mistyk1/util/*.java
javac -d .classes src/java/fr/mistyk1/jeux/*.java
if [[ $(< src/assets/javaFXVersion) != $FX ]]; then
	javac -d .classes src/java/fr/mistyk1/util/javafx/*.java
	javac -d .classes src/java/fr/mistyk1/windows/*.java
	javac -d .classes src/java/fr/mistyk1/jeux/javafx/*.java
fi
javac -d .classes src/java/fr/mistyk1/Main.java
