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

    public void filter(List<Integer> cond, List<BallRedFilter> datas) {
        // 重号处理结果，保存供给下个处理使用
        List<BallRedFilter> saveData = new ArrayList<BallRedFilter>();

        //最近一期中奖号码
        List<Integer> historys = new BallHistoryImpl().getHistoryByDataNo(20160416);

        int count = 0;
        // 得到所有红球里是重号的个数
        for (BallRedFilter data : datas) {
            for(Integer history: historys) {
                if(data.getRed1() == history) {
                  count++;
                } else if(data.getRed2() == history) {
                    count++;
                } else if(data.getRed3() == history) {
                    count++;
                } else if(data.getRed4() == history) {
                    count++;
                } else if(data.getRed5() == history) {
                    count++;
                } else if(data.getRed6() == history) {
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

        BallRedFilterImpl ballRedFilterImpl = new BallRedFilterImpl();
        ballRedFilterImpl.saveToDb(saveData);
    }
}
