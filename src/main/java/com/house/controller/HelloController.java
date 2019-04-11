package com.house.controller;

import com.house.entity.Area;
import com.house.service.AreaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HelloController {

    Logger logger = LoggerFactory.getLogger(HelloController.class);
    @Autowired
    private AreaService areaService;

    @RequestMapping(value = "/getAreaList", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getAreaList(){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Area> areaList = new ArrayList<Area>();
        try {
            areaList = areaService.getAreaList();
            modelMap.put("rows", areaList);
            modelMap.put("total", areaList.size());
        } catch (Exception e) {
            e.printStackTrace();
            modelMap.put("success", false);
            modelMap.put("errMsg", e.toString());
        }
        logger.info("===end===");
        return modelMap;
    }
}
