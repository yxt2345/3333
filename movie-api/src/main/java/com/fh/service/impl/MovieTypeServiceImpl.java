package com.fh.service.impl;

import com.fh.mapper.MovieTypeMapper;
import com.fh.model.MovieType;
import com.fh.model.ConditionQuery;
import com.fh.model.DataTableResult;
import com.fh.service.MovieTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MovieTypeServiceImpl implements MovieTypeService {

    @Autowired
    private MovieTypeMapper movieTypeMapper;

    @Override
    public DataTableResult queryMovieTypeList(ConditionQuery conditionQuery) {
        Long count = movieTypeMapper.queryMovieTypeCount(conditionQuery);
        List<MovieType> movieTypeList = movieTypeMapper.queryMovieTypeList(conditionQuery);
        DataTableResult dataTableResult = new DataTableResult(conditionQuery.getDraw(),count,count,movieTypeList);
        return dataTableResult;
    }

    @Override
    public void deleteMovieType(Integer id) {
        movieTypeMapper.deleteMovieType(id);
    }

    @Override
    public void addMovieType(MovieType movieType) {
        movieType.setCreateTime(new Date());
        movieTypeMapper.addMovieType(movieType);
    }

    @Override
    public MovieType querySingleMovieType(Integer id) {
        return movieTypeMapper.querySingleMovieType(id);
    }

    @Override
    public void updateMovieType(MovieType movieType) {
        movieTypeMapper.updateMovieType(movieType);
    }
}