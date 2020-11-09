package agh.cs.lab1;

import java.util.Arrays;

public class World {
    static void run(Direction[] args){
        for(Direction u : args){
            switch (u){
                case f:
                    System.out.println("zwierzak idzie do przodu");
                    break;
                case b:
                    System.out.println("zwierzak idzie do tyłu");
                    break;
                case r:
                    System.out.println("zwierzak skręca w prawo");
                    break;
                case l:
                    System.out.println("zwierzak skręca w lewo");
                    break;
            }
        }

//        System.out.println("Zwierzak idzie do przodu");
//        for(String u : Arrays.copyOfRange(args, 0, args.length - 1)){
//            System.out.print(u + ", ");
//        }
//        System.out.println(args[args.length - 1]);
    }
    public static void main(String[] args){
        System.out.println("start");
        Direction[] dir = new Direction[args.length];
        for(int i = 0; i < args.length; i++){
            dir[i] = Direction.valueOf(args[i]);
        }
        //String[] r_arg = {"raz", "dwa", "trzy"};
        run(dir);
        System.out.println("stop");
    }
}
