/*
 * Copyright Lumens Team, Inc. All Rights Reserved.
 */
package com.lumens.engine.serializer;

import com.lumens.connector.Direction;
import com.lumens.engine.TransformComponent;
import com.lumens.engine.TransformProject;
import com.lumens.engine.component.DataSource;
import com.lumens.engine.component.DataTransformation;
import com.lumens.engine.component.FormatEntry;
import com.lumens.engine.component.TransformRuleEntry;
import com.lumens.engine.serializer.parser.ProjectHandlerImpl;
import com.lumens.engine.serializer.parser.ProjectParser;
import com.lumens.io.StringWriter;
import com.lumens.io.XmlSerializer;
import com.lumens.model.Format;
import com.lumens.model.Value;
import com.lumens.model.serializer.FormatXmlSerializer;
import com.lumens.processor.transform.TransformRule;
import com.lumens.processor.transform.serializer.TransformRuleXmlSerializer;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.xml.sax.InputSource;

/**
 *
 * @author shaofeng wang (shaofeng.cjpw@gmail.com)
 */
public class ProjectXmlSerializer implements XmlSerializer
{
    private final static String INDENT = "  ";
    private TransformProject project;

    public ProjectXmlSerializer(TransformProject project)
    {
        this.project = project;
    }

    @Override
    public void read(InputStream in) throws Exception
    {
        ProjectParser.parse(new InputSource(in), new ProjectHandlerImpl(project));
    }

    @Override
    public void write(OutputStream out) throws Exception
    {
        StringWriter xml = new StringWriter(out);
        xml.print("<project").print(" name=\"").print(project.getName()).println("\">");
        xml.print(INDENT).println("<description>").print("<![CDATA[").print(
                project.getDescription()).println("]]>").print(INDENT).println("</description>");
        writeDatasourceListToXml(xml, project.getDatasourceList(), INDENT);
        writeDataTransformationListToXml(xml,
                                         project.getDataTransformationList(), INDENT);
        xml.println("</project>");
    }

    private void writeDatasourceListToXml(StringWriter xml,
                                          List<DataSource> datasourceList,
                                          String indent) throws Exception
    {
        if (datasourceList != null && !datasourceList.isEmpty())
        {
            xml.print(indent).println("<datasource-list>");
            for (DataSource ds : datasourceList)
                writeDatasourceToXml(xml, ds, indent + INDENT);
            xml.print(indent).println("</datasource-list>");
        }
    }

    private void writeDatasourceToXml(StringWriter xml, DataSource ds, String indent) throws Exception
    {
        String nextIndent = indent + INDENT;
        xml.print(indent).print("<datasource name=\"").print(ds.getName()).print("\" class-name=\"").
                print(ds.getClassName()).println("\">");
        xml.print(nextIndent).println("<description>").print("<![CDATA[").print(
                ds.getDescription()).println("]]>").print(nextIndent).println("</description>");
        xml.print(nextIndent).print("<position x=\"")
                .print(Integer.toString(ds.getX())).print("\" y=\"")
                .print(Integer.toString(ds.getY())).println("\"/>");
        writeDatasourceParameterListToXml(xml, ds.getPropertyList(), nextIndent);
        writeRegisterFormatListToXml(xml, Direction.IN, ds.getRegisteredFormatList(Direction.IN),
                                     nextIndent);
        writeRegisterFormatListToXml(xml, Direction.OUT, ds.getRegisteredFormatList(Direction.OUT),
                                     nextIndent);
        writeTargetListToXml(xml, ds.getTargetList(), nextIndent);
        xml.print(indent).println("</datasource>");
    }

    private void writeTargetListToXml(StringWriter xml,
                                      Map<String, TransformComponent> targetList,
                                      String indent) throws IOException
    {
        if (targetList != null)
        {
            String nextIndent = indent + INDENT;
            xml.print(indent).println("<target-list>");
            Iterator<Entry<String, TransformComponent>> it = targetList.entrySet().iterator();
            while (it.hasNext())
            {
                Entry<String, TransformComponent> entry = it.next();
                xml.print(nextIndent).print("<target ").print("name=\"").print(entry.getKey()).
                        println("\"/>");
            }
            xml.print(indent).println("</target-list>");
        }
    }

