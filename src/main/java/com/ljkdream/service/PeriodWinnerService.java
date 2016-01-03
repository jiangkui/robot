package com.ljkdream.service;

import com.ljkdream.dao.PeriodWinnerMapper;
import com.ljkdream.dao.UserMapper;
import com.ljkdream.model.PeriodWinner;
import com.ljkdream.model.PeriodWinnerExample;
import com.ljkdream.model.User;
import com.ljkdream.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * PeriodWinnerService
 * Created by ljk on 16-1-3.
 */
@Service
public class PeriodWinnerService {

    @Autowired
    private PeriodWinnerMapper periodWinnerDao;

    @Autowired
    private UserMapper userDao;

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
}
