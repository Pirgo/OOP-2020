import agh.cs.lab2.MapDirection;
import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab3.OptionParser;
import agh.cs.lab4.IEngine;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab4.RectangularMap;
import agh.cs.lab4.SimulationEngine;
import agh.cs.lab4.Animal;
import agh.cs.lab6.IPositionChangeObserver;
import org.junit.Assert;
import org.junit.Test;

//public class AnimalMapTest{
//
//    @Test
//    public void moveTest(){
//        String[] input = {"f", "f"};
//        MoveDirection[] directions = OptionParser.parse(input);
//        IWorldMap map = new RectangularMap(5, 5);
//        Vector2d[] positions = { new Vector2d(1,1), new Vector2d(3,3) };
//        IEngine engine = new SimulationEngine(directions, map, positions, (IPositionChangeObserver)map);
//        engine.run();
//
//        Assert.assertEquals(new Vector2d(1,2), map.getAnimals().get(0).getPosition());
//        Assert.assertEquals(MapDirection.NORTH, map.getAnimals().get(0).getOrient());
//        Assert.assertEquals(new Vector2d(3,4), map.getAnimals().get(1).getPosition());
//        Assert.assertEquals(MapDirection.NORTH, map.getAnimals().get(1).getOrient());
//
//        String[] input2 = {"r", "r"};
//        MoveDirection[] directions2 = OptionParser.parse(input2);
//        IWorldMap map2 = new RectangularMap(5, 5);
//        Vector2d[] positions2 = { new Vector2d(1,1), new Vector2d(3,3) };
//        IEngine engine2 = new SimulationEngine(directions2, map2, positions2, (IPositionChangeObserver)map2);
//        engine2.run();
//
//        Assert.assertEquals(new Vector2d(1,1), map2.getAnimals().get(0).getPosition());
//        Assert.assertEquals(MapDirection.EAST, map2.getAnimals().get(0).getOrient());
//        Assert.assertEquals(new Vector2d(3,3), map2.getAnimals().get(1).getPosition());
//        Assert.assertEquals(MapDirection.EAST, map2.getAnimals().get(1).getOrient());
//
//        String[] input3 = {"b", "l"};
//        MoveDirection[] directions3 = OptionParser.parse(input3);
//        IWorldMap map3 = new RectangularMap(5, 5);
//        Vector2d[] positions3 = { new Vector2d(1,2), new Vector2d(3,3) };
//        IEngine engine3 = new SimulationEngine(directions3, map3, positions3, (IPositionChangeObserver)map3);
//        engine3.run();
//
//        Assert.assertEquals(new Vector2d(1,1), map3.getAnimals().get(0).getPosition());
//        Assert.assertEquals(MapDirection.NORTH, map3.getAnimals().get(0).getOrient());
//        Assert.assertEquals(new Vector2d(3,3), map3.getAnimals().get(1).getPosition());
//        Assert.assertEquals(MapDirection.WEST, map3.getAnimals().get(1).getOrient());
//
//        String[] input4 = {"l", "l", "l"};
//        MoveDirection[] directions4 = OptionParser.parse(input4);
//        IWorldMap map4 = new RectangularMap(5, 5);
//        Vector2d[] positions4 = { new Vector2d(1,2), new Vector2d(3,3) };
//        IEngine engine4 = new SimulationEngine(directions4, map4, positions4, (IPositionChangeObserver)map4);
//        engine4.run();
//
//        Assert.assertEquals(new Vector2d(1,2), map4.getAnimals().get(0).getPosition());
//        Assert.assertEquals(MapDirection.SOUTH, map4.getAnimals().get(0).getOrient());
//        Assert.assertEquals(new Vector2d(3,3), map4.getAnimals().get(1).getPosition());
//        Assert.assertEquals(MapDirection.WEST, map4.getAnimals().get(1).getOrient());
//    }
//
//    @Test
//    public void collisionTest(){
//        String[] input = {"f", "b"};
//        MoveDirection[] directions = OptionParser.parse(input);
//        IWorldMap map = new RectangularMap(5, 5);
//        Vector2d[] positions = { new Vector2d(1,1), new Vector2d(1,3) };
//        IEngine engine = new SimulationEngine(directions, map, positions, (IPositionChangeObserver)map);
//        engine.run();
//
//        Assert.assertEquals(new Vector2d(1,2), map.getAnimals().get(0).getPosition());
//        Assert.assertEquals(MapDirection.NORTH, map.getAnimals().get(0).getOrient());
//        Assert.assertEquals(new Vector2d(1,3), map.getAnimals().get(1).getPosition());
//        Assert.assertEquals(MapDirection.NORTH, map.getAnimals().get(1).getOrient());
//
//
//        String[] input2 = {"r", "f", "r", "f", "f", "l"};
//        MoveDirection[] directions2 = OptionParser.parse(input2);
//        IWorldMap map2 = new RectangularMap(5, 5);
//        Vector2d[] positions2 = { new Vector2d(1,1), new Vector2d(1,3) };
//        IEngine engine2 = new SimulationEngine(directions2, map2, positions2, (IPositionChangeObserver)map2);
//        engine2.run();
//
//        Assert.assertEquals(new Vector2d(1,1), map2.getAnimals().get(0).getPosition());
//        Assert.assertEquals(MapDirection.SOUTH, map2.getAnimals().get(0).getOrient());
//        Assert.assertEquals(new Vector2d(1,5), map2.getAnimals().get(1).getPosition());
//        Assert.assertEquals(MapDirection.WEST, map2.getAnimals().get(1).getOrient());
//
//        String[] input3= {"r", "f", "f", "l", "r", "f"};
//        MoveDirection[] directions3 = OptionParser.parse(input3);
//        IWorldMap map3 = new RectangularMap(5, 5);
//        Vector2d[] positions3 = { new Vector2d(5,1), new Vector2d(1,3) };
//        IEngine engine3 = new SimulationEngine(directions3, map3, positions3, (IPositionChangeObserver)map3);
//        engine3.run();
//
//        Assert.assertEquals(new Vector2d(5,1), map3.getAnimals().get(0).getPosition());
//        Assert.assertEquals(MapDirection.SOUTH, map3.getAnimals().get(0).getOrient());
//        Assert.assertEquals(new Vector2d(1,4), map3.getAnimals().get(1).getPosition());
//        Assert.assertEquals(MapDirection.WEST, map3.getAnimals().get(1).getOrient());
//    }
//}