//**************************************************************************************************
package j4de.noise;
//**************************************************************************************************

//**************************************************************************************************
public class ScaleBias extends Module {

	//==============================================================================================
	private Module input;
	private double bias  = 0.0;
	private double scale = 1.0;
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
	public double getBias() {
		return this.bias;
	}
	//==============================================================================================
	
	//==============================================================================================
	public void setBias(double bias) {
		this.bias = bias;
	}
	//==============================================================================================

	//==============================================================================================
	public double getScale() {
		return this.scale;
	}
	//==============================================================================================
	
	//==============================================================================================
	public void setScale(double scale) {
		this.scale = scale;
	}
	//==============================================================================================
	
	//==============================================================================================
	protected double getCalculatedValue(double x, double y, double z) {
		double inputValue = this.input.getValue(x, y, z);
		return this.bias + this.scale * inputValue;
	}
	//==============================================================================================
	
}
//**************************************************************************************************
