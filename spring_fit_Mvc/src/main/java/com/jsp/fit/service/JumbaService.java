package com.jsp.fit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.fit.dao.JumbaDao;
import com.jsp.fit.dto.Jumba;

@Component
public class JumbaService {
	@Autowired
	JumbaDao jumbaDao;

	public Jumba saveJumba(Jumba jumba) {
		return jumbaDao.saveJumba(jumba);
	}

	public boolean deleteJumbaById(int id) {
		return jumbaDao.deleteJumbaById(id);

	}

	public Jumba updateJumbaById(int id, Jumba jumba) {
		return jumbaDao.updateJumbaById(id, jumba);

	}
}
