package com.ec.ec.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ec.ec.Vo.ImgVo;

@Controller
@CrossOrigin(allowCredentials="true",allowedHeaders="*")
public class FileController {

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public ImgVo upLoadImg(MultipartFile file ) throws IOException {

        System.out.println(System.getProperty("user.dir"));

        String path = System.getProperty("user.dir")+"\\src\\main\\resources\\static\\images";
        String fileName = file.getOriginalFilename();  // 文件名
        assert fileName != null;
        String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
        fileName = System.currentTimeMillis() + suffixName; // 新文件名
        File dir = new File(path, fileName);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        file.transferTo(dir);
        String file_path="../images/"+fileName;
        return new ImgVo(true,file_path,"图片上传成功");
    }

}