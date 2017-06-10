package com.sri.completeCoreJava;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class DNStoIPAddress {

	public static void main(String[] args) {
		InetAddress address = null;
		InetAddress ip = null;
		try{
			address = InetAddress.getByName("in.portal.csc.com");
			ip = InetAddress.getByName("20.198.218.32");
		}catch(UnknownHostException ae){
			System.out.println(ae);
			//System.exit(2);
		}
		System.out.println(address.getHostName()+" --> "+ address.getHostAddress() );
		System.out.println(ip.getHostAddress()+" --> "+ ip.getHostName() );
		//System.exit(0);
	}

}
