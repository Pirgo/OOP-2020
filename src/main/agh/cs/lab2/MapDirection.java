package agh.cs.lab2;

public enum MapDirection {
    NORTH, SOUTH, WEST, EAST;

    public String toString() {
        switch (this) {
            case EAST:
                return "Wschód";
            case WEST:
                return "Zachód";
            case NORTH:
                return "Północ";
            case SOUTH:
                return "Południe";
        }
        return null;
    }
    public MapDirection next(){
        switch (this){
            case EAST: return SOUTH;
            case NORTH: return EAST;
            case SOUTH: return WEST;
            case WEST: return NORTH;
        }
        return null;
    }

    public MapDirection previous(){
        switch (this){
            case WEST: return SOUTH;
            case SOUTH: return EAST;
            case NORTH: return WEST;
            case EAST: return NORTH;
        }
        return null;
    }
    public Vector2d toUnitVector(){
        switch (this){
            case NORTH: return new Vector2d(0,1);
            case SOUTH: return new Vector2d(0,-1);
            case EAST: return new Vector2d(1,0);
            case WEST: return new Vector2d(-1,0);
        }
        return null;
    }
}
