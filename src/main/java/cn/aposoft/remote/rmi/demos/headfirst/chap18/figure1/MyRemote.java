/**
 * 
 */
package cn.aposoft.remote.rmi.demos.headfirst.chap18.figure1;

import java.rmi.*;

public interface MyRemote extends Remote {
	public String sayHello() throws RemoteException;
}