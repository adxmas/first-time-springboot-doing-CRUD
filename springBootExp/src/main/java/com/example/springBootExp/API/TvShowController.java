package com.example.springBootExp.API;

import com.example.springBootExp.MODEL.TVShow;
import com.example.springBootExp.SERVICE.TVShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/show")
@RestController
public class TvShowController {

    private final TVShowService tvShowService;

    @Autowired
    public TvShowController(TVShowService tvShowService) {
        this.tvShowService = tvShowService;
    }

    @PostMapping
    public void addTvShow(@RequestBody TVShow show){
        tvShowService.addTvShow(show);
    }

    @GetMapping
    public List<TVShow> getAllShows(){
        return tvShowService.getAllShows();
    }

    @GetMapping(path = "{id}")
    public TVShow getTVShowByID(@PathVariable("id") UUID id){
        return tvShowService.getShowById(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteTvShowById(@PathVariable("id") UUID id){
        tvShowService.deleteTVShow(id);
    }


    @PutMapping(path = "{id}")
    public void updateTvShow(@PathVariable("id") UUID id, @RequestBody TVShow showToUpdate){
        tvShowService.updateTVshow(id, showToUpdate);
    }

}
