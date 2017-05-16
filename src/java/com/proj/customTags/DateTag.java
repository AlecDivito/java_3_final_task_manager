/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proj.customTags;

import java.io.IOException;
import java.util.Calendar;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author alecdivito
 */
public class DateTag extends SimpleTagSupport{
    
    /**
     *
     * @throws IOException
     * @throws JspException
     */
    @Override
    public void doTag() throws IOException, JspException {
        JspWriter out = getJspContext().getOut();
        int year = Calendar.getInstance().get(Calendar.YEAR);
        out.println(year);
    }
    
}
