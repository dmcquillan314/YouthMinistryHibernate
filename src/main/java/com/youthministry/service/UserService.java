package com.youthministry.service;

import java.util.List;

import com.youthministry.domain.User;

public interface UserService {
	 
    /**
     * Add User
     *
     * @param  User user
     */
    public void addUser(User user);
 
    /**
     * Update User
     *
     * @param  User user
     */
    public void updateUser(User user);
 
    /**
     * Delete User
     *
     * @param  User user
     */
    public void deleteUser(User user);
 
    /**
     * Get User
     *
     * @param  int User Id
     */
    public User getUserById(Long id);
    public User getUserByIdWithGroups(Long id);
    /**
     * Get User List
     *
     * @return List - User list
     */
    public List<User> getUsers();
}
