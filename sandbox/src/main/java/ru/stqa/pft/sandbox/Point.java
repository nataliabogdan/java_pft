package ru.stqa.pft.sandbox;

/**
 * Created by plopik on 21.11.2016.
 */
public class Point {

  public double x;
  public double y;

  public Point(double x, double y){
    this.x = x;
    this.y = y;
  }
  public double distance(Point p){
    return Math.sqrt(Math.pow((p.x - x),2) + Math.pow((p.y - y),2));

  }

}
