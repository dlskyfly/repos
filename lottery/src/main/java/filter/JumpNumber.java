package filter;

import java.util.ArrayList;
import java.util.List;

import comm.Common;
import impl.BallHistoryImpl;
import impl.BallRedFilterImpl;
import model.BallRedFilter;

public class JumpNumber {

	    public static void filter(String[] recCond, String historyDate) {

	        if(recCond == null || historyDate == null) {
	            return;
	        }

	        BallRedFilterImpl ballRedFilterImpl = new BallRedFilterImpl();

	        //取得红球
	        List<BallRedFilter> datas = ballRedFilterImpl.getRed();

	        //post上传参数由String转换成Integer类型
	        int[] cond = Common.strarrayToIntarray(recCond);

		//取出最近第二期的中奖号码
		BallHistoryImpl impl = new BallHistoryImpl();
		List<Integer> historys= impl.getHistoryDate2(historyDate);

		//跳号处理结果，保存供给下个处理使用
		List<BallRedFilter> saveData = new ArrayList<BallRedFilter>();

		//每组可能的号码与最近第二期的中奖号码相比较，得到“相同次数”的值
        for (BallRedFilter data : datas) {
            int count = 0;

            Integer red1 = data.getRed1();
            Integer red2 = data.getRed2();
            Integer red3 = data.getRed3();
            Integer red4 = data.getRed4();
            Integer red5 = data.getRed5();
            Integer red6 = data.getRed6();

            for (Integer his : historys) {
                if (his.compareTo(red1) == 0) {
                    count++;
                } else if (his.compareTo(red2) == 0) {
                    count++;
                } else if (his.compareTo(red3) == 0) {
                    count++;
                } else if (his.compareTo(red4) == 0) {
                    count++;
                } else if (his.compareTo(red5) == 0) {
                    count++;
                } else if (his.compareTo(red6) == 0) {
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

		ballRedFilterImpl.saveToDb(saveData);
	}
}
