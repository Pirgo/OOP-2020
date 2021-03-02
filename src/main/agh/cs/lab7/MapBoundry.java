package agh.cs.lab7;

import agh.cs.lab2.Vector2d;
import agh.cs.lab4.Animal;
import agh.cs.lab5.Grass;
import agh.cs.lab6.IPositionChangeObserver;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class MapBoundry implements IPositionChangeObserver {
    TreeSet<Vector2d> animalsX = new TreeSet<Vector2d>(new Xcomparator());
    TreeSet<Vector2d> animalsY = new TreeSet<Vector2d>(new Ycomparator());
    TreeSet<Vector2d> grassX = new TreeSet<Vector2d>(new Xcomparator());
    TreeSet<Vector2d> grassY = new TreeSet<Vector2d>(new Ycomparator());

    public void placeAnimal(Animal animal){
        animalsX.add(animal.getPosition());
        animalsY.add(animal.getPosition());
    }

    public void placeGrass(Grass grass){
        grassX.add(grass.getPosition());
        grassY.add(grass.getPosition());
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        animalsX.remove(oldPosition);
        animalsX.add(newPosition);
        animalsY.remove(oldPosition);
        animalsY.add(newPosition);
    }

    public Vector2d getBegin(){
        return new Vector2d(min(animalsX.first().x , grassX.first().x), min(animalsY.first().y, grassY.first().y));
    }

    public Vector2d getEnd(){
        return new Vector2d(max(animalsX.last().x , grassX.last().x), max(animalsY.last().y, grassY.last().y));
    }




}
