package com.learnjava.reflection;

import lombok.Data;
import org.omg.PortableInterceptor.INACTIVE;

/**
 * @Author: chenyawei
 * @Date: 2020-05-27  14:36
 * @Description:
 */
@Data
public class Demo_2_BO {
    private Integer peopleNum;

    public Demo_2_BO(Integer peopleNum){
        this.peopleNum = peopleNum;
    }
}
