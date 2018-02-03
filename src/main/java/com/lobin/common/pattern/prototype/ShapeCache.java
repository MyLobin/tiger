package com.lobin.common.pattern.prototype;

import java.util.HashMap;

public class ShapeCache {
    private static HashMap<String,Shape> shapeMap=new HashMap<>();
    public static Shape getShape(String id){
        Shape cacheShape=shapeMap.get(id);
        return (Shape) cacheShape.clone();
    }
    public static void loadCache(){
        Square square = new Square();
        square.setId("1");
        shapeMap.put(square.getId(),square);

        Rectangle rectangle = new Rectangle();
        rectangle.setId("2");
        shapeMap.put(rectangle.getId(),rectangle);
    }
}
