package agh.cs.lab4;

import agh.cs.lab2.MapDirection;
import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab6.IPositionChangeObserver;

import java.util.ArrayList;
import java.util.List;

public class Animal {

    private MapDirection orient = MapDirection.NORTH;
    private Vector2d position;
    private IWorldMap worldMap;
    private List<IPositionChangeObserver> observers = new ArrayList<>();

    public Animal(IWorldMap map) {
        this.worldMap = map;
    }


    public Animal(IWorldMap map, Vector2d initialPosition, IPositionChangeObserver observer) {
        this.worldMap = map;
        this.position = initialPosition;
        this.addObserver(observer);
    }

    public Vector2d getPosition() {
        return this.position;
    }

    public void addObserver(IPositionChangeObserver observer){
        this.observers.add(observer);
    }

    public void removeObserver(IPositionChangeObserver observer){
        this.observers.remove(observer);
    }

    public MapDirection getOrient(){
        return this.orient;
    }

    public String toString() {
        if (this.orient.toString().equals("Północ")) return "N";
        if (this.orient.toString().equals("Wschód")) return "E";
        if (this.orient.toString().equals("Zachód")) return "W";
        if (this.orient.toString().equals("Południe")) return "S";
        return null;
    }


    public void move(MoveDirection direction) {
        Vector2d oldpos = this.position;
        switch (direction) {
            case RIGHT:
                this.orient = orient.next();
                break;
            case LEFT:
                this.orient = orient.previous();
                break;
            case FORWARD:
                Vector2d tmp = new Vector2d(this.position.x, this.position.y);
                tmp = tmp.add(orient.toUnitVector());
                if (this.worldMap.canMoveTo(tmp)) {
                    this.position = tmp;
                    this.positionChanged(oldpos, this.position);
                }
                break;
            case BACKWARD:
                Vector2d tmp1 = new Vector2d(this.position.x, this.position.y);
                tmp1 = tmp1.subtract(orient.toUnitVector());
                if (this.worldMap.canMoveTo(tmp1)) {
                    this.position = tmp1;
                    this.positionChanged(oldpos, this.position);
                }
                break;

        }

    }
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        for(IPositionChangeObserver observer : this.observers){
            observer.positionChanged(oldPosition, newPosition);
        }
    }
}
