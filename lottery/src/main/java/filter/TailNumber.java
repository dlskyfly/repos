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
    public static void filter(String recGroup, String recTimes) {
        if (recGroup == null || recTimes == null) {
            return;
        }

        BallRedFilterImpl ballRedFilterImpl = new BallRedFilterImpl();

        // 取得红球
        List<BallRedFilter> datas = ballRedFilterImpl.getRed();

        // post上传参数由String转换成Integer类型
        int group = Integer.parseInt(recGroup);
        // post上传参数由String转换成Integer类型
        int times = Integer.parseInt(recTimes);

        // 同尾号处理结果，保存供给下个处理使用
        List<BallRedFilter> saveData = new ArrayList<BallRedFilter>();

        int countGrp = 0;// 同尾号组数(如1,11,2,12，为2次)
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

            boolean isMatchNum = false;//出现的号码中是否有相同了的。false：还没有出现相同的
            int countTimes = 1; // 相同尾号出现个数(如1,11,21,31，为4次)
            int maxCountTimes = 1;  //相同尾号出现了的最多个数

            for (int x = 0; x < 5; x++) {
                if (dataArray[x] == dataArray[x+1]) {//如果N与N+1相同
                    if(isMatchNum == false) {//首次出现相同号码
                        isMatchNum= true;
                        countGrp++;//组数加一
                    }
                    countTimes++;//相同尾号组出现的个数加一
                } else {//如果N与N+1不同
                    isMatchNum = false;//下次的匹配将重置为首次
                    if(countTimes > maxCountTimes) {//保留当前相同尾号出现的个数
                        maxCountTimes = countTimes;
                    }
                    countTimes=1;
                }
            }

            if(group == countGrp) {//如果组数符合要求
                if((times == 1) || ((maxCountTimes == times)  && (times > 1)) ) {//相同尾号出现的个数也符合要求
                    saveData.add(data);
                }
            }

            //初始化或复原状态
            isMatchNum = false;
            countGrp = 0;
            maxCountTimes = 1;
        }

        ballRedFilterImpl.saveToDb(saveData);
    }
}
