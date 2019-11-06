package org.smartstruts.action;

public class ActionForward {
	private String name;

	private String path;
	
    private boolean redirect = false;
    public ActionForward(){
    	super();
    }

	public ActionForward(String name, String path, boolean redirect) {
		super();
		this.name = name;
		this.path = path;
		this.redirect = redirect;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public boolean isRedirect() {
		return redirect;
	}

	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}

}
