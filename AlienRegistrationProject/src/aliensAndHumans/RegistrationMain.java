package aliensAndHumans;

import java.io.File;
import java.net.MalformedURLException;
import applicationFlow.FlowClass;
import net.xeoh.plugins.base.PluginManager;
import net.xeoh.plugins.base.impl.PluginManagerFactory;


/**
 * Main Class - created to start the application and plugin. It has method call for starting application flow.
 * @author Atulya Rastogi
 *
 */
public class RegistrationMain {

	
	
	/**
	 * @param args
	 * @throws MalformedURLException 
	 */
	public static void main(String[] args) throws MalformedURLException {

		System.out.println();
		
		//Plugin is started using this code. It uses PluginManager to manage its Life-cycle
		PluginManager pm = PluginManagerFactory.createPluginManager();
		pm.addPluginsFrom(new File("plugins/").toURI().toURL());
		System.out.println();

		//method call to start the application flow
		FlowClass.mainFlow();
	}
}
