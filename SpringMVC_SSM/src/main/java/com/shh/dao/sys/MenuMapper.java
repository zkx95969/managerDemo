package com.shh.dao.sys;

import com.shh.pojo.common.Clause;
import com.shh.pojo.sys.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MenuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Menu menu);

    int insertSelective(Menu menu);

    List<Menu> selectByExample(Clause clause);

    Menu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Menu menu);

    int updateByPrimaryKey(Menu menu);
}