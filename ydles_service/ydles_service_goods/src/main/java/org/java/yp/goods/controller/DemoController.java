package org.java.yp.goods.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 杨鹏
 * @version 1.0
 * Create by 2022/9/2 17:39
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @GetMapping("/test")
    public String test(){
        return "success";
    }
}
