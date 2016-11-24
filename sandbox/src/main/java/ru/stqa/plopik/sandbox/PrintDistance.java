package ru.stqa.plopik.sandbox;

/**
 * Created by plopik on 21.11.2016.
 */
public class PrintDistance {

  public static void main(String[] args){

    Point p1 = new Point(10,4);
    Point p2 = new Point(8,1);


    System.out.println("Distance between 2 points is equally to " + p1.distance(p2));
  }


}
