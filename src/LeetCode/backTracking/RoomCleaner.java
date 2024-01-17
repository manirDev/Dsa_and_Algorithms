package LeetCode.backTracking;

import java.util.HashSet;

public class RoomCleaner {
   /* enum Direction{

        UP(0, 1, "up"),
        DOWN(0, -1, "down"),
        LEFT(-1, 0, "left"),
        RIGHT(1, 0, "right");

        int r;
        int c;
        String d;

        Direction(int r, int c, String d){
            this.r = r;
            this.c = c;
            this.d = d;
        }

        public String toString(){
            return d;
        }
    }

    // all possible directions
    Direction[] directions = new Direction[]{Direction.UP, Direction.RIGHT, Direction.DOWN, Direction.LEFT};

    Robot robot;

    // tracks current direction robot is facing
    Direction currentDirection;

    // tracks visited cells
    HashMap<Integer, HashSet<Integer>> visited = new HashMap<>();


    public void cleanRoom(Robot robot) {

        currentDirection = Direction.UP;
        this.robot = robot;
        traverse(0, 0);
    }

    private void traverse(int row, int col){
        // clean current room
        robot.clean();

        // mark current room as visited
        visit(row, col);

        // store original direction the robot was facing when it entered this cell
        Direction original = copy(currentDirection);

        // iterate over all directions
        for(Direction dir : directions){
            int nr = row + dir.r;
            int nc = col + dir.c;

            // check if cell is not visited
            if(!isVisted(nr, nc)){

                // turn robot toward direction of neighboring cell
                turn(currentDirection, dir);
                // track the above direction change
                currentDirection = dir;

                // we need to check if robot can move into the neighboring cell
                // because robot may try to visit unvisited obstacles or walls
                if(robot.move()){

                    // if neighbor is visitable then recurse
                    traverse(nr, nc);
                }
                else{
                    // if neighbor not visitable mark it as visited to avoid
                    // unnecessary calls to robot.move()
                    visit(nr, nc);
                }
            }

        }

        // recursion is done
        // so we need to restore position of robot from which it entered this cell
        // this is done by finding opposite direction of original direction from
        // which the robot entered the cell and turning it in this opposite direction
        // now we just move the robot in this opposite direction
        Direction oppositeOriginal = getOpposite(original);
        turn(currentDirection, oppositeOriginal);
        currentDirection = oppositeOriginal;
        robot.move();
    }

    // helper for marking cell as visited
    private void visit(int r, int c){
        HashSet<Integer> hs = visited.getOrDefault(r, new HashSet<Integer>());
        hs.add(c);
        visited.put(r, hs);
    }

    // helper to check if cell is visited
    private boolean isVisted(int r, int c){
        return visited.containsKey(r) && visited.get(r).contains(c);
    }

    // creates copy of direction
    private Direction copy(Direction f){
        if(f == Direction.UP)
            return Direction.UP;
        if(f == Direction.DOWN)
            return Direction.DOWN;
        if(f == Direction.LEFT)
            return Direction.LEFT;
        if(f == Direction.RIGHT)
            return Direction.RIGHT;
        return null;
    }

    // returns opposite of direction
    private Direction getOpposite(Direction f){
        if(f == Direction.UP)
            return Direction.DOWN;
        if(f == Direction.DOWN)
            return Direction.UP;
        if(f == Direction.LEFT)
            return Direction.RIGHT;
        if(f == Direction.RIGHT)
            return Direction.LEFT;
        return null;
    }

    // function which tells robot how to move from one direction to other
    private void turn(Direction from, Direction to){
        if(from == to)
            return;
        if(from == Direction.UP){
            if(to == Direction.DOWN){
                robot.turnLeft();
                robot.turnLeft();
            }
            else if(to == Direction.LEFT)
                robot.turnLeft();
            else if(to == Direction.RIGHT)
                robot.turnRight();
        }
        else if(from == Direction.DOWN){
            if(to == Direction.UP){
                robot.turnLeft();
                robot.turnLeft();
            }
            else if(to == Direction.LEFT)
                robot.turnRight();
            else if(to == Direction.RIGHT)
                robot.turnLeft();
        }
        else if(from == Direction.LEFT){
            if(to == Direction.RIGHT){
                robot.turnLeft();
                robot.turnLeft();
            }
            else if(to == Direction.UP)
                robot.turnRight();
            else if(to == Direction.DOWN)
                robot.turnLeft();
        }
        else if(from == Direction.RIGHT){
            if(to == Direction.LEFT){
                robot.turnLeft();
                robot.turnLeft();
            }
            else if(to == Direction.UP)
                robot.turnLeft();
            else if(to == Direction.DOWN)
                robot.turnRight();
        }
    }*/
}
