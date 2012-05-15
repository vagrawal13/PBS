package com.pbs.utility;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTag;
import javax.servlet.jsp.tagext.Tag;

public class HelloWorldTag implements Tag,BodyTag{

	private PageContext pc;
	private Tag parent;
	
	@Override
	public int doEndTag() throws JspException {
		try {
			pc.getOut().write("Hello World");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}

	@Override
	public int doStartTag() throws JspException {
		return SKIP_BODY;
	}

	@Override
	public void release() {
		pc = null;
		parent = null;
	}

	@Override
	public void setPageContext(PageContext arg0) {
		this.pc = arg0;
	}

	@Override
	public void setParent(Tag arg0) {
		this.parent = arg0;
	}
	
	@Override
	public Tag getParent() {
		// TODO Auto-generated method stub
		return parent;
	}

	@Override
	public void doInitBody() throws JspException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setBodyContent(BodyContent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int doAfterBody() throws JspException {
		// TODO Auto-generated method stub
		return 0;
	}

}
