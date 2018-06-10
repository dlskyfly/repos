package impl;

import java.util.ArrayList;
import java.util.List;

import model.BallRedFilter;

public class BallRedFilterImpl {
	
	private List<BallRedFilter> datas = new ArrayList<BallRedFilter>();
	
	public void fillFromBase() {
		delAll();
		
	}

	public List<BallRedFilter> getAll() {
		datas=null;
		return datas;
		
	}
	
	public void saveToDb(List<BallRedFilter> datas) {
		
	}
	
	public void delAll() {

	}
}
