package com.ljkdream.yiyuanduobao.service;

import com.ljkdream.yiyuanduobao.dao.GoodsMapper;
import com.ljkdream.yiyuanduobao.dao.PeriodWinnerMapper;
import com.ljkdream.yiyuanduobao.dao.RelationGoodsPeriodMapper;
import com.ljkdream.yiyuanduobao.dao.UserMapper;
import com.ljkdream.yiyuanduobao.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    private PeriodWinnerMapper periodWinnerMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private RelationGoodsPeriodMapper relationGoodsPeriodMapper;

    private Logger logger = LoggerFactory.getLogger(YiYuanDuoBaoService.class);

    public int savePeriodWinnerByNotExist(PeriodWinner periodWinner) {
        PeriodWinner periodWinner1 = this.queryPeriodWinnerByPeriod(periodWinner.getPeriod());
        if (periodWinner1 != null) {
            return 1;
        }

        int insert = periodWinnerMapper.insert(periodWinner);
        return insert;
    }

    public PeriodWinner queryPeriodWinnerByPeriod(Long period) {
        PeriodWinnerExample periodWinnerExample = new PeriodWinnerExample();
        periodWinnerExample.createCriteria().andPeriodEqualTo(period);

        List<PeriodWinner> periodWinnerList = periodWinnerMapper.selectByExample(periodWinnerExample);

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

        int insert = userMapper.insert(user);
        return insert;
    }

    private User queryUserByCid(Long cid) {
        UserExample example = new UserExample();
        example.createCriteria().andCidEqualTo(cid);

        List<User> userList = userMapper.selectByExample(example);

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
        periodWinnerExample.setOrderByClause("period limit 1");

        List<PeriodWinner> periodWinnerList = periodWinnerMapper.selectByExample(periodWinnerExample);
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

        int insert = goodsMapper.insert(goods);
        if (insert > 0) {
            goodsIdMap.put(gid, gid);
        }

        return insert;
    }

    private Goods queryGoodsByGid(Long gid) {
        GoodsExample goodsExample = new GoodsExample();
        goodsExample.createCriteria().andGidEqualTo(gid);

        List<Goods> goodsList = goodsMapper.selectByExample(goodsExample);
        if (goodsList.size() > 0) {
            return goodsList.get(0);
        }

        return null;
    }

    public void saveRelationGoodsPeriodByMap(Map<String, String> relationMap) {
        Date now = new Date();

        for (Map.Entry<String, String> entry : relationMap.entrySet()) {
            try {
                String gidStr = entry.getKey();
                String periodStr = entry.getValue();
                long gid = Long.parseLong(gidStr);
                long period = Long.parseLong(periodStr);

                RelationGoodsPeriod relation = queryRelationGoodsPeriodByGid(gid);

                if (relation == null) {
                    RelationGoodsPeriod relationGoodsPeriod = new RelationGoodsPeriod();
                    relationGoodsPeriod.setGid(gid);
                    relationGoodsPeriod.setPeriod(period);
                    relationGoodsPeriod.setCreateTime(now);
                    relationGoodsPeriod.setModifyTime(now);
                    relationGoodsPeriodMapper.insert(relationGoodsPeriod);
                } else {
                    relation.setPeriod(period);
                    relation.setModifyTime(now);
                    relationGoodsPeriodMapper.updateByPrimaryKeySelective(relation);
                }
            } catch (Exception e) {
                logger.error("存储关系失败！" + e.getMessage());
            }
        }
    }

    private RelationGoodsPeriod queryRelationGoodsPeriodByGid(long gid) {
        RelationGoodsPeriodExample relationGoodsPeriodExample = new RelationGoodsPeriodExample();
        relationGoodsPeriodExample.createCriteria().andGidEqualTo(gid);

        List<RelationGoodsPeriod> list = relationGoodsPeriodMapper.selectByExample(relationGoodsPeriodExample);

        if (list.size() > 0) {
            return list.get(0);
        }

        return null;
    }

    public List<RelationGoodsPeriod> queryAllRelationGoodsPeriod() {
        RelationGoodsPeriodExample example = new RelationGoodsPeriodExample();

        List<RelationGoodsPeriod> list = relationGoodsPeriodMapper.selectByExample(example);

        return list;
    }

    public PeriodWinner queryNewPeriodWinnerByGid(Long gid) {
        PeriodWinnerExample example = new PeriodWinnerExample();
        example.createCriteria().andGidEqualTo(gid);
        example.setOrderByClause("period desc limit 1");

        List<PeriodWinner> list = periodWinnerMapper.selectByExample(example);
        if (list.size() > 0) {
            return list.get(0);
        }

        return null;
    }
}
