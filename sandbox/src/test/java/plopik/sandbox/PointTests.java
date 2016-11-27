package plopik.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by plopik on 27.11.2016.
 */
public class PointTests {

  @Test
  public void testDistance(){

    Point p1 = new Point(8,4);
    Point p2 = new Point(8,1);
    Assert.assertEquals(p1.distance(p2), 3.0);

  }

  @Test
  public void testDistance2(){

    Point p3 = new Point(1,1);
    Point p4 = new Point(4,5);
    Assert.assertEquals(p3.distance(p4), 5.0);
  }
}
