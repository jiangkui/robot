package com.ljkdream.yiyuanduobao.service;

import com.ljkdream.yiyuanduobao.dao.UserMapper;
import com.ljkdream.yiyuanduobao.model.User;
import com.ljkdream.yiyuanduobao.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户服务
 * Created by jiangkui on 16-2-2.
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

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
}
