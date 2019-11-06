package org.smartstruts.action;

public class StrutsConfig {
	private ActionMappings mappings;

	private FormBeans formBeans;

	private GlobalForwards globalForwards;

	private MessageResources messageResources;

	public MessageResources getMessageResources() {
		return messageResources;
	}

	public void setMessageResources(MessageResources messageResources) {
		this.messageResources = messageResources;
	}

	public GlobalForwards getGlobalForwards() {
		return globalForwards;
	}

	public void setGlobalForwards(GlobalForwards globalForwards) {
		this.globalForwards = globalForwards;
	}

	public ActionMappings getMappings() {
		return mappings;
	}

	public void setMappings(ActionMappings mappings) {
		this.mappings = mappings;
	}

	public FormBeans getFormBeans() {
		return formBeans;
	}

	public void setFormBeans(FormBeans formBeans) {
		this.formBeans = formBeans;
	}

}
