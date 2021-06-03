package com.lalitpatil.ormLiteDemo.service;

import com.j256.ormlite.dao.CloseableWrappedIterable;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.lalitpatil.ormLiteDemo.connection.DbConnection;
import com.lalitpatil.ormLiteDemo.model.Team;
import com.lalitpatil.ormLiteDemo.model.User;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class TeamService {
    Dao<Team, Long> teamDao;

    TeamService() {
        try {
            teamDao = DaoManager.createDao(DbConnection.getConnectionSource(), Team.class);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Team> getAllTeams() throws IOException {
        List<Team> allTeams = new ArrayList<Team>();
        try (CloseableWrappedIterable<Team> wrappedIterable
                     = teamDao.getWrappedIterable()) {
            for (Team team : wrappedIterable) {
                allTeams.add(team);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return allTeams;
    }
}
