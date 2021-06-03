package com.lalitpatil.ormLiteDemo.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.lalitpatil.ormLiteDemo.dao.UserDaoImpl;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Getter
@NoArgsConstructor
@DatabaseTable(tableName = "users", daoClass = UserDaoImpl.class)
public class User {


    @Id
    @DatabaseField
    private long id;

    @Setter
    @DatabaseField(columnName = "team_id")
    private long teamId;

    @Setter
    @DatabaseField
    private String email;

    @Setter
    @DatabaseField
    private String username;

    @Setter
    @DatabaseField(columnName = "deleted")
    private boolean isDeleted;

    public User(long id, long teamId, String email, String username, boolean isDeleted) {
        this.id = id;
        this.teamId = teamId;
        this.email = email;
        this.username = username;
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "User [username=" + username + ", id=" + id + "]";
    }
}
