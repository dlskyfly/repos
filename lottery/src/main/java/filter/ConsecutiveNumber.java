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

import comm.Common;
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
    public static void filter(String[] recCond) {
        if (recCond == null) {
            return;
        }

        BallRedFilterImpl ballRedFilterImpl = new BallRedFilterImpl();

        // 取得红球
        List<BallRedFilter> datas = ballRedFilterImpl.getRed();

        // post上传参数由String转换成Integer类型
        int[] cond = Common.strarrayToIntarray(recCond);

        // 连号处理结果，保存供给下个处理使用
        List<BallRedFilter> saveData = new ArrayList<BallRedFilter>();

        for (BallRedFilter data : datas) {
            int[] dataArray = new int[6];
            dataArray[0] = data.getRed1();
            dataArray[1] = data.getRed2();
            dataArray[2] = data.getRed3();
            dataArray[3] = data.getRed4();
            dataArray[4] = data.getRed5();
            dataArray[5] = data.getRed6();

            // data中相邻数值的差是否相差一个数。1：相差一个数， 0：相差不止一个数
            int[] resultArray = new int[5];
            for (int i = 0; i < 5; i++) {
                if (dataArray[i] == dataArray[i + 1] - 1) {
                    resultArray[i] = 1;
                } else {
                    resultArray[i] = 0;
                }
            }

            for (int i : cond) {
                boolean isAdd = false;
                switch (i) {
                case 6://四连号
                    if (isConsecutiveNumber4(resultArray)) {
                        isAdd = true;
                    }
                    break;
                case 5://2组三连号
                    if (isConsecutiveNumber3(resultArray) == 2) {
                        isAdd = true;
                    }
                    break;
                case 4://1组三连号
                    if (!isConsecutiveNumber4(resultArray) && (isConsecutiveNumber3(resultArray) == 1)) {
                        isAdd = true;
                    }
                    break;
                case 3://3组两连号
                    if (!isConsecutiveNumber4(resultArray) && (isConsecutiveNumber3(resultArray) == 0)) {
                        if (isConsecutiveNumber2(resultArray) == 3) {
                            isAdd = true;
                        }
                    }
                    break;
                case 2://2组两连号
                    if (!isConsecutiveNumber4(resultArray) && (isConsecutiveNumber3(resultArray) == 0)) {
                        if (isConsecutiveNumber2(resultArray) == 2) {
                            isAdd = true;
                        }
                    }
                    break;
                case 1://1组两连号
                    if (!isConsecutiveNumber4(resultArray) && (isConsecutiveNumber3(resultArray) == 0)) {
                        if (isConsecutiveNumber2(resultArray) == 1) {
                            isAdd = true;
                        }
                    }
                    break;
                case 0://无连号
                    if (!isConsecutiveNumber4(resultArray) && (isConsecutiveNumber3(resultArray) == 0)) {
                        if (isConsecutiveNumber2(resultArray) == 0) {
                            isAdd = true;
                        }
                    }
                    break;
                default:
                    break;
                }

                if(isAdd) {
                    isAdd = false;
                    saveData.add(data);
                    break;
                }
            }
        }
        ballRedFilterImpl.saveToDb(saveData);
    }

    // 判断是否2连号(0:无连号，1：1组2连号，2：2组二连号，3：3组二连号)
    private static int isConsecutiveNumber2(final int[] resultArray) {
        int result = 0;
        int sum = 0;
        for (int index : resultArray) {
            sum += index;
        }

        // 不是三连号以上的情况下，下列判断才成立
        if (sum == 1) {
            result = 1;
        } else if (sum == 2) {
            result = 2;
        } else if (sum == 3) {
            result = 3;
        }

        return result;
    }

    // 判读是否是3连号(0:非三连号，1：一组三连号， 2：2组三连号)
    private static int isConsecutiveNumber3(final int[] resultArray) {
        int result = 0;
        if (resultArray[0] + resultArray[1] == 2) {
            if (resultArray[3] + resultArray[4] == 2) {
                result = 2;
            } else {
                result = 1;
            }
        } else if (resultArray[1] + resultArray[2] == 2) {
            result = 1;
        } else if (resultArray[2] + resultArray[3] == 2) {
            result = 1;
        } else if (resultArray[3] + resultArray[4] == 2) {
            result = 1;
        }
        return result;
    }

    // 判断是否是4连号(5连号以上的已经在基表中被去除掉了),true:是4连号
    private static boolean isConsecutiveNumber4(final int[] resultArray) {
        boolean result = false;
        if (resultArray[0] + resultArray[1] + resultArray[2] == 3) {
            result = true;
        } else if (resultArray[1] + resultArray[2] + resultArray[3] == 3) {
            result = true;
        } else if (resultArray[2] + resultArray[3] + resultArray[4] == 3) {
            result = true;
        }
        return result;
    }
}
