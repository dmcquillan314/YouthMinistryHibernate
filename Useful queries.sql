-- find a user's current roles
SELECT * FROM YouthMinistry.USER u
inner join YouthMinistry.USER_ROLES u_r
on u.user_id = u_r.user_user_id
inner join YouthMinistry.ROLES r
on u_r.roles_id = r.id; 


-- find a user's current groups
SELECT * FROM YouthMinistry.USER u
inner join YouthMinistry.USER_GROUP u_g
on u.user_id = u_g.user_id
inner join YouthMinistry.GROUP_DETAILS g
on u_g.group_id = g.groupId; 