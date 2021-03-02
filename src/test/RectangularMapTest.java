import agh.cs.lab2.Vector2d;
import agh.cs.lab4.Animal;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab4.RectangularMap;
import agh.cs.lab6.IPositionChangeObserver;
import org.junit.Assert;
import org.junit.Test;

public class RectangularMapTest {

    @Test
    public void placeTest(){
        IWorldMap map = new RectangularMap(6,6);
        Vector2d tmp = new Vector2d(2,2);
        Animal komodo = new Animal(map, new Vector2d(4,4), (IPositionChangeObserver)map);
        map.place(new Animal(map,new Vector2d(2,2), (IPositionChangeObserver)map));
        map.place(new Animal(map,new Vector2d(3,3), (IPositionChangeObserver)map));
        map.place(komodo);

        Assert.assertEquals(new Vector2d(2,2), map.getAnimals().get(tmp).getPosition());
        Assert.assertTrue(map.canMoveTo(new Vector2d(2,3)));
        Assert.assertFalse(map.canMoveTo(new Vector2d(3,3)));
        Assert.assertTrue(map.isOccupied(new Vector2d(2,2)));
        Assert.assertFalse(map.isOccupied(new Vector2d(1,1)));
        Assert.assertNull(map.objectAt(new Vector2d(3,2)));
        Assert.assertEquals(komodo, map.objectAt(new Vector2d(4,4)));
        Assert.assertFalse(map.place(new Animal(map,new Vector2d(3,3), (IPositionChangeObserver)map)));

    }
}
