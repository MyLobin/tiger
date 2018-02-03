package com.lobin.common.pattern.decorator;

public class RedShapeDecorator extends ShapeDecorator {
    @Override
    public void draw() {
        super.draw();
        System.out.println("red");
    }

    public RedShapeDecorator(Shape decoratorShape) {
        super(decoratorShape);
    }
}
