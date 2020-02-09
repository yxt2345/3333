package com.fh.controller;

import com.fh.model.*;
import com.fh.service.MovieService;
import com.fh.util.AliyunOSSUtil;
import com.fh.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("MovieController")
@CrossOrigin
public class MovieController {

    @Autowired
    private MovieService movieService;

    @RequestMapping("queryMovieList")
    public ServerResponse queryMovieList(ConditionQuery conditionQuery){
        DataTableResult dataTableResult = movieService.queryMovieList(conditionQuery);
            return ServerResponse.success(dataTableResult);
        }

    /*//上传用户头像
    @RequestMapping("uploadFile")
    public Map<String,Object> uploadFile(@RequestParam("file") MultipartFile file, HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        try {
            String filePath = FileUtil.uploadFile(request,file,"File");
            result.put("mainImages",filePath);
            result.put("code",200);
        } catch (Exception e) {
            e.printStackTrace();
            result.put("code",500);
        }
        return result;
    }*/

    @RequestMapping("uploadFile")
    public Map<String,Object> uploadPhoto(@RequestParam("file") MultipartFile file, HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        try {
            String originalFileName = file.getOriginalFilename();
            String url = AliyunOSSUtil.uploadFile(file.getInputStream(), originalFileName, "File");
            result.put("mainImages",url);
            result.put("code",200);
        } catch (Exception e) {
            e.printStackTrace();
            result.put("code",500);
        }
        return result;
    }

    @RequestMapping("queryMovieTypeList")
    public ServerResponse queryMovieTypeList(){
        List<MovieType> movieTypeList = movieService.queryMovieTypeList();
        return ServerResponse.success(movieTypeList);
    }

    @RequestMapping("queryAreaList")
    public ServerResponse queryAreaList(){
        List<Area> areaList = movieService.queryAreaList();
        return ServerResponse.success(areaList);
    }

    @RequestMapping("deleteMovie")
    public ServerResponse deleteMovie(Integer id){
        movieService.deleteMovie(id);
        return ServerResponse.success();
    }

    @PostMapping("addMovie")
    public ServerResponse addMovie(Movie movie){
        movieService.addMovie(movie);
        return ServerResponse.success();
    }

    @RequestMapping("querySingleMovie")
    public ServerResponse querySingleMovie(Integer id){
        movieService.querySingleMovie(id);
        return ServerResponse.success();
    }


    @RequestMapping("getMovieById")
    public ServerResponse getMovieById(Integer id){
        Movie movie = movieService.getMovieById(id);
        return ServerResponse.success(movie);
    }


    @RequestMapping("updateMovie")
    public ServerResponse updateMovie(Movie movie){
        movieService.updateMovie(movie);
        return ServerResponse.success();
    }

}




