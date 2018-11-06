package com.shh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author :         wujun
 * @version :        1.0
 * @description :
 * @date :     2018/11/6 11:06
 */
@Controller
public class PageTurnController {

    @RequestMapping("/")
    public String toIndex(){
        return "sys/demo";
    }
}