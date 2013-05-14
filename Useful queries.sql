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


SELECT * FROM YouthMinistry.USER u
inner join YouthMinistry.USER_GROUP u_g
on u.user_id = u_g.user_id
inner join YouthMinistry.GROUP_DETAILS g
on u_g.group_id = g.groupId; 

SELECT * FROM YouthMinistry.USER u
inner join YouthMinistry.USER_ROLES u_r
on u.user_id = u_r.user_user_id
inner join YouthMinistry.ROLES r
on u_r.roles_id = r.id; 

SELECT p.pageContentId, location, page_content_name, content_body, content_title, group_name FROM YouthMinistry.PageContent p
inner join YouthMinistry.TextEntry t
on p.pageContentId = t.pageContentId
inner join YouthMinistry.GROUP_PAGE_CONTENT gpc
on gpc.PAGE_CONTENT_ID = p.pageContentId
inner join YouthMinistry.GROUP_DETAILS g
on gpc.GROUP_ID = g.groupId;

SELECT * FROM YouthMinistry.PageContent p
inner join YouthMinistry.Image i
on p.pageContentId = i.pageContentId
inner join YouthMinistry.GROUP_PAGE_CONTENT gpc
on gpc.PAGE_CONTENT_ID = p.pageContentId
inner join YouthMinistry.GROUP_DETAILS g
on gpc.GROUP_ID = g.groupId;

SELECT * FROM YouthMinistry.EVENT e
inner join YouthMinistry.EVENT_GROUP eg
on e.EVENT_ID = eg.EVENT_ID;