drop table `EVENT_GROUP`;
CREATE TABLE `EVENT_GROUP` (
      `EVENT_ID` bigint(20) NOT NULL,
      `GROUP_ID` bigint(20) NOT NULL,
      KEY `FKD114985A90527599` (`EVENT_ID`),
      KEY `FKD114985A9E07AF79` (`GROUP_ID`),
      CONSTRAINT `FKD114985A9E07AF79` FOREIGN KEY (`GROUP_ID`) REFERENCES `GROUP_DETAILS` (`groupId`),
      CONSTRAINT `FKD114985A90527599` FOREIGN KEY (`EVENT_ID`) REFERENCES `EVENT` (`EVENT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
drop table `GROUP_PAGE_CONTENT`;
CREATE TABLE `GROUP_PAGE_CONTENT` (
      `PAGE_CONTENT_ID` bigint(20) NOT NULL,
      `GROUP_ID` bigint(20) NOT NULL,
      KEY `FKC122C0899E07AF79` (`GROUP_ID`),
      KEY `FKC122C089BC9FC1A` (`PAGE_CONTENT_ID`),
      CONSTRAINT `FKC122C089BC9FC1A` FOREIGN KEY (`PAGE_CONTENT_ID`) REFERENCES `PageContent` (`pageContentId`),
      CONSTRAINT `FKC122C0899E07AF79` FOREIGN KEY (`GROUP_ID`) REFERENCES `GROUP_DETAILS` (`groupId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
drop table `USER_GROUP`;
CREATE TABLE `USER_GROUP` (
      `USER_ID` bigint(20) NOT NULL,
      `GROUP_ID` bigint(20) NOT NULL,
      KEY `FKC62E00EB1C6957DB` (`USER_ID`),
      KEY `FKC62E00EB9E07AF79` (`GROUP_ID`),
      CONSTRAINT `FKC62E00EB9E07AF79` FOREIGN KEY (`GROUP_ID`) REFERENCES `GROUP_DETAILS` (`groupId`),
      CONSTRAINT `FKC62E00EB1C6957DB` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
drop table `USER_ROLES`;
CREATE TABLE `USER_ROLES` (
      `user_USER_ID` bigint(20) NOT NULL,
      `roles_id` bigint(20) NOT NULL,
      KEY `FK734299497758EF67` (`user_USER_ID`),
      KEY `FK7342994915570C54` (`roles_id`),
      CONSTRAINT `FK7342994915570C54` FOREIGN KEY (`roles_id`) REFERENCES `roles` (`id`),
      CONSTRAINT `FK734299497758EF67` FOREIGN KEY (`user_USER_ID`) REFERENCES `user` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- alter table script for roles table
ALTER TABLE `YouthMinistry`.`roles` 
CHANGE COLUMN `name` `name` VARCHAR(255) NOT NULL  
, ADD UNIQUE INDEX `role_name_UNIQUE` (`name` ASC);
