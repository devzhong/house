package com.house.controller;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.house.entity.Response;
import com.house.service.AreaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/area")
public class AreaControlelr {
    private static Logger logger = LoggerFactory.getLogger(AreaControlelr.class);

    @Autowired
    private AreaService areaService;

    @RequestMapping(value = "/listArea", method = RequestMethod.GET)
    public Response getAreaList(){
        return Response.success(areaService.getAreaList());
    }

    @RequestMapping(value = "/getAreaDetail", method = RequestMethod.GET)
    public Response getAreaDetail(@RequestParam("id") int id){
        return Response.success(areaService.getAreaDetaill(id));
    }
}
