package com.lionxxw.bean;

import lombok.Getter;
import lombok.Setter;

/**
 * 照片基类(共同抽象父类)
 * Package com.lionxxw.bean
 * Project lionxxw_demos
 * Company www.baofoo.com
 * Author wangjian@baofoo.com
 * Created on 2016/10/24 11:20
 * version 1.0.0
 */
public abstract class Photo {
    @Getter
    @Setter
    private String description = "";         // 简介

    /**
     * 价格
     * @return
     */
    public abstract Double cost();
}