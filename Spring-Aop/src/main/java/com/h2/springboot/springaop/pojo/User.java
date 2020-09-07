package com.h2.springboot.springaop.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Created by: huhao
 * Date: 2020/9/7
 */
@Data
@Accessors(chain=true)
public class User {
    private String id;
    private String name;
}
