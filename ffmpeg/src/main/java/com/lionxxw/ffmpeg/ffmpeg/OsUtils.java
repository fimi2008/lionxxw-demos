package com.lionxxw.ffmpeg.ffmpeg;

/**		
 * <p>Title: OsUtils </p>
 * <p>Description: 类描述:java运行系统判断</p>
 * <p>Copyright (c) 2015 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author xiang_wang	
 * @date 2015年12月2日下午4:24:35
 * @version 1.0
 * <p>修改人：</p>
 * <p>修改时间：</p>
 * <p>修改备注：</p>
 */
public class OsUtils {
	public OsUtils(){
		
	}
	
	public static boolean isWindowsOS(){
		boolean isWindowsOS = false;
		String osName = System.getProperty("os.name");
		if(osName.toLowerCase().indexOf("windows")>-1){
			isWindowsOS = true;
		}
		return isWindowsOS;
	}
}