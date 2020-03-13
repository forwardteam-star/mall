package com.ec.ec.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * (User)实体类
 *
 */
@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    //手机号
    private String phone;
    //性别
    private String sex;
    //昵称
    private String name;
    //年龄
    private String age;
    //收货地址
    private String address;
    //收货地址
    private String address2;
    //收货地址
    private String address3;
    //密码
    private String password;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    public User() {
    }

    public User(String phone, String sex, String name, String age, String address, String address2, String address3, String password, Date date) {
        this.phone = phone;
        this.sex = sex;
        this.name = name;
        this.age = age;
        this.address = address;
        this.address2 = address2;
        this.address3 = address3;
        this.password = password;
        this.date = date;
    }
}