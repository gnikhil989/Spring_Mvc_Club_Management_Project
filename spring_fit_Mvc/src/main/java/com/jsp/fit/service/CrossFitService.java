package com.jsp.fit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.fit.dao.CrossFitDao;
import com.jsp.fit.dto.CrossFit;

@Component
public class CrossFitService {
	@Autowired
	CrossFitDao crossFitDao;

	public CrossFit saveCrossFit(CrossFit crossFit) {
		return crossFitDao.saveCrossFit(crossFit);
	}

	public boolean deleteCrossFitById(int id) {
		return crossFitDao.deleteCrossFitById(id);

	}

	public CrossFit updateCrossFitById(int id, CrossFit crossFit) {
		return crossFitDao.updateCrossFitById(id, crossFit);

	}

}
