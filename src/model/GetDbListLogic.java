package model;

import java.util.List;

import dao.ConnDbDao;

public class GetDbListLogic {
	public List<GetDB> execute(){
		ConnDbDao conDb = new ConnDbDao();
		List<GetDB> DbList = conDb.findAll();
		return DbList;
	}
}
