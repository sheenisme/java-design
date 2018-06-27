package curriculum_design;

import java.util.Date;

public class User{
	private String id;
	private String passward;
	private Date birth;
	public static int total;
	
	User(String id,String passward,Date birth) {
		this.id=id;
		this.passward=passward;
		this.birth=birth;
		total++;
	}
	
	public String getid() {
		return id;
	}
	
	public String getpassward() {
		return passward;
	}
	
	public Date getbirthday() {
		return birth;
	}
	
	public void show() {
		System.out.println(getid()+"  "+getpassward()+"  "+getbirthday());
	}
	
}