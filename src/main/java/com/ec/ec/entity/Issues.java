package com.ec.ec.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
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
 * (Issues)实体类
 *
 */
@Data
@Entity@JsonIgnoreProperties("hibernateLazyInitializer")
public class Issues implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    
    private String issuesName;
    
    private String issuesUrl;
    //剩余数量
    private Integer issuesNum;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date issuesDate;
    //商品描述
    private String issuesDetails;
    
    private Double issuesPrice;

    public Issues() {
    }

    public Issues(String issuesName, String issuesUrl, Integer issuesNum, String issuesDetails, Double issuesPrice) {

        this.issuesName = issuesName;
        this.issuesUrl = issuesUrl;
        this.issuesNum = issuesNum;
        this.issuesDate = new Date();
        this.issuesDetails = issuesDetails;
        this.issuesPrice = issuesPrice;
    }

    public Issues(Integer id, String issuesName, String issuesUrl, Integer issuesNum, String issuesDetails, Double issuesPrice) {
        this.id = id;
        this.issuesName = issuesName;
        this.issuesUrl = issuesUrl;
        this.issuesNum = issuesNum;
        this.issuesDate = new Date();
        this.issuesDetails = issuesDetails;
        this.issuesPrice = issuesPrice;
    }
}