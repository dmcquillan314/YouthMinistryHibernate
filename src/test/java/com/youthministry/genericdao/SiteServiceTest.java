package com.youthministry.genericdao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.youthministry.domain.Site;
import com.youthministry.service.SiteService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:META-INF/spring/applicationContext*.xml"}) 
@TransactionConfiguration
@Transactional
public class SiteServiceTest {

	@Autowired
	protected SiteService SiteService;
	
	final Logger logger = LoggerFactory.getLogger(SiteServiceTest.class);

	public Long testCreateSite() {
		Site site = new Site();
		site.setSiteName("test");
		
		SiteService.create(site);
		return site.getSiteId();
	}
	
	@Test
	public void testReadRenderer() {
		Long id = testCreateSite();
		Site site = SiteService.read(id);
	}
	
	@Test
	public void testUpdateRenderer() {
		Long id = testCreateSite();
		Site site = SiteService.read(id);
		site.setSiteName("test name");
		SiteService.update(site);
	}
	
	@Test
	public void testDeleteRenderer() {
		Long id = testCreateSite();
		Site site = SiteService.read(id);
		SiteService.delete(site);
	}

}
