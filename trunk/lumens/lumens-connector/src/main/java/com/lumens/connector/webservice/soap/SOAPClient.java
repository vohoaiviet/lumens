/*
 * Copyright Lumens Team, Inc. All Rights Reserved.
 */
package com.lumens.connector.webservice.soap;

import com.lumens.model.Element;
import com.lumens.model.Format;

/**
 *
 * @author shaofeng wang
 */
public class SOAPClient
{
    private FormatFromWSDLBuilder builder;
    private String wsdlURL;
    private String user;
    private String password;
    private Format services;

    public SOAPClient(String wsdlURL, String user, String password)
    {
        this.wsdlURL = wsdlURL;
        this.user = user;
        this.password = password;
    }

    public void open()
    {
        builder = new FormatFromWSDLBuilder(wsdlURL);
        builder.loadWSDL();
        services = builder.buildFormats();
    }

    public void close()
    {
        builder = null;
    }

    public Format getFormats()
    {
        return services;
    }

    public Format getFormat(Format format)
    {
        return builder.buildFormat(format);
    }

    public Element execute(Element element)
    {
        return null;
    }
}
