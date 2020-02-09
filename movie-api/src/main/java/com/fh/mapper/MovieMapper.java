package com.fh.mapper;

import com.fh.model.Area;
import com.fh.model.ConditionQuery;
import com.fh.model.Movie;
import com.fh.model.MovieType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface MovieMapper {
    Long queryMovieCount(ConditionQuery conditionQuery);

    List<Movie> queryMovieList(ConditionQuery conditionQuery);

    List<MovieType> queryMovieTypeList();

    void deleteMovie(Integer id);

    List<Area> queryAreaList();

    void addMovie(Movie movie);

    void querySingleMovie(Integer id);

    Movie getMovieById(Integer id);

    void updateMovie(Movie movie);
}
