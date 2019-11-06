package org.smartstruts.action;

import java.util.HashMap;
import java.util.Map;

public class GlobalForwards {
	private Map<String, ActionForward> forwards = new HashMap<String, ActionForward>();

	public void addActionForward(ActionForward forward) {
		forwards.put(forward.getName(), forward);
	}

	public ActionForward findActionForward(String name) {
		return forwards.get(name);
	}

	public Map<String, ActionForward> getForwards() {
		return forwards;
	}

	public void setForwards(Map<String, ActionForward> forwards) {
		this.forwards = forwards;
	}

}
