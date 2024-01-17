package LeetCode.backTracking;

public class RobotCleanerIII {
//    Set<String> visited = new HashSet<>();
//    int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
//    public void cleanRoom(Robot robot) {
//        //faceUp==>true
//        //faceDown ==> false
//        //faceRight ==> false
//        //faceLeft ==> false;
//        roomCleanerHelper(robot, 0, 0, true, false, false, false);
//    }
//    private void roomCleanerHelper(Robot robot, int row, int col, boolean faceUp, boolean faceDown, boolean faceRight, boolean faceLeft){
//        visited.add(row +""+ col);
//        robot.clean();
//        for(int i=1; i<=4; i++){
//            int dir = (currDir)
//        }
//        if(faceUp){
//            if(robot.move()){
//                roomCleanerHelper(robot, row - 1, col, faceUp, faceDown, faceRight, faceLeft);
//                faceUp = false;
//            }
//            else{
//                robot.turnRight();
//                faceRight = true;
//                roomCleanerHelper(robot, row, col + 1, faceUp, faceDown, faceRight, faceLeft);
//                robot.turnLeft();
//                faceLeft = true;
//                roomCleanerHelper(robot, row, col - 1, faceUp, faceDown, faceRight, faceLeft);
//            }
//        }
//        if(faceDown){
//            if(robot.move()){
//                roomCleanerHelper(robot, row + 1, col, faceUp, faceDown, faceRight, faceLeft);
//                faceDown = false;
//            }
//            else{
//                robot.turnRight();
//                faceLeft = true;
//                roomCleanerHelper(robot, row, col - 1, faceUp, faceDown, faceRight, faceLeft);
//                robot.turnLeft();
//                faceRight = true;
//                roomCleanerHelper(robot, row, col + 1, faceUp, faceDown, faceRight, faceLeft);
//            }
//        }
//        if(faceRight){
//            if(robot.move()){
//                roomCleanerHelper(robot, row, col + 1, faceUp, faceDown, faceRight, faceLeft);
//                faceRight = false;
//            }else{
//                robot.turnRight();
//                faceDown = true;
//                roomCleanerHelper(robot, row + 1, col, faceUp, faceDown, faceRight, faceLeft);
//                robot.turnLeft();
//                faceUp = true;
//                roomCleanerHelper(robot, row - 1, col, faceUp, faceDown, faceRight, faceLeft);
//            }
//        }
//        if(faceLeft){
//            if(robot.move()){
//                roomCleanerHelper(robot, row, col + 1, faceUp, faceDown, faceRight, faceLeft);
//                faceLeft = false;
//            }
//            else{
//                robot.turnRight();
//                faceUp = true;
//                roomCleanerHelper(robot, row - 1, col, faceUp, faceDown, faceRight, faceLeft);
//                robot.turnLeft();
//                faceDown = true;
//                roomCleanerHelper(robot, row + 1, col, faceUp, faceDown, faceRight, faceLeft);
//            }
//        }
//    }
}
