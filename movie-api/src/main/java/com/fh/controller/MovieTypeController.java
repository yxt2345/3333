package com.fh.controller;

import com.fh.model.MovieType;
import com.fh.model.ConditionQuery;
import com.fh.model.DataTableResult;
import com.fh.model.ServerResponse;
import com.fh.service.MovieTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("MovieTypeController")
@CrossOrigin
public class MovieTypeController {

    @Autowired
    private MovieTypeService movieTypeService;

    @RequestMapping("queryMovieTypeList")
    public ServerResponse queryMovieTypeList(ConditionQuery conditionQuery){
        DataTableResult dataTableResult = movieTypeService.queryMovieTypeList(conditionQuery);
            return ServerResponse.success(dataTableResult);
        }

    @RequestMapping("deleteMovieType")
    public ServerResponse deleteMovieType(Integer id){
        movieTypeService.deleteMovieType(id);
        return ServerResponse.success();
    }

    @PostMapping("addMovieType")
    public ServerResponse addMovieType(MovieType movieType){
        movieTypeService.addMovieType(movieType);
        return ServerResponse.success();
    }
    @RequestMapping("querySingleMovieType")
    public ServerResponse querySingleMovieType(Integer id) {
        MovieType movieType = movieTypeService.querySingleMovieType(id);
        return ServerResponse.success(movieType);
    }

    @PutMapping("updateMovieType")
    public ServerResponse updateMovieType(MovieType movieType){
        movieTypeService.updateMovieType(movieType);
        return ServerResponse.success();
    }

}




