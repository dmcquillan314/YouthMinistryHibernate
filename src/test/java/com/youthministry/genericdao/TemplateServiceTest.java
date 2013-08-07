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

import com.youthministry.domain.Layout;
import com.youthministry.service.LayoutService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:META-INF/spring/applicationContext*.xml"}) 
@TransactionConfiguration
@Transactional
public class TemplateServiceTest {

	@Autowired
	protected LayoutService TemplateService;
	
	final Logger logger = LoggerFactory.getLogger(TemplateServiceTest.class);

	public Long testCreateRenderer() {
		Layout template = new Layout();
		return 1l;
	}
	
	@Test
	public void testReadRenderer() {
		Long id = testCreateRenderer();
		Layout template = TemplateService.read(id);
	}
	
	@Test
	public void testUpdateRenderer() {
		Long id = testCreateRenderer();
		Layout template = TemplateService.read(id);
	}
	
	public void testDeleteRenderer() {
		Long id = testCreateRenderer();
		Layout template = TemplateService.read(id);
		TemplateService.delete(template);
	}

}
