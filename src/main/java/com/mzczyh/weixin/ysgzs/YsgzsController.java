package com.mzczyh.weixin.ysgzs;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/weixin")
public class YsgzsController {
    @GetMapping("/ysgzs")
//    @ResponseBody
    public String ysgzs(){
        return "/weixin/ysgzs/ysgzs.html";
       // return "ysgzs";
    }

}
