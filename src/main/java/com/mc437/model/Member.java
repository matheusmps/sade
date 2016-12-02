package com.mc437.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
@DiscriminatorValue("MEM")
public class Member extends User {
	
	public static final String TYPE = "MEM";
	
	@ManyToMany
	@JoinTable(name="member_groups",
			joinColumns = { @JoinColumn(name = "member_id")},
			inverseJoinColumns = { @JoinColumn(name = "group_id") })
	Set<MemberGroup> groups = new HashSet<MemberGroup>();

}
