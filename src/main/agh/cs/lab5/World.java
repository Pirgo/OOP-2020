package agh.cs.lab5;



import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab3.OptionParser;
import agh.cs.lab4.IEngine;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab4.RectangularMap;
import agh.cs.lab4.SimulationEngine;
import agh.cs.lab6.IPositionChangeObserver;

/*
Nie wydaje mi się że dodanie interfejsu IMapElement ułatwiłoby w znacznym stopniu implementacji GrassField


Dodanie klasy AbstractWorldMapElement ułatwiłoby dodawanie podobnych do siebie klas. Jednak kiedy juz mamy zaimplementowane
obie klasy tj Animal i Grass to moim zdaniem nie jest dobrym pomyslem tworzenie w tym momencie klasy abstrakcyjnej.

 */

public class World {
    public static void main(String[] args){
        try {
            MoveDirection[] directions = new OptionParser().parse(args);
            RectangularMap map = new RectangularMap(10, 5);
            Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(1, 2)};
            IEngine engine = new SimulationEngine(directions, map, positions, map);
            engine.run();
            System.out.print(map.toString());

            MoveDirection[] directions2 = new OptionParser().parse(args);
            GrassField map2 = new GrassField(10);
            Vector2d[] positions2 = {new Vector2d(2, 2), new Vector2d(1, 2)};
            IEngine engine2 = new SimulationEngine(directions2, map2, positions2, map2);
            engine2.run();
            System.out.print(map2.toString());
        }catch (IllegalArgumentException a){
            System.out.println(a);
            return;
        }
    }
}
