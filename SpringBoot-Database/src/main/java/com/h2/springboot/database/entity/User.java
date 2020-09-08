package com.h2.springboot.database.entity;

import com.h2.springboot.database.convert.SexConverter;
import com.h2.springboot.database.enu.SexEnum;
import lombok.Data;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by: huhao
 * Date: 2020/9/8
 */
@Data
@Entity(name = "user")
@Table(name = "t_user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="user_name")
    private String userName;
    @Convert(converter= SexConverter.class)
    private SexEnum sex;
    @Column(name = "note")
    private String note;
}
