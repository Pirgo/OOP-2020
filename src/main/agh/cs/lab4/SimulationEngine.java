package agh.cs.lab4;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine {
    private MoveDirection[] directions;
    private IWorldMap map;
    private Vector2d[] positions;


    public SimulationEngine(MoveDirection[] dir, IWorldMap map, Vector2d[] pos){
        this.directions = dir;
        this.map = map;
        this.positions = pos;
        for(Vector2d u: pos){
            Animal tmp = new Animal(this.map, u);
            this.map.place(tmp);
        }
    }


    @Override
    public void run() {
        List<Animal> animals = map.getAnimals();
        for(int i = 0; i < this.directions.length; i++){
            animals.get(i % animals.size()).move(this.directions[i]);
        }
    }
}
