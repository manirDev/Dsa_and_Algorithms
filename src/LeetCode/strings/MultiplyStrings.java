package LeetCode.strings;

public class MultiplyStrings {
    public static void main(String[] args) {
        String num1 = "9";
        String num2 = "9";
        String res = multiplyStringsHelper(num1, num2);
        System.out.println(res);
    }

    private static String multiplyStringsHelper(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int count = -1;
        for (int c2=num2.length() - 1; c2>=0; c2--){
            StringBuilder tempRes = new StringBuilder();
            int carry = 0;
            int c1 = num1.length() - 1;
            while (c1 >=0 || carry > 0){
                int multiplication = 0;
                if (c1 >= 0){
                    multiplication = (num2.charAt(c2) - '0') * (num1.charAt(c1) - '0');
                    c1--;
                }
                multiplication = multiplication + carry;
                carry = multiplication / 10;
                tempRes.append(multiplication % 10);
            }
            count = count + 1;
            if (res.length() == 0){
                res.append(tempRes);
            }
            else{
                tempRes.reverse();
                if (count > 0){
                    for (int k=0; k<count; k++){
                        tempRes.append(0);
                    }
                }
                StringBuilder tempSum = res.reverse();
                res = new StringBuilder();
                carry = 0;
                int i = tempRes.length()  - 1;
                int j = tempSum.length() - 1;
                while (i >= 0 || j >= 0 || carry > 0){
                    int sum = 0;
                    if (i >= 0){
                        sum = sum +  (tempRes.charAt(i) - '0');
                        i--;
                    }
                    if (j >= 0){
                        sum = sum + (tempSum.charAt(j) - '0');
                        j--;
                    }
                    sum = sum + carry;
                    carry = sum / 10;
                    res.append(sum % 10);
                }
            }

        }

        return res.reverse().toString();
    }
}
