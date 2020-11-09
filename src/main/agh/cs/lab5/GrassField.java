package agh.cs.lab5;

import agh.cs.lab2.Vector2d;
import agh.cs.lab4.Animal;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab4.MapVisualizer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class GrassField implements IWorldMap {

    private List<Animal> animals = new ArrayList<Animal>();
    private List<Grass> grass = new ArrayList<Grass>();
    private Vector2d begin = new Vector2d(0,0);
    private Vector2d end;
    private int quantity;


    public GrassField(int cnt){
        this.quantity = cnt;
        int maxpos = (int) StrictMath.sqrt(cnt*10);
        for(int i=0; i<this.quantity;){
            int x = ThreadLocalRandom.current().nextInt(0,maxpos);
            int y = ThreadLocalRandom.current().nextInt(0,maxpos);
            if(!isOccupied(new Vector2d(x,y))){
                i++;
                this.grass.add(new Grass(new Vector2d(x,y)));
            }

        }
    }


    @Override
    public List<Animal> getAnimals() {
        return this.animals;
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
    public boolean canMoveTo(Vector2d position) {
        if (position.x > 0 && position.y > 0 && (!isOccupied(position) || objectAt(position) instanceof Grass))
            return true;
        return false;
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
    public Object objectAt(Vector2d position) {
        for (int i = 0; i < this.animals.size(); i++) {
            if (this.animals.get(i).getPosition().equals(position)) return this.animals.get(i);
        }
        for(int j = 0; j < this.grass.size(); j++){
            if(this.grass.get(j).getPosition().equals(position)) return this.grass.get(j);
        }
        return null;

    }

    public String toString(){
        int maxX = 0;
        int maxY = 0;
        for(Animal a: this.animals){
            maxX = Math.max(a.getPosition().x, maxX);
            maxY = Math.max(a.getPosition().y, maxY);
        }
        for(Grass g: this.grass){
            maxX = Math.max(g.getPosition().x, maxX);
            maxY = Math.max(g.getPosition().y, maxY);
        }
        MapVisualizer map = new MapVisualizer(this);
        this.end = new Vector2d(maxX + 1, maxY + 1);
        return map.draw(this.begin, this.end);
    }
}
