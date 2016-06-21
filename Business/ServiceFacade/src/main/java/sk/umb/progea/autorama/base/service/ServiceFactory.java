package sk.umb.progea.autorama.base.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;

public class ServiceFactory {

	private static Map<String, Object> cachedMocks = new HashMap<String, Object>();

	public static <T> T getService(Class<T> serviceClass, T serviceObj) {
		if (serviceObj!=null) {
			return serviceObj;
		}
		String sname = serviceClass.getName();
		if (cachedMocks.get(sname)!=null) {
			return (T)cachedMocks.get(sname);
		}
		try {
			Class<T> c = (Class<T>)Class.forName(sname.substring(0, sname.lastIndexOf('.')) + ".impl"
				+ sname.substring(sname.lastIndexOf('.')) + "Mock");
			T ret = c.newInstance();
			cachedMocks.put(sname, ret);
			return ret;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
