package com.mzczyh.weixin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.weixin4j.spring.web.WeixinJieruController;

@Controller
@RequestMapping("/weixin/jieru")
public class MyWeixinJieruController extends WeixinJieruController {

//    @RequestMapping("/yanzheng")
//    public void yanzhengFuwuqi(HttpServletRequest request, HttpServletResponse response){
//         //消息来源可靠性验证
//        String signature = request.getParameter("signature");// 微信加密签名
//        String timestamp = request.getParameter("timestamp");// 时间戳
//        String nonce = request.getParameter("nonce");       // 随机数
//        //Token为weixin4j.properties中配置的Token
////        String token = TokenUtil.get();
//        String token="weixinCourse";
//        //1.验证消息真实性
//        //http://mp.weixin.qq.com/wiki/index.php?title=验证消息真实性
//        //成为开发者验证
//        String echostr = request.getParameter("echostr");
//        //确认此次GET请求来自微信服务器，原样返回echostr参数内容，则接入生效，成为开发者成功，否则接入失败
//        if (TokenUtil.checkSignature(token, signature, timestamp, nonce)) {
//            try {
//                response.getWriter().write(echostr);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        }
//    }

}
