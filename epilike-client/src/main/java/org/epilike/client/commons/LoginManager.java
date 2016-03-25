package org.epilike.client.commons;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.THttpClient;
import org.apache.thrift.transport.TTransport;

import eu.epitech.epilike.thrift.EpiLikeService;
import eu.epitech.epilike.thrift.LoginForm;

public class LoginManager {

	public static void main(String[] args) {
		System.out.println(new LoginManager().login("toto", "pass"));
		System.out.println(new LoginManager().login("toto", "tata"));
		System.out.println(new LoginManager().login("titi", "tata"));
	}

	public boolean login(String user, String pass) {
		boolean result = false;
		try {
			TTransport transport = new THttpClient("http://localhost:8080/epilike/");

			TProtocol protocol = new TBinaryProtocol.Factory().getProtocol(transport);

			EpiLikeService.Client client = new EpiLikeService.Client(protocol);

			result = client.login(new LoginForm(user, pass));

			transport.close();
		} catch (TException x) {
			x.printStackTrace();
		}
		return result;
	}

}
