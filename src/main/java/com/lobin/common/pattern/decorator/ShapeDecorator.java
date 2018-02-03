package com.lobin.common.pattern.decorator;

public abstract class ShapeDecorator implements Shape{
    protected Shape decoratorShape;

    public ShapeDecorator(Shape decoratorShape){
        this.decoratorShape=decoratorShape;
    }
    @Override
    public void draw() {
        this.decoratorShape.draw();
    }
}
