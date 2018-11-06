package com.shh.controller.sys;

import com.shh.pojo.sys.Menu;
import com.shh.service.sys.MenuService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * @author :         wujun
 * @version :        1.0
 * @description :
 * @date :     2018/11/6 10:31
 */
@Controller
public class MenuController {
    @Autowired
    private MenuService menuService;
    private final Logger logger = LogManager.getLogger(MenuController.class);
    @RequestMapping("/findAllMenu")
    @ResponseBody
    public List<Menu> findAllMenu(){
        logger.info("哎呀我去了，哈哈哈哈");
        return menuService.findAllMenu();
    }
    @RequestMapping("/addMenu")
    @ResponseBody
    public int addMenu(Menu menu){
        menu.setCreatTime(new Date());
        menu.setCreatUser("admin");
        return menuService.addMenu(menu);
    }

    @RequestMapping("/updateMenu")
    @ResponseBody
    public int updateMenu(Menu menu){
        return menuService.updateMenu(menu);
    }

    @RequestMapping("/removeMenu")
    @ResponseBody
    public int removeMenu(Long id){
        return menuService.deletePById(id);
    }
    @RequestMapping("/findById")
    @ResponseBody
    public Menu findById(Long id){
        return menuService.findById(id);
    }

    @RequestMapping("/findByName")
    @ResponseBody
    public List<Menu> findByName(String name){
        return menuService.findByName(name);
    }
}