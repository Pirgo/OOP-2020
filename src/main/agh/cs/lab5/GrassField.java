package agh.cs.lab5;

import agh.cs.lab2.Vector2d;
import agh.cs.lab4.Animal;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab4.MapVisualizer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class GrassField extends AbstractWorldMap {

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
    public boolean canMoveTo(Vector2d position) {
        if (position.x > 0 && position.y > 0 && (!isOccupied(position) || objectAt(position) instanceof Grass))
            return true;
        return false;
    }

    @Override
    public Vector2d getEnd(){
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
        return new Vector2d(maxX + 1, maxY + 1);

    }

    @Override
    public Vector2d getBegin(){
        return this.begin;
    }
}
