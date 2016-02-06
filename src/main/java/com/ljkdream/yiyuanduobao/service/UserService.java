package com.ljkdream.yiyuanduobao.service;

import com.ljkdream.yiyuanduobao.dao.UserMapper;
import com.ljkdream.yiyuanduobao.model.User;
import com.ljkdream.yiyuanduobao.model.UserExample;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 用户服务
 * Created by jiangkui on 16-2-2.
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;
    private ConcurrentHashMap<Long, Boolean> cidCacheMap = new ConcurrentHashMap<>();

    public int saveUserByNotExist(User user) {
        boolean userExist = this.userExist(user.getCid());
        if (userExist) {
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
     * 判断 user 是否已经存在数据库中
     *
     * @param cid cid
     * @return true 已经存在
     */
    public boolean userExist(Long cid) {
//        if (cidCacheMap.isEmpty()) {
//            synchronized (UserService.class) {
//                if (cidCacheMap.isEmpty()) {
//                    refreshCidCache();
//                }
//            }
//        }

        //缓存中已经存在
        Boolean exist = cidCacheMap.putIfAbsent(cid, true);
        if (exist != null) {
            return true;
        }

        //查询 user 数据是否已经存在
        User user = queryUserByCid(cid);
        if (user == null) {
            return false;
        } else {
            return true;
        }
    }

    private void refreshCidCache() {
        List<Long> list = userMapper.queryAllCid();
        for (Long cid : list) {
            cidCacheMap.put(cid, true);
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
