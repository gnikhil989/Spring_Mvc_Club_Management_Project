package com.jsp.fit.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Branch {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String location;
private String s_name;
@ManyToOne(cascade = CascadeType.ALL)
private Admin admin;
@OneToMany(mappedBy = "branch2")
private List<User> users;
@OneToOne(cascade = CascadeType.ALL)
private Boxing boxing;
@OneToOne(cascade = CascadeType.ALL)
private CrossFit crossFit;
@OneToOne(cascade = CascadeType.ALL)
private Gym gym;
@OneToOne(cascade = CascadeType.ALL)
private Jumba jumba;
@OneToOne(cascade = CascadeType.ALL)
private Karate karate;
@OneToOne(cascade = CascadeType.ALL)
private Mma mma;
@OneToOne(cascade = CascadeType.ALL)
private Swim swim;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public Admin getAdmin() {
	return admin;
}
public void setAdmin(Admin admin) {
	this.admin = admin;
}
public List<User> getUsers() {
	return users;
}
public void setUsers(List<User> users) {
	this.users = users;
}
public Boxing getBoxing() {
	return boxing;
}
public void setBoxing(Boxing boxing) {
	this.boxing = boxing;
}
public CrossFit getCrossFit() {
	return crossFit;
}
public void setCrossFit(CrossFit crossFit) {
	this.crossFit = crossFit;
}
public Gym getGym() {
	return gym;
}
public void setGym(Gym gym) {
	this.gym = gym;
}
public Jumba getJumba() {
	return jumba;
}
public void setJumba(Jumba jumba) {
	this.jumba = jumba;
}
public Karate getKarate() {
	return karate;
}
public void setKarate(Karate karate) {
	this.karate = karate;
}
public Mma getMma() {
	return mma;
}
public void setMma(Mma mma) {
	this.mma = mma;
}
public Swim getSwim() {
	return swim;
}
public void setSwim(Swim swim) {
	this.swim = swim;
}
public String getS_name() {
	return s_name;
}
public void setS_name(String s_name) {
	this.s_name = s_name;
}

}
