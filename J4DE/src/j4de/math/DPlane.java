//*************************************************************************************************
package j4de.math;
//*************************************************************************************************


//*************************************************************************************************
public class DPlane {

	//==============================================================================================
	public double a, b, c, d;
	//==============================================================================================

	//==============================================================================================
	public DPlane() {
		super();
	}
	//==============================================================================================

	//==============================================================================================
	public DPlane(DPlane p) {
		super();
		this.set(p);
	}
	//==============================================================================================

	//==============================================================================================
	public DPlane(
		D3Vector n,
		double d) {
		super();
		this.set(n, d);
	}
	//==============================================================================================

	//==============================================================================================
	public DPlane(
			D3Vector a,
			D3Vector b,
			D3Vector c) {
		super();
		this.set(a, b, c);
	}
	//==============================================================================================
	
	//==============================================================================================
	public DPlane(
			double a, 
			double b, 
			double c, 
			double d) {
		this.set(a, b, c, d);
	}
	//==============================================================================================
	
	//==============================================================================================
	public void set(DPlane p) {
		this.set(p.a, p.b, p.c, p.d);
	}
	//==============================================================================================
	
	//==============================================================================================
	public void set(
			double a, 
			double b, 
			double c, 
			double d) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}
	//==============================================================================================

	//==============================================================================================
	public void set(
		D3Vector n,
		double d) {
		this.set(n.x, n.y, n.z, d);
	}
	//==============================================================================================
	
	//==============================================================================================
	public void set(
		D3Vector a,
		D3Vector b,
		D3Vector c) {
		D3Vector dab = new D3Vector(); 
		D3Vector dac = new D3Vector();
		D3Vector n   = new D3Vector();
		dab.sub(b, a);
		dac.sub(c, a);
		n.cross(dab, dac);
		n.normalize(n);
		this.set(n.x, n.y, n.z, n.dot(a));
	}
	//==============================================================================================
	
}
//*************************************************************************************************
