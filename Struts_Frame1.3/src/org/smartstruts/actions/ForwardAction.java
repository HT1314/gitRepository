package org.smartstruts.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.smartstruts.action.Action;
import org.smartstruts.action.ActionForm;
import org.smartstruts.action.ActionForward;
import org.smartstruts.action.ActionMapping;

public class ForwardAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping,ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return mapping.findActionForward("forward");
	}

}
