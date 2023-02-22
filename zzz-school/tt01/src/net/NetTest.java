package net;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetTest {
	/*
	 * 
	
	 * 
	 */
	public static void main(String[] args) throws Exception {
		String url = "http://127.0.0.1:8080/mgmt/menuTree.do";
		String requestParams = "{\"areaName\": \"中国上海\", \"priority\": 1}";
		//
		StringBuffer sb;
		HttpURLConnection connection = null;
		DataOutputStream out = null;
		BufferedReader reader = null;
		try {
			URL urlPost = new URL(url);
			connection = (HttpURLConnection) urlPost.openConnection();// 创建一个连接
			/* 对连接进行配置 */
			connection.setDoOutput(true);// 允许写出
			connection.setDoInput(true);// 允许写入
			connection.setRequestMethod("POST");
			connection.setUseCaches(false);// 不使用缓存
			connection.setInstanceFollowRedirects(true);

			connection.setRequestProperty("content-type", "application/json");
			connection.setRequestProperty("charset", "UTF-8");
			connection.setRequestProperty("Accept-Charset", "utf-8");
			connection.connect();// 开启连接
			if (requestParams != null || !requestParams.isEmpty()) {
				out = new DataOutputStream(connection.getOutputStream());
				out.write((requestParams.getBytes()));
				out.flush();
			}
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));// 字节流转字符流

			sb = new StringBuffer();
			String lines;
			while ((lines = reader.readLine()) != null) {
				lines = new String(lines.getBytes(), "UTF-8");// 字符串转字节数组设置编码后转字符串
				sb.append(lines);// json类型字符串
			}
		} catch (Exception e) {
			throw new Exception("040003");
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			connection.disconnect();
		}
		System.out.println(sb.toString());
	}
}
