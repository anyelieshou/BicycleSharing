package com.jc.bike.controller.config;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Copyright: Copyright (c) 2020 jc
 *
 * @package: com.jc.bike.controller.config
 * @className: FileUploadController
 * @description TODO
 * @version: 1.0
 * @author: lijp6
 * @date: 2021/2/23 14:30
 * <p>
 * Modification History:
 * Date                Author        Version           Description
 * ---------------------------------------------------------------
 * 2021/2/23 14:30     lijp6      v1.1.0              修改原因
 **/
@RestController
public class FileUploadController {
    SimpleDateFormat sdf=new SimpleDateFormat("/yyyy/MM/dd");

    @PostMapping("/upload")
    public Map<String,Object> fileupload(MultipartFile file, HttpServletRequest req){
        Map<String,Object> result=new HashMap<>();
        String orginName=file.getOriginalFilename();
        if(!orginName.endsWith(".jpg")){
            result.put("status","error");
            result.put("msg","文件类型不对");
        }
        String format=sdf.format(new Date());
        String realPath=req.getServletContext().getRealPath("/")+format;
        File folder=new File(realPath);
        if(!folder.exists()){
            folder.mkdirs();
        }
        String newName= UUID.randomUUID().toString()+".jpg";
        try {
            file.transferTo(new File(folder,newName));
            String url=req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+format+newName;
            result.put("status","success");
            result.put("url",url);
        } catch (IOException e) {
            result.put("status","error");
            result.put("msg",e.getMessage());
        }
        return result;
    }
}