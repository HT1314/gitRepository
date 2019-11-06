package org.smartstruts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Action {
	public static final String SUCCESS = "success";

	public static final String FAIL = "fail";

	public abstract ActionForward execute(ActionMapping mapping,ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception;
}
