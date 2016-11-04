package com.lionxxw.test;

import com.lionxxw.bean.PhotoAlbum;
import com.lionxxw.bean.PhotoPs;
import com.lionxxw.bean.WeddingPhoto;

/**
 * 测试
 * Package com.lionxxw.test
 * Project lionxxw_demos
 * Company www.baofoo.com
 * Author wangjian@baofoo.com
 * Created on 2016/10/24 13:20
 * version 1.0.0
 */
public class Test {
    public static void main(String[] args) {
        WeddingPhoto photo = new WeddingPhoto();
        PhotoPs ps = new PhotoPs(photo);
        System.out.println(ps.getDescription()+"价格:"+ps.cost());

        PhotoAlbum album = new PhotoAlbum(ps);
        System.out.println(album.getDescription()+"价格"+album.cost());

        PhotoAlbum album2 = new PhotoAlbum(photo);
        System.out.println(album2.getDescription()+"价格"+album2.cost());
    }
}