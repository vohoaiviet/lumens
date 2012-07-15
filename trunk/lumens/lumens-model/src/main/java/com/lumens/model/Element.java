/*
 * Copyright Lumens Team, Inc. All Rights Reserved.
 */
package com.lumens.model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author shaofeng wang
 */
public interface Element
{
    /*Methods to get and set properties of data node*/
    public int getLevel();

    public void removeChild(Element child);

    public Element newChild(Format format);

    public Element addChild(String name);

    public Element addChild(Element child);

    public Element addArrayItem(Element item);

    public Element addArrayItem();

    public Element newArrayItem();

    public Element getParent();

    public Element getChild(String name);

    public Element getChildByPath(String path);

    public Element getChildByPath(Path path);

    public List<Element> getChildren();

    public Format getFormat();

    public Object getValue();

    public void setParent(Element data);

    public void setValue(Object value);

    public void setValue(short value);

    public void setValue(byte value);

    public void setValue(boolean value);

    public void setValue(int value);

    public void setValue(long value);

    public void setValue(float value);

    public void setValue(double value);

    public void setValue(byte[] value);

    public void setValue(Date value);

    public void setValue(String value);

    public short getShort();

    public byte getByte();

    public boolean getBoolean();

    public int getInt();

    public long getLong();

    public float getFloat();

    public double getDouble();

    public byte[] getBinary();

    public String getString();

    public Date getDate();

    public boolean isField();

    public boolean isStruct();

    public boolean isArray();

    public boolean isArrayOfField();

    public boolean isArrayOfStruct();

    public boolean isArrayItem();

    public boolean isEmpty();

    public boolean isShort();

    public boolean isByte();

    public boolean isBoolean();

    public boolean isInt();

    public boolean isLong();

    public boolean isFloat();

    public boolean isDouble();

    public boolean isBinary();

    public boolean isDate();

    public boolean isString();
}
