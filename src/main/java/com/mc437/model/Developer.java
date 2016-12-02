package com.mc437.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
@DiscriminatorValue("DEV")
public class Developer extends User {
	
	public static final String TYPE = "DEV";
	
	@ManyToMany
	@JoinTable(name="dev_skill_grades",
			joinColumns = { @JoinColumn(name = "dev_id")},
			inverseJoinColumns = { @JoinColumn(name = "skill_grade_id") })
	Set<SkillGrade> skillGrades = new HashSet<SkillGrade>();
	
	@Column
	private String address;

	@Column
	private String phoneNumber;
	
	@Column
	private String cellphoneNumber;
	
	@Column
	private String educationInstitution;
	
	@Column
	private String course;
	
	@Column
	private String courseStartYear;
	
	@Column
	private Integer availableHours;
	
	@Column
	private Integer courseHours;
	
	@Column
	private Integer internshipHours;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCellphoneNumber() {
		return cellphoneNumber;
	}

	public void setCellphoneNumber(String cellphoneNumber) {
		this.cellphoneNumber = cellphoneNumber;
	}

	public String getEducationInstitution() {
		return educationInstitution;
	}

	public void setEducationInstitution(String educationInstitution) {
		this.educationInstitution = educationInstitution;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getCourseStartYear() {
		return courseStartYear;
	}

	public void setCourseStartYear(String courseStartYear) {
		this.courseStartYear = courseStartYear;
	}

	public Integer getAvailableHours() {
		return availableHours;
	}

	public void setAvailableHours(Integer availableHours) {
		this.availableHours = availableHours;
	}

	public Integer getCourseHours() {
		return courseHours;
	}

	public void setCourseHours(Integer courseHours) {
		this.courseHours = courseHours;
	}

	public Integer getInternshipHours() {
		return internshipHours;
	}

	public void setInternshipHours(Integer internshipHours) {
		this.internshipHours = internshipHours;
	}

	public Set<SkillGrade> getSkillGrades() {
		return skillGrades;
	}

	public void setSkillGrades(Set<SkillGrade> skillGrades) {
		this.skillGrades = skillGrades;
	}
}
