package com.jsp.fit.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class CrossFit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String sport_name;
private int timeslot1;
private int timeslot2;
private int timeslot3;
private int timeslot4;
@OneToMany
private List<User> users;

@OneToOne(mappedBy = "crossFit")
private Branch branch;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getSport_name() {
	return sport_name;
}
public void setSport_name(String sport_name) {
	this.sport_name = sport_name;
}

public int getTimeslot1() {
	return timeslot1;
}
public void setTimeslot1(int timeslot1) {
	this.timeslot1 = timeslot1;
}
public int getTimeslot2() {
	return timeslot2;
}
public void setTimeslot2(int timeslot2) {
	this.timeslot2 = timeslot2;
}
public int getTimeslot3() {
	return timeslot3;
}
public void setTimeslot3(int timeslot3) {
	this.timeslot3 = timeslot3;
}
public int getTimeslot4() {
	return timeslot4;
}
public void setTimeslot4(int timeslot4) {
	this.timeslot4 = timeslot4;
}
public List<User> getUsers() {
	return users;
}
public void setUsers(List<User> users) {
	this.users = users;
}
public Branch getBranch() {
	return branch;
}
public void setBranch(Branch branch) {
	this.branch = branch;
}

}
