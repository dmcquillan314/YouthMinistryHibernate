package com.youthministry.controller.binding;

import java.beans.PropertyEditorSupport;

import org.apache.commons.lang.StringUtils;

public class EnumerationEditor extends PropertyEditorSupport {
    
    private Enum enumertion;
    
    public EnumerationEditor(Enum enumeration) {
        this.enumertion = enumeration;
    }

    @Override
    public String getAsText() {
        Enum e = (Enum) this.getValue();
        
        if (e != null) {
            return e.name();
        } else {
            return null;
        }
    }

    @Override
    public void setAsText(String eValue) throws IllegalArgumentException {
        
        String val = StringUtils.trim(eValue);
        
        if (val != null) {
           this.setValue(this.enumertion.valueOf(
                   this.enumertion.getDeclaringClass(), val));
        }
    } 
}
