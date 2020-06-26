package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.PositionDTO;
import UTILS.DBUtils;

public class PositionDAL {
	private DBUtils dbUtils = null;
    private Connection con=null;
    
    private PreparedStatement preparedStatement = null;
    
    private ResultSet resultSet = null;
    public ArrayList<PositionDTO> getAllPosition(){
    	ArrayList<PositionDTO> rs= new ArrayList<PositionDTO>();
    	String sql="Select * from chucvu";
    	try {
    		dbUtils= new DBUtils();
    		con= dbUtils.getConnection();
    		preparedStatement=con.prepareStatement(sql);
    		resultSet=preparedStatement.executeQuery();
    		while(resultSet.next()) {
    			PositionDTO posDTO= new PositionDTO();
    			posDTO.setMaCV(resultSet.getString("MaCV"));
    			posDTO.setTenCV(resultSet.getString("TenChucVu"));
    			rs.add(posDTO);
    		}
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return rs;
    }
    public int insertPosition(PositionDTO posDTO) {
    	int result=0;
    	String sqlInsert=("insert into chucvu(MaCV,TenChucVu) values(?,?)");
    	try{
    		dbUtils= new DBUtils();
    		con= dbUtils.getConnection();
    		preparedStatement=con.prepareStatement(sqlInsert);
    		preparedStatement.setString(1,posDTO.getMaCV());
    		preparedStatement.setString(2,posDTO.getTenCV());
    		result=preparedStatement.executeUpdate();
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return result;
    }
    public int deletePosition(PositionDTO posDTO) {
    	int result =0;
		String sqlDelete = "delete from chucvu where MaCV = ?";
		try {
			dbUtils = new DBUtils();
			con= dbUtils.getConnection();
			preparedStatement= con.prepareStatement(sqlDelete);
			preparedStatement.setString(1, posDTO.getMaCV());
			preparedStatement.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
    }
    
    public int updatePosition(PositionDTO posDTO) {
    	int result=0;
		String sqlUpdate ="update chucvu set TenChucVu=? where MaCV=?";
		try {
			dbUtils = new DBUtils();
			con=dbUtils.getConnection();
			preparedStatement = con.prepareStatement(sqlUpdate);
			preparedStatement.setString(1, posDTO.getTenCV());
			preparedStatement.setString(2, posDTO.getMaCV());
			result= preparedStatement.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
    }
    
    public int countID(String ID) {
    	int result=0;
    	try {
			dbUtils = new DBUtils();
			con = dbUtils.getConnection();
			preparedStatement = con.prepareStatement("Select MaCV from chucvu where MaCV LIKE ?");
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
			preparedStatement = con.prepareStatement("Select MaCV from chucvu where MaCV = ?");
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
    
   public ArrayList<String>getAllPositionID(){
    	 String sql = "select MaCV from chucvu";
         ArrayList<String> result= new ArrayList<String>();
         try {
             dbUtils= new DBUtils();
             con=dbUtils.getConnection();
             preparedStatement = con.prepareStatement(sql);
             resultSet = preparedStatement.executeQuery();
             
             while (resultSet.next()) {          
                 result.add(resultSet.getString("MaCV"));
             }
         } catch (Exception e) {
         	e.printStackTrace();
         }
         return result;
    }
}
