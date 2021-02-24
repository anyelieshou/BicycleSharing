package com.jc.bike.service;

import com.jc.bike.mapper.RentMapper;
import com.jc.bike.model.Rent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Copyright: Copyright (c) 2020 jc
 *
 * @package: com.jc.bike.service
 * @className: RentService
 * @description TODO
 * @version: 1.0
 * @author: lijp6
 * @date: 2021/2/23 15:22
 * <p>
 * Modification History:
 * Date                Author        Version           Description
 * ---------------------------------------------------------------
 * 2021/2/23 15:22     lijp6      v1.1.0              修改原因
 **/
@Service
public class RentService {
    @Autowired
    RentMapper rentMapper;

    public List<Rent> getAllRents(){
        return rentMapper.getAllRents();
    }

    public Integer addRentPoint(Rent rent) {
        return rentMapper.insertSelective(rent);
    }

    public Integer deleteRentPointById(Integer id) {
        return rentMapper.deleteByPrimaryKey(id);
    }

    public Integer deleteRentPoints(Integer[] ids) {
        return rentMapper.deleteRentPoints(ids);
    }

    public Integer updateRentPoint(Rent rent) {
        return rentMapper.updateByPrimaryKeySelective(rent);
    }
}