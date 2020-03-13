package com.ec.ec.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * (Cart)实体类
 */
@Entity
@Data
@JsonIgnoreProperties("hibernateLazyInitializer")
public class Cart implements Serializable {
    private static final long serialVersionUID = 535064035329705586L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    
    private long openId;
    
    private long issuesId;
    
    private Integer num;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    public Cart() {
    }

    public Cart(long openId, Integer issuesId, Integer num, Date date) {

        this.openId = openId;
        this.issuesId = issuesId;
        this.num = num;
        this.date = date;
    }


}