import agh.cs.lab2.Vector2d;
import org.junit.Assert;
import org.junit.Test;

public class Vector2dTest {
    @Test
    public void testEquals(){
        Vector2d tmpvec1 = new Vector2d(2,2);
        Vector2d tmpvec2 = new Vector2d(2,2);
        Vector2d tmpvec3 = new Vector2d(2,3);
        Assert.assertTrue(tmpvec1.equals(tmpvec2));
        Assert.assertFalse(tmpvec1.equals(tmpvec3));
    }

    @Test
    public void testToString(){
        Assert.assertEquals("(2,2)", new Vector2d(2,2).toString());
    }

    @Test
    public void testPrecedes(){
        Assert.assertTrue(new Vector2d(2,2).precedes(new Vector2d(2,3)));
        Assert.assertFalse(new Vector2d(2,2).precedes(new Vector2d(1,1)));
    }

    @Test
    public void testFollows(){
        Assert.assertFalse(new Vector2d(2,2).follows(new Vector2d(2,3)));
        Assert.assertTrue(new Vector2d(2,2).follows(new Vector2d(1,1)));
    }

    @Test
    public void testUpperRight(){
        Assert.assertEquals(new Vector2d(2,2).upperRight(new Vector2d(2,3)), new Vector2d(2,3));
    }

    @Test
    public void testLowerLeft(){
        Assert.assertEquals(new Vector2d(4,2).lowerLeft(new Vector2d(2,3)), new Vector2d(2,2));
    }

    @Test
    public void testAdd(){
        Assert.assertEquals(new Vector2d(2,2).add(new Vector2d(1,-1)), new Vector2d(3,1));
    }

    @Test
    public void testSubtract(){
        Assert.assertEquals(new Vector2d(2,2).subtract(new Vector2d(1,-1)), new Vector2d(1,3));
    }

    @Test
    public void testOpposite(){
        Assert.assertEquals(new Vector2d(2,2).opposite(), new Vector2d(-2,-2));
    }
}
