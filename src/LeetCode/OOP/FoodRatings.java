package LeetCode.OOP;

import java.util.*;

public class FoodRatings {
    String[] foods;
    String[] cuisines;
    int[] ratings;
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        this.foods = foods;
        this.cuisines = cuisines;
        this.ratings = ratings;
    }

    public void changeRating(String food, int newRating) {
        int idx = 0;
        for (int i=0; i< foods.length; i++){
            if (foods[i].equals(food)){
                idx = i;
            }
        }
        ratings[idx] = newRating;
    }

    public String highestRated(String cuisine) {
        Map<String, Integer> foodRatings = new HashMap<>();
        for (int i=0; i<foods.length; i++){
            if (cuisines[i].equals(cuisine)){
                foodRatings.put(foods[i], ratings[i]);
            }

        }
        Map<String, Integer> sortFoodRatings = new TreeMap<>(foodRatings);
        int maxRating = Integer.MIN_VALUE;
        String foodRes = "";
        for (Map.Entry<String, Integer> entry : sortFoodRatings.entrySet()){
            if (entry.getValue() > maxRating){
                maxRating = entry.getValue();
                foodRes = entry.getKey();
            }
        }
        return foodRes;
    }

    public static void main(String[] args) {
        String[] foods = {"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"};
        String[] cuisines = {"korean", "japanese", "japanese", "greek", "japanese", "korean"};
        int[] ratings = {9, 12, 8, 15, 14, 7};
        FoodRatings foodRatings = new FoodRatings(foods, cuisines, ratings);
        System.out.println(foodRatings.highestRated("korean")); // return "kimchi"
        // "kimchi" is the highest rated korean food with a rating of 9.
        System.out.println(foodRatings.highestRated("japanese")); // return "ramen"
        // "ramen" is the highest rated japanese food with a rating of 14.
        foodRatings.changeRating("sushi", 16); // "sushi" now has a rating of 16.
        System.out.println(foodRatings.highestRated("japanese"));; // return "sushi"
        // "sushi" is the highest rated japanese food with a rating of 16.
        foodRatings.changeRating("ramen", 16); // "ramen" now has a rating of 16.
        System.out.println(foodRatings.highestRated("japanese"));; // return "ramen"
        // Both "sushi" and "ramen" have a rating of 16.
        // However, "ramen" is lexicographically smaller than "sushi".
    }
}
