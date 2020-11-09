package agh.cs.lab3;

import agh.cs.lab2.MoveDirection;

import java.util.Arrays;

public class OptionParser {
    public static MoveDirection[] parse(String[] tab){
        MoveDirection[] directions = new MoveDirection[tab.length];
        int cnt = 0;
        for (String u : tab){
            switch (u){
                case "f":
                    directions[cnt++] = MoveDirection.FORWARD;
                    break;
                case "b":
                    directions[cnt++] = MoveDirection.BACKWARD;
                    break;
                case "r":
                    directions[cnt++] = MoveDirection.RIGHT;
                    break;
                case "l":
                    directions[cnt++] = MoveDirection.LEFT;
                    break;
            }
        }
        return Arrays.copyOfRange(directions, 0, cnt);
    }
}
