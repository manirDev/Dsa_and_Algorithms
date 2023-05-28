package Leetcodes.String;

/*
    XL --> LX
    RX --> XR

    Input: start = "RXXLRXRXL", end = "XRLXXRRLX"
    Output: true
    Explanation: We can transform start to end following these steps:
    RXXLRXRXL ->
    XRXLRXRXL ->
    XRLXRXRXL ->
    XRLXXRRXL ->
    XRLXXRRLX
 */
public class SwapAdjacentInLRString {
    public static void main(String[] args) {
        String start = "RXXLRXRXL";
        String end = "XRLXXRRLX";
        System.out.println(start);
        System.out.println(canTransform(start, end));
        System.out.println(end);
    }

    private static String canTransform(String start, String end) {
        int i = 1;
        int j = 1;
        String xl = "XL";
        String lx = "LX";
        String rx = "RX";
        String xr = "XR";
        StringBuilder sb = new StringBuilder();
        while(i<start.length()){
            String s = ""+start.charAt(i-1) + start.charAt(i);
            if (s.equals(xl)){
                sb.append(lx);
            }

            if (s.equals(rx)){
                sb.append(xr);
            }
            i++;
        }

        return sb.toString();
    }
}
