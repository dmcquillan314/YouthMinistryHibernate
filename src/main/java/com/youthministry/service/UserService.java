package com.youthministry.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.context.ContextLoader;

import com.youthministry.domain.User;

public interface UserService extends UserDetailsService {
	 
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
    public User getByUsername(String username);
    public User getByUserId(Long id);
    
    /**
     * Get User List
     *
     * @return List - User list
     */
    public List<User> getUsers();
    
	@Override
	public UserDetails loadUserByUsername(String username);
}
