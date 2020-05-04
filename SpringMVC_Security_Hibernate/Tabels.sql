
create table Authorities (id integer not null auto_increment, authority varchar(255), primary key (id));
-------------------------------------------------------------------------------------------
CREATE TABLE `user` (
  `userId` int NOT NULL AUTO_INCREMENT,
  `password` varchar(255) DEFAULT NULL,
  `userAddress` varchar(255) DEFAULT NULL,
  `userEmail` varchar(255) DEFAULT NULL,
  `userName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userId`)
);
------------------------------------------------------------------------------------------
create table user_authority (USER_ID integer not null, AUTHORITY_ID integer not null, primary key (USER_ID, AUTHORITY_ID));
-------------------------------------------------------------------------------------------
alter table user_authority add constraint FK58ss3f2epuu8jbcbc1i040jcc foreign key (AUTHORITY_ID) references Authorities (id);
alter table user_authority add constraint FKmo00qf8wms2g1u9dxyibaj835 foreign key (USER_ID) references User (userId);
