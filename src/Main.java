public class Main {
    public static void main(String[] args){
        System.out.println("Hello world!");
        int n = 2; // Desired length

// Calculate the starting value based on n
        int startValue = (int) Math.pow(10, n - 1);

// Loop through all possible combinations of digits starting from the calculated startValue
        for (int i = startValue; i < Math.pow(10, n); i++) {
            // Format the number to have leading zeros if necessary
            String formattedNum = String.format("%0" + n + "d", i);
            System.out.println(formattedNum);
        }
    }
}