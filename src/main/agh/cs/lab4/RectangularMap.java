package agh.cs.lab4;

import agh.cs.lab2.Vector2d;
import agh.cs.lab4.Animal;
import agh.cs.lab5.AbstractWorldMap;
import agh.cs.lab5.Grass;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class RectangularMap extends AbstractWorldMap {

    private int width, height;
    private Vector2d begin = new Vector2d(1,1);
    private Vector2d end;
    private MapVisualizer map;



    public RectangularMap(int x, int y){
        this.width = x;
        this.height = y;
        this.end = new Vector2d(x,y);
    }

    @Override
    public Vector2d getBegin() {
        return this.begin;
    }

    @Override
    public Vector2d getEnd(){
        return this.end;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if(position.x > 0 && position.x <= this.width && position.y > 0 && position.y <= this.height) return !this.isOccupied(position);
        return false;
    }



}
