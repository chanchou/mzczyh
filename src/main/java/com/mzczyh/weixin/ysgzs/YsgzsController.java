package com.mzczyh.weixin.ysgzs;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.weixin4j.Weixin;
import org.weixin4j.WeixinException;
import org.weixin4j.model.js.Ticket;
import org.weixin4j.util.SHA1;
import org.weixin4j.util.SignUtil;
import org.weixin4j.util.TokenUtil;


import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
//@RequestMapping("/weixin")
public class YsgzsController {
    @Autowired
    private Weixin weixin;

    @GetMapping("/weixin/ysgzs")
    public String ysgzs(Model model) {
//
////                  appId: res.data.appId, // 必填，公众号的唯一标识
////                  timestamp: res.data.timestamp, // 必填，生成签名的时间戳
////                  nonceStr: res.data.nonceStr, // 必填，生成签名的随机串
////                  signature: res.data.signature,// 必填，签名，见附录1
//
//
//        //获取微信js-sdk开发ticket
//        //注意，jsapi_ticket，有效期7200秒，开发者必须在自己的服务全局缓存jsapi_ticket
//        //请自行保存到缓存
//        //本示例仅演示获取流程
//
//        Ticket jsApiTicket=null;
//        try {
//            //weixin.getToken().getAccess_token();
//            jsApiTicket  = weixin.getJsApiTicket();
//        } catch (WeixinException e) {
//            e.printStackTrace();
//        }
//        //获得jsapi_ticket之后，就可以生成JS-SDK权限验证的签名了。
//        //签名算法
//        //签名生成规则如下：
//        //参与签名的字段包括noncestr（随机字符串）,有效的jsapi_ticket, timestamp（时间戳）, url（当前网页的URL，不包含#及其后面部分）。
//        //对所有待签名参数按照字段名的ASCII 码从小到大排序（字典序）后，使用URL键值对的格式（即key1=value1&key2=value2…）拼接成字符串string1。
//        //这里需要注意的是所有参数名均为小写字符。
//        //对string1作sha1加密，字段名和字段值都采用原始值，不进行URL转义。
//        //对应我们weixin4j的开发，则已经把签名算法写好了
//        String nonceStr = UUID.randomUUID().toString().substring(0, 15);
//        String timestamp = System.currentTimeMillis() + "";
//        //注：本链接仅作为演示，实际链接请以自己业务链接为主
//        String url = "http://mzczyh.natapp1.cc/weixin";
//        String signature = SignUtil.getSignature(jsApiTicket.getTicket(), nonceStr, timestamp, url);
//
//        Map<String, String> map = new HashMap<String, String>();
//        map.put("data.appId", "wxbc30f6be5c24a3d0");
//        map.put("data.timestamp", timestamp);
//        map.put("data.nonceStr", nonceStr);
//        map.put("data.signature", signature);
//        model.addAttribute("res", map);
        return "/weixin/ysgzs/ysgzs.html";

    }

    @GetMapping("/weixin/ysgzs/fenxiang")
    @ResponseBody
    public Map<String,String> fenxiang(Model model) {
        //                  appId: res.data.appId, // 必填，公众号的唯一标识
//                  timestamp: res.data.timestamp, // 必填，生成签名的时间戳
//                  nonceStr: res.data.nonceStr, // 必填，生成签名的随机串
//                  signature: res.data.signature,// 必填，签名，见附录1


        //获取微信js-sdk开发ticket
        //注意，jsapi_ticket，有效期7200秒，开发者必须在自己的服务全局缓存jsapi_ticket
        //请自行保存到缓存
        //本示例仅演示获取流程
        Ticket jsApiTicket = null;
        try {
            System.out.println(weixin.getAppId());
            System.out.println(weixin.getSecret());
            System.out.println(weixin.getToken());
            System.out.println(weixin.getToken().getAccess_token());

            //weixin.getToken().getAccess_token();
            jsApiTicket = weixin.getJsApiTicket();
        } catch (WeixinException e) {
            e.printStackTrace();
        }
        //获得jsapi_ticket之后，就可以生成JS-SDK权限验证的签名了。
        //签名算法
        //签名生成规则如下：
        //参与签名的字段包括 noncestr（随机字符串）,有效的jsapi_ticket, timestamp（时间戳）, url（当前网页的URL，不包含#及其后面部分）。
        //对所有待签名参数按照字段名的ASCII 码从小到大排序（字典序）后，使用URL键值对的格式（即key1=value1&key2=value2…）拼接成字符串string1。
        //这里需要注意的是所有参数名均为小写字符。
        //对string1作sha1加密，字段名和字段值都采用原始值，不进行URL转义。
        //对应我们weixin4j的开发，则已经把签名算法写好了
        String noncestr = UUID.randomUUID().toString().substring(0, 15);
        String timestamp = System.currentTimeMillis()/1000 + "";
        //注：本链接仅作为演示，实际链接请以自己业务链接为主
        String url = "http://mzczyh.natapp1.cc/weixin/ysgzs";
        String signature = SignUtil.getSignature(jsApiTicket.getTicket(), noncestr, timestamp, url);

        Map<String, String> map = new HashMap<String, String>();
        map.put("data.appId", weixin.getAppId());
        map.put("data.timestamp", timestamp);
        map.put("data.noncestr", noncestr);
        map.put("data.signature", signature);
        model.addAttribute("res", map);
        System.out.println(jsApiTicket.getTicket());
        System.out.println(noncestr);
        System.out.println(timestamp);
        System.out.println(url);
        System.out.println(signature);
        return map;
    }
}

