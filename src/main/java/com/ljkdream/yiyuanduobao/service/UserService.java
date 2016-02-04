package com.ljkdream.yiyuanduobao.service;

import com.ljkdream.yiyuanduobao.dao.UserMapper;
import com.ljkdream.yiyuanduobao.model.User;
import com.ljkdream.yiyuanduobao.model.UserExample;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 用户服务
 * Created by jiangkui on 16-2-2.
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;
    private Set<Long> cidCacheSet = new HashSet<>();

    public int saveUserByNotExist(User user) {
        boolean userExist = this.userExist(user.getCid());
        if (userExist) {
            return 1;
        }

        int insert = userMapper.insert(user);

        //加入缓存
        cidCacheSet.add(user.getCid());
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
     * 判断 user 是否已经存在数据库中
     *
     * @param cid cid
     * @return true 已经存在
     */
    public boolean userExist(Long cid) {
        if (cidCacheSet.isEmpty()) {
            synchronized (UserService.class) {
                if (cidCacheSet.isEmpty()) {
                    refreshCidCache();
                }
            }
        }
        return cidCacheSet.contains(cid);
    }

    private void refreshCidCache() {
        List<Long> list = userMapper.queryAllCid();
        for (Long cid : list) {
            cidCacheSet.add(cid);
        }
    }

    public void insertByList(List<User> userList) {
        if (CollectionUtils.isEmpty(userList)) {
            return;
        }

        for (User user : userList) {
            saveUserByNotExist(user);
        }
    }
}
