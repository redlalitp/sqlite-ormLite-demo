package com.lalitpatil.ormLiteDemo.service;

import com.j256.ormlite.dao.*;
import com.j256.ormlite.stmt.QueryBuilder;
import com.lalitpatil.ormLiteDemo.connection.DbConnection;
import com.lalitpatil.ormLiteDemo.model.Team;
import com.lalitpatil.ormLiteDemo.model.User;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService {
    Dao<User, Long> userDao;
    Dao<Team, Long> teamDao;

    UserService() {
        try {
            userDao = DaoManager.createDao(DbConnection.getConnectionSource(), User.class);
            teamDao = DaoManager.createDao(DbConnection.getConnectionSource(), Team.class);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void addUser(User user) {
        try {
            System.out.println(user.toString());
            userDao.create(user);
        }
        catch (DataAccessException | SQLException e) {
            System.out.println("Cannot access database\n");
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() throws IOException {
        List<User> allUsers = new ArrayList<User>();
        try (CloseableWrappedIterable<User> wrappedIterable
                     = userDao.getWrappedIterable()) {
            for (User user : wrappedIterable) {
                allUsers.add(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return allUsers;
    }

    public List<String[]> getAllTeamsForUSer(String emailId) throws SQLException {
        List<Team> teams = new ArrayList<Team>();

        GenericRawResults<String[]> rawResults = userDao.queryRaw("SELECT name FROM (select * from users where (email='roadrunner@acme.com' and deleted=0)) as u, teams as t where u.team_id=t.id");
        List<String[]> results = rawResults.getResults();
        return results;
    }
}
