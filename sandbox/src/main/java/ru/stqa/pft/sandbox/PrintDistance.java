package ru.stqa.pft.sandbox;

/**
 * Created by plopik on 21.11.2016.
 */
public class PrintDistance {

  public static void main(String[] args){

    Point p1 = new Point(10,5);
    Point p2 = new Point(8,1);


    System.out.println("Distance between 2 points: " + "x1 = " + p1.x + " y1 = " + p1.y + " and "  + " x2 = " + p2.x + " y2 = " + p2.y + " is equally to " + distance(p1,p2));
  }


  public static double distance(Point p1, Point p2){
    return Math.sqrt(Math.pow((p2.x - p1.x),2) + Math.pow((p2.y - p1.y),2));

  }


}
