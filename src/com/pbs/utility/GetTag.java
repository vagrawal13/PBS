package com.pbs.utility;

import java.util.Hashtable;
import java.util.Stack;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

public class GetTag extends TagSupport {
   /**
	 * 
	 */ 
   private static final long serialVersionUID = 1L;
	
   private String name;

   public void setName(String name) {
      this.name = name;
   }
   public int doStartTag() throws JspException {
      // obtain reference to template stack
      Stack stack = (Stack)pageContext.getAttribute("template-stack", PageContext.REQUEST_SCOPE);

      if(stack == null)
         throw new JspException("GetTag.doStartTag(): " + "NO STACK");
      // peek at hashtable
      Hashtable params = (Hashtable)stack.peek();
      // hashtable should not be null
      if(params == null)
         throw new JspException("GetTag.doStartTag(): " +"NO HASHTABLE");
      // get page parameter from hashtable
      PageParameter param = (PageParameter)params.get(name);
      if(param != null) {
         String content = param.getContent();
         if(param.isDirect()) {
            // print content if direct attribute is true
            try {
               pageContext.getOut().print(content);
            }
            catch(java.io.IOException ex) {
               throw new JspException(ex.getMessage());
            }
         }
         else {
            // include content if direct attribute is false
            try {
               pageContext.getOut().flush();
               pageContext.include(content);
            }
            catch(Exception ex) {
               throw new JspException(ex.getMessage());
            }
         }
      }
      return SKIP_BODY; // not interested in tag body, if present
   }

   public void release() {
      name = null;
   }
}