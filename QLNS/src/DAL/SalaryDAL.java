package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.SalaryDTO;
import UTILS.DBUtils;

public class SalaryDAL {
	private DBUtils dbUtils = null;
    private Connection con=null;
    
    private PreparedStatement preparedStatement = null;
    
    private ResultSet resultSet = null;
    public ArrayList<SalaryDTO> getAllSalary(){
    	ArrayList<SalaryDTO> rs= new ArrayList<SalaryDTO>();
    	String sql="Select * from bacluong";
    	try {
    		dbUtils= new DBUtils();
    		con= dbUtils.getConnection();
    		preparedStatement=con.prepareStatement(sql);
    		resultSet=preparedStatement.executeQuery();
    		while(resultSet.next()) {
    			SalaryDTO bacluongDTO= new SalaryDTO();
    			bacluongDTO.setMaBL(resultSet.getString("MaBL"));
    			bacluongDTO.setSoTien(resultSet.getFloat("SoTien"));
    			rs.add(bacluongDTO);
    		}
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return rs;
    }
    public int insertSalary(SalaryDTO salaryDTO) {
    	int result=0;
    	String sqlInsert=("insert into bacluong(MaBL,SoTien) values(?,?)");
    	try{
    		dbUtils= new DBUtils();
    		con= dbUtils.getConnection();
    		preparedStatement=con.prepareStatement(sqlInsert);
    		preparedStatement.setString(1,salaryDTO.getMaBL());
    		preparedStatement.setFloat(2,salaryDTO.getSoTien());
    		result=preparedStatement.executeUpdate();
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return result;
    }
    public int deleteSalary(SalaryDTO salaryDTO) {
    	int result =0;
		String sqlDelete = "delete from bacluong where MaBL = ?";
		try {
			dbUtils = new DBUtils();
			con= dbUtils.getConnection();
			preparedStatement= con.prepareStatement(sqlDelete);
			preparedStatement.setString(1, salaryDTO.getMaBL());
			preparedStatement.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
    }
    
    public int updateSalary(SalaryDTO salaryDTO) {
    	int result=0;
		String sqlUpdate ="update bacluong set SoTien=? where MaBL=?";
		try {
			dbUtils = new DBUtils();
			con=dbUtils.getConnection();
			preparedStatement = con.prepareStatement(sqlUpdate);
			preparedStatement.setFloat(1, salaryDTO.getSoTien());
			preparedStatement.setString(2, salaryDTO.getMaBL());
			result= preparedStatement.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
    }
    
    public int countRecord() {
    	int result=0;
    	try {
			dbUtils = new DBUtils();
			con = dbUtils.getConnection();
			preparedStatement = con.prepareStatement("Select MaBL from bacluong");
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
			preparedStatement = con.prepareStatement("Select MaBL from bacluong where MaBL = ?");
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
    
   public ArrayList<String>getAllSalaryID(){
    	 String sql = "select MaBL from bacluong";
         ArrayList<String> result= new ArrayList<String>();
         try {
             dbUtils= new DBUtils();
             con=dbUtils.getConnection();
             preparedStatement = con.prepareStatement(sql);
             resultSet = preparedStatement.executeQuery();
             
             while (resultSet.next()) {          
                 result.add(resultSet.getString("MaBL"));
             }
         } catch (Exception e) {
         	e.printStackTrace();
         }
         return result;
    }
}
