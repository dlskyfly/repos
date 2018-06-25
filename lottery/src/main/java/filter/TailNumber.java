/**
 * @Title  TailNumber.java
 * @Package  filter
 * @Description  TODO
 * @author  Andy
 * @date  2018年6月20日 下午3:15:54
 * @version  V1.0
 * @Copyright  2018 http://www.dlmzk.com Inc. All rights reserved.
 */
package filter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import impl.BallRedFilterImpl;
import model.BallRedFilter;

/**
 * @ClassName TailNumber
 * @Description TODO
 * @author Andy
 * @date 2018年6月20日
 */
public class TailNumber {

    // time为同尾号出现最多次数
    public void filter(List<Integer> cond, List<BallRedFilter> datas, int time) {
        // 同尾号处理结果，保存供给下个处理使用
        List<BallRedFilter> saveData = new ArrayList<BallRedFilter>();

        int count = 0;// 同尾号出现次数(如1,11,2,12，为2次)
        for (BallRedFilter data : datas) {
            // 尾数数组
            int[] dataArray = new int[6];
            dataArray[0] = data.getRed1() % 10;
            dataArray[1] = data.getRed2() % 10;
            dataArray[2] = data.getRed3() % 10;
            dataArray[3] = data.getRed4() % 10;
            dataArray[4] = data.getRed5() % 10;
            dataArray[5] = data.getRed6() % 10;

            Arrays.sort(dataArray);

            for (int x = 0; x < 5; x++) {
                int countNumber = 0; // 同尾号出现个数(如1,11,21,31，为4次)
                for (int y = x + 1; y < 6; y++) {
                    if (dataArray[x] == dataArray[y]) {
                        countNumber++;
                        count++;
                    } else if(dataArray[x] < dataArray[y]) {
                        break;
                    }
                }

                //同样尾号球的个数超过规定限制
                if(countNumber > time) {
                    break;
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
