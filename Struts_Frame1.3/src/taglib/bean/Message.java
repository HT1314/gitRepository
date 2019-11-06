package taglib.bean;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Message extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		JspFragment body = this.getJspBody();
		JspContext jspCtx = this.getJspContext();
		PageContext ctx = (PageContext) jspCtx;
		JspWriter out = ctx.getOut();
		out.write("testMessage......");
//		body.invoke(out);
	}

}
