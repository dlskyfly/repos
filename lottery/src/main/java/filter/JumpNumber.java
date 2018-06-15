package filter;

import java.util.ArrayList;
import java.util.List;

import impl.BallHistoryImpl;
import impl.BallRedFilterImpl;
import model.BallRedFilter;

public class JumpNumber {

	public void filter(List<Integer> cond, List<BallRedFilter> datas, int dataNo) {
		//取出最近第二期的中奖号码
		BallHistoryImpl impl = new BallHistoryImpl();
		List<Integer> historys= impl.getHistoryByDataNo(dataNo-2);

		//跳号处理结果，保存供给下个处理使用
		List<BallRedFilter> saveData = new ArrayList<BallRedFilter>();

		//每组可能的号码与最近第二期的中奖号码相比较，得到“相同次数”的值
        for (BallRedFilter data : datas) {
            int count = 0;
            for (Integer his : historys) {
                if (his.compareTo(data.getRed1()) == 0) {
                    count++;
                } else if (his.compareTo(data.getRed2()) == 0) {
                    count++;
                } else if (his.compareTo(data.getRed3()) == 0) {
                    count++;
                } else if (his.compareTo(data.getRed4()) == 0) {
                    count++;
                } else if (his.compareTo(data.getRed5()) == 0) {
                    count++;
                } else if (his.compareTo(data.getRed6()) == 0) {
                    count++;
                }
            }

            for (int i : cond) {
                if (count == i) {
                    saveData.add(data);
                    break;
                }
            }
        }

		BallRedFilterImpl ballRedFilterImpl = new BallRedFilterImpl();
		ballRedFilterImpl.saveToDb(saveData);
	}
}
