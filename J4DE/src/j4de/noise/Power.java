//**************************************************************************************************
package j4de.noise;
//**************************************************************************************************

//**************************************************************************************************
public class Power extends Module {

	//==============================================================================================
	private Module inputA;
	private Module inputB;
	//==============================================================================================
	
	//==============================================================================================
	public Module getInputA() {
		return this.inputA;
	}
	//==============================================================================================
	
	//==============================================================================================
	public void setInputA(Module input) {
		this.inputA = input;
	}
	//==============================================================================================

	//==============================================================================================
	public Module getInputB() {
		return this.inputB;
	}
	//==============================================================================================
	
	//==============================================================================================
	public void setInputB(Module input) {
		this.inputB = input;
	}
	//==============================================================================================
	
	//==============================================================================================
	protected double getCalculatedValue(double x, double y, double z) {
		double inputValueA = this.inputA.getValue(x, y, z);
		double inputValueB = this.inputB.getValue(x, y, z);
		return Math.pow(inputValueA, inputValueB);
	}
	//==============================================================================================
	
}
//**************************************************************************************************
