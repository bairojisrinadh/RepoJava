package com.zurich.ch.server.model;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author pdixit
 *
 */

public abstract class AbstractModel implements Model{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  Integer id ;
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id=id;
	}

	public void applyUpdate(Object obj) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException{
		Method [] m =obj.getClass().getDeclaredMethods();
		Method m1;
		Object [] obj1=new Object[1];
		Object [] obj2= new Object[0];
		for(int i= 0;i<m.length;i++){
			if("set".equals( m[i].getName().substring(0,3))){
				m1 = this.getClass().getMethod("get"+m[i].getName().substring(3),null);
				obj1 [0]=m1.invoke(obj,obj2);
				m[i].invoke(this,obj1 );
			}
		}
	
	}
}
