package com.fh.service;

import com.fh.model.Area;
import com.fh.model.ConditionQuery;
import com.fh.model.DataTableResult;

import java.util.List;

public interface AreaService {
    DataTableResult queryAreaList(ConditionQuery conditionQuery);

    void deleteArea(Integer id);

    void addArea(Area area);

    void updateArea(Area area);

    Area querySingleArea(Integer id);

}
