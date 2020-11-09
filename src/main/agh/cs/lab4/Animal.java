package agh.cs.lab4;

import agh.cs.lab2.MapDirection;
import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;

public class Animal {

    private MapDirection orient = MapDirection.NORTH;
    private Vector2d position;
    private IWorldMap worldMap;

    public Animal(IWorldMap map) {
        this.worldMap = map;
    }

    public Animal(IWorldMap map, Vector2d initialPosition) {
        this.worldMap = map;
        this.position = initialPosition;
    }

    public Vector2d getPosition() {
        return this.position;
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
                }
                break;
            case BACKWARD:
                Vector2d tmp1 = new Vector2d(this.position.x, this.position.y);
                tmp1 = tmp1.subtract(orient.toUnitVector());
                if (this.worldMap.canMoveTo(tmp1)) {
                    this.position = tmp1;
                }
                break;

        }

    }
}
