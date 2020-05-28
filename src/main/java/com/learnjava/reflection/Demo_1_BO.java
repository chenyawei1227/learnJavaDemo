package com.learnjava.reflection;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Author: chenyawei
 * @Date: 2020-05-27  14:36
 * @Description:
 */
@Data
@ToString
public class Demo_1_BO implements Serializable {
    private Integer peopleNum;

    public Demo_1_BO(){

    }
    public Demo_1_BO(Integer peopleNum){
        this.peopleNum = peopleNum;
    }

}
