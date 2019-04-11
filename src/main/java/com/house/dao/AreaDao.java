package com.house.dao;

import com.house.entity.Area;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AreaDao {

    /**
     * 新增查询区域
     * @param area
     * @return
     */
    int insertArea(Area area);

    /**
     * 查询area列表
     * @return
     */
    List<Area> queryArea();
}
