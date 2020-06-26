package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.DepartmentDTO;
import UTILS.DBUtils;

public class DepartmentDAL {
	private DBUtils dbUtils = null;
    private Connection con=null;
    
    private PreparedStatement preparedStatement = null;
    
    private ResultSet resultSet = null;
    public ArrayList<DepartmentDTO> getAllDepartment() {
    	ArrayList<DepartmentDTO> rs= new ArrayList<DepartmentDTO>();
        String sql = "select * from phongban";
        
        try {
            dbUtils= new DBUtils();
            con=dbUtils.getConnection();
            preparedStatement = con.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {                
                DepartmentDTO departmentDTO= new DepartmentDTO();
                departmentDTO.setMaPB(resultSet.getString("MaPB"));
                departmentDTO.setTenPB(resultSet.getString("TenPB"));
                rs.add(departmentDTO);
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
		return rs;
    }
    
    public int insertDepartment(DepartmentDTO departmentDTO) {
    	int result =0;
		String sqlInsert = "insert into phongban(MaPB,TenPB) values (?,?)";
		try {
			dbUtils = new DBUtils();
			con = dbUtils.getConnection();
			preparedStatement= con.prepareStatement(sqlInsert);
			preparedStatement.setString(1, departmentDTO.getMaPB());
			preparedStatement.setString(2, departmentDTO.getTenPB());
			result=preparedStatement.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
				preparedStatement.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
    }
    
    public int deleteDepartment(DepartmentDTO departmentDTO) {
    	int result =0;
		String sqlDelete = "delete from phongban where MaPB = ?";
		try {
			dbUtils = new DBUtils();
			con= dbUtils.getConnection();
			preparedStatement= con.prepareStatement(sqlDelete);
			preparedStatement.setString(1, departmentDTO.getMaPB());
			preparedStatement.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
				preparedStatement.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
    }
    
    public int updateDepartment(DepartmentDTO departmentDTO) {
    	int result=0;
		String sqlUpdate ="update phongban set TenPB=? where MaPB=?";
		try {
			dbUtils = new DBUtils();
			con=dbUtils.getConnection();
			preparedStatement = con.prepareStatement(sqlUpdate);
			preparedStatement.setString(1, departmentDTO.getTenPB());
			preparedStatement.setString(2, departmentDTO.getMaPB());
			result= preparedStatement.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
				preparedStatement.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
    }
    public int countID(String ID) {
    	int result=0;
    	try {
			dbUtils = new DBUtils();
			con = dbUtils.getConnection();
			preparedStatement = con.prepareStatement("Select MaPB from phongban where MaPB LIKE ?");
			preparedStatement.setString(1, ID+"%");
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				result++;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
    }
    public boolean checkID(String ID) {
    	try {
			dbUtils = new DBUtils();
			con = dbUtils.getConnection();
			preparedStatement = con.prepareStatement("Select MaPB from phongban where MaPB = ?");
			preparedStatement.setString(1, ID);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				return true;
			}else return false;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
    }
    public ArrayList<String> getAllDepartmentID() {
    	 String sql = "select MaPB from phongban";
         ArrayList<String> result= new ArrayList<String>();
         try {
             dbUtils= new DBUtils();
             con=dbUtils.getConnection();
             preparedStatement = con.prepareStatement(sql);
             resultSet = preparedStatement.executeQuery();
             
             while (resultSet.next()) {          
                 result.add(resultSet.getString("MaPB"));
             }
         } catch (Exception e) {
         	e.printStackTrace();
         }
         return result;
    }
}
