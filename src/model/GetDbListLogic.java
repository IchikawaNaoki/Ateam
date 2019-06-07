package model;

import java.util.List;

public class GetDbListLogic {
	public List<GetDB> execute(){
		ConnDB conDb = new ConnDB();
		List<GetDB> DbList = conDb.findAll();
		return DbList;
	}
}
