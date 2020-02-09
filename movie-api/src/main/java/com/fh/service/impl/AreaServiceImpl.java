package com.fh.service.impl;

import com.fh.mapper.AreaMapper;
import com.fh.model.*;
import com.fh.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaMapper areaMapper;

    @Override
    public DataTableResult queryAreaList(ConditionQuery conditionQuery) {
        Long count = areaMapper.queryAreaCount(conditionQuery);
        List<Area> areaList = areaMapper.queryAreaList(conditionQuery);
        DataTableResult dataTableResult = new DataTableResult(conditionQuery.getDraw(),count,count,areaList);
        return dataTableResult;
    }

    @Override
    public void deleteArea(Integer id) {
        areaMapper.deleteArea(id);
    }

    @Override
    public void addArea(Area area) {
        area.setCreateTime(new Date());
        areaMapper.addArea(area);
    }

    @Override
    public Area querySingleArea(Integer id) {
        return areaMapper.querySingleArea(id);
    }

    @Override
    public void updateArea(Area area) {
        area.setUpdateTime(new Date());
        areaMapper.updateArea(area);
    }

}
