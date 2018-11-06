package com.shh.service.sys.impl;

import com.shh.dao.sys.MenuMapper;
import com.shh.pojo.common.Clause;
import com.shh.pojo.common.Page;
import com.shh.pojo.sys.Menu;
import com.shh.service.sys.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author :         wujun
 * @version :        1.0
 * @description :
 * @date :     2018/11/6 10:26
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;
    @Override
    public int addMenu(Menu menu) {
        return menuMapper.insert(menu);
    }

    @Override
    public int deletePById(long id) {
        return menuMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateMenu(Menu menu) {
        return menuMapper.updateByPrimaryKeySelective(menu);
    }

    @Override
    public Menu findById(long id) {
        return menuMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Menu> findAllMenu() {
        Clause clause = new Clause();
        return menuMapper.selectByExample(clause);
    }

    @Override
    public List<Menu> findByName(String name) {
        Clause clause = new Clause();
        clause.andWhereClause("sys_menu.name=",name);
        return menuMapper.selectByExample(clause);
    }
}