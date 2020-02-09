package com.fh.mapper;

import com.fh.model.Area;
import com.fh.model.ConditionQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface AreaMapper {
    Long queryAreaCount(ConditionQuery conditionQuery);

    List<Area> queryAreaList(ConditionQuery conditionQuery);

    void deleteArea(Integer id);

    void addArea(Area area);

    void updateArea(Area area);

    Area querySingleArea(Integer id);

}
