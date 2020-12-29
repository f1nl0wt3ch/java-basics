package com.tikkidinh.soap.demo;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
/*SOAPBinding : xác định web service này theo RPC style hoặc Document style.*/
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface HelloSOAPService {
	
	/*WebMethod : đánh dấu đây là các phương thức của web service.*/
	@WebMethod
	int insert(UserBean user);

	@WebMethod
	boolean update(UserBean user);

	@WebMethod
	boolean delete(String username);

	@WebMethod
	UserBean get(String username);

	@WebMethod
	UserBean[] getAll();
}
