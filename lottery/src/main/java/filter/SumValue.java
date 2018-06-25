/**
 * @Title  SumValue.java
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

import impl.BallRedFilterImpl;
import model.BallRedFilter;

/**
 * @ClassName SumValue
 * @Description TODO
 * @author Andy
 * @date 2018年6月20日
 */

public class SumValue {

    public void filter(List<Integer> cond, List<BallRedFilter> datas) {
        // 和值处理结果，保存供给下个处理使用
        List<BallRedFilter> saveData = new ArrayList<BallRedFilter>();

        int count = 0;
        int sum = 0;
        for (BallRedFilter data : datas) {
            // 以后改成从数据库中查询到的就是和值
            sum = data.getRed1() + data.getRed2() + data.getRed3() + data.getRed4() + data.getRed5() + data.getRed6();

            if (sum < 61) {
                count = 0;
            } else if (sum < 71) {
                count = 1;
            } else if (sum < 81) {
                count = 2;
            } else if (sum < 91) {
                count = 3;
            } else if (sum < 101) {
                count = 4;
            } else if (sum < 111) {
                count = 5;
            } else if (sum < 121) {
                count = 6;
            } else if (sum < 131) {
                count = 7;
            } else if (sum < 141) {
                count = 8;
            } else if (sum < 151) {
                count = 9;
            } else if (sum < 161) {
                count = 10;
            } else {
                count = 11;
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
