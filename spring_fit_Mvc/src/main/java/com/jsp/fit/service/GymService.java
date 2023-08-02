package com.jsp.fit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.fit.dao.GymDao;
import com.jsp.fit.dto.Gym;

@Component
public class GymService {
	@Autowired
	GymDao gymDao;

	public Gym saveGym(Gym gym) {
		return gymDao.saveGym(gym);
	}

	public boolean deleteGymById(int id) {
		return gymDao.deleteGymById(id);

	}

	public Gym updateGymById(int id, Gym gym) {
		return gymDao.updateGymById(id, gym);

	}

}
