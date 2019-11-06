package test.actions;

import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.smartstruts.action.ActionForm;
import org.smartstruts.action.ActionForward;
import org.smartstruts.action.ActionMapping;
import org.smartstruts.actions.DispatchAction;

public class TestDispatAction extends DispatchAction{


	public ActionForward login(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
     System.out.println("LoginAction*********");
		
		LoginForm loginForm = (LoginForm) form;
		String number = (String) request.getSession().getAttribute("number");
		if ("admin".equals(loginForm.getUsername())
				&& "admin123456".equals(loginForm.getPassword())
				&& number.equals(loginForm.getNumber())) {

			return mapping.findActionForward("list");
		} else {
			ResourceBundle rb=(ResourceBundle) request.getSession().getServletContext().getAttribute("resourceBoundle");
			System.out.println(rb+"    ResourceBundle*********2");
			request.setAttribute("errorMessage",rb.getString("errorMessage"));
			return mapping.findActionForward("error");
		}
	}
	}


