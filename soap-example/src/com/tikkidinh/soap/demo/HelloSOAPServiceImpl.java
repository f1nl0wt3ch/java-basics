package com.tikkidinh.soap.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.jws.WebService;

/*
 * java.util.List is an interface, and JAXB can't handle interfaces.
 * WebService : đánh dấu class này như một Web service. 
 * Đối số endpointInterface xác định đây là một implementation của một WS Interface cụ thể.
 */
@WebService(endpointInterface = "com.tikkidinh.soap.demo.SOAPService")
public class HelloSOAPServiceImpl implements HelloSOAPService {

	Map<Integer, UserBean> USERS = new HashMap<Integer, UserBean>();

	private int generateUniqueId() {
		return USERS.keySet().stream().max((x1, x2) -> x1 - x2).orElse(0) + 1;
	}

	@Override
	public int insert(UserBean user) {
		Integer id = generateUniqueId();
		USERS.put(id, user);
		return id;
	}

	@Override
	public boolean update(UserBean user) {
		USERS.put(USERS.size() + 1, user);
		return true;
	}

	@Override
	public boolean delete(String username) {
		return true;
	}

	@Override
	public UserBean get(String username) {
		for (Entry<Integer, UserBean> user : USERS.entrySet()) {
			if (user.getValue().getUsername().equalsIgnoreCase(username))
				return user.getValue();
		}
		return null;
	}

	@Override
	public UserBean[] getAll() {
		UserBean[] result = null;
		for (Entry<Integer, UserBean> user : USERS.entrySet()) {
			result[user.getKey()] = user.getValue();
		}
		return result;
	}

}
