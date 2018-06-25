/**
 * @Title  ConsecutiveNumber.java
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
 * @ClassName ConsecutiveNumber
 * @Description TODO
 * @author Andy
 * @date 2018年6月20日
 */

public class ConsecutiveNumber {

    // time:最多允许几个号码完全相连
    public void filter(List<Integer> cond, List<BallRedFilter> datas, int time) {
        // 连号处理结果，保存供给下个处理使用
        List<BallRedFilter> saveData = new ArrayList<BallRedFilter>();

        int count = 0;
        for (BallRedFilter data : datas) {
            int[] dataArray = new int[6];
            dataArray[0] = data.getRed1();
            dataArray[1] = data.getRed2();
            dataArray[2] = data.getRed3();
            dataArray[3] = data.getRed4();
            dataArray[4] = data.getRed5();
            dataArray[5] = data.getRed6();

            int countNumber = 0; // 连号球出现个数(如1,2,3,4，为4次)
            for (int x = 0; x < 5; x++) {
                int index = 1;
                for (int y = x + 1; y < 6; y++) {
                    if (dataArray[y] - dataArray[x] == index) {
                        countNumber++;
                        count++;
                    } else {
                        break;
                    }
                }

                // 连号球出现个数超过规定限制
                if (countNumber > time) {
                    break;
                }
            }
            if (countNumber <= time) {
                for (int i : cond) {
                    if (count == i) {
                        saveData.add(data);
                        break;
                    }
                }
                count = 0;
                countNumber = 0;
            }
        }
        BallRedFilterImpl ballRedFilterImpl = new BallRedFilterImpl();
        ballRedFilterImpl.saveToDb(saveData);
    }
}
