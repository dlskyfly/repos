/**
 * @Title  RepeatNumber.java
 * @Package  filter
 * @Description  TODO
 * @author  Andy
 * @date  2018年6月20日 下午3:15:54
 * @version  V1.0
 * @Copyright  2018 http://www.dlmzk.com Inc. All rights reserved.
 */

package filter;

import java.util.ArrayList;
import java.util.List;

import comm.Common;
import impl.BallHistoryImpl;
import impl.BallRedFilterImpl;
import model.BallRedFilter;

/**
 * @ClassName RepeatNumber
 * @Description TODO
 * @author Andy
 * @date 2018年6月20日
 */

public class RepeatNumber {

    public static void filter(String[] recCond, String historyDate) {
        if(recCond == null || historyDate == null) {
            return;
        }

        BallRedFilterImpl ballRedFilterImpl = new BallRedFilterImpl();

        //取得红球
        List<BallRedFilter> datas = ballRedFilterImpl.getRed();

        //post上传参数由String转换成Integer类型
        int[] cond = Common.strarrayToIntarray(recCond);

        // 重号处理结果，保存供给下个处理使用
        List<BallRedFilter> saveData = new ArrayList<BallRedFilter>();

        //最近一期中奖号码
        List<Integer> historys = new BallHistoryImpl().getHistoryByDataNo(Integer.parseInt(historyDate));

        int count = 0;
        // 得到所有红球里是重号的个数
        for (BallRedFilter data : datas) {
            int red1=data.getRed1();
            int red2=data.getRed2();
            int red3=data.getRed3();
            int red4=data.getRed4();
            int red5=data.getRed5();
            int red6=data.getRed6();
            for(Integer history: historys) {
                if(red1 == history) {
                  count++;
                } else if(red2 == history) {
                    count++;
                } else if(red3 == history) {
                    count++;
                } else if(red4 == history) {
                    count++;
                } else if(red5 == history) {
                    count++;
                } else if(red6 == history) {
                    count++;
                }
            }

            for (int i : cond) {
                if (count == i) {
                    saveData.add(data);
                    break;
                }
            }
            count = 0;
        }

        ballRedFilterImpl.saveToDb(saveData);
    }
}
