//*************************************************************************************************
package j4de.math;
//*************************************************************************************************


//*************************************************************************************************
public class D33Matrix {

	//==============================================================================================
	public double c11, c12, c13;
	public double c21, c22, c23;
	public double c31, c32, c33;
	//==============================================================================================

	//==============================================================================================
	public D33Matrix() {
		super();
	}
	//==============================================================================================

	//==============================================================================================
	public D33Matrix(D33Matrix m) {
		super();
		this.set(m);
	}
	//==============================================================================================

	//==============================================================================================
	public D33Matrix(
			double c11, double c12, double c13,
			double c21, double c22, double c23,
			double c31, double c32, double c33) {
		this.set(
			c11, c12, c13,
			c21, c22, c23,
			c31, c32, c33);
	}
	//==============================================================================================
	
	//==============================================================================================
	public void set(D33Matrix m) {
		this.set(
			m.c11, m.c12, m.c13,
			m.c21, m.c22, m.c23,
			m.c31, m.c32, m.c33);
	}
	//==============================================================================================
	
	//==============================================================================================
	public void set(
			double c11, double c12, double c13,
			double c21, double c22, double c23,
			double c31, double c32, double c33) {
		this.c11 = c11; this.c12 = c12; this.c13 = c13;
		this.c21 = c21; this.c22 = c22; this.c23 = c23;
		this.c31 = c31; this.c32 = c32; this.c33 = c33;
	}
	//==============================================================================================

	//==============================================================================================
	public void setZero() {
		this.set(
			0, 0, 0,
			0, 0, 0,
			0, 0, 0);
	}
	//==============================================================================================

	//==============================================================================================
	public void setIdentity() {
		this.set(
			1, 0, 0,
			0, 1, 0,
			0, 0, 1);
	}
	//==============================================================================================

	//==============================================================================================
	public double det() {
		return
			this.c11 * this.c22 * this.c33 + 
			this.c12 * this.c23 * this.c31 +
			this.c13 * this.c21 * this.c32 -
			this.c31 * this.c22 * this.c13 -
			this.c32 * this.c23 * this.c11 -
			this.c33 * this.c21 * this.c12;
	}
	//==============================================================================================
	
	//==============================================================================================
	public void mul(			
			D33Matrix m,
			double s) {
		this.set(
			(m.c11*s), (m.c12*s), (m.c13*s),
			(m.c21*s), (m.c22*s), (m.c23*s),
			(m.c31*s), (m.c32*s), (m.c33*s));
	}
	//==============================================================================================

	//==============================================================================================
	public void div(			
			D33Matrix m,
			double d) {
		double dInv = 1.0/d;
		this.mul(m, dInv);
	}
	//==============================================================================================
	
	//==============================================================================================
	public void add(
			D33Matrix a,
			D33Matrix b) {
		this.set(
			(a.c11+b.c11), (a.c12+b.c12), (a.c13+b.c13),
			(a.c21+b.c21), (a.c22+b.c22), (a.c23+b.c23),
			(a.c31+b.c31), (a.c32+b.c32), (a.c33+b.c33));
	}
	//==============================================================================================

	//==============================================================================================
	public void sub(
			D33Matrix a,
			D33Matrix b) {
		this.set(
			(a.c11-b.c11), (a.c12-b.c12), (a.c13-b.c13),
			(a.c21-b.c21), (a.c22-b.c22), (a.c23-b.c23),
			(a.c31-b.c31), (a.c32-b.c32), (a.c33-b.c33));
	}
	//==============================================================================================

	//==============================================================================================
	public void transpose(D33Matrix m) {
		this.set(
			m.c11, m.c21, m.c31,
			m.c12, m.c22, m.c32,
			m.c13, m.c23, m.c33);
	}
	//==============================================================================================
	
