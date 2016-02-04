package com.ljkdream.yiyuanduobao.service;

import com.ljkdream.yiyuanduobao.dao.PeriodWinnerMapper;
import com.ljkdream.yiyuanduobao.model.GrabBuyRecord;
import com.ljkdream.yiyuanduobao.model.PeriodWinner;
import com.ljkdream.yiyuanduobao.model.PeriodWinnerExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 开奖服务
 * Created by jiangkui on 16-2-2.
 */
@Service
public class PeriodWinnerService {
    @Autowired
    private PeriodWinnerMapper periodWinnerMapper;

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

    public PeriodWinner queryNewPeriodWinnerByGid(Long gid) {
        PeriodWinnerExample example = new PeriodWinnerExample();
        example.createCriteria().andGidEqualTo(gid);
        example.setOrderByClause("duobao_time desc limit 1");

        List<PeriodWinner> list = periodWinnerMapper.selectByExample(example);
        if (list.size() > 0) {
            return list.get(0);
        }

        return null;
    }

    public PeriodWinner queryByMin() {
        PeriodWinnerExample example = new PeriodWinnerExample();
        example.setOrderByClause("id limit 1");

        List<PeriodWinner> list = periodWinnerMapper.selectByExample(example);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    public PeriodWinner queryNext(Long gid, Long period) {
        PeriodWinnerExample example = new PeriodWinnerExample();
        example.createCriteria().andGidEqualTo(gid).andPeriodEqualTo(period);

        List<PeriodWinner> list = periodWinnerMapper.selectByExample(example);
        if (list.isEmpty()) {
            return null;
        }

        PeriodWinner periodWinner = list.get(0);
        PeriodWinner resultDate = this.queryNextById(periodWinner.getId());
        if (resultDate == null) {
            return null;
        }

        return resultDate;
    }

    private PeriodWinner queryNextById(Long id) {
        PeriodWinnerExample example = new PeriodWinnerExample();
        example.createCriteria().andIdGreaterThan(id);
        example.setOrderByClause("id asc limit 1");
        List<PeriodWinner> list = periodWinnerMapper.selectByExample(example);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

}
