package agh.cs.lab5;

import agh.cs.lab2.Vector2d;
import agh.cs.lab4.Animal;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab4.MapVisualizer;
import agh.cs.lab6.IPositionChangeObserver;
import agh.cs.lab7.MapBoundry;

import java.util.*;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
//    protected List<Animal> animals = new ArrayList<Animal>();
//    protected List<Grass> grass = new ArrayList<Grass>();
    protected Map<Vector2d, Animal> animalMap = new LinkedHashMap<>();
    protected Map<Vector2d, Grass> grassMap = new LinkedHashMap<>();
    protected MapBoundry mapBoundry = new MapBoundry();

    public abstract Vector2d getBegin();
    public abstract Vector2d getEnd();


    @Override
    public Map<Vector2d,Animal> getAnimals() {
        return this.animalMap;
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        this.mapBoundry.positionChanged(oldPosition, newPosition);
        Animal animal = (Animal)this.objectAt(oldPosition);
        this.animalMap.remove(oldPosition);
        this.animalMap.put(newPosition, animal);
    }

    @Override
    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition())) {
            this.animalMap.put(animal.getPosition(), animal);
            this.mapBoundry.placeAnimal(animal);
            return true;
        }
        throw new IllegalArgumentException(String.valueOf("position" + animal.getPosition()) + "is occupied or out of the map");
    }

    @Override
    public boolean isOccupied(Vector2d position) {
//        for(Animal a : this.animals){
//            if(a.getPosition().equals(position)) return true;
//        }
//        for(Grass g : this.grass){
//            if (g.getPosition().equals(position)) return true;
//        }
        if(this.animalMap.containsKey(position) || this.grassMap.containsKey(position)) return true;

        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
//        for (int i = 0; i < this.animals.size(); i++){
//            if (this.animals.get(i).getPosition().equals(position)) return this.animals.get(i);
//        }
//        for(int j = 0; j < this.grass.size(); j++){
//            if(this.grass.get(j).getPosition().equals(position)) return this.grass.get(j);
//        }
        if(this.animalMap.containsKey(position)) return animalMap.get(position);
        if(this.grassMap.containsKey(position)) return grassMap.get(position);
        return null;

    }

    @Override
    public String toString(){
        MapVisualizer map = new MapVisualizer(this);
        return map.draw(getBegin(), getEnd());
    }
}
