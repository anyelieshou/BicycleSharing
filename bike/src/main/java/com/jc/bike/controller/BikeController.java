package com.jc.bike.controller;

import com.jc.bike.model.Bike;
import com.jc.bike.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Copyright: Copyright (c) 2020 jc
 *
 * @package: com.jc.bike.controller
 * @className: BikeController
 * @description TODO
 * @version: 1.0
 * @author: lijp6
 * @date: 2021/2/20 15:48
 * <p>
 * Modification History:
 * Date                Author        Version           Description
 * ---------------------------------------------------------------
 * 2021/2/20 15:48     lijp6      v1.1.0              修改原因
 **/
@RestController
@RequestMapping("/vehicle/information")
public class BikeController {
    @Autowired
    BikeService bikeService;
    @GetMapping("/")
    public List<Bike> getAllBikes(){
        return bikeService.getAllBikes();
    }
}