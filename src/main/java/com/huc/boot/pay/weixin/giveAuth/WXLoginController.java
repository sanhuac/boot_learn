package com.huc.boot.pay.weixin.giveAuth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.text.ParseException;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.alibaba.fastjson.JSONObject;


/**
 * @Auther: 胡丛
 * @Date: 2018/8/16 16:22
 * @Description:
 */
@Controller
@RequestMapping("/wx")
public class WXLoginController {


    private static final Logger logger = Logger.getLogger(WXLoginController.class);
    /**
     * 公众号微信登录授权
     * @param request
     * @param response
     * @return
     * @throws ParseException
     * @author  lbh
     * @date 创建时间：2018年1月18日 下午7:33:59
     * @parameter
     */
    @RequestMapping(value = "/wxLogin", method = RequestMethod.GET)
    public String wxLogin(HttpServletRequest request,
                          HttpServletResponse response)
            throws Exception {
        //这个url的域名必须要进行再公众号中进行注册验证，这个地址是成功后的回调地址
        String backUrl="http://cs.zhouzhoutech.com/weixin/callBack";
        // 第一步：用户同意授权，获取code
        String url ="https://open.weixin.qq.com/connect/oauth2/authorize?appid="+WXAuthUtil.APPID+
                "&redirect_uri="+URLEncoder.encode(backUrl,"UTF-8")+
                "&response_type=code"+
                "&scope=snsapi_userinfo"+
                "&state=123#wechat_redirect";

        logger.info("forward重定向地址{" + url + "}");
        logger.info("加密后的回调地址{" + URLEncoder.encode(backUrl,"UTF-8") + "}");
        //response.sendRedirect(url);
        return "redirect:"+url;//必须重定向，否则不能成功
    }
    /**
     * 公众号微信登录授权回调函数
     * @param modelMap
     * @param req
     * @param resp
     * @return
     * @throws ServletException
     * @throws IOException
     * @author  hc
     * @date 创建时间：2018年8月16日
     * @parameter
     */
    @RequestMapping(value = "/callBack", method = RequestMethod.GET)
    public String callBack(ModelMap modelMap,HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
         * start 获取微信用户基本信息
         */
        String code =req.getParameter("code");
        //第二步：通过code换取网页授权access_token
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="+WXAuthUtil.APPID
                + "&secret="+WXAuthUtil.APPSECRET
                + "&code="+code
                + "&grant_type=authorization_code";

        System.out.println("url:"+url);
        JSONObject jsonObject = WXAuthUtil.doGetJson(url);
        /*
         { "access_token":"ACCESS_TOKEN",
            "expires_in":7200,
            "refresh_token":"REFRESH_TOKEN",
            "openid":"OPENID",
            "scope":"SCOPE"
           }
         */
        String openid = jsonObject.getString("openid");
        String access_token = jsonObject.getString("access_token");
        String refresh_token = jsonObject.getString("refresh_token");
        //第五步验证access_token是否失效；展示都不需要
        String chickUrl="https://api.weixin.qq.com/sns/auth?access_token="+access_token+"&openid="+openid;
        JSONObject chickuserInfo = WXAuthUtil.doGetJson(chickUrl);
        System.out.println(chickuserInfo.toString());
        if(!"0".equals(chickuserInfo.getString("errcode"))){
            // 第三步：刷新access_token（如果需要）-----暂时没有使用,参考文档https://mp.weixin.qq.com/wiki，
            String refreshTokenUrl="https://api.weixin.qq.com/sns/oauth2/refresh_token?appid="+openid+"&grant_type=refresh_token&refresh_token="+refresh_token;

            JSONObject refreshInfo = WXAuthUtil.doGetJson(chickUrl);
            /*
             * { "access_token":"ACCESS_TOKEN",
                "expires_in":7200,
                "refresh_token":"REFRESH_TOKEN",
                "openid":"OPENID",
                "scope":"SCOPE" }
             */
            System.out.println(refreshInfo.toString());
            access_token=refreshInfo.getString("access_token");
        }

        // 第四步：拉取用户信息(需scope为 snsapi_userinfo)
        String infoUrl = "https://api.weixin.qq.com/sns/userinfo?access_token="+access_token
                + "&openid="+openid
                + "&lang=zh_CN";
        System.out.println("infoUrl:"+infoUrl);
        JSONObject userInfo = WXAuthUtil.doGetJson(infoUrl);
        /*
         {    "openid":" OPENID",
            " nickname": NICKNAME,
            "sex":"1",
            "province":"PROVINCE"
            "city":"CITY",
            "country":"COUNTRY",
            "headimgurl":    "http://wx.qlogo.cn/mmopen/g3MonUZtNHkdmzicIlibx6iaFqAc56vxLSUfpb6n5WKSYVY0ChQKkiaJSgQ1dZuTOgvLLrhJbERQQ4eMsv84eavHiaiceqxibJxCfHe/46",
            "privilege":[ "PRIVILEGE1" "PRIVILEGE2"     ],
            "unionid": "o6_bmasdasdsad6_2sgVt7hMZOPfL"
            }
         */
        System.out.println("JSON-----"+userInfo.toString());
        System.out.println("名字-----"+userInfo.getString("nickname"));
        System.out.println("头像-----"+userInfo.getString("headimgurl"));
        /*
         * end 获取微信用户基本信息
         */
        //获取到用户信息后就可以进行重定向，走自己的业务逻辑了。。。。。。
        //接来的逻辑就是你系统逻辑了，请自由发挥

        return "login";
    }
}
