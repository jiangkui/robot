package com.ljkdream.yiyuanduobao.service;

import com.ljkdream.yiyuanduobao.dao.GoodsMapper;
import com.ljkdream.yiyuanduobao.model.Goods;
import com.ljkdream.yiyuanduobao.model.GoodsExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 商品service
 * Created by jiangkui on 16-2-2.
 */
@Service
public class GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

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

}
