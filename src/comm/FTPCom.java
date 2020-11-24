package comm;

import java.io.IOException;
import java.net.SocketException;

import org.apache.commons.net.ftp.*;

public class FTPCom {
	
	private FTPClient clienteFTP;
	
	public FTPCom() {
		clienteFTP = new FTPClient();
		try {
			clienteFTP.connect("192.168.1.14", 21);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public FTPClient getCliente() {
		return clienteFTP;
	}
	
	public boolean connect(String user, String password) {
		boolean result = false;
		try {
			result = clienteFTP.login(user, password);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

}
