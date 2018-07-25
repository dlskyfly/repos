/**
 * @Title  BallRedFilterMapper.java
 * @Package  dao
 * @Description  TODO
 * @author  Andy
 * @date  2018年6月13日 下午3:53:02
 * @version  V1.0
 * @Copyright  2018 http://www.dlmzk.com Inc. All rights reserved.
 */

package mapper;

import java.util.List;

import model.BallRedFilter;

/**
 * @ClassName  BallRedFilterMapper
 * @Description  TODO
 * @author  Andy
 * @date  2018年6月13日
 */

public interface BallRedFilterMapper {
    List<BallRedFilter> getRed();

    List<BallRedFilter> getRedFromRandom(int countNum);

    int getCount();

    void truncateTable();

    int insertByBatch(List<BallRedFilter> datas);

    void postFromBase();
}
