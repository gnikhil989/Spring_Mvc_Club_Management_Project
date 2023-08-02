package com.jsp.fit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.fit.dao.KarateDao;
import com.jsp.fit.dto.Karate;

@Component
public class KarateService {
	@Autowired
	KarateDao karateDao ;
	

	public Karate saveKarate(Karate karate) {
		return karateDao.saveKarate(karate);
	}

	public boolean deleteKarateById(int id) {
		return karateDao.deleteKarateById(id);

	}

	public Karate updateKarateById(int id, Karate karate) {
		return karateDao.updateKarateById(id, karate);

	}

}
