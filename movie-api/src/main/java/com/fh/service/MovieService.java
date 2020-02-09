package com.fh.service;

import com.fh.model.*;

import java.util.List;

public interface MovieService {
    DataTableResult queryMovieList(ConditionQuery conditionQuery);

    void deleteMovie(Integer id);

    List<MovieType> queryMovieTypeList();

    List<Area> queryAreaList();

    void addMovie(Movie movie);

    void querySingleMovie(Integer id);

    Movie getMovieById(Integer id);

    void updateMovie(Movie movie);
}
