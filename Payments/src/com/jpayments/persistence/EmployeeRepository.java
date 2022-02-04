package com.jpayments.persistence;

import java.util.ArrayList;
import java.util.List;

import com.payments.domain.AbsStaffMember;

public class EmployeeRepository {			

	private static List<AbsStaffMember> members = new ArrayList<>();
	
	public EmployeeRepository() {}
	
	public static List<AbsStaffMember> getMembers() {
		return members;
	}

	public static void setMembers(List<AbsStaffMember> members) {
		EmployeeRepository.members = members;
	}	
	
	public List<AbsStaffMember> getAllMembers() {
		return members;
	}	
	
	public void addMember(AbsStaffMember member) throws Exception {
		if(member==null) throw new Exception();
		members.add(member);
	}

}
