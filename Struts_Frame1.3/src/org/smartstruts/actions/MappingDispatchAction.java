package org.smartstruts.actions;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.smartstruts.action.Action;
import org.smartstruts.action.ActionForm;
import org.smartstruts.action.ActionForward;
import org.smartstruts.action.ActionMapping;

public class MappingDispatchAction extends Action {



	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String methodName = mapping.getParameter();
        
		Class clazz = this.getClass();
		Method method = clazz.getMethod(methodName, new Class[] {
				ActionMapping.class, ActionForm.class,
				HttpServletRequest.class, HttpServletResponse.class });

		return (ActionForward) method.invoke(this, new Object[] { mapping,
				form, request, response });

	}

}
