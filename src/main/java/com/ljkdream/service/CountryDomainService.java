package com.ljkdream.service;

import com.ljkdream.dao.CountryDomainMapper;
import com.ljkdream.model.CountryDomain;
import com.ljkdream.util.RegexUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 国际域名Service
 * Created by ljk on 16-1-9.
 */
@Service
public class CountryDomainService {

    @Autowired
    private CountryDomainMapper countryDomainMapper;



}
