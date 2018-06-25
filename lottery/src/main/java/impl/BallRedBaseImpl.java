/**
 * @Title  BallRedBaseImpl.java
 * @Package  impl
 * @Description  TODO
 * @author  Andy
 * @date  2018年6月14日 下午4:01:04
 * @version  V1.0
 * @Copyright  2018 http://www.dlmzk.com Inc. All rights reserved.
 */

package impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dao.BaseDao;
import mapper.BallRedBaseMapper;
import model.BallRedBase;

/**
 * @ClassName BallRedBaseImpl
 * @Description TODO
 */
public class BallRedBaseImpl extends BaseDao {

    private static Logger logger = LoggerFactory.getLogger("lottery");

    public List<BallRedBase> getAll() {
        SqlSession sqlSession = null;
        List<BallRedBase> result = new ArrayList<BallRedBase>();
        try {
            sqlSession = getSqlSession();
            BallRedBaseMapper ballRedBaseMapper = sqlSession.getMapper(BallRedBaseMapper.class);
            result = ballRedBaseMapper.getAll();
        } catch (IOException e) {
            logger.error("ERR", e);
        }finally {
            sqlSession.close();
        }
        return result;
    }
}
