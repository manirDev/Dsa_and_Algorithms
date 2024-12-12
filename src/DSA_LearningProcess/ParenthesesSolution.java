package DSA_LearningProcess;

import java.util.*;

public class ParenthesesSolution {
    // Brute Force Solution
    static class BruteForce {
        private String kitParentheses;
        private int[] efficiencyRatings;

        public BruteForce(String kitParentheses, int[] efficiencyRatings) {
            this.kitParentheses = kitParentheses;
            this.efficiencyRatings = efficiencyRatings;
        }

        public int findMaxEfficiencyScore(String s) {
            Set<Integer> availableIndices = new HashSet<>();
            for (int i = 0; i < kitParentheses.length(); i++) {
                availableIndices.add(i);
            }
            return generateCombinations(s, availableIndices, new ArrayList<>());
        }

        private boolean isBalanced(String sequence) {
            int count = 0;
            for (char c : sequence.toCharArray()) {
                if (c == '(') count++;
                else if (c == ')') count--;
                if (count < 0) return false;
            }
            return count == 0;
        }

        private int calculateScore(List<Integer> usedIndices) {
            int score = 0;
            for (int idx : usedIndices) {
                score += efficiencyRatings[idx];
            }
            return score;
        }

        private int generateCombinations(String currSequence, Set<Integer> availableIndices,
                                         List<Integer> usedIndices) {
            if (!isBalanced(currSequence)) {
                return Integer.MIN_VALUE;
            }

            int maxScore = calculateScore(usedIndices);

            for (int i = 0; i < kitParentheses.length(); i++) {
                if (availableIndices.contains(i)) {
                    String newSequence = currSequence + kitParentheses.charAt(i);

                    Set<Integer> newAvailable = new HashSet<>(availableIndices);
                    newAvailable.remove(i);

                    List<Integer> newUsed = new ArrayList<>(usedIndices);
                    newUsed.add(i);

                    int score = generateCombinations(newSequence, newAvailable, newUsed);
                    maxScore = Math.max(maxScore, score);
                }
            }

            return maxScore;
        }
    }
    public static int findMaxEfficiencyScore(String s, String kitParentheses, int[] efficiencyRatings, int m) {

        int maxBalance = m * 2;
        int[] dp = new int[maxBalance + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);

        int balance = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') balance++;
            else if (c == ')') balance--;
        }

        dp[balance] = 0;

        for (int i = 0; i < m; i++) {
            char currChar = kitParentheses.charAt(i);
            int currRate = efficiencyRatings[i];
            int[] updatedDp = Arrays.copyOf(dp, dp.length);

            for (int j = 0; j <= maxBalance; j++) {
                if (dp[j] != Integer.MIN_VALUE) {
                    if (currChar == '(') {

                        if (j + 1 <= maxBalance) {
                            updatedDp[j + 1] = Math.max(updatedDp[j + 1], dp[j] + currRate);
                        }
                    }
                    else if (currChar == ')') {
                        if (j > 0) {
                            updatedDp[j - 1] = Math.max(updatedDp[j - 1], dp[j] + currRate);
                        }
                    }
                }
            }
            dp = updatedDp;
        }

        return dp[0] == Integer.MIN_VALUE ? 0 : dp[0];
    }

    public static void main(String[] args) {
        // Example input
        String s = ")((";
        String kitParentheses = ")(()))";
        int m = 6;
        int[] efficiencyRatings = {3, 4, 2, -4, -1, -3};

        int res = findMaxEfficiencyScore(s, kitParentheses, efficiencyRatings, m);
        System.out.println(res);
    }
}
