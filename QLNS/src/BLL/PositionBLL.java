package BLL;

import java.util.ArrayList;

import DAL.PositionDAL;
import DTO.PositionDTO;

public class PositionBLL {
	PositionDAL posDAL= new PositionDAL();
	public ArrayList<PositionDTO>getAllPosition(){
		return posDAL.getAllPosition();
	}
	public int insertPosition(PositionDTO posDTO,String nameCV) {
		 String temp="";
		 for(String s:nameCV.split(" ")) {
			 temp+=s.charAt(0);
		 }
		 String b="";
		 if(posDAL.countID(temp)>0) {
			 int num=posDAL.countID(temp)+1;
			 String initials = temp;
			  b= initials+String.format("%03d", num);
			  if(posDAL.checkID(b)) {
				  num++;
				  b=initials+String.format("%03d", num);
			  }
		 }else if(posDAL.countID(temp)==0) {
			 b=temp;
		 }
		 posDTO.setMaCV(b);
		 return posDAL.insertPosition(posDTO);
	 }
	public int deletePosition(PositionDTO posDTO) {
		 return posDAL.deletePosition(posDTO);
	 }
	 
	 public int updatePosition(PositionDTO posDTO) {
		 return posDAL.updatePosition(posDTO);
	 }
	 
	 public ArrayList<String> getAllPositionID(){
		 return posDAL.getAllPositionID();
	 }
}
