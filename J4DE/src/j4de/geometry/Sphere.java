/***************************************************************************************************
 * File:    Sphere.java
 * Project: J4DE
 * 
 * @author  Philip
 * @date    10.07.2018
 **************************************************************************************************/

//*************************************************************************************************
package j4de.geometry;
//*************************************************************************************************

//*************************************************************************************************
import j4de.math.D3Vector;
//*************************************************************************************************

//*************************************************************************************************
public class Sphere {

	//==============================================================================================
	private D3Vector center = null;
	private Double   radius = null;
	//==============================================================================================

	//==============================================================================================
	public D3Vector getCenter() {
		return this.center;
	}
	//==============================================================================================
	
	//==============================================================================================
	public void setCenter(D3Vector center) {
		this.center = center;
	}
	//==============================================================================================

	//==============================================================================================
	public Double getRadius() {
		return this.radius;
	}
	//==============================================================================================
	
	//==============================================================================================
	public void setRadius(Double radius) {
		this.radius = radius;
	}
	//==============================================================================================
	
}
//*************************************************************************************************