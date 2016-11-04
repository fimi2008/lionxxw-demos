package com.lionxxw.ffmpeg.ffmpeg;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;


/**		
 * <p>Title: FFmpegUtil </p>
 * <p>Description: 类描述:封装ffmpeg基本操作</p>
 * <p>Copyright (c) 2015 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author xiang_wang	
 * @date 2015年12月2日下午1:51:36
 * @version 1.0
 * <p>修改人：</p>
 * <p>修改时间：</p>
 * <p>修改备注：</p>
 */
public class FFmpegUtil implements IStringGetter {
	protected Logger logger = Logger.getLogger(FFmpegUtil.class);
	
	public final static String WIN_FFMPEG_URI = "E:/ffmpeg/bin/ffmpeg.exe"; // window下的FFmpeg路径
	public final static String LINUX_FFMPEG_URI = "/usr/local/bin/ffmpeg";	// linux下的FFmpeg路径
	
	private long runtime = 0;
	private String ffmpegUri;		// ffmpeg地址
	private String originFileUri; 	// 视频源文件地址
	private boolean isSupported;
	private final static int DEFAULT_WEIGHT = 160;		// 默认视频的宽(像素)
	private final static int DEFAULT_HEIGHT = 120;		// 默认视频的高(像素)
	private final static int DEFAULT_SECONDS = 2;		// 默认截图第2秒后的帧动画
	private List<String> cmd = new ArrayList<String>();

	private enum FFMpegUtilStatus {
		Empty, CheckingFile, GettingRuntime
	};

	private FFMpegUtilStatus status = FFMpegUtilStatus.Empty;

	public FFmpegUtil(String originFileUri) {
		if(OsUtils.isWindowsOS()){
			this.ffmpegUri = WIN_FFMPEG_URI;
		}else{
			this.ffmpegUri = LINUX_FFMPEG_URI;
		}
		this.originFileUri = originFileUri;
	}

	
	/**
	 * 构造函数
	 * 
	 * @param ffmpegUri  ffmpeg的全路径 如e:/ffmpeg/ffmpeg.exe 或 /usr/local/bin/ffmpeg
	 * @param originFileUri 所操作视频文件的全路径 如e:/upload/temp/test.wmv
	 */
	public FFmpegUtil(String ffmpegUri, String originFileUri) {
		this.ffmpegUri = ffmpegUri;
		this.originFileUri = originFileUri;
	}

	/**
	 * 获取视频时长
	 * @return
	 * @author xiang_wang
	 * 2015年12月2日下午2:00:39
	 */
	public long getRuntime() {
		runtime = 0;
		status = FFMpegUtilStatus.GettingRuntime;
		logger.info("getRuntime()==============>status:" + status);
		cmd.clear();
		cmd.add(ffmpegUri);
		cmd.add("-i");
		cmd.add(originFileUri);
		try {
			CmdExecuter.exec(cmd, this);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return runtime;
	}

	/**
	 * 检测文件是否是支持的格式 将检测视频文件本身，而不是扩展名
	 * @return
	 * @author xiang_wang
	 * 2015年12月2日下午2:01:34
	 */
	public boolean isSupported() {
		isSupported = false;
		status = FFMpegUtilStatus.CheckingFile;
		cmd.clear();
		cmd.add(ffmpegUri);
		cmd.add("-i");
		cmd.add(originFileUri);
		cmd.add("Duration: (.*?), start: (.*?), bitrate: (\\d*) kb\\/s");
		try {
			CmdExecuter.exec(cmd, this);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSupported;
	}

	/**
	 * 生成视频截图
	 * @param imageSavePath 截图文件保存全路径
	 * @param seconds 		截取视频第几秒后的视频区间[0,视频时长]
	 * @param screenWeight  截图大小宽(像素)
	 * @param screenHeight  截图大小高(像素)
	 * @author xiang_wang
	 * 2015年12月2日下午2:08:38
	 */
	public boolean makeScreenCut(String imageSavePath, Integer seconds, Integer screenWeight, Integer screenHeight) {
		if (null == seconds || seconds.intValue() < 0 || seconds.intValue() > getRuntime()){
			seconds = DEFAULT_SECONDS;
		}
		cmd.clear();
		cmd.add(ffmpegUri);
		cmd.add("-i");
		cmd.add(originFileUri);
		cmd.add("-y");
		cmd.add("-f");
		cmd.add("image2");
		cmd.add("-ss");
		cmd.add(String.valueOf(seconds));
		cmd.add("-t");
		cmd.add("0.001");
		cmd.add("-s");
		if (null == screenWeight || screenWeight.intValue() <= 0){
			screenWeight = DEFAULT_WEIGHT;
		}
		if (null == screenHeight || screenHeight.intValue() <= 0){
			screenHeight = DEFAULT_HEIGHT;
		}
		cmd.add(screenWeight +"*" + screenHeight);
		cmd.add(imageSavePath);
		try {
			CmdExecuter.exec(cmd, this);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	/**
	 * 生成视频截图
	 * @param imageSavePath
	 * @author xiang_wang
	 * 2015年12月2日下午2:09:14
	 */
	public boolean makeScreenCut(String imageSavePath) {
		return makeScreenCut(imageSavePath, DEFAULT_SECONDS, DEFAULT_WEIGHT, DEFAULT_HEIGHT);
	}
	
	/**
	 * 生成视频截图
	 * @param imageSavePath 截图文件保存全路径
	 * @param seconds 		截取视频第几秒后的视频区间[0,视频时长]
	 * @return
	 * @author xiang_wang
	 * 2015年12月2日下午2:27:24
	 */
	public boolean makeScreenCut(String imageSavePath, Integer seconds) {
		return makeScreenCut(imageSavePath, seconds, DEFAULT_WEIGHT, DEFAULT_HEIGHT);
	}
	
	/**
	 * 生成视频截图
	 * @param imageSavePath 截图文件保存全路径
	 * @param screenWeight  截图大小宽(像素)
	 * @param screenHeight  截图大小高(像素)
	 * @return
	 * @author xiang_wang
	 * 2015年12月2日下午2:28:26
	 */
	public boolean makeScreenCut(String imageSavePath, Integer screenWeight, Integer screenHeight) {
		return makeScreenCut(imageSavePath, DEFAULT_SECONDS, screenWeight, screenHeight);
	}

	/* 
	 * 处理字符串
	 */
	public void dealString(String str) {
		logger.info("dealString=========>" + str);

		switch (status) {
			case Empty:
				break;
			case CheckingFile: {
				if (-1 != str.indexOf("Metadata:"))
					this.isSupported = true;
				break;
			}
			case GettingRuntime: {
				String strs="";
				
				if(str.contains("Duration")){
					System.out.println(str.substring(str.indexOf(":")+1,str.indexOf(",")));
					strs=str.substring(str.indexOf(":")+1,str.indexOf(","));
					if(strs!=null){
						runtime = getRuntime(strs);
					}
				}
				break;
			}
		}
	}
	
	/**
	 * 获取视频时长
	 * @param str
	 * @return
	 * @author xiang_wang
	 * 2015年12月2日下午1:51:05
	 */
	private long getRuntime(String str){
		long t=Integer.parseInt(str.substring(1,3))*60*60+Integer.parseInt(str.substring(4,6))*60+Integer.parseInt(str.substring(7,9));
		return t;
	}
}