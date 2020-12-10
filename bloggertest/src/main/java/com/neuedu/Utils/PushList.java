package com.neuedu.Utils;

import java.util.ArrayList;
import java.util.List;
import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.impl.ListMessage;
import com.gexin.rp.sdk.base.impl.Target;
import com.gexin.rp.sdk.http.IGtPush;
import com.gexin.rp.sdk.template.NotificationTemplate;
import com.gexin.rp.sdk.template.style.Style0;
public class PushList {
    //采用"Java SDK 快速入门"， "第二步 获取访问凭证 "中获得的应用配置，用户可以自行替换
    private static String appId = "";
    private static String appKey = "";
    private static String masterSecret = "";

    static String CID1 = "";
    static String CID2 = "";
    //别名推送方式
    // static String Alias1 = "";
    // static String Alias2 = "";
    static String host = "http://sdk.open.api.igexin.com/apiex.htm";
    public static void startList(List<String> cidList) throws Exception {
        // 配置返回每个用户返回用户状态，可选
        System.setProperty("gexin_pushList_needDetails", "true");
    // 配置返回每个别名及其对应cid的用户状态，可选
    // System.setProperty("gexin_pushList_needAliasDetails", "true");
        IGtPush push = new IGtPush(host, appKey, masterSecret);
        // 通知透传模板
        NotificationTemplate template = notificationTemplateDemo();
        ListMessage message = new ListMessage();
        message.setData(template);
        // 设置消息离线，并设置离线时间
        message.setOffline(true);
        // 离线有效时间，单位为毫秒，可选
        message.setOfflineExpireTime(24 * 1000 * 3600);
        // 配置推送目标
        List targets = new ArrayList();
        for(String c:cidList) {
        	Target target1 = new Target();
        	 target1.setAppId(appId);
             target1.setClientId(c);
             targets.add(target1);
        }
//        Target target1 = new Target();
//        Target target2 = new Target();
//        target1.setAppId(appId);
//        target1.setClientId(CID1);
//   //     target1.setAlias(Alias1);
//        target2.setAppId(appId);
//        target2.setClientId(CID2);
//   //     target2.setAlias(Alias2);
//        targets.add(target1);
//        targets.add(target2);
        // taskId用于在推送时去查找对应的message
        String taskId = push.getContentId(message);
        IPushResult ret = push.pushMessageToList(taskId, targets);
        System.out.println(ret.getResponse().toString());
    }
    public static NotificationTemplate notificationTemplateDemo() {
        NotificationTemplate template = new NotificationTemplate();
        // 设置APPID与APPKEY
        template.setAppId(appId);
        template.setAppkey(appKey);

        Style0 style = new Style0();
        // 设置通知栏标题与内容
        style.setTitle("飞马测试");
        style.setText("您有一条新的考试！");
        // 配置通知栏图标
        style.setLogo("icon.png");
        // 配置通知栏网络图标
        style.setLogoUrl("");
        // 设置通知是否响铃，震动，或者可清除
        style.setRing(true);
        style.setVibrate(true);
        style.setClearable(true);
        template.setStyle(style);

        // 透传消息设置，1为强制启动应用，客户端接收到消息后就会立即启动应用；2为等待应用启动
        template.setTransmissionType(2);
        template.setTransmissionContent("请输入您要透传的内容");
        return template;
    }
}
