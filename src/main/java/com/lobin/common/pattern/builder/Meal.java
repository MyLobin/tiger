package com.lobin.common.pattern.builder;

import java.util.ArrayList;
import java.util.List;

public class Meal {
    private List<Item> items=new ArrayList<>();
    public void addItem(Item item){
        items.add(item);
    }
    public void showItems(){
        for(Item item:items){
            System.out.println(item.name());
            System.out.println(item.packing().pack());
        }
    }
}
