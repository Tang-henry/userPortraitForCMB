/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014 abel533@gmail.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.isea533.mybatis.test;

import com.fid.mapper.common.DbConfigMapper;
import com.fid.model.common.DbConfig;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liuzh on 2015/3/7.
 */
public class PageMapperTest extends BasicTest {

    @Autowired
    private DbConfigMapper dbConfigMapper;

    @Autowired
    private SqlSession sqlSession;

    @Test
    public void testGet(){
    	DbConfig dbConfig = dbConfigMapper.selectByPrimaryKey(5);
    	System.out.println(dbConfig);
    }
    
    @Test
    public void getList(){
//    	  PageHelper.startPage(1,3);
//    	  Map<String, Object> params = new HashMap<String, Object>();
//    	  params.put("testid", 20);
//    	  List<DbConfig> test = countryMapper.getList(params);
//    	  PageInfo<DbConfig> pageInfo = new PageInfo<DbConfig>(test);
//    	  System.out.println(pageInfo.getTotal());
    }
    
    @Test
    public void test(){
        DbConfigMapper countryMapper = sqlSession.getMapper(DbConfigMapper.class);
        Example example = new Example(DbConfig.class);
        example.createCriteria().andGreaterThan("id",100);
        PageHelper.startPage(2,10);
        List<DbConfig> countries = countryMapper.selectByExample(example);
        PageInfo<DbConfig> pageInfo = new PageInfo<DbConfig>(countries);
        System.out.println(pageInfo.getTotal());

        countries = countryMapper.selectByExample(example);
        pageInfo = new PageInfo<DbConfig>(countries);
        System.out.println(pageInfo.getTotal());
    }
}
