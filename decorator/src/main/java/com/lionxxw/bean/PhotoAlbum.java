package com.lionxxw.bean;

/**
 * 照片入册
 * Package com.lionxxw.bean
 * Project lionxxw_demos
 * Company www.baofoo.com
 * Author wangjian@baofoo.com
 * Created on 2016/10/24 11:32
 * version 1.0.0
 */
public class PhotoAlbum extends PhotoFormat {
    private Photo photo;

    public PhotoAlbum(Photo photo) {
        this.photo = photo;
    }

    private double price = 10.00;

    @Override
    public String getDescription() {
        return photo.getDescription()+" + album(照片入册)";
    }

    @Override
    public Double cost() {
        return photo.cost()+this.price;
    }
}
