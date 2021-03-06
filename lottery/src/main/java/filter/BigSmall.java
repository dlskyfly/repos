/**
 * @Title  BigSmall.java
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
import impl.BallRedFilterImpl;
import model.BallRedFilter;

/**
 * @ClassName BigSmall
 * @Description TODO
 * @author Andy
 * @date 2018年6月20日
 */

public class BigSmall {

    public static void filter(String[] recCond) {

        if(recCond == null) {
            return;
        }

        BallRedFilterImpl ballRedFilterImpl = new BallRedFilterImpl();

        //取得红球
        List<BallRedFilter> datas = ballRedFilterImpl.getRed();

        //post上传参数由String转换成Integer类型
        int[] cond = Common.strarrayToIntarray(recCond);

        // 大小比处理结果，保存供给下个处理使用
        List<BallRedFilter> saveData = new ArrayList<BallRedFilter>();

        int count = 0;
        // 1~16为小号，得到所有红球里是小号球的个数
        for (BallRedFilter data : datas) {
            if (data.getRed1() < 17) {
                count++;
            }
            if (data.getRed2() < 17) {
                count++;
            }
            if (data.getRed3() < 17) {
                count++;
            }
            if (data.getRed4() < 17) {
                count++;
            }
            if (data.getRed5() < 17) {
                count++;
            }
            if (data.getRed6() < 17) {
                count++;
            }

            for (int i : cond) {
                if (count == i) {
                    saveData.add(data);
                    break;
                }
            }
            count = 0;
        }

        //保存处理结果，以备下个过滤器使用
        ballRedFilterImpl.saveToDb(saveData);
    }
}
