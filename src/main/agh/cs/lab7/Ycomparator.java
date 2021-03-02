package agh.cs.lab7;

import agh.cs.lab2.Vector2d;

import java.util.Comparator;

public class  Ycomparator implements Comparator<Vector2d> {
    @Override
    public int compare(Vector2d oldpos, Vector2d newpos) {
        if(oldpos.y > newpos.y){
            return 1;
        }
        else if(oldpos.y < newpos.y){
            return -1;
        }
        else{
            return Integer.compare(oldpos.y, newpos.y);
        }
    }
}
