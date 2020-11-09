import agh.cs.lab2.MapDirection;
import org.junit.Assert;
import org.junit.Test;

public class MapDirectionTest {
    @Test
    public void testNext(){
        Assert.assertEquals(MapDirection.NORTH, MapDirection.WEST.next());
        Assert.assertEquals(MapDirection.WEST, MapDirection.SOUTH.next());
        Assert.assertEquals(MapDirection.SOUTH, MapDirection.EAST.next());
        Assert.assertEquals(MapDirection.EAST, MapDirection.NORTH.next());
    }
    @Test
    public void testPrev(){
        Assert.assertEquals(MapDirection.NORTH, MapDirection.EAST.previous());
        Assert.assertEquals(MapDirection.WEST, MapDirection.NORTH.previous());
        Assert.assertEquals(MapDirection.SOUTH, MapDirection.WEST.previous());
        Assert.assertEquals(MapDirection.EAST, MapDirection.SOUTH.previous());
    }
}
