package socket_TT;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.junit.Test;

public class tt1 {
	@Test
	public void tt_01() throws UnknownHostException {
		InetAddress ip = InetAddress.getLocalHost();
		/*
		 * 192.168.23.1 zcp-no zcp-no
		 */
		System.out.println(ip.getHostAddress());
		System.out.println(ip.getCanonicalHostName());
		System.out.println(ip.getHostName());

	}

	
}
