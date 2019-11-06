package test;

import org.apache.commons.digester.Digester;
import org.apache.commons.digester.xmlrules.DigesterLoader;
import org.smartstruts.action.ActionServlet;
import org.smartstruts.action.StrutsConfig;

public class TestDigester {
	public static void main(String[] args) throws Exception {
		Digester digester = DigesterLoader.createDigester(ActionServlet.class
				.getClassLoader()
				.getResource("org/smartstruts/action/rule.xml"));
		StrutsConfig config = new StrutsConfig();
		digester.push(config);
		digester.parse(ActionServlet.class.getClassLoader().getResource(
				"smartstruts-config.xml"));
		System.out.println(config.getFormBeans());
		System.out.println(config.getMappings());
	}
}
