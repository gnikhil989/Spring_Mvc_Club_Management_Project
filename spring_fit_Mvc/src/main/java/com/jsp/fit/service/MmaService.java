package com.jsp.fit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.fit.dao.MmaDao;
import com.jsp.fit.dto.Mma;

@Component
public class MmaService {
	@Autowired
	MmaDao mmaDao ;
	

	public Mma saveMma(Mma mma) {
		return mmaDao.saveMma(mma);
	}

	public boolean deleteMmaById(int id) {
		return mmaDao.deleteMmaById(id);

	}

	public Mma updateMmaById(int id, Mma mma) {
		return mmaDao.updateMmaById(id, mma);

	}

}
