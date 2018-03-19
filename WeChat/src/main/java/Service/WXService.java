package Service;
import java.util.Arrays;

import util.Sha1Util;

public class WXService {
	private static final String token = "hello";
	/**
	 * sha1加密
	 * 首字母进行排序
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @return
	 */
	public  boolean cheak(String signature,String timestamp,String nonce){
			
		String[] us = new String[]{token,timestamp,nonce}; 
		//按首字母排序
		Arrays.sort(us);
		
		StringBuffer content = new StringBuffer();
		for(int i = 0;i < us.length;i++){
			content.append(us[i]);
		}
		//sha1加密处理
		String temp = Sha1Util.getSha1(content.toString());
		return temp.equals(signature);
	}
}
