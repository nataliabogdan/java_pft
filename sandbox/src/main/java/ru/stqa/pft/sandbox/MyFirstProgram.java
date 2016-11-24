package ru.stqa.pft.sandbox;

public class MyFirstProgram {

  public static void main(String[] args) {
    hello("world");
    hello("Natalia");
    double l = 5;
    double a = 3;
    double b = 2;
    System.out.println("Area of square with side " + l + " = " + area(l));
    System.out.println("Area of a rectangle with sides " + a + " and " + b + " = " + area(a, b));

  }

  public static void hello(String somebody) {
    System.out.println( "Hello, " + somebody + "! ");
  }

  public static double area(double len){
    return len * len;
  }

  public static double area(double a, double b){
    return a * b;

  }
}



