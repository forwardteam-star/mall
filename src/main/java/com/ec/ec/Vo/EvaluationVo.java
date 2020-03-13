package com.ec.ec.Vo;

import lombok.Data;

/**
 * @USER: Mr.Wang
 * @DATE: 2020/1/16
 **/
@Data
public class EvaluationVo {
    private String url;
    private String name;
    private String comment;

    public EvaluationVo() {
    }

    public EvaluationVo(String url, String name, String comment) {
        this.url = url;
        this.name = name;
        this.comment = comment;
    }
}
