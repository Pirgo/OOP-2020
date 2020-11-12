package agh.cs.lab4;

import agh.cs.lab2.Vector2d;
import agh.cs.lab4.Animal;
import agh.cs.lab5.AbstractWorldMap;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class RectangularMap extends AbstractWorldMap {

//    private List<Animal> animals = new ArrayList<Animal>();
    private int width, height;
    private Vector2d begin = new Vector2d(1,1);
    private Vector2d end;
    private MapVisualizer map;



    public RectangularMap(int x, int y){
        this.width = x;
        this.height = y;
        this.end = new Vector2d(x,y);
    }
//    @Override
//    public List<Animal> getAnimals(){
//        return this.animals;
//    }

//    @Override
//    public boolean isOccupied(Vector2d position) {
//        for (int i = 0; i < this.animals.size(); i++){
//            if(this.animals.get(i).getPosition().equals(position)) return true;
//        }
//        return false;
//    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if(position.x > 0 && position.x <= this.width && position.y > 0 && position.y <= this.height) return !this.isOccupied(position);
        return false;
    }

//    @Override
//    public boolean place(Animal animal) {
//        if(canMoveTo(animal.getPosition())){
//            this.animals.add(animal);
//            return true;
//        }
//        return false;
//    }


//    @Override
//    public Object objectAt(Vector2d position) {
//        for (int i = 0; i<this.animals.size(); i++){
//            if(this.animals.get(i).getPosition().equals(position)) return this.animals.get(i);
//        }
//        return null;
//
//    }

    public String toString(){
        MapVisualizer map = new MapVisualizer(this);
        return map.draw(this.begin, this.end);
    }
}
