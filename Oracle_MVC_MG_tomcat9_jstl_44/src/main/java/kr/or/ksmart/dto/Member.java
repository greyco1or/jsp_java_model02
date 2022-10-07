package kr.or.ksmart.dto;

public class Member {
	private String ora_id;
	private String ora_pw;
	private String ora_level;
	private String ora_name;
	private String ora_email;
	public String getOra_id() {
		return ora_id;
	}
	public void setOra_id(String ora_id) {
		this.ora_id = ora_id;
	}
	public String getOra_pw() {
		return ora_pw;
	}
	public void setOra_pw(String ora_pw) {
		this.ora_pw = ora_pw;
	}
	public String getOra_level() {
		return ora_level;
	}
	public void setOra_level(String ora_level) {
		this.ora_level = ora_level;
	}
	public String getOra_name() {
		return ora_name;
	}
	public void setOra_name(String ora_name) {
		this.ora_name = ora_name;
	}
	public String getOra_email() {
		return ora_email;
	}
	public void setOra_email(String ora_email) {
		this.ora_email = ora_email;
	}
	@Override
	public String toString() {
		return "Member [ora_id=" + ora_id + ", ora_pw=" + ora_pw + ", ora_level=" + ora_level + ", ora_name=" + ora_name
				+ ", ora_email=" + ora_email + "]";
	}
	
	
}
