package com.jc.bike.controller;

import com.jc.bike.model.Rent;
import com.jc.bike.model.RespBean;
import com.jc.bike.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Copyright: Copyright (c) 2020 jc
 *
 * @package: com.jc.bike.controller
 * @className: RentController
 * @description TODO
 * @version: 1.0
 * @author: lijp6
 * @date: 2021/2/23 15:20
 * <p>
 * Modification History:
 * Date                Author        Version           Description
 * ---------------------------------------------------------------
 * 2021/2/23 15:20     lijp6      v1.1.0              修改原因
 **/
@RestController
@RequestMapping("/rent/information")
public class RentController {
    @Autowired
    RentService rentService;

    @GetMapping("/")
    public List<Rent> getAllRents(){
        return rentService.getAllRents();
    }

    @PostMapping("/")
    public RespBean addRentPoint(@RequestBody Rent rent){
        if(rentService.addRentPoint(rent)==1){
            return RespBean.ok("添加成功！");
        }
        return RespBean.error("添加失败！");
    }

    @PutMapping("/")
    public RespBean updateRentPoint(@RequestBody Rent rent){
        if(rentService.updateRentPoint(rent)==1){
            return RespBean.ok("更新成功！");
        }
        return RespBean.error("更新成功！");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteRentPointById(@PathVariable Integer id){
        if(rentService.deleteRentPointById(id)==1){
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    @DeleteMapping("/")
    public RespBean deleteRentPoints(Integer[] ids){
        if(rentService.deleteRentPoints(ids)==ids.length){
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }
}