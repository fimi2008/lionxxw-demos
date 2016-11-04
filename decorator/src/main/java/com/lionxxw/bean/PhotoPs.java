package com.lionxxw.bean;

/**
 * 精修照片
 * Package com.lionxxw.bean
 * Project lionxxw_demos
 * Company www.baofoo.com
 * Author wangjian@baofoo.com
 * Created on 2016/10/24 11:23
 * version 1.0.0
 */
public class PhotoPs extends PhotoFormat{

    private Photo photo;

    private double price = 40.00;

    public PhotoPs(Photo photo) {
        this.photo = photo;
    }

    @Override
    public String getDescription() {
        return photo.getDescription()+" + Ps(精修照片)";
    }

    @Override
    public Double cost() {
        return photo.cost()+this.price;
    }
}