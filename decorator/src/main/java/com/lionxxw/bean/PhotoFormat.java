package com.lionxxw.bean;

/**
 * PhotoFormat（照片规格）装饰者，扩展自Photo父类
 * Package com.lionxxw.bean
 * Project lionxxw_demos
 * Company www.baofoo.com
 * Author wangjian@baofoo.com
 * Created on 2016/10/24 11:24
 * version 1.0.0
 */
public abstract class PhotoFormat extends Photo {

    /**
     * 简介
     * @return
     */
    public abstract String getDescription();
}
