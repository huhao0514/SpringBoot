package com.h2.springboot.database.convert;

import com.h2.springboot.database.enu.SexEnum;

import javax.persistence.AttributeConverter;

/**
 * Created by: huhao
 * Date: 2020/9/8
 */
public class SexConverter implements AttributeConverter<SexEnum,Integer> {
    //将枚举转换为数据库列
    @Override
    public Integer convertToDatabaseColumn(SexEnum sexEnum) {
        return sexEnum.getId();
    }

    //将数据列转换为枚举
    @Override
    public SexEnum convertToEntityAttribute(Integer id) {
        return SexEnum.getSexById(id);
    }

}
