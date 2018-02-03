package com.lobin.common.pattern.builder;

public class VegBurger extends Burger{
    @Override
    public String name() {
        return "Veg Burger";
    }

    @Override
    public Float price() {
        return null;
    }
}
