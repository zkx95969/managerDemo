package com.shh.service.sys;


import com.shh.pojo.sys.Menu;

import java.util.List;

/**
 * @author :         wujun
 * @version :        1.0
 * @description :
 * @date :     2018/11/6 10:24
 */
public interface MenuService {
    int addMenu(Menu menu);

    int deletePById(long id);

    int updateMenu(Menu menu);

    Menu findById(long id);

    List<Menu> findAllMenu();

    List<Menu> findByName(String name);
}