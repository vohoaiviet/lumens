package com.lumens.client.utils;

import com.google.gwt.core.client.GWT;
import com.lumens.client.i18n.Ci18nConstants;

/**
 *
 * @author shaofeng wang
 */
public interface CConstants
{
    public Ci18nConstants messages = GWT.create(Ci18nConstants.class);
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
    public String newProjectButtonOfTransformDesignID = "newProjectButtonOfTransformDesignID";
    public String openProjectButtonOfTransformDesignID = "openProjectButtonOfTransformDesignID";
    public String saveProjectButtonOfTransformDesignID = "saveProjectButtonOfTransformDesignID";
    public String applyParamsButtonOfSettingsID = "applyParamsButtonOfSettingsID";
    
    // Utils constants
    public static final String g_strEmpty = "";
}