    private void writeDatasourceParameterListToXml(StringWriter xml,
                                                   Map<String, Value> propertyList,
                                                   String indent) throws IOException
    {
        if (propertyList != null && !propertyList.isEmpty())
        {
            String nextIndent = indent + INDENT;
            xml.print(indent).println("<property-list>");
            Iterator<Entry<String, Value>> it = propertyList.entrySet().iterator();
            while (it.hasNext())
            {
                Entry<String, Value> entry = it.next();
                xml.print(nextIndent).print("<property name=\"").print(entry.getKey()).print("\"");
                xml.print(" type=\"").print(entry.getValue().type().toString()).print("\">");
                xml.print(entry.getValue().toString());
                xml.println("</property>");
            }
            xml.print(indent).println("</property-list>");
        }
    }

    private void writeRegisterFormatListToXml(StringWriter xml, Direction direction,
                                              Map<String, FormatEntry> registeredFormatList,
                                              String indent) throws Exception
    {
        if (registeredFormatList != null && !registeredFormatList.isEmpty())
        {
            String nextIndent = indent + INDENT;
            xml.print(indent).print("<format-list direction=\"").print(direction.name()).println(
                    "\">");
            Iterator<Entry<String, FormatEntry>> it = registeredFormatList.entrySet().iterator();
            while (it.hasNext())
            {
                Entry<String, FormatEntry> entry = it.next();
                FormatEntry fe = entry.getValue();
                xml.print(nextIndent).print("<format-entry name=\"").print(fe.getName()).print(
                        "\" direction=\"").print(fe.getDirection().name()).println("\">");
                writeFormatToXml(xml, fe.getFormat(), nextIndent + INDENT);
                xml.print(nextIndent).println("</format-entry>");
            }
            xml.print(indent).println("</format-list>");
        }
    }

    private void writeFormatToXml(StringWriter xml, Format format, String indent) throws Exception
    {
        FormatXmlSerializer formatXml = new FormatXmlSerializer(format);
        formatXml.initIndent(indent);
        formatXml.write(xml.getOutStream());
    }

    private void writeDataTransformationListToXml(StringWriter xml,
                                                  List<DataTransformation> dataTransformationList,
                                                  String indent) throws Exception
    {
        if (dataTransformationList != null && !dataTransformationList.isEmpty())
        {
            String nextIndent = indent + INDENT;
            xml.print(indent).println("<processor-list>");
            for (DataTransformation dt : dataTransformationList)
            {
                writeDataTransformationToXml(xml, dt, nextIndent);
            }
            xml.print(indent).println("</processor-list>");
        }
    }

    private void writeDataTransformationToXml(StringWriter xml, DataTransformation dt,
                                              String indent) throws Exception
    {
        String nextIndent = indent + INDENT;
        xml.print(indent).print("<processor name=\"").print(dt.getName()).print("\" class-name=\"").
                print(dt.getClassName()).println("\">");
        xml.print(nextIndent).print("<position x=\"")
                .print(Integer.toString(dt.getX())).print("\" y=\"")
                .print(Integer.toString(dt.getY())).println("\"/>");
        writeTargetListToXml(xml, dt.getTargetList(), nextIndent);
        writeTransformRuleList(xml, dt.getTransformRuleList(), nextIndent);
        xml.print(indent).println("</processor>");
    }

    private void writeTransformRuleList(StringWriter xml,
                                        List<TransformRuleEntry> transformRuleList,
                                        String indent) throws Exception
    {
        if (transformRuleList != null && !transformRuleList.isEmpty())
        {
            String nextIndent = indent + INDENT;
            xml.print(indent).println("<transform-rule-list>");
            for (TransformRuleEntry ruleEntry : transformRuleList)
                writeTransformRuleEntry(xml, ruleEntry, nextIndent);
            xml.print(indent).println("</transform-rule-list>");
        }
    }

    private void writeTransformRuleEntry(StringWriter xml, TransformRuleEntry ruleEntry,
                                         String indent) throws Exception
    {
        xml.print(indent).print("<transform-rule-entry name=\"").print(ruleEntry.getName()).print(
                "\"");
        xml.print(" source-name=\"").print(ruleEntry.getSourceName()).print("\"");
        xml.print(" target-name=\"").print(ruleEntry.getTargetName()).println("\">");
        writeRuleToXml(xml, ruleEntry.getRule(), indent + INDENT);
        xml.print(indent).println("</transform-rule-entry>");
    }

    private void writeRuleToXml(StringWriter xml, TransformRule rule, String indent) throws Exception
    {
        TransformRuleXmlSerializer ruleXml = new TransformRuleXmlSerializer(rule);
        ruleXml.initIndent(indent);
        ruleXml.write(xml.getOutStream());
    }
}