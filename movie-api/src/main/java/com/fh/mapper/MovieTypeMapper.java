package com.fh.mapper;

import com.fh.model.MovieType;
import com.fh.model.ConditionQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface MovieTypeMapper {
    Long queryMovieTypeCount(ConditionQuery conditionQuery);

    List<MovieType> queryMovieTypeList(ConditionQuery conditionQuery);

    void deleteMovieType(Integer id);

    void addMovieType(MovieType area);

    MovieType querySingleMovieType(Integer id);

    void updateMovieType(MovieType movieType);
}
