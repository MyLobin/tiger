package com.lobin.common.pattern.builder;

public class Main {
    public static void main(String[] args) {
        MealBuilder builder=new MealBuilder();

        Meal vegMeal=builder.prepareVegMeal();
        vegMeal.showItems();

        Meal nonVegMeal=builder.prepareNonVegMeal();
        nonVegMeal.showItems();
    }
}
