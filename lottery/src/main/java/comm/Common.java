/**
 * @Title  Common.java
 * @Package  comm
 * @Description  TODO
 * @author  Andy
 * @date  2018年6月20日 上午9:13:38
 * @version  V1.0
 * @Copyright  2018 http://www.dlmzk.com Inc. All rights reserved.
 */
package comm;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Transformer;

/**
 * @ClassName Common
 * @Description TODO
 */
public class Common {

    public static final int PAGE_INTERCEPT = 10000;

    //字符串数组转成int型数组
    public static int[] strarrayToIntarray(String[] param) {
        if (param != null) {
            int length = param.length;
            int[] result = new int[length];
            for (int i = 0; i < length; i++) {
                result[i] = Integer.parseInt(param[i]);
            }
            return result;
        } else {
            return null;
        }
    }

    //字符串List转成Integer型List
    public static List<Integer> strlistToIntlist(List<String> param) {
        List<Integer> result = new ArrayList<Integer>();

        CollectionUtils.collect(param, new Transformer() {
            @Override
            public Object transform(Object o) {
               return Integer.valueOf(o.toString());
            }
         }, result);

        return result;
    }
}
