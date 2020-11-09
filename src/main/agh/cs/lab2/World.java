package agh.cs.lab2;

import agh.cs.lab3.Animal;
import agh.cs.lab3.OptionParser;

public class World {
    public static void main(String[] args){
        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));

        Animal zwierz = new Animal();
        System.out.println(zwierz.toString());
        zwierz.move(MoveDirection.RIGHT);
        zwierz.move(MoveDirection.FORWARD);
        zwierz.move(MoveDirection.FORWARD);
        zwierz.move(MoveDirection.FORWARD);
        System.out.println(zwierz.toString());
        System.out.println(zwierz.getOrient());

        Animal komododragon = new Animal();
        MoveDirection[] where = OptionParser.parse(args);
        System.out.println(komododragon.toString());
        for(MoveDirection u: where){
            komododragon.move(u);
            System.out.println(komododragon.toString());
        }

    }
}
