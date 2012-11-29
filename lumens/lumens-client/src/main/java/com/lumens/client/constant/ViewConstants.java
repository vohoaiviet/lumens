package com.lumens.client.constant;

import com.google.gwt.core.client.GWT;
import com.lumens.client.i18n.Clienti18nConstants;

/**
 *
 * @author shaofeng wang
 */
public interface ViewConstants
{
    public Clienti18nConstants messages = GWT.create(Clienti18nConstants.class);
    public String BACKGROUD_COLOR = "#fbfbfb";
    public String COMPONENT_NAME = "ComponentName";
    public String DATASOURCE_SECTION_ID = "Datasource_section_ID";
    public String PROCESSOR_SECTION_ID = "Processor_section_ID";
    public String DATASOURCE_PARAMS_ID = "Datasource_params_ID";
    //Temp constants
    public String webserviceID = "WebserviceSOAP-Datasource";
    public String databaseID = "Database-Datasource";
    public String transformPrID = "Transform-Processor";
    
    //Action button ID
    public String saveButtonOfTransformDesignID = "saveButtonOfTransformDesign";
    public String applyButtonOfSettingsID = "applyButtonOfSettings";
    public String undoButtonOfSettingsID = "undoButtonOfSettings";
}