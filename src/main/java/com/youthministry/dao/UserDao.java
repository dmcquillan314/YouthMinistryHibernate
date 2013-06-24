package com.youthministry.dao;

import java.util.List;

import com.youthministry.domain.User;
import com.youthministry.genericdao.GenericDao;

public interface UserDao extends GenericDao<User, Long> {
	List<User> findByUsername(String username);
}
