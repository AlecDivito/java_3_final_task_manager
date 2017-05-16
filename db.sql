DROP TABLE IF EXISTS `projGroup`;
DROP TABLE IF EXISTS `tag`;
DROP TABLE IF EXISTS `subTask`;
DROP TABLE IF EXISTS `task`;
DROP TABLE IF EXISTS `project`;
DROP TABLE IF EXISTS `user`;



CREATE TABLE `user` (
  `userid` int(11) NOT NULL ,
  `username` varchar(64) NOT NULL,
  `password` varchar(64) NOT NULL,
  `firstname` varchar(64) NOT NULL,
  `lastname` varchar(64) NOT NULL,
  `company` varchar(64) NOT NULL,
  `profilepic` varchar(128),
  PRIMARY KEY  (`userid`)
);

insert into user(userid, username, password, firstname, lastname, company)
  values(1,"user","pass","namef","lastf","Compb"),
  (2,"user2","pass","namef2","lastf2","Compb"),
  (3,"user3","pass","namef3","lastf3","Compc");



CREATE TABLE `project` (
  `projid` int(11) NOT NULL,
  `adminid` int(11) NOT NULL , -- this guy is the admin
  `projtitle` varchar(64) NOT NULL,
  `projdesc` varchar(512) DEFAULT "no description",
   PRIMARY KEY  (`projid`),
   FOREIGN KEY ( adminid ) REFERENCES user(userid)
);

insert into project
  values (4, 2, "Awesome Project yo", "this is that description bra");
  (1,1,"title","this is a description for table 1"),
  (2,1,"A new Title","this maybe a description for table 1"),
  (3,1,"An old Title","I am a description for table NONE");


CREATE TABLE `task` (
  `taskid` int(11) NOT NULL ,
  `projid` int(11) NOT NULL,
  `tasktitle` varchar(64) NOT NULL,
   PRIMARY KEY (taskid),
   FOREIGN KEY (projid) REFERENCES project(projid)
);

insert into task
  values(1,1,"this is a title"),
  (2,1,"a new title"),
  (3,1,"example title"),
  (4,1,"title"),
  (5,2,"title for number 2"),
  (6,3,"title for project 4");



CREATE TABLE `subTask` (
  `subtaskid` int(11) not null,
  `taskid` int(11) NOT NULL,
  `userid` int(11) NOT NULL ,
  `subtitle` varchar(64) NOT NULL,
  `subdesc` varchar(512) DEFAULT "no description",
  `actiondesc` varchar(64)
  `actiontime` date
  PRIMARY KEY(subtaskid),
   FOREIGN KEY (taskid) REFERENCES task(taskid),
   FOREIGN KEY (userid) REFERENCES user(userid)
);

insert into subTask
  values(1, 1, 1, "sub title", " for task 1 proj 1  subtask 1"),
  (2, 1, 1, "sub title 222", " for task 1 proj 1 subtask 2"),
  (3, 1, 1, "sub title 333", " for task 1 proj 1 subtask 3"),
  (4, 2, 1, "sub title by 1", " for task 1 proj 1"),
  (5, 3, 1, "sub title by 1 again", " for task 1 proj 1");

CREATE TABLE `tag` (
  `tagid` int(11) NOT NULL,
  `subtaskid` int(11) NOT NULL,
  `tagname` varchar(64) NOT NULL ,
  `tagcolorclass` varchar(64) NOT NULL,
  PRIMARY KEY (tagid),
  FOREIGN KEY (subtaskid) REFERENCES subTask(subtaskid)
);

insert into tag
  values(1, 1, "important", "col-red"),
    (2, 1, "lol", "col-orange");


CREATE TABLE projGroup (
  groupid int(11) NOT NULL,
  projid int(11) NOT NULL,
  userid int(11) NOT NULL,
  isAdmin BIT NOT NULL DEFAULT 0,
  status varchar(12) NOT NULL DEFAULT "pending",
   PRIMARY KEY (groupid),
   FOREIGN KEY (projid) REFERENCES project(projid),
   FOREIGN KEY (userid) REFERENCES user(userid)
);

insert into projGroup
  values(1, 1, 3, 1, 'confermed'),
  (2, 1, 2, 0, 'pending'),
  (3, 1, 3, 0, 'negitive');

