package com.macquarium.ong;

import com.macquarium.ong.vo.Enrollment;

public interface EnrollmentDaoService {

	public int insertEnrollment(Enrollment enrollment);

	public int updateEnrollement(Enrollment enrollment,int id);

}
