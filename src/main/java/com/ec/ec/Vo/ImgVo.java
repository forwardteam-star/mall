package com.ec.ec.Vo;

import lombok.Data;

/**
 **/
@Data
public class ImgVo {
    private boolean success;
    private String file_path;
    private String msg;

    public ImgVo(boolean success, String file_path, String msg) {
        this.success = success;
        this.file_path = file_path;
        this.msg = msg;
    }
}
