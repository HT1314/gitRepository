package org.smartstruts.action;

import java.util.HashMap;
import java.util.Map;

public class ActionMappings {
	private Map<String, ActionMapping> actions = new HashMap<String, ActionMapping>();

	/**
	 * 
	 * @param mapping
	 */
	public void addActionMapping(ActionMapping mapping) {
		actions.put(mapping.getPath(), mapping);
	}

	/**
	 * 
	 * @param path
	 * @return
	 */
	public ActionMapping findActionMapping(String path) {
		return (ActionMapping) actions.get(path);
	}

	public String toString() {
		return actions.toString();
	}

}
