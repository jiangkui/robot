package com.ljkdream.dao;

import com.ljkdream.model.CountryDomain;
import com.ljkdream.model.CountryDomainExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryDomainMapper {
    int countByExample(CountryDomainExample example);

    int deleteByExample(CountryDomainExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CountryDomain record);

    int insertSelective(CountryDomain record);

    List<CountryDomain> selectByExample(CountryDomainExample example);

    CountryDomain selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CountryDomain record, @Param("example") CountryDomainExample example);

    int updateByExample(@Param("record") CountryDomain record, @Param("example") CountryDomainExample example);

    int updateByPrimaryKeySelective(CountryDomain record);

    int updateByPrimaryKey(CountryDomain record);
}