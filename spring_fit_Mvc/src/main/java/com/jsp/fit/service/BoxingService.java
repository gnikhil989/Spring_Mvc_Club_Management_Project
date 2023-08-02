package com.jsp.fit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.fit.dao.BoxingDao;
import com.jsp.fit.dto.Boxing;

@Component
public class BoxingService {
	@Autowired
	BoxingDao boxingDao;

	public Boxing saveBoxing(Boxing boxing) {
		return boxingDao.saveBoxing(boxing);
	}

	public boolean deleteBoxingById(int id) {
		return boxingDao.deleteBoxingById(id);

	}

	public Boxing updateBoxingById(int id, Boxing boxing) {
		return boxingDao.updateBoxingById(id, boxing);

	}

}
