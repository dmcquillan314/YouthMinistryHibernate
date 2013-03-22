package com.youthministry.service;

import java.util.List;

import com.youthministry.domain.Group;

public interface GroupService {
	
    /**
     * Add Group
     *
     * @param  Group Group
     */
    public void addGroup(Group group);
 
    /**
     * Update Group
     *
     * @param  Group Group
     */
    public void updateGroup(Group group);
 
    /**
     * Delete Group
     *
     * @param  Group Group
     */
    public void deleteGroup(Group group);
    
    /**
     * Get Group
     *
     * @param  int Id
     */
    public Group getGroupById(int id);
    
    /**
     * Get Event
     *
     * @param  int Event Id
     */
    public Group getGroupByName(String name);
 
    /**
     * Get Group List
     *
     */
    public List<Group> getGroups();
	
}
