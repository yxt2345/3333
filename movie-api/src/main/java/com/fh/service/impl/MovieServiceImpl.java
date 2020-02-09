package com.fh.service.impl;

import com.fh.mapper.MovieMapper;
import com.fh.model.*;
import com.fh.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieMapper movieMapper;

    @Override
    public DataTableResult queryMovieList(ConditionQuery conditionQuery) {
        Long count = movieMapper.queryMovieCount(conditionQuery);
        List<Movie> movieList = movieMapper.queryMovieList(conditionQuery);
        DataTableResult dataTableResult = new DataTableResult(conditionQuery.getDraw(),count,count,movieList);
        return dataTableResult;
    }

    @Override
    public List<MovieType> queryMovieTypeList() {
        return movieMapper.queryMovieTypeList();
    }

    @Override
    public void deleteMovie(Integer id) {
        movieMapper.deleteMovie(id);
    }

    @Override
    public List<Area> queryAreaList() {
        return movieMapper.queryAreaList();
    }

    @Override
    public void addMovie(Movie movie) {
        movie.setCreateTime(new Date());
        movieMapper.addMovie(movie);
    }

    @Override
    public void querySingleMovie(Integer id) {
        movieMapper.querySingleMovie(id);
    }

    @Override
    public Movie getMovieById(Integer id) {
        return movieMapper.getMovieById(id);
    }

    @Override
    public void updateMovie(Movie movie) {
        movie.setUpdateTime(new Date());
        movieMapper.updateMovie(movie);
    }
}
