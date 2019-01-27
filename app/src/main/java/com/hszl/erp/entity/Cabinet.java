package com.hszl.erp.entity;

import java.io.Serializable;

/**
 * 写个事例对象，目前只需要name属性值，实际字段根据接口的返回值
 * 添加响应的字段，因为目前接口没出来
 */
public class Cabinet implements Serializable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
