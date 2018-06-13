
/**
 * @Title  BallHistoryMapper.java
 * @Package  dao
 * @Description  TODO
 * @author  Andy
 * @date  2018年6月13日 下午3:53:02
 * @version  V1.0
 * @Copyright  2018 http://www.dlmzk.com Inc. All rights reserved.
 */

package mapper;

import model.BallHistory;

/**
 * @ClassName  BallHistoryMapper
 * @Description  TODO
 * @author  Andy
 * @date  2018年6月13日
 */

public interface BallHistoryMapper {
    BallHistory getHistoryByDataNo(int dataNo);
}

