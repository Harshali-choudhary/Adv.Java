package com.app.Service;

import java.util.List;

import com.app.entities.Railway;

public interface RailwayService {

	Railway Add(Railway railway);
	String Delete(long id);
	List<Railway> GetAll();
	Railway GeById(long id);
	Railway UpdateDetails (Railway r);
	//Railway GetbyCategory(String category);
}
