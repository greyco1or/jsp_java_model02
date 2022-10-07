package kr.or.ksmart.forward;
//DTO 역활 
//forward or redirect 결정 및 경로 셋팅 역활
public class MActionForward {
	//전역변수 = field
	private boolean isRedirect=false;
	private String path=null;
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	@Override
	public String toString() {
		return "MActionForward [isRedirect=" + isRedirect + ", path=" + path + "]";
	}

}
