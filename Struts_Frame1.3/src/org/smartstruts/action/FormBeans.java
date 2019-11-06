package org.smartstruts.action;

import java.util.HashMap;
import java.util.Map;

public class FormBeans {
	private Map<String, FormBean> forms = new HashMap<String, FormBean>();

	public void addFormBean(FormBean form) {
		forms.put(form.getName(), form);
	}

	public FormBean findFormBean(String name) {
		return forms.get(name);
	}

	public String toString() {
		return forms.toString();
	}
}
