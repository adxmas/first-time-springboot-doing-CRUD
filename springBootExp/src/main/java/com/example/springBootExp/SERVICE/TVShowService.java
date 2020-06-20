package com.example.springBootExp.SERVICE;

import com.example.springBootExp.DAO.TVShowDao;
import com.example.springBootExp.MODEL.TVShow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TVShowService {

    private final TVShowDao tvShowDao;

    @Autowired
    public TVShowService(@Qualifier("postgres") TVShowDao tvShowDao) {
        this.tvShowDao = tvShowDao;
    }


    public int addTvShow(TVShow show) {
        return tvShowDao.insertTvShow(show);
    }

    public List<TVShow> getAllShows(){
        return tvShowDao.selectAllShows();
    }

    public Optional<TVShow> getShowById(UUID id){
        return tvShowDao.selectTVShowById(id);
    }

    public int deleteTVShow(UUID id){
        return tvShowDao.deleteTVShowById(id);
    }

    public int updateTVshow(UUID id, TVShow newShow){
        return tvShowDao.updateTVShowById(id, newShow);
    }

}
