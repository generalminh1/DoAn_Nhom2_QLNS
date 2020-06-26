package DTO;

public class UserDTO {
	private static String username;
	private static String pw;
	
	public UserDTO() {
		this.username = "";
		this.pw = "";
	}
	
	
	public UserDTO(String username, String pw) {
		this.username = username;
		this.pw = pw;
	}


	public static String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPw() {
		return pw;
	}


	public void setPw(String pw) {
		this.pw = pw;
	}
	
	
}
