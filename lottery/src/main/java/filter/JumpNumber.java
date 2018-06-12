package filter;

import java.util.ArrayList;
import java.util.List;

import impl.BallHistoryImpl;
import impl.BallRedFilterImpl;

public class JumpNumber {
	public void filter(List<Integer> cond, List<List<Integer>> datas, int dataNo) {
		
		//取出最近第二期的中奖号码
		BallHistoryImpl impl = new BallHistoryImpl();
		int[] historys= impl.getHistoryByDataNo(dataNo-2);
		
		List<List<Integer>> saveData = new ArrayList<List<Integer>>();
		
		for(List<Integer> data: datas) {
			int count = 0;
			for(Integer fil : data) {
				for(Integer his : historys) {
					if(fil.compareTo(his)==0) {
						count++;
						break;
					}
				}
			}
			
			for(int i: cond) {
				if (count == i) {
					saveData.add(data);
				}
			}
		}
		
		BallRedFilterImpl ballRedFilterImpl = new BallRedFilterImpl();
		ballRedFilterImpl.saveToDb(saveData);
	}
}
