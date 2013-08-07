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

import com.youthministry.domain.Renderer;
import com.youthministry.service.RendererService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:META-INF/spring/applicationContext*.xml"}) 
@TransactionConfiguration
@Transactional
public class RendererServiceTest {

	@Autowired
	protected RendererService RendererService;
	
	final Logger logger = LoggerFactory.getLogger(RendererServiceTest.class);
	
	public Long testCreateRenderer() {
		Renderer renderer = new Renderer();
		renderer.setRendererName("test");
		
		RendererService.create(renderer);
		return renderer.getRendererId();
	}
	
	@Test
	public void testReadRenderer() {
		Long id = testCreateRenderer();
		Renderer renderer = RendererService.read(id);
	}
	
	@Test
	public void testUpdateRenderer() {
		Long id = testCreateRenderer();
		Renderer renderer = RendererService.read(id);
		renderer.setRendererName("test name");
		RendererService.update(renderer);
	}
	
	public void testDeleteRenderer() {
		Long id = testCreateRenderer();
		Renderer renderer = RendererService.read(id);
		RendererService.delete(renderer);
	}

}
