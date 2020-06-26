package BLL;

import DAL.UserDAL;
import DTO.UserDTO;

public class UserBLL {
	UserDAL userDAL = new UserDAL();
	public boolean userAuth(UserDTO userDTO) {
		return userDAL.userAuth(userDTO);
	}
	
	public boolean changePassword(String pass,String newPass,String newPass1) {
		return userDAL.changePassword(pass, newPass, newPass1);
	}
}
