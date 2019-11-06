package taglib.bean;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class HelloTag extends SimpleTagSupport {
	private int num;

	private String value;

	public HelloTag() {
		System.out.println("HelloTag()");
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		System.out.println("setNum(" + num + ")");
		this.num = num;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		System.out.println("setValue(" + value + ")");
		this.value = value;
	}

	@Override
	public void doTag() throws JspException, IOException {
		System.out.println("Tag...");
		JspContext jspCtx = this.getJspContext();
		PageContext ctx = (PageContext) jspCtx;
		JspWriter out = ctx.getOut();
		for (int i = 1; i <= num; i++) {
			out.write(value + " ");
		}
	}

}
