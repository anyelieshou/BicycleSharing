package com.jc.bike.service;

import com.jc.bike.mapper.BikeMapper;
import com.jc.bike.model.Bike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Copyright: Copyright (c) 2020 jc
 *
 * @package: com.jc.bike.service
 * @className: BikeService
 * @description TODO
 * @version: 1.0
 * @author: lijp6
 * @date: 2021/2/20 15:49
 * <p>
 * Modification History:
 * Date                Author        Version           Description
 * ---------------------------------------------------------------
 * 2021/2/20 15:49     lijp6      v1.1.0              修改原因
 **/
@Service
public class BikeService {
    @Autowired
    BikeMapper bikeMapper;
    public List<Bike> getAllBikes(){
        return bikeMapper.getAllBikes();
    }
}