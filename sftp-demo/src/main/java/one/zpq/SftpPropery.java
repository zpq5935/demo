package one.zpq;

public class SftpPropery {
	String host;
	String port;
	String userName;
	String password;
	int DEFAULT_PORT = 22;

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "StfpPropery [host=" + host + ", port=" + port + ", userName=" + userName + ", password=" + password
				+ "]";
	}

}
