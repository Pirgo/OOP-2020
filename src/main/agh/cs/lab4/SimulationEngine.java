package agh.cs.lab4;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab6.IPositionChangeObserver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SimulationEngine implements IEngine {
    private MoveDirection[] directions;
    private IWorldMap map;
    private Vector2d[] positions;


    public SimulationEngine(MoveDirection[] dir, IWorldMap map, Vector2d[] pos, IPositionChangeObserver observer){
        this.directions = dir;
        this.map = map;
        this.positions = pos;
        for(Vector2d u: pos){
            Animal tmp = new Animal(this.map, u, observer);
            this.map.place(tmp);
        }
    }


    @Override
    public void run() {
        Collection<Animal> animals1 = map.getAnimals().values();
        List<Animal> animals = new ArrayList<>(animals1);
        for(int i = 0; i < this.directions.length; i++){
            animals.get(i % animals.size()).move(this.directions[i]);
        }
    }
}
