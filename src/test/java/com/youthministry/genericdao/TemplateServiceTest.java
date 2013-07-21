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
import com.youthministry.service.TemplateService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "root-context.xml"}) 
@TransactionConfiguration
@Transactional
public class TemplateServiceTest {

	@Autowired
	protected TemplateService TemplateService;
	
	final Logger logger = LoggerFactory.getLogger(TemplateServiceTest.class);

	public Long testCreateRenderer() {
		Layout template = new Layout();
		template.setTemplateName("test");
		
		TemplateService.create(template);
		return template.getTemplateId();
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
		template.setTemplateName("test name");
		TemplateService.update(template);
	}
	
	@Test
	public void testDeleteRenderer() {
		Long id = testCreateRenderer();
		Layout template = TemplateService.read(id);
		TemplateService.delete(template);
	}

}
