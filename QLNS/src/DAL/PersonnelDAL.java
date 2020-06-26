/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import UTILS.DBUtils;
import DTO.PersonnelDTO;
/**
 *
 * @author Huy
 */
public class PersonnelDAL {
    private DBUtils dbUtils = null;
    private Connection con=null;
    
    private PreparedStatement preparedStatement = null;
    
    private ResultSet resultSet = null;
    
    public ArrayList<PersonnelDTO> getAllPersonnel() {
        ArrayList<PersonnelDTO> rs= new ArrayList<PersonnelDTO>();
        String sql = "select * from thongtinnv";
        
        try {
            dbUtils= new DBUtils();
            con=dbUtils.getConnection();
            preparedStatement = con.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {                
                PersonnelDTO personnelDTO = new PersonnelDTO();
                personnelDTO.setMaNV(resultSet.getString("MaNV"));
                personnelDTO.setHoten(resultSet.getString("HoTen"));
                personnelDTO.setNgaySinh(resultSet.getString("NgaySinh"));
                personnelDTO.setQueQuan(resultSet.getString("QueQuan"));
                personnelDTO.setGioiTinh(resultSet.getString("GioiTinh"));
                personnelDTO.setDanToc(resultSet.getString("DanToc"));
                personnelDTO.setSDT(resultSet.getString("SoDienThoai"));
                personnelDTO.setMaPB(resultSet.getString("MaPB"));
                personnelDTO.setMaCV(resultSet.getString("MaCV"));
                personnelDTO.setMaTDHV(resultSet.getString("MaTDHV"));
                personnelDTO.setBacLuong(resultSet.getString("MucLuong"));
                personnelDTO.setCMND(resultSet.getString("SoCMND"));
                rs.add(personnelDTO);
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
    
    public int insertPersonnel(PersonnelDTO personDTO) {
		int result =0;
		String sqlInsert = "insert into thongtinnv(MaNV,HoTen,NgaySinh,QueQuan,GioiTinh,DanToc,SoDienThoai"
				+ ",MaPB,MaCV,MaTDHV,MucLuong,SoCMND) values (?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			dbUtils = new DBUtils();
			con = dbUtils.getConnection();
			preparedStatement= con.prepareStatement(sqlInsert);
			preparedStatement.setString(1, personDTO.getMaNV());
			preparedStatement.setString(2, personDTO.getHoten());
			preparedStatement.setString(3, personDTO.getNgaySinh());
			preparedStatement.setString(4, personDTO.getQueQuan());
			preparedStatement.setString(5, personDTO.getGioiTinh());
			preparedStatement.setString(6, personDTO.getDanToc());
			preparedStatement.setString(7, personDTO.getSDT());
			preparedStatement.setString(8, personDTO.getMaPB());
			preparedStatement.setString(9, personDTO.getMaCV());
			preparedStatement.setString(10, personDTO.getMaTDHV());
			preparedStatement.setString(11, personDTO.getBacLuong());
			preparedStatement.setString(12, personDTO.getCMND());
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
    public int deletePersonnel(PersonnelDTO personDTO) {
		int result =0;
		String sqlDelete = "delete from thongtinnv where MaNV = ?";
		try {
			dbUtils = new DBUtils();
			con= dbUtils.getConnection();
			preparedStatement= con.prepareStatement(sqlDelete);
			preparedStatement.setString(1, personDTO.getMaNV());
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
    
    public int updatePersonnel(PersonnelDTO personDTO){
		int result=0;
		String sqlUpdate ="update thongtinnv set HoTen=?,NgaySinh=?,QueQuan=?,GioiTinh=?,DanToc=?,SoDienThoai=?" + 
					",MaPB=?,MaCV=?,MaTDHV=?,MucLuong=?,SoCMND=? where MaNV=?";
		try {
			dbUtils = new DBUtils();
			con=dbUtils.getConnection();
			preparedStatement = con.prepareStatement(sqlUpdate);
			preparedStatement.setString(1, personDTO.getHoten());
			preparedStatement.setString(2, personDTO.getNgaySinh());
			preparedStatement.setString(3, personDTO.getQueQuan());
			preparedStatement.setString(4, personDTO.getGioiTinh());
			preparedStatement.setString(5, personDTO.getDanToc());
			preparedStatement.setString(6, personDTO.getSDT());
			preparedStatement.setString(7, personDTO.getMaPB());
			preparedStatement.setString(8, personDTO.getMaCV());
			preparedStatement.setString(9, personDTO.getMaTDHV());
			preparedStatement.setString(10, personDTO.getBacLuong());
			preparedStatement.setString(11, personDTO.getCMND());
			preparedStatement.setString(12, personDTO.getMaNV());
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
    public int countRecord() {
		int num=0;
		try {
			dbUtils = new DBUtils();
			con = dbUtils.getConnection();
			preparedStatement = con.prepareStatement("select count(*) from thongtinnv");
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				num=resultSet.getInt(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return num;
	}
    public boolean checkCMND(PersonnelDTO personDTO) {
    	try {
			dbUtils = new DBUtils();
			con = dbUtils.getConnection();
			preparedStatement = con.prepareStatement("Select SoCMND from thongtinnv where SoCMND = ?");
			preparedStatement.setString(1, personDTO.getCMND());
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				return true;
			}else return false;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
    }
    public ArrayList<PersonnelDTO> getPersonByKey(String key){
		ArrayList<PersonnelDTO> result = new ArrayList<PersonnelDTO>();
		String sqlSelectById="Select * from thongtinnv where  HoTen LIKE ? OR MaNV LIKE ? OR SoDienThoai LIKE ?"
				+ "OR SoCMND LIKE ? OR MaPB LIKE ? OR MaCV LIKE ? OR MucLuong LIKE ?";
		try {
			dbUtils= new DBUtils();
			con=dbUtils.getConnection();
			preparedStatement = con.prepareStatement(sqlSelectById);
			preparedStatement.setString(1, "%" + key + "%");
			preparedStatement.setString(2, "%" + key + "%");
			preparedStatement.setString(3, "%" + key + "%");
			preparedStatement.setString(4, "%" + key + "%");
			preparedStatement.setString(5, "%" + key + "%");
			preparedStatement.setString(6, "%" + key + "%");
			preparedStatement.setString(7, "%" + key + "%");
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				PersonnelDTO personDTO1 = new PersonnelDTO();
				personDTO1.setMaNV(resultSet.getString("MaNV"));
				personDTO1.setHoten(resultSet.getString("HoTen"));
				personDTO1.setNgaySinh(resultSet.getString("NgaySinh"));
				personDTO1.setQueQuan(resultSet.getString("QueQuan"));
				personDTO1.setGioiTinh(resultSet.getString("GioiTinh"));
				personDTO1.setDanToc(resultSet.getString("DanToc"));
				personDTO1.setSDT(resultSet.getString("SoDienThoai"));
				personDTO1.setMaPB(resultSet.getString("MaPB"));
				personDTO1.setMaCV(resultSet.getString("MaCV"));
				personDTO1.setMaTDHV(resultSet.getString("MaTDHV"));
				personDTO1.setBacLuong(resultSet.getString("MucLuong"));
				personDTO1.setCMND(resultSet.getString("SoCMND"));
				result.add(personDTO1);
			}
		}catch(SQLException e) {
			
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
		return result;
	} 
}
