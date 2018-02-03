package com.lobin.common.pattern.prototype;

/**
 * 原型设计模式
 */
public class Main {
    public static void main(String[] args) {
        ShapeCache.loadCache();

        Shape cloneShape=ShapeCache.getShape("1");
        System.out.println(cloneShape.type);
    }
}
