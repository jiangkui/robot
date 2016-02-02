package com.ljkdream.yiyuanduobao.service;

import com.ljkdream.yiyuanduobao.dao.RelationGoodsPeriodMapper;
import com.ljkdream.yiyuanduobao.model.RelationGoodsPeriod;
import com.ljkdream.yiyuanduobao.model.RelationGoodsPeriodExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * PeriodWinnerService
 * Created by ljk on 16-1-3.
 */
@Service
public class RelationGoodsPeriodService {

    @Autowired
    private RelationGoodsPeriodMapper relationGoodsPeriodMapper;

    private Logger logger = LoggerFactory.getLogger(RelationGoodsPeriodService.class);


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

}
