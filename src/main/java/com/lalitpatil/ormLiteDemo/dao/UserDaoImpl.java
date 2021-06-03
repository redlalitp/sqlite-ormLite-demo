package com.lalitpatil.ormLiteDemo.dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import com.lalitpatil.ormLiteDemo.model.User;

import java.sql.SQLException;

public class UserDaoImpl extends BaseDaoImpl<User, Long> implements IUserDAO {
    public UserDaoImpl(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, User.class);
    }
}
