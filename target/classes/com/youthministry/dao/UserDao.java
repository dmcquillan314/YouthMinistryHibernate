package com.youthministry.dao;

import java.util.List;

import com.youthministry.domain.User;

public interface UserDao {

	public void addUser(User user);
    public void updateUser(User user);
    public void deleteUser(User user);
    public User getUserById(Long id);
    public User getUserByIdWithGroups(Long id);
    public User getUserByName(String name);
    public User getUserByNameWithGroups(String name);
    public List<User> getUsers();
    public List<User> getUsersWithGroups();
}
