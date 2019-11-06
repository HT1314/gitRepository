package org.smartstruts.action;

import java.util.HashMap;
import java.util.Map;

public class ActionMapping {
	private String path;

	private String type;

	private String name;

	private String scope;

	private String attribute;
	
	private String parameter;

	private Map<String, ActionForward> forwards = new HashMap<String, ActionForward>();

	public void addActionForward(ActionForward forward) {
		forwards.put(forward.getName(), forward);
	}

	public ActionForward findActionForward(String name) {
		ActionForward forward=forwards.get(name);
		if(forward==null){
			forward= new ActionForward(name,null,false);
		}
		return forward;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public Map<String, ActionForward> getForwards() {
		return forwards;
	}

	public void setForwards(Map<String, ActionForward> forwards) {
		this.forwards = forwards;
	}

	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}
}
