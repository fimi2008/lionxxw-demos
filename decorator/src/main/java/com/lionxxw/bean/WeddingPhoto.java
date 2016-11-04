package com.lionxxw.bean;

/**
 * 婚纱照
 * Package com.lionxxw.bean
 * Project lionxxw_demos
 * Company www.baofoo.com
 * Author wangjian@baofoo.com
 * Created on 2016/10/24 11:34
 * version 1.0.0
 */
public class WeddingPhoto extends Photo {
    private double price = 40.00;

    public WeddingPhoto() {
        setDescription(getDescription()+"wedding(婚纱照)");
    }

    @Override
    public Double cost() {
        return this.price;
    }
}
