package impl;

import java.util.ArrayList;
import java.util.List;

import model.BallRedFilter;

public class BallRedFilterImpl {
	
	private List<List<Integer>> datas = new ArrayList<List<Integer>>();
	
	public void fillFromBase() {
		delAll();
		
	}

	public List<List<Integer>> getAll() {
		return datas;
	}
	
	public void saveToDb(List<List<Integer>> datas) {
		
	}
	
	public void delAll() {

	}
}
