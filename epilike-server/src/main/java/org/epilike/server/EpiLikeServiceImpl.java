package org.epilike.server;

import java.util.HashMap;
import java.util.Map;

import org.apache.thrift.TException;

import eu.epitech.epilike.thrift.EpiLikeService;
import eu.epitech.epilike.thrift.LoginForm;

public class EpiLikeServiceImpl implements EpiLikeService.Iface {

	@Override
	public boolean login(LoginForm form) throws TException {
		Map<String, String> users = new HashMap<String, String>();
		users.put("toto", "pass");
		users.put("titi", "tata");

		return users.containsKey(form.getLogin()) && users.get(form.getLogin()).equals(form.getPassword());
	}
}
