package tooltwist.factories;

import cucumber.runtime.java.picocontainer.PicoFactory;
import tooltwist.utils.TestInit;

public class CustomPicoFactory extends PicoFactory {
	public CustomPicoFactory() {
		addClass(TestInit.class);
	}
}
