package com.jc.bike.controller.config;

import com.jc.bike.config.FastDFSUtils;
import com.jc.bike.model.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


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
    @Value("${fastdfs.nginx.host}")
    String nginxHost;

    @PostMapping("/upload")
    public RespBean upLoadImg(MultipartFile file){
        String fileId= FastDFSUtils.upload(file);
        String url=nginxHost+fileId;
        return RespBean.ok("url",url);
    }
}