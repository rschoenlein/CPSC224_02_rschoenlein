{\rtf1\ansi\ansicpg1252\cocoartf1671
{\fonttbl\f0\fswiss\fcharset0 Helvetica;}
{\colortbl;\red255\green255\blue255;}
{\*\expandedcolortbl;;}
\margl1440\margr1440\vieww10800\viewh8400\viewkind0
\pard\tx720\tx1440\tx2160\tx2880\tx3600\tx4320\tx5040\tx5760\tx6480\tx7200\tx7920\tx8640\pardirnatural\partightenfactor0

\f0\fs24 \cf0 import java.util.Scanner;\
import java.lang.Math;     // Note: Needed for math functions in part (3)\
\
public class PaintEstimator \{\
   public static void main(String[] args) \{\
      Scanner scnr = new Scanner(System.in);\
      double wallHeight;\
      double wallWidth;\
      double wallArea;\
      \
      System.out.println("Enter wall height (feet):");\
      wallHeight = scnr.nextDouble();\
      \
      System.out.println("Enter wall width (feet):");\
      wallWidth = scnr.nextDouble();                   // FIXME (1): Prompt user to input wall's width\
      \
      // Calculate and output wall area\
      wallArea = wallHeight * wallWidth;                        // FIXME (1): Calculate the wall's area\
      System.out.println("Wall area: " + wallArea + " square feet");     // FIXME (1): Finish the output statement\
      \
      // FIXME (2): Calculate and output the amount of paint in gallons needed to paint the wall\
      System.out.println("Paint needed: " + wallArea/350.0 + " gallons");\
      \
      // FIXME (3): Calculate and output the number of 1 gallon cans needed to paint the wall, rounded up to nearest integer\
      System.out.println("Cans needed: " + Math.round(wallArea/350.0) + " can(s)");\
   \}\
\}}