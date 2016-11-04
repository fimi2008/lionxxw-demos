package com.lionxxw.ffmpeg.ffmpeg;

import java.io.IOException;


public class Test {
	public static void executer(String[] args) {
		// 视频文件
		String videoRealPath = "F://Wildlife.wmv";
		// 截图的路径（输出路径）
		String imageRealPath = "F://test.jpg";
		try {
			// 调用批处理文件
			Runtime.getRuntime().exec(
					"cmd /c start F://createPic.bat " + videoRealPath + " "+ 20 +" " + imageRealPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		FFmpegUtil ffmpeg = new FFmpegUtil("F://Wildlife.wmv");
		
		long time = ffmpeg.getRuntime();
		System.out.println("视频时长:" + time);
		
		ffmpeg.makeScreenCut("F://200180.jpg", 200, 180);
	}
}