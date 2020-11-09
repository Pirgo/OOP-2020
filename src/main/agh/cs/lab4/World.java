package agh.cs.lab4;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab3.OptionParser;
import agh.cs.lab5.GrassField;

public class World {
    public static void main(String[] args){
        MoveDirection[] directions = new OptionParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(2,2) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        System.out.print(map.toString());

        MoveDirection[] directions2 = new OptionParser().parse(args);
        IWorldMap map2 = new GrassField(10);
        Vector2d[] positions2 = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine2 = new SimulationEngine(directions2, map2, positions2);
        engine2.run();
        System.out.print(map2.toString());

    }
}
