#!/bin/zsh

rm -rf out

javac -d out $(find src -name "*.java")

java -cp out com.flowledger.app.Main