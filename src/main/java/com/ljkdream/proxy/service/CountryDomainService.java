package com.ljkdream.proxy.service;

import com.ljkdream.proxy.dao.CountryDomainMapper;
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
