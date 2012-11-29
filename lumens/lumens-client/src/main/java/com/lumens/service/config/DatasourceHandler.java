/*
 * File:           DatasourceHandler.java
 * Date:           November 20, 2012  10:39 PM
 *
 * @author  washaofe
 * @version generated by NetBeans XML module
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lumens.service.config;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

/**
 *
 * @author shaofeng wang (shaofeng.cjpw@gmail.com)
 */
public interface DatasourceHandler
{

    /**
     *
     * A data element event handling method.
     * @param data value or null
     * @param meta attributes
     */
    public void handle_Name(final String data, final Attributes meta) throws SAXException;

    /**
     *
     * A container element start event handling method.
     * @param meta attributes
     */
    public void start_Datasource(final Attributes meta) throws SAXException;

    /**
     *
     * A container element end event handling method.
     */
    public void end_Datasource() throws SAXException;

    /**
     *
     * A container element start event handling method.
     * @param meta attributes
     */
    public void start_Parameters(final Attributes meta) throws SAXException;

    /**
     *
     * A container element end event handling method.
     */
    public void end_Parameters() throws SAXException;

    /**
     *
     * A container element start event handling method.
     * @param meta attributes
     */
    public void start_Datasources(final Attributes meta) throws SAXException;

    /**
     *
     * A container element end event handling method.
     */
    public void end_Datasources() throws SAXException;

    /**
     *
     * A data element event handling method.
     * @param data value or null
     * @param meta attributes
     */
    public void handle_ID(final String data, final Attributes meta) throws SAXException;

    /**
     *
     * An empty element event handling method.
     * @param data value or null
     */
    public void handle_Parameter(final Attributes meta) throws SAXException;

    /**
     *
     * A data element event handling method.
     * @param data value or null
     * @param meta attributes
     */
    public void handle_ClassName(final String data, final Attributes meta) throws SAXException;

    /**
     *
     * A data element event handling method.
     * @param data value or null
     * @param meta attributes
     */
    public void handle_Icon(final String data, final Attributes meta) throws SAXException;

    /**
     *
     * A data element event handling method.
     * @param data value or null
     * @param meta attributes
     */
    public void handle_ComponentIcon(final String data, final Attributes meta) throws SAXException;
    
}
