package agh.cs.lab3;

import agh.cs.lab2.MapDirection;
import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab4.IWorldMap;

public class Animal{
    private MapDirection orient = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);

    public String toString(){
        return this.position.toString() + this.orient.toString();
    }

    public String getOrient(){
        return this.orient.toString();
    }
    public String getPos(){
        return this.position.toString();
    }

    public void move(MoveDirection direction){
        switch (direction){
            case RIGHT:
                this.orient = orient.next();
                break;
            case LEFT:
                this.orient = orient.previous();
                break;
            case FORWARD:
                Vector2d tmp = new Vector2d(this.position.x, this.position.y);
                this.position = tmp.add(orient.toUnitVector());
                break;
            case BACKWARD:
                Vector2d tmp1 = new Vector2d(this.position.x, this.position.y);
                this.position = tmp1.subtract(orient.toUnitVector());
                break;

        }
        if (this.position.x < 0) this.position = new Vector2d(0,this.position.y);
        else if (this.position.x > 4) this.position = new Vector2d(4,this.position.y);
        else if (this.position.y > 4) this.position = new Vector2d(this.position.x ,4);
        else if (this.position.y < 0) this.position = new Vector2d(this.position.x,0);
    }
}
