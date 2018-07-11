//*************************************************************************************************
package j4de.proto;
//*************************************************************************************************

//*************************************************************************************************
public class PClient extends Thread {

	//==============================================================================================
	private boolean terminated = false;
	//==============================================================================================
	
	//==============================================================================================
	public PClient() {
		super();
	}
	//==============================================================================================

	//==============================================================================================
	public void begin() {
		super.start();
	}
	//==============================================================================================

	//==============================================================================================
	public void end() {
		this.terminated = true;
	}
	//==============================================================================================
	
	//==============================================================================================
	private void init() {
		System.out.println("CLIENT: INIT");
	}
	//==============================================================================================

	//==============================================================================================
	private void step() {
		System.out.println("CLIENT: STEP");
	}
	//==============================================================================================
	
	//==============================================================================================
	private void done() {
		System.out.println("CLIENT: DONE");
	}
	//==============================================================================================
	
	//==============================================================================================
	public void run() {
		init();
		while (!terminated) {
			step();
		}
		done();
	}
	//==============================================================================================
	
}
//*************************************************************************************************