	//==============================================================================================
	public void mul(
			D33Matrix a,
			D33Matrix b) {
		this.set(
			(a.c11*b.c11) + (a.c12*b.c21) + (a.c13*b.c31),
			(a.c11*b.c12) + (a.c12*b.c22) + (a.c13*b.c32),
			(a.c11*b.c13) + (a.c12*b.c23) + (a.c13*b.c33),
			(a.c21*b.c11) + (a.c22*b.c21) + (a.c23*b.c31),
			(a.c21*b.c12) + (a.c22*b.c22) + (a.c23*b.c32),
			(a.c21*b.c13) + (a.c22*b.c23) + (a.c23*b.c33),
			(a.c31*b.c11) + (a.c32*b.c21) + (a.c33*b.c31),
			(a.c31*b.c12) + (a.c32*b.c22) + (a.c33*b.c32),
			(a.c31*b.c13) + (a.c32*b.c23) + (a.c33*b.c33));
	}
	//==============================================================================================

	//==============================================================================================
	public void mulTa(
			D33Matrix a,
			D33Matrix b) {
		this.set(
			(a.c11*b.c11) + (a.c21*b.c21) + (a.c31*b.c31),
			(a.c11*b.c12) + (a.c21*b.c22) + (a.c31*b.c32),
			(a.c11*b.c13) + (a.c21*b.c23) + (a.c31*b.c33),
			(a.c12*b.c11) + (a.c22*b.c21) + (a.c32*b.c31),
			(a.c12*b.c12) + (a.c22*b.c22) + (a.c32*b.c32),
			(a.c12*b.c13) + (a.c22*b.c23) + (a.c32*b.c33),
			(a.c13*b.c11) + (a.c23*b.c21) + (a.c33*b.c31),
			(a.c13*b.c12) + (a.c23*b.c22) + (a.c33*b.c32),
			(a.c13*b.c13) + (a.c23*b.c23) + (a.c33*b.c33));
	}
	//==============================================================================================

	//==============================================================================================
	public void mulTb(
			D33Matrix a,
			D33Matrix b) {
		this.set(
			(a.c11*b.c11) + (a.c12*b.c12) + (a.c13*b.c13),
			(a.c11*b.c21) + (a.c12*b.c22) + (a.c13*b.c23),
			(a.c11*b.c31) + (a.c12*b.c32) + (a.c13*b.c33),
			(a.c21*b.c11) + (a.c22*b.c12) + (a.c23*b.c13),
			(a.c21*b.c21) + (a.c22*b.c22) + (a.c23*b.c23),
			(a.c21*b.c31) + (a.c22*b.c32) + (a.c23*b.c33),
			(a.c31*b.c11) + (a.c32*b.c12) + (a.c33*b.c13),
			(a.c31*b.c21) + (a.c32*b.c22) + (a.c33*b.c23),
			(a.c31*b.c31) + (a.c32*b.c32) + (a.c33*b.c33));
	}
	//==============================================================================================

	//==============================================================================================
	public void mulTaTb(
			D33Matrix a,
			D33Matrix b) {
		this.set(
			(a.c11*b.c11) + (a.c12*b.c21) + (a.c13*b.c31),
			(a.c11*b.c12) + (a.c12*b.c22) + (a.c13*b.c32),
			(a.c11*b.c13) + (a.c12*b.c23) + (a.c13*b.c33),
			(a.c21*b.c11) + (a.c22*b.c21) + (a.c23*b.c31),
			(a.c21*b.c12) + (a.c22*b.c22) + (a.c23*b.c32),
			(a.c21*b.c13) + (a.c22*b.c23) + (a.c23*b.c33),
			(a.c31*b.c11) + (a.c32*b.c21) + (a.c33*b.c31),
			(a.c31*b.c12) + (a.c32*b.c22) + (a.c33*b.c32),
			(a.c31*b.c13) + (a.c32*b.c23) + (a.c33*b.c33));
	}
	//==============================================================================================
	
}
//*************************************************************************************************
