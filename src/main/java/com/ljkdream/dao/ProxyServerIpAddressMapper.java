package com.ljkdream.dao;

import com.ljkdream.model.ProxyServerIpAddress;
import com.ljkdream.model.ProxyServerIpAddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProxyServerIpAddressMapper {
    int countByExample(ProxyServerIpAddressExample example);

    int deleteByExample(ProxyServerIpAddressExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ProxyServerIpAddress record);

    int insertSelective(ProxyServerIpAddress record);

    List<ProxyServerIpAddress> selectByExample(ProxyServerIpAddressExample example);

    ProxyServerIpAddress selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ProxyServerIpAddress record, @Param("example") ProxyServerIpAddressExample example);

    int updateByExample(@Param("record") ProxyServerIpAddress record, @Param("example") ProxyServerIpAddressExample example);

    int updateByPrimaryKeySelective(ProxyServerIpAddress record);

    int updateByPrimaryKey(ProxyServerIpAddress record);
}