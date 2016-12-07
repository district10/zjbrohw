#!/bin/bash

echo No args
echo %%% java -jar target/zjbrohw.jar
java -jar target/zjbrohw.jar

echo
echo One arg: Admin
echo %%% java -jar target/zjbrohw.jar Admin;
java -jar target/zjbrohw.jar Admin;
echo One arg: not Admin
echo %%% java -jar target/zjbrohw.jar XXX
java -jar target/zjbrohw.jar XXX

echo
echo two args: Admin, name
echo %%% java -jar target/zjbrohw.jar Admin XYZ
java -jar target/zjbrohw.jar Admin XYZ

echo
echo three args: Admin, name, income
echo %%% java -jar target/zjbrohw.jar Admin XYZ 77
java -jar target/zjbrohw.jar Admin XYZ 77

echo
echo four args: Admin, name, income, delta
echo %%% java -jar target/zjbrohw.jar Admin XYZ 77 -7
java -jar target/zjbrohw.jar Admin XYZ 77 -7
echo %%% java -jar target/zjbrohw.jar Admin XYZ 77 12
java -jar target/zjbrohw.jar Admin XYZ 77 12
echo %%% java -jar target/zjbrohw.jar Admin XYZ 77 2147483647
java -jar target/zjbrohw.jar Admin XYZ 77 2147483647

echo
echo more than four args: Admin, [{name, income}], ...
echo %%% java -jar target/zjbrohw.jar Admin XYZ 77 kkk -9
java -jar target/zjbrohw.jar Admin XYZ 77 kkk -9
echo %%% java -jar target/zjbrohw.jar Admin a 1 b 2 a
java -jar target/zjbrohw.jar Admin a 1 b 2 a
echo %%% java -jar target/zjbrohw.jar Admin a 1 b 2 a 3
java -jar target/zjbrohw.jar Admin a 1 b 2 a 3
echo %%% java -jar target/zjbrohw.jar Admin a 1 b 2 a 3 kk -1
java -jar target/zjbrohw.jar Admin a 1 b 2 a 3 kk -1
