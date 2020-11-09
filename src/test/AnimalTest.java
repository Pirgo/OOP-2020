import agh.cs.lab2.*;
import agh.cs.lab3.Animal;
import agh.cs.lab3.OptionParser;
import org.junit.Assert;
import org.junit.Test;

public class AnimalTest {
    @Test
    public void testOrientation() {
        Animal komodo = new Animal();
        Assert.assertEquals(komodo.getOrient(), MapDirection.NORTH.toString());
        komodo.move(MoveDirection.RIGHT);
        Assert.assertEquals(komodo.getOrient(), MapDirection.EAST.toString());
        komodo.move(MoveDirection.RIGHT);
        Assert.assertEquals(komodo.getOrient(), MapDirection.SOUTH.toString());
        komodo.move(MoveDirection.RIGHT);
        Assert.assertEquals(komodo.getOrient(), MapDirection.WEST.toString());

        Animal komodo2 = new Animal();
        Assert.assertEquals(komodo2.getOrient(), MapDirection.NORTH.toString());
        komodo2.move(MoveDirection.LEFT);
        Assert.assertEquals(komodo2.getOrient(), MapDirection.WEST.toString());
        komodo2.move(MoveDirection.LEFT);
        Assert.assertEquals(komodo2.getOrient(), MapDirection.SOUTH.toString());
        komodo2.move(MoveDirection.LEFT);
        Assert.assertEquals(komodo2.getOrient(), MapDirection.EAST.toString());
    }
    @Test
    public void testPosition(){
        Animal komodo = new Animal();
        Assert.assertEquals(new Vector2d(2,2).toString(), komodo.getPos());
        komodo.move(MoveDirection.FORWARD);
        Assert.assertEquals(new Vector2d(2,3).toString(), komodo.getPos());
        komodo.move(MoveDirection.FORWARD);
        Assert.assertEquals(new Vector2d(2,4).toString(), komodo.getPos());
        komodo.move(MoveDirection.FORWARD);
        Assert.assertEquals(new Vector2d(2,4).toString(), komodo.getPos());
        komodo.move(MoveDirection.LEFT);
        komodo.move(MoveDirection.FORWARD);
        Assert.assertEquals(new Vector2d(1,4).toString(), komodo.getPos());
        komodo.move(MoveDirection.BACKWARD);
    }
    @Test
    public void testInMap(){
        Animal komodo = new Animal();
        komodo.move(MoveDirection.FORWARD);
        komodo.move(MoveDirection.FORWARD);
        komodo.move(MoveDirection.FORWARD);
        Assert.assertEquals(new Vector2d(2,4).toString(), komodo.getPos());
        komodo.move(MoveDirection.BACKWARD);
        komodo.move(MoveDirection.BACKWARD);
        komodo.move(MoveDirection.BACKWARD);
        komodo.move(MoveDirection.BACKWARD);
        komodo.move(MoveDirection.BACKWARD);
        Assert.assertEquals(new Vector2d(2,0).toString(), komodo.getPos());
        komodo.move(MoveDirection.LEFT);
        komodo.move(MoveDirection.FORWARD);
        komodo.move(MoveDirection.FORWARD);
        komodo.move(MoveDirection.FORWARD);
        Assert.assertEquals(new Vector2d(0,0).toString(), komodo.getPos());
        komodo.move(MoveDirection.BACKWARD);
        komodo.move(MoveDirection.BACKWARD);
        komodo.move(MoveDirection.BACKWARD);
        komodo.move(MoveDirection.BACKWARD);
        komodo.move(MoveDirection.BACKWARD);
        Assert.assertEquals(new Vector2d(4,0).toString(), komodo.getPos());

    }

    @Test
    public void testDirectionParser(){
        String[] test = {"f", "b", "r", "l", "k"};
        Assert.assertEquals(OptionParser.parse(test), new MoveDirection[]{MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.RIGHT, MoveDirection.LEFT});
    }
}
