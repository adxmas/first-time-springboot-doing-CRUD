package com.example.springBootExp.DAO;

import com.example.springBootExp.MODEL.TVShow;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TVShowDao {

    int insertTvShow(TVShow show);


    /*default int insertTvShow(UUID id, TVShow show){
        id = UUID.randomUUID();
        return insertTvShow(id, show);
    }*/

    List<TVShow> selectAllShows();

    Optional<TVShow> selectTVShowById(UUID id);

    int deleteTVShowById(UUID id);

    int updateTVShowById(UUID id, TVShow show);

}
