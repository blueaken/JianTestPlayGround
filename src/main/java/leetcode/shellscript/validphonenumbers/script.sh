#!/usr/bin/env bash

regex="^(\([0-9]{3}\) ){1}[0-9]{3}-[0-9]{4}$|^([0-9]{3}-){2}[0-9]{4}$"
while read line || [ -n "$line" ]; do [[ $line =~ $regex ]] && echo $line; done < file.txt
