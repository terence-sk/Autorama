package sk.umb.progea.autorama.base.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;

import com.sun.enterprise.util.io.FileUtils;

public class BaseServiceImplIT {

	private static EJBContainer c;

	protected static void startContainer() throws IOException {
		Map<String, Object> properties = new HashMap<String, Object>();
		// nazov aplikacie
		properties.put(EJBContainer.APP_NAME, "Autorama");
		// potrebne moduly s ejb triedami; nakopiruj persistence.xml do DaoImpl projektu
		new File("../../Persistence/DaoImpl/target/classes/META-INF").mkdir();
		FileUtils.copyFile(new File("target/test-classes/META-INF/persistence.xml"), new File("../../Persistence/DaoImpl/target/classes/META-INF/persistence.xml"));
		File serviceClassesDir = new File("target/classes");
		File daoClassesDir = new File("../../Persistence/DaoImpl/target/classes");
		properties.put(EJBContainer.MODULES, new File[]{daoClassesDir, serviceClassesDir});
		// instalacia glassfish
		properties.put("org.glassfish.ejb.embedded.glassfish.installation.root", "./src/test/glassfish");
		// vytvor kontajner
		c = EJBContainer.createEJBContainer(properties);
	}

	protected static void stopContainer() {
		c.close();
	}

	protected <T> T lookupBy(Class<T> type) throws NamingException {
		return (T)c.getContext().lookup("java:global/Autorama/classesejb/" + type.getSimpleName());  
	}

}
