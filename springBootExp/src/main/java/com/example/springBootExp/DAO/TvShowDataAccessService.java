package com.example.springBootExp.DAO;

import com.example.springBootExp.MODEL.TVShow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class TvShowDataAccessService implements TVShowDao {

    private static List<TVShow> DB = new ArrayList<>();

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TvShowDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertTvShow(TVShow show) {
        UUID randID = UUID.randomUUID();
        String sql = "insert into tvshow(id, name, company, released) values (?,?,?,?)";
        return jdbcTemplate.update(
                sql,
                //new Object[] {UUID.fromString(show.getId().toString()), show.getName(), show.getCompany(), show.getReleased()});
                new Object[]{randID, show.getName(), show.getCompany(), show.getReleased()});

    }

    @Override
    public List<TVShow> selectAllShows() {
        String sql = "SELECT id, name, company, released FROM tvshow";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID id = (UUID.fromString(resultSet.getString("id")));
            String name = resultSet.getString("name");
            String company = resultSet.getString("company");
            String released = resultSet.getString("released");
            return new TVShow(id, name, company, released);
        });
    }

    @Override
    public Optional<TVShow> selectTVShowById(UUID id) {
        String sql = "SELECT * FROM tvshow WHERE id = ?";

        TVShow show = jdbcTemplate.queryForObject(sql, new Object[]{id}, ((resultSet, i) -> {
            UUID showID = UUID.fromString(resultSet.getString("id"));
            String name = resultSet.getString("name");
            String company = resultSet.getString("company");
            String released = resultSet.getString("released");
            return new TVShow(id, name, company, released);
        }));
        return Optional.ofNullable(show);

    }

    @Override
    public int deleteTVShowById(UUID id) {
        Optional<TVShow> showToDelete = selectTVShowById(id);
        String sql = "delete from tvshow where id = ?";
        return jdbcTemplate.update(
                sql,
                new Object[]{id});
    }

    @Override
    public int updateTVShowById(UUID id, TVShow show) {
        String sqlUpdate = "update tvshow set name = ?, company = ?, released = ? where id = ?";
        return jdbcTemplate.update(
                sqlUpdate,
                new Object[]{show.getName(), show.getCompany(), show.getReleased(), id});

    }
}

