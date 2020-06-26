package BLL;

import java.util.ArrayList;

import DAL.SalaryDAL;
import DTO.SalaryDTO;



public class SalaryBLL {
	SalaryDAL salaryDAL= new SalaryDAL();
	public ArrayList<SalaryDTO>getAllSalary(){
		return salaryDAL.getAllSalary();
	}
	public int insertPosition(SalaryDTO salaryDTO) {
		int num=salaryDAL.countRecord();
		String initials = "MUC";
		String b = initials+String.format("%01d", num);
		if(salaryDAL.checkID(b)) {
			b = initials+String.format("%01d", num+1);
			salaryDTO.setMaBL(b);
		}else
		salaryDTO.setMaBL(b);
		int result= salaryDAL.insertSalary(salaryDTO);
		return result;
	 }
	public int deleteSalary(SalaryDTO salaryDTO) {
		 return salaryDAL.deleteSalary(salaryDTO);
	 }
	 
	 public int updateSalary(SalaryDTO salaryDTO) {
		 return salaryDAL.updateSalary(salaryDTO);
	 }
	 
	 public ArrayList<String> getAllSalaryID(){
		 return salaryDAL.getAllSalaryID();
	 }
}
