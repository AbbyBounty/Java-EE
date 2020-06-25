package tags;

import java.io.IOException;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class CleanTagHandler extends SimpleTagSupport{
	public CleanTagHandler() {
		System.out.println("Inside constructor of "+this.getClass().getSimpleName());
	}
	@Override
	public void doTag() throws JspException, IOException {
		PageContext pageContext = (PageContext) this.getJspContext();
		HttpSession session = pageContext.getSession();
		session.invalidate();
	}
}
