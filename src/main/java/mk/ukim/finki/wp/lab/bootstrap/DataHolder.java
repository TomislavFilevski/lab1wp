package mk.ukim.finki.wp.lab.bootstrap;

import mk.ukim.finki.wp.lab.model.Chef;
import mk.ukim.finki.wp.lab.model.Dish;

import java.util.ArrayList;
import java.util.List;

public class DataHolder {
    public static List<Chef> chefs = new ArrayList<>();
    public static List<Dish> dishes = new ArrayList<>();

    static {
        chefs.add(new Chef(1L, "Gordon", "Ramsay", "World-renowned chef with 16 Michelin stars"));
        chefs.add(new Chef(2L, "Jamie", "Oliver", "British celebrity chef and restaurateur"));
        chefs.add(new Chef(3L, "Marco", "Pierre White", "First British chef to earn three Michelin stars"));
        chefs.add(new Chef(4L, "Wolfgang", "Puck", "Austrian-American chef and restaurateur"));
        chefs.add(new Chef(5L, "Emeril", "Lagasse", "American celebrity chef known for Creole cuisine"));

        dishes.add(new Dish("D001", "Pasta Carbonara", "Italian", 25));
        dishes.add(new Dish("D002", "Beef Wellington", "British", 90));
        dishes.add(new Dish("D003", "Chicken Tikka Masala", "Indian", 45));
        dishes.add(new Dish("D004", "Sushi Platter", "Japanese", 30));
        dishes.add(new Dish("D005", "Paella", "Spanish", 60));
    }
}