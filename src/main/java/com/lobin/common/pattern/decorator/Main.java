package com.lobin.common.pattern.decorator;

/**
 * 装饰器模式
 *
 */
public class Main {
    public static void main(String[] args) {
        Shape shape=new RedShapeDecorator(new Circle());
        shape.draw();
    }
}
