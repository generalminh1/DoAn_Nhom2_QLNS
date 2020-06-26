/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.util.ArrayList;
import DAL.PersonnelDAL;
import DTO.PersonnelDTO;
/**
 *
 * @author Huy
 */
public class PersonnelBLL {
	PersonnelDAL personDAL= new PersonnelDAL();
    public ArrayList<PersonnelDTO> getAllPersonnel() {
        
        return personDAL.getAllPersonnel();
    }
    public int insertPersonnel(PersonnelDTO personDTO) {
    	if(!personDAL.checkCMND(personDTO)){
    	String num=personDTO.getCMND().substring(personDTO.getCMND().length()-6);
		String initials = "NV";
		String b = initials+String.format(num);
		personDTO.setMaNV(b);
		personDAL.insertPersonnel(personDTO);
		return 1;
    	}else
    	return 0;
    }
    public int deletePersonnel(PersonnelDTO personDTO) {
    	return personDAL.deletePersonnel(personDTO);
    }
    public int updatePersonnel(PersonnelDTO personDTO) {
    	String b= personDTO.getMaNV();
    	String num=personDTO.getCMND().substring(personDTO.getCMND().length()-6);
		String initials = "NV";
		b = initials+String.format(num);
		personDTO.setMaNV(b);
    	return personDAL.updatePersonnel(personDTO);
    }
    public ArrayList<PersonnelDTO> getPersonByKey(String Key){
    	return personDAL.getPersonByKey(Key);
    }
    
    public boolean checkLegitCMND(PersonnelDTO personDTO) {
    	String regex = "^[0-9]{12}$";
    	String regex1="^[0-9]{9}$";
    	if (personDTO.getCMND().matches(regex) || personDTO.getCMND().matches(regex1)) {
    		return true;
    	}
    	return false;
    }
    
    public boolean checkLegitNumber(PersonnelDTO personDTO) {
    	String regex = "^[0-9]{10}$";
    	if(personDTO.getSDT().startsWith("0") && personDTO.getSDT().matches(regex)) {
    		return true;
    	}
    	return false;
    }
}
