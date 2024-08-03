package Libraries;

public class Libs {
    public static Integer max_int = Integer.MAX_VALUE;
    public static Integer min_int = Integer.MIN_VALUE;


    public static boolean rowAndColInBounds(int row, int col, int rowLen, int colLen){
        boolean rowInBounds = row >= 0 && row < rowLen;
        boolean colInBounds = col >= 0 && col < colLen;
        return  rowInBounds  || colInBounds;
    }
    public static boolean isNotInLenBounds(int row, int col, int rowLen, int colLen){
        boolean rowInBounds = row < rowLen;
        boolean colInBounds = col < colLen;
        return  !rowInBounds  || !colInBounds;
    }
}
