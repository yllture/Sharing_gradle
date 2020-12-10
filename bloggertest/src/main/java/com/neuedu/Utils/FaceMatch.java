package com.neuedu.Utils;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.util.ResourceUtils;

import com.alibaba.fastjson.JSON;
import com.baidu.ai.aip.utils.GsonUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FaceMatch {
 
    /**
     * 重要提示代码中所需工具类
     * FileUtil,Base64Util,HttpUtil,GsonUtils请从
     * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
     * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
     * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
     * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3
     * 下载
     */
    public static String match(String ak, String sk, String imgPath1, String imgPath2) {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/match";
        try {
            // 【本地文件1地址】
            byte[] bytes1 = FileUtil.readFileByBytes(imgPath1);
            // 【本地文件2地址】
            byte[] bytes2 = FileUtil.readFileByBytes(imgPath2);
            String image1 = Base64Util.encode(bytes1);
            String image2 = Base64Util.encode(bytes2);
 
            List<Map<String, Object>> images = new ArrayList<>();
 
            Map<String, Object> map1 = new HashMap<>();
            map1.put("image", image1);
            map1.put("image_type", "BASE64");
            map1.put("face_type", "LIVE");
            map1.put("quality_control", "LOW");
            map1.put("liveness_control", "NORMAL");
 
            Map<String, Object> map2 = new HashMap<>();
            map2.put("image", image2);
            map2.put("image_type", "BASE64");
            map2.put("face_type", "LIVE");
            map2.put("quality_control", "LOW");
            map2.put("liveness_control", "NORMAL");
 
            images.add(map1);
            images.add(map2);
 
            String param = GsonUtils.toJson(images);
 
            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            // 【调用鉴权接口获取的token】
            String accessToken = AuthService.getAuth(ak, sk);
 
            String result = HttpUtil.post(url, accessToken, "application/json", param);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
 
    public static void main(String[] args) throws FileNotFoundException {
    	File f =  ResourceUtils.getFile("classpath:static");
		String rootPath=f.getPath();
		String filePath = rootPath+"\\upload" +File.separator+ "test"+File.separator;
       
        String ak = "t6q6SPyKU6Ae6gwxgFEmqTeB";
        String sk = "VaYrOhwKTwzaiSYlZVuUGwCNbIdfjIIQ";
        String imgPath1 = filePath + "0.jpg";
        String imgPath2 = filePath + "2.jpg";
        String result = FaceMatch.match(ak, sk, imgPath1, imgPath2);
        System.out.println("对比结果为：" + result);
        com.alibaba.fastjson.JSONObject parseObject = JSON.parseObject(result);
        try {
        	if(parseObject.get("result")!=null) {
            String score = (new JSONObject(result).getJSONObject("result").get("score")).toString();
            System.out.println("相似得分为：" + score);
            String judge = "不是同一人";
            // 阈值为80，高于80分判断为同一人s
            if( Double.parseDouble(score) >= 80){
                judge = "同一人";
            }
 
            System.out.println("判断为：" + judge);
        	}
        	else{
        		  System.out.println("判断为：" + "不是同一人");
        	}
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
