#!/bin/bash

echo %%% java Admin;
java Admin;

echo
echo %%% java Admin XYZ
java Admin XYZ

echo
echo %%% java Admin XYZ 77
java Admin XYZ 77

echo
echo %%% java Admin XYZ 77 -7
java Admin XYZ 77 -7
echo %%% java Admin XYZ 77 12
java Admin XYZ 77 12
echo %%% java Admin XYZ 77 2147483647
java Admin XYZ 77 2147483647

echo
echo %%% java Admin XYZ 77 kkk -9
java Admin XYZ 77 kkk -9
echo %%% java Admin a 1 b 2 a
java Admin a 1 b 2 a
echo %%% java Admin a 1 b 2 a 3
java Admin a 1 b 2 a 3
echo %%% java Admin a 1 b 2 a 3 kk -1
java Admin a 1 b 2 a 3 kk -1
