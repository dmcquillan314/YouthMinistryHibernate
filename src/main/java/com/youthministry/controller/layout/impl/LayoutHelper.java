package com.youthministry.controller.layout.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.codehaus.jackson.map.*;
import org.codehaus.jackson.*;

import com.youthministry.domain.Col;
import com.youthministry.domain.Layout;
import com.youthministry.domain.Row;
import com.youthministry.genericdao.ContentServiceTest;

@SuppressWarnings("deprecation")
public class LayoutHelper {
	
    final Logger logger = LoggerFactory.getLogger(LayoutHelper.class);

	private JsonFactory f = new MappingJsonFactory();
    private JsonParser jp = null;
		
	public Layout parseJSON(Layout layout ) {
		try {
			jp = f.createJsonParser(layout.getLayoutJSON());
			JsonToken current = null;
			
		    current = jp.nextToken();
		    if (current != JsonToken.START_OBJECT) {
		      System.out.println("Error: root should be object: quiting.");
		      return layout;
		    }

		    while (jp.nextToken() != JsonToken.END_OBJECT) {
		    	String fieldName = jp.getCurrentName();
		    	
		    	// move from field name to field value
		    	current = jp.nextToken();
		    	if( fieldName.equals("rows") ) {
		    		if( current == JsonToken.START_ARRAY ) {
		    			// for each of the records in the array
		    			Row row = new Row();
		    			
		    			while( jp.nextToken() != JsonToken.END_ARRAY ) {
		    				// read the record into a tree model,
		    				// this moves the parsing position to the end of it

		    				JsonNode node = jp.readValueAsTree();
		    				
		    				Iterator<JsonNode> colNodes = node.get("cols").getElements();

		    				while( colNodes.hasNext() ) {
			    				Col col = new Col();
			    				JsonNode curNode = colNodes.next();
		    					col.setColumnWidth( curNode.get("width").toString() );
			    				row.getCols().add(col);
		    				}
		    				
		    			}
		    			
		    			layout.getRows().add( row );
		    		} else {
		    			logger.error("Records should be an array: skipping.");
		    			jp.skipChildren();
		    		}
		    	} else {
		    		logger.error("Unprocessed property: " + fieldName);
		    		jp.skipChildren();
		    	}
		    }
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return layout;
	}

	/**
	 * @return the jp
	 */
	public JsonParser getJp() {
		return jp;
	}

	/**
	 * @param jp the jp to set
	 */
	public void setJp(JsonParser jp) {
		this.jp = jp;
	}

}
