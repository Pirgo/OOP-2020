package agh.cs.lab7;

import agh.cs.lab2.Vector2d;

import java.util.Comparator;

public class Xcomparator implements Comparator<Vector2d> {

    @Override
    public int compare(Vector2d oldpos, Vector2d newpos) {
        if(oldpos.x > newpos.x){
            return 1;
        }
        else if(oldpos.x < newpos.x){
            return -1;
        }
        else{
            return Integer.compare(oldpos.x, newpos.x);
        }
    }
}
