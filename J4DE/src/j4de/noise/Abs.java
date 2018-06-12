//**************************************************************************************************
package j4de.noise;
//**************************************************************************************************

//**************************************************************************************************
public class Abs extends Module {

	//==============================================================================================
	private Module input;
	//==============================================================================================
	
	//==============================================================================================
	public Module getInput() {
		return this.input;
	}
	//==============================================================================================
	
	//==============================================================================================
	public void setInput(Module input) {
		this.input = input;
	}
	//==============================================================================================
	
	//==============================================================================================
	protected double getCalculatedValue(double x, double y, double z) {
		double inputValue = this.input.getValue(x, y, z);
		return Math.abs(inputValue);
	}
	//==============================================================================================
	
}
//**************************************************************************************************