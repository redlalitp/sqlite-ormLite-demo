CREATE TABLE users(
   id       INTEGER  NOT NULL PRIMARY KEY
  ,team_id  INTEGER  NOT NULL
  ,email    VARCHAR(32) NOT NULL
  ,username VARCHAR(18) NOT NULL
  ,deleted  TINYINT(3)  NOT NULL
);
CREATE TABLE teams(
   id            INTEGER  NOT NULL PRIMARY KEY
  ,name          VARCHAR(21) NOT NULL
  ,email_domain  VARCHAR(11)
  ,date_create   INTEGER  NOT NULL
);