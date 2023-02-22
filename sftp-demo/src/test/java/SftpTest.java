import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Vector;

import org.junit.Test;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.ChannelSftp.LsEntry;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;

import one.zpq.SftpPropery;
import one.zpq.SftpUtils;

public class SftpTest {

	/**
	 * 
	 * @Description TODO 测试展示文件目录
	 * @throws Exception
	 * @author zhangchaopei
	 * @throws SftpException
	 * @date 2020年5月17日
	 */

	public void printRemotePath(String path, ChannelSftp channelSftp) throws SftpException {
		Vector ls = channelSftp.ls(path);
		channelSftp.cd(path);
		System.out.println("当前路径：" + channelSftp.pwd());
		for (int i = 0; i < ls.size(); i++) {
			LsEntry entry = (LsEntry) ls.get(i);
			System.out.println(entry.getClass() + " " + entry);
		}
	}

	@Test
	public void testLs() {
		try {
			ChannelSftp channel = getLocalChannel();
			System.out.println(channel.pwd());
			printRemotePath("./", channel);
			//
			printRemotePath("/home/zpq5935/2", channel);
			//
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * @Description TODO 测试下载文件
	 * @throws Exception
	 * @author zhangchaopei
	 * @date 2020年5月17日
	 */
	@Test
	public void testGet() throws Exception {
		ChannelSftp channel = getLocalChannel();
		byte[] data = new byte[1024];
		int length = 0;
		InputStream inputStream = channel.get("测试文件上传.txt");

		while ((length = inputStream.read(data)) > 0) {
			System.out.println(length);
			for (byte b : data) {
				System.out.print(b + " ");
			}
			System.out.println(new String(data, 0, length, StandardCharsets.UTF_8));
		}
	}

	/**
	 * 
	 * @Description TODO 测试上传文件
	 * @throws Exception
	 * @author zhangchaopei
	 * @date 2020年5月17日
	 */
	@Test
	public void testPut() throws Exception {
		ChannelSftp channel = getLocalChannel();
		String dsString = "/home/zpq5935/2/";
		dsString+="pom3.text";
		upload(channel, "./pom.xml", dsString);
	}

	public boolean upload(ChannelSftp channel, String src, String dst) throws FileNotFoundException, SftpException {
		try {
			InputStream inputStream = new FileInputStream(src);
			channel.put(inputStream, dst);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Test
	public void testMakeDir() {
		try {
			ChannelSftp channel = getLocalChannel();
			channel.mkdir("/home/zpq5935/2");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	/**
	 * 
	 * @Description TODO 获取ChannelSftp
	 * @return
	 * @throws JSchException
	 * @author zhangchaopei
	 * @date 2020年5月17日
	 */
	public ChannelSftp getLocalChannel() throws JSchException {
		SftpUtils sftpUtils = new SftpUtils();
		SftpPropery propery = new SftpPropery();
		propery.setHost("192.168.231.128");
		propery.setUserName("zpq5935");
		propery.setPassword("123");
		ChannelSftp channel = sftpUtils.getChannel(propery, 1000 * 60);
		return channel;
	}
}
