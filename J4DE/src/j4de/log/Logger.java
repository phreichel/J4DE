//*************************************************************************************************
package j4de.log;
//*************************************************************************************************


//*************************************************************************************************
public class Logger {

	//==============================================================================================
	private int indent = 0;
	//==============================================================================================
	
	//==============================================================================================
	public void enter() {
		try {
			throw new LogException();
		} catch (LogException e) {
			StackTraceElement[] stackTraceArray = e.getStackTrace();
			int stackTraceIndex = 1;
			StackTraceElement element = stackTraceArray[stackTraceIndex];
			for (int i=0; i<indent; i++) {
				System.out.print("\t");
			}
			System.out.println(element.getClassName() + "->" + element.getMethodName() + " - " + element.getFileName() + ":" + element.getLineNumber() + " {");
			indent++;
		}
	}
	//==============================================================================================

	//==============================================================================================
	public void exit() {
		try {
			throw new LogException();
		} catch (LogException e) {
			indent--;
			StackTraceElement[] stackTraceArray = e.getStackTrace();
			int stackTraceIndex = 1;
			StackTraceElement element = stackTraceArray[stackTraceIndex];
			for (int i=0; i<indent; i++) {
				System.out.print("\t");
			}
			System.out.println("} " + element.getClassName() + "->" + element.getMethodName());
		}
	}
	//==============================================================================================

	//==============================================================================================
	public static void main(String[] args) {
		Logger logger = new Logger();
		logger.enter();
		logger.klammer(2);
		logger.exit();
	}
	//==============================================================================================

	//==============================================================================================
	public void klammer(int i) {
		enter();
		if (i > 0) {
			klammer(i-1);
		}
		exit();
	}
	//==============================================================================================
	
}
//*************************************************************************************************
