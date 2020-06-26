package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.PersonnelDTO;
import DTO.UserDTO;
import UTILS.DBUtils;

public class UserDAL {
	private DBUtils dbUtils = null;
    private Connection con=null;
    
    private PreparedStatement preparedStatement = null;
    
    private ResultSet resultSet = null;
    
    public boolean userAuth(UserDTO userDTO) {
    	String sql = "select * from user where TaiKhoan=? and MatKhau=?";
    	try {
            dbUtils= new DBUtils();
            con=dbUtils.getConnection();
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, userDTO.getUsername());
            preparedStatement.setString(2, userDTO.getPw());
            resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {                
                return false;
            }
            return true;
        } catch (Exception e) {
        	e.printStackTrace();
        }
        finally {
			try {
				con.close();
				preparedStatement.close();
				resultSet.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
    	return true;
    }
    public boolean changePassword(String pass,String newPass,String newPass1) {
    	int result=0;
    	String sqlCheckpass = "select * from user where TaiKhoan = ? and MatKhau=?";
		String sqlUpdate ="update user set MatKhau = ? where TaiKhoan  = ?";
		try {
            dbUtils= new DBUtils();
            con=dbUtils.getConnection();
            preparedStatement = con.prepareStatement(sqlCheckpass);
            preparedStatement.setString(1, UserDTO.getUsername());
            preparedStatement.setString(2, pass);
            resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {                
                return false;
            } else {
            	if (newPass.equals(newPass1)) {
            		try {
                        dbUtils= new DBUtils();
                        con=dbUtils.getConnection();
                        preparedStatement = con.prepareStatement(sqlUpdate);
                        preparedStatement.setString(1, newPass);
                        preparedStatement.setString(2, UserDTO.getUsername());
                        result=preparedStatement.executeUpdate();
                    } catch (Exception e) {
                    	e.printStackTrace();
                    }
                    finally {
            			try {
            				con.close();
            				preparedStatement.close();
            				resultSet.close();
            			}catch(SQLException e) {
            				e.printStackTrace();
            			}
            		}
				} else {
					return false;
				}
            }
        } catch (Exception e) {
        	e.printStackTrace();
        }
        finally {
			try {
				con.close();
				preparedStatement.close();
				resultSet.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
    }
}
