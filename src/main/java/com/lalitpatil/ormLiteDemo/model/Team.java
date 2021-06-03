package com.lalitpatil.ormLiteDemo.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.lalitpatil.ormLiteDemo.dao.TeamDaoImpl;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;
import java.util.Date;

@Getter
@NoArgsConstructor
@DatabaseTable(tableName = "teams", daoClass = TeamDaoImpl.class)
public class Team {


    @Id
    @DatabaseField
    private long id;

    @Setter
    @DatabaseField
    private String name;

    @Setter
    @DatabaseField(columnName = "email_domain")
    private String emailDomain;

    @Setter
    @DatabaseField(columnName = "date_create")
    private Date dateCreated;

    public Team(long id, String name, String emailDomain, Date dateCreated) {
        this.id = id;
        this.name = name;
        this.emailDomain = emailDomain;
        this.dateCreated = dateCreated;
    }



    @Override
    public String toString() {
        return "User [name=" + name + ", id=" + id + "]";
    }
}
