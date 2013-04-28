package com.youthministry.dao;

import java.util.List;

import com.youthministry.domain.Role;

public interface RoleDao {
	
    /**
     * Add Group
     *
     * @param  Group Group
     */
    public void addRole(Role role);
 
    /**
     * Update Group
     *
     * @param  Group Group
     */
    public void updateRole(Role role);
 
    /**
     * Delete Group
     *
     * @param  Group Group
     */
    public void deleteRole(Role role);
    
    /**
     * Get Group
     *
     * @param  int Id
     */
    public Role getRoleById(Long id);
    
    /**
     * Get Event
     *
     * @param  int Event Id
     */
    public Role getRoleByName(String name);
 
    /**
     * Get Group List
     *
     */
    public List<Role> getRoles();
	
}
