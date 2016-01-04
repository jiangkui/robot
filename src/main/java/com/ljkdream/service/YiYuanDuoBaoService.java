package com.ljkdream.service;

import com.ljkdream.dao.GoodsMapper;
import com.ljkdream.dao.PeriodWinnerMapper;
import com.ljkdream.dao.UserMapper;
import com.ljkdream.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * PeriodWinnerService
 * Created by ljk on 16-1-3.
 */
@Service
public class YiYuanDuoBaoService {

    @Autowired
    private PeriodWinnerMapper periodWinnerDao;

    @Autowired
    private UserMapper userDao;

    @Autowired
    private GoodsMapper goodsDao;

    public int savePeriodWinnerByNotExist(PeriodWinner periodWinner) {
        PeriodWinner periodWinner1 = this.queryPeriodWinnerByPeriod(periodWinner.getPeriod());
        if (periodWinner1 != null) {
            return 1;
        }

        int insert = periodWinnerDao.insert(periodWinner);
        return insert;
    }

    public PeriodWinner queryPeriodWinnerByPeriod(Long period) {
        PeriodWinnerExample periodWinnerExample = new PeriodWinnerExample();
        periodWinnerExample.createCriteria().andPeriodEqualTo(period);

        List<PeriodWinner> periodWinnerList = periodWinnerDao.selectByExample(periodWinnerExample);

        if (periodWinnerList.size() > 0) {
            return periodWinnerList.get(0);
        }

        return null;
    }


    public int saveUserByNotExist(User user) {
        User user1 = this.queryUserByCid(user.getCid());
        if (user1 != null) {
            return 1;
        }

        int insert = userDao.insert(user);
        return insert;
    }

    private User queryUserByCid(Long cid) {
        UserExample example = new UserExample();
        example.createCriteria().andCidEqualTo(cid);

        List<User> userList = userDao.selectByExample(example);

        if (userList.size() > 0) {
            return userList.get(0);
        }

        return null;
    }

    /**
     * 获取 该商品最旧的哪一个 获奖数据
     *
     * @param gid 商品id
     * @return obj
     */
    public PeriodWinner queryOldPeriodWinnerByGid(Long gid) {
        PeriodWinnerExample periodWinnerExample = new PeriodWinnerExample();
        periodWinnerExample.createCriteria().andGidEqualTo(gid);
        periodWinnerExample.setOrderByClause("id desc limit 1");

        List<PeriodWinner> periodWinnerList = periodWinnerDao.selectByExample(periodWinnerExample);
        if (periodWinnerList.size() > 0) {
            return periodWinnerList.get(0);
        }

        return null;
    }

    private Map<Long, Long> goodsIdMap = new HashMap<>();

    public int saveGoodsByNotExist(Goods goods) {
        Long gid = goods.getGid();
        if (goodsIdMap.containsKey(gid)) {
            return 1;
        }

        Goods goods1 = queryGoodsByGid(gid);
        if (goods1 != null) {
            goodsIdMap.put(gid, gid);
            return 1;
        }

        int insert = goodsDao.insert(goods);
        if (insert > 0) {
            goodsIdMap.put(gid, gid);
        }

        return insert;
    }

    private Goods queryGoodsByGid(Long gid) {
        GoodsExample goodsExample = new GoodsExample();
        goodsExample.createCriteria().andGidEqualTo(gid);

        List<Goods> goodsList = goodsDao.selectByExample(goodsExample);
        if (goodsList.size() > 0) {
            return goodsList.get(0);
        }

        return null;
    }
}
