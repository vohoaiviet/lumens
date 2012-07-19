/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lumens.client.view.element;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.DragAppearance;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.DragMoveEvent;
import com.smartgwt.client.widgets.events.DragMoveHandler;
import com.smartgwt.client.widgets.toolbar.ToolStrip;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author washaofe
 */
public class TransformationElement extends ToolStrip
        implements DragMoveHandler
{
    private List<ElementLink> outLinks = new ArrayList<ElementLink>();
    private List<ElementLink> inLinks = new ArrayList<ElementLink>();
    private Label label = new Label();

    public TransformationElement()
    {
        init();
    }

    public TransformationElement(String ico)
    {
        init();
        label.setIconSize(48);
        label.setIcon(ico);
        label.setLayoutAlign(Alignment.LEFT);
        addMember(label);
    }

    public void setLabel(String text)
    {
        label.setContents(text);
    }

    public void addOutLink(ElementLink link)
    {
        outLinks.add(link);
    }

    public void addInLink(ElementLink link)
    {
        inLinks.add(link);
    }

    @Override
    public void onDragMove(DragMoveEvent event)
    {
        for (ElementLink link : outLinks)
        {
            link.updatePosition();
        }
        for (ElementLink link : inLinks)
        {
            link.updatePosition();
        }
    }

    private void init()
    {
        setWidth(120);
        setHeight(60);
        setCanDrag(true);
        setKeepInParentRect(true);
        setDragAppearance(DragAppearance.TARGET);
        addDragMoveHandler(this);
    }
}