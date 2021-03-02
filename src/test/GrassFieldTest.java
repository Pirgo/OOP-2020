import agh.cs.lab2.Vector2d;
import agh.cs.lab4.Animal;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab5.GrassField;
import agh.cs.lab6.IPositionChangeObserver;
import org.junit.Assert;
import org.junit.Test;

public class GrassFieldTest {

    @Test
    public void GrassTest(){
        IWorldMap map = new GrassField(5);
        Animal komodo = new Animal(map, new Vector2d(4,4), (IPositionChangeObserver)map);
        map.place(new Animal(map,new Vector2d(2,2),(IPositionChangeObserver)map ));
        map.place(new Animal(map,new Vector2d(3,3),(IPositionChangeObserver)map));
        map.place(komodo);

        Assert.assertEquals(new Vector2d(2,2), map.getAnimals().get(new Vector2d(2,2)).getPosition());
        Assert.assertTrue(map.canMoveTo(new Vector2d(2,3)));
        Assert.assertFalse(map.canMoveTo(new Vector2d(3,3)));
        Assert.assertTrue(map.isOccupied(new Vector2d(2,2)));
//        Assert.assertFalse(map.isOccupied(new Vector2d(1,1)));
        Assert.assertEquals(komodo, map.objectAt(new Vector2d(4,4)));
        Assert.assertFalse(map.place(new Animal(map,new Vector2d(3,3), (IPositionChangeObserver)map)));
    }
}
