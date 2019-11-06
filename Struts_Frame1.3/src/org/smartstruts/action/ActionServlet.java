package org.smartstruts.action;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.digester.Digester;
import org.apache.commons.digester.xmlrules.DigesterLoader;

public class ActionServlet extends HttpServlet {
	private StrutsConfig config;

	private ActionMappings mappings;

	private FormBeans formBeans;

	private GlobalForwards globalForwards;

	private MessageResources messageResources;

	
	public void init()throws ServletException{
		System.out.println("init()....");
		try {
			this.initConfig();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
  public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			
			String path = processPath(request);
			System.out.println(mappings+" mappings");
			ActionMapping mapping = mappings.findActionMapping(path);
			Action action = processAction(mapping);
			ActionForm form = processForm(request, mapping);
			ActionForward forward = action.execute(mapping,form, request, response);
			processForward(forward, mapping, request, response);

		} catch (Exception e) {
			throw new ServletException("smartstruts", e);
		}
	}

	/**
	 *1.创建一个按照rule.xml配置的规则解析.xml文件的解析器对象
	 *2.给解析器提供一个与要解析的.xml文件对应的封装类（StrutsConfig）
	 *3.解析器按rule.xml文件定义的规则解析smartstruts-config.xml文件
	 *  用解析过程中得到的对象来给StrutsConfig的属性赋值。
	 *4.解析完了之后strutsConfig对象的属性就都有值了
	 * 
	 * @throws Exception
	 */
	private void initConfig() throws Exception {
		Digester digester = DigesterLoader.createDigester(ActionServlet.class
				.getClassLoader()
				.getResource("org/smartstruts/action/rule.xml"));
		config = new StrutsConfig();
		
		digester.push(config);
		digester.parse(ActionServlet.class.getClassLoader().getResource(
				"smartstruts-config.xml"));
		mappings = config.getMappings();
		formBeans = config.getFormBeans();
		globalForwards = config.getGlobalForwards();
		messageResources = config.getMessageResources();
		
		ResourceBundle rb = processMessageResource();
		processBaseResource(rb);
	}

	/**
	 * 锟斤拷锟斤拷Path
	 * 
	 * @param request
	 * @return
	 */
	private String processPath(HttpServletRequest request) {
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
		return path;
	}

	/**
	 * 
	 * @param mapping
	 * @return
	 */
	private Action processAction(ActionMapping mapping) throws Exception {
		String type = mapping.getType();
		Class clazz = Class.forName(type);
		return (Action) clazz.newInstance();
	}

	/**
	 * 
	 * @param mapping
	 * @return
	 */
	private ActionForm processForm(HttpServletRequest request,
			ActionMapping mapping) throws Exception {
		String name = mapping.getName();
		HttpSession session = request.getSession();
		if (name != null) {
			String attribute = mapping.getAttribute();
			if (attribute == null)
				attribute = name;
			String scope = mapping.getScope();

			ActionForm form = null;

			if (scope == null)
				scope = "session";

			if ("session".equals(scope)) {
				form = (ActionForm) session.getAttribute(attribute);
			} else {
				form = (ActionForm) request.getAttribute(attribute);
			}

			if (form == null) {
				FormBean formBean = formBeans.findFormBean(name);
				String type = formBean.getType();
				Class clazz = Class.forName(type);
				form = (ActionForm) clazz.newInstance();
				if ("session".equals(scope)) {
					session.setAttribute(attribute, form);
				} else {
					request.setAttribute(attribute, form);
				}
			}

			BeanUtils.populate(form, request.getParameterMap());

			return form;
		} else {
			return null;
		}
	}

	/**
	 * 
	 * @param forwardName
	 * @param mapping
	 */
	private void processForward(ActionForward forward, ActionMapping mapping,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
//		ActionForward forward = mapping.findActionForward(forwardName);
		if (forward.getPath() != null) {
			if (!forward.isRedirect()) {
				request.getRequestDispatcher(forward.getPath()).forward(
						request, response);
			} else {
				response.sendRedirect(request.getContextPath()
						+ forward.getPath());
			}
		} else {
			System.out.println("golbalForwards****************");
			forward = globalForwards.findActionForward(forward.getName());
			if(forward!=null){
			if (!forward.isRedirect()) {
				request.getRequestDispatcher(forward.getPath()).forward(
						request, response);
			} else {
				response.sendRedirect(request.getContextPath()
						+ forward.getPath());
			}
			}else{
				request.getRequestDispatcher("/WEB-INF/jsp/error404.jsp").forward(
						request, response);
				System.out.println("can not find the resource.......");
			}
		}
	}

	public ResourceBundle processMessageResource() {
		ResourceBundle rb=null;
		String baseResource = messageResources.getParameter();
		System.out.println(baseResource+"    baseResource*********1");
		if(baseResource!=null&&baseResource.length()!=0){
		rb = ResourceBundle.getBundle(baseResource);
		}
		return rb;
	}

	public void processBaseResource(ResourceBundle resourceBundle) {
		getServletContext().setAttribute("resourceBoundle", resourceBundle);
	}
}
