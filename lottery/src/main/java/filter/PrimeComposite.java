/**
 * @Title  PrimeComposite.java
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
 * @ClassName PrimeComposite
 * @Description 质合
 * @author Andy
 * @date 2018年6月20日
 */

public class PrimeComposite {

    private static final int[] PRIMES = {2,3,5,7,11,13,17,19,23,29,31};

    public void filter(List<Integer> cond, List<BallRedFilter> datas) {
        // 质合比处理结果，保存供给下个处理使用
        List<BallRedFilter> saveData = new ArrayList<BallRedFilter>();

        int count = 0;
        // 得到所有红球里是质数号球的个数
        for (BallRedFilter data : datas) {
            if (isPrime(data.getRed1())) {
                count++;
            }
            if (isPrime(data.getRed2())) {
                count++;
            }
            if (isPrime(data.getRed3())) {
                count++;
            }
            if (isPrime(data.getRed4())) {
                count++;
            }
            if (isPrime(data.getRed5())) {
                count++;
            }
            if (isPrime(data.getRed6())) {
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

        BallRedFilterImpl ballRedFilterImpl = new BallRedFilterImpl();
        ballRedFilterImpl.saveToDb(saveData);
    }

    private boolean isPrime(Integer number) {
        boolean result = false;
        for (int i = 0; i < PRIMES.length; i++) {
            if(number == PRIMES[i]) {
                result = true;
                break;
            }
        }
        return result;
    }
}
