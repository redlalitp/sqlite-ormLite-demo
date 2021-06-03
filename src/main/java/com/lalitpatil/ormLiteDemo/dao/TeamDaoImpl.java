package com.lalitpatil.ormLiteDemo.dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import com.lalitpatil.ormLiteDemo.model.Team;
import com.lalitpatil.ormLiteDemo.model.User;

import java.sql.SQLException;

public class TeamDaoImpl extends BaseDaoImpl<Team, Long> implements ITeamDAO {
    public TeamDaoImpl(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, Team.class);
    }
}
