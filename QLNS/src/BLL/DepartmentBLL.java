package BLL;

import java.util.ArrayList;

import DAL.DepartmentDAL;
import DTO.DepartmentDTO;

public class DepartmentBLL {
	DepartmentDAL departmentDAL= new DepartmentDAL();
	 public ArrayList<DepartmentDTO> getAllDepartment() {
		 return departmentDAL.getAllDepartment();
	 }
	 public int insertDepartment(DepartmentDTO departmentDTO,String namePB) {
		 String temp="";
		 for(String s:namePB.split(" ")) {
			 temp+=s.charAt(0);
		 }
		 String b="";
		 if(departmentDAL.countID(temp)>0) {
			 int num=departmentDAL.countID(temp)+1;
			 String initials = temp;
			  b= initials+String.format("%03d", num);
			  if(departmentDAL.checkID(b)) {
				  num++;
				  b=initials+String.format("%03d", num);
			  }
		 }else if(departmentDAL.countID(temp)==0) {
			 b=temp;
		 }
		 departmentDTO.setMaPB(b);
		 return departmentDAL.insertDepartment(departmentDTO);
	 }
	 
	 public int deleteDepartment(DepartmentDTO departmentDTO) {
		 return departmentDAL.deleteDepartment(departmentDTO);
	 }
	 
	 public int updateDepartment(DepartmentDTO departmentDTO) {
		 return departmentDAL.updateDepartment(departmentDTO);
	 }
	 
	 public ArrayList<String> getAllDepartmentID(){
		 return departmentDAL.getAllDepartmentID();
	 }
}
