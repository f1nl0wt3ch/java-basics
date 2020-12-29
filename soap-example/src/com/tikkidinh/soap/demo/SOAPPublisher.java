package com.tikkidinh.soap.demo;

import javax.xml.ws.Endpoint;

public class SOAPPublisher {

	public static final String ENDPOINT_SERVICE = "http://localhost:8080/ws/users";
	public static void main(String[] args) {
		Endpoint.publish(ENDPOINT_SERVICE, new HelloSOAPServiceImpl());
	}

}
