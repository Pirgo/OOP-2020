package agh.cs.lab5;

import agh.cs.lab2.Vector2d;
import agh.cs.lab4.Animal;
import agh.cs.lab4.IWorldMap;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractWorldMap implements IWorldMap {
    protected List<Animal> animals = new ArrayList<Animal>();
    protected List<Grass> grass = new ArrayList<Grass>();

    @Override
    public List<Animal> getAnimals() {
        return this.animals;
    }


    @Override
    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition())) {
            this.animals.add(animal);
            return true;
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for(Animal a : this.animals){
            if(a.getPosition().equals(position)) return true;
        }
        for(Grass g : this.grass){
            if (g.getPosition().equals(position)) return true;
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (int i = 0; i < this.animals.size(); i++){
            if (this.animals.get(i).getPosition().equals(position)) return this.animals.get(i);
        }
        for(int j = 0; j < this.grass.size(); j++){
            if(this.grass.get(j).getPosition().equals(position)) return this.grass.get(j);
        }
        return null;

    }
}
