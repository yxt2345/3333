package com.fh.service;

import com.fh.model.MovieType;
import com.fh.model.ConditionQuery;
import com.fh.model.DataTableResult;

public interface MovieTypeService {
    DataTableResult queryMovieTypeList(ConditionQuery conditionQuery);

    void deleteMovieType(Integer id);

    void addMovieType(MovieType area);

    MovieType querySingleMovieType(Integer id);

    void updateMovieType(MovieType movieType);
}
