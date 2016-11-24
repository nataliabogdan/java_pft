package ru.stqa.pft.sandbox;

public class MyFirstProgram {

  public static void main(String[] args) {
    hello("world");
    hello("Natalia");

    Square s = new Square(5);

    Rectangle r = new Rectangle(3,2);

    System.out.println("Area of square with side " + s.l + " = " + s.area());
    System.out.println("Area of a rectangle with sides " + r.a + " and " + r.b + " = " + r.area());

  }

  public static void hello(String somebody) {
    System.out.println( "Hello, " + somebody + "! ");
  }


  public static double area(Rectangle r){
    return r.a * r.b;

  }
}



