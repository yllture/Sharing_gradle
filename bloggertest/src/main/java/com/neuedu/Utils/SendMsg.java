package com.neuedu.Utils;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONObject;
import com.zhenzi.sms.ZhenziSmsClient;

public class SendMsg {
	public static Boolean sendSms(HttpServletRequest request, String number) {
        try {
            JSONObject json = null;
            //生成6位验证码
            String verifyCode = String.valueOf(new Random().nextInt(899999) + 100000);
            System.out.println(verifyCode);
            System.out.println(number);
            //发送短信
            ZhenziSmsClient client = new ZhenziSmsClient("https://sms_developer.zhenzikj.com","101833","9b8408eb-4b40-4022-a52f-7c6a84370c7c\r\n");
            String result = client.send(number, "飞马测试平台："+number+"您的验证码为:" + verifyCode + "，该码有效期为5分钟，只能使用一次");
            json = JSONObject.parseObject(result);
            System.out.println(json.getString("data"));
            if(json.getIntValue("code") != 0)//发送短信失败
                return false;
            //将验证码存到session中,同时存入创建时间
            //以json存放，这里使用的是阿里的fastjson
            HttpSession session = request.getSession();
            json = new JSONObject();
            json.put("verifyCode", verifyCode);
            json.put("createTime", System.currentTimeMillis());
            //将认证码存入SESSION
            request.getSession().setAttribute("verifyCode", json);
            //验证码有效时间为5分钟
            //request.getSession().setMaxInactiveInterval(60*5);
            return true;//0000为请求成功码
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
