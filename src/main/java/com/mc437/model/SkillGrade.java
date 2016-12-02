package com.mc437.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="skill_grade")
public class SkillGrade implements Serializable{

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private Integer gradeConpec;
	
	@Column
	private Integer gradeDev;
	
	@ManyToOne
	@JoinColumn(name="skill_id")
	private Skill skill;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getGradeConpec() {
		return gradeConpec;
	}

	public void setGradeConpec(Integer gradeConpec) {
		this.gradeConpec = gradeConpec;
	}

	public Integer getGradeDev() {
		return gradeDev;
	}

	public void setGradeDev(Integer gradeDev) {
		this.gradeDev = gradeDev;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}
	
}
