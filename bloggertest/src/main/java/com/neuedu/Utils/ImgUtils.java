package com.neuedu.Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.UUID;

import org.springframework.util.ResourceUtils;

import sun.misc.BASE64Decoder;

public class ImgUtils {
	/**
	 * 保存图片，根据图片的类型存储图片路径
	 * 
	 * @param imageBase
	 * @param imageType
	 * @return 返回上传图片的路径
	 * @throws FileNotFoundException 
	 */
	public static String saveImage(String imageBase, String imageType) throws FileNotFoundException {
		String data = "";
		try {
			data = URLDecoder.decode(imageBase, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		if (data == null || data.contentEquals("")) {
			return "";
		}
		File f =  ResourceUtils.getFile("classpath:static");
		
		String rootPath=f.getPath();


		// 解决文件重名问题
		UUID randomUUID = UUID.randomUUID();
		String newFileName = randomUUID + ".jpg";
	
		
		String filePath = rootPath+"\\upload" +File.separator+ imageType;
		System.out.println(filePath);
		makeSureDirExists(filePath);
		String path = filePath+File.separator+newFileName;
		generateImageFromBase64(data, path);
		return "upload" +File.separator+ imageType+File.separator+newFileName;
	}

	/**
	 * sure确定是否文件存在
	 * 
	 * @param dirPath
	 * @return
	 */
	public static File makeSureDirExists(String dirPath) {
		File dir = new File(dirPath);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		return dir;
	}

	/**
	 * get生成图片文件
	 * 
	 * @param imgStr
	 * @param path
	 * @return
	 */
	private static boolean generateImageFromBase64(String imgStr, String path) {
		// 对字节数组字符串进行Base64解码并生成图片
		if (imgStr == null) // 图像数据为空
			return false;
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			// Base64解码
			byte[] b = decoder.decodeBuffer(imgStr);
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {// 调整异常数据
					b[i] += 256;
				}
			}
			// 生成jpeg图片
			// String imgFilePath = "d://222.jpg";//新生成的图片
			OutputStream out = new FileOutputStream(path);
			out.write(b);
			out.flush();
			out.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
