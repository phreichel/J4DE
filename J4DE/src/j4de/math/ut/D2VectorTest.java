//*************************************************************************************************
package j4de.math.ut;
//*************************************************************************************************

//*************************************************************************************************
import org.junit.Test;
import j4de.math.D2Vector;
import static org.junit.Assert.*;
//*************************************************************************************************

//*************************************************************************************************
public class D2VectorTest {

	//==============================================================================================
	@Test
	public void testD2Vector() {
		
		D2Vector v = new D2Vector();
		assertEquals(v.x, 0.0, 0.0);
		assertEquals(v.y, 0.0, 0.0);
		
	}
	//==============================================================================================

	//==============================================================================================
	@Test
	public void testD2VectorD2Vector() {

		D2Vector vs = new D2Vector();
		D2Vector vd = new D2Vector(); 
		
		vd.set(0.0, 0.0);
		vs.set(Double.MIN_VALUE, Double.MAX_VALUE);
		vd.set(vs);
		assertEquals(vs.x, Double.MIN_VALUE, 0.0);
		assertEquals(vs.y, Double.MAX_VALUE, 0.0);
		assertEquals(vd.x, Double.MIN_VALUE, 0.0);
		assertEquals(vd.y, Double.MAX_VALUE, 0.0);

		vd.set(0.0, 0.0);
		vs.set(Double.MAX_VALUE, Double.MIN_VALUE);
		vd.set(vs);
		assertEquals(vs.x, Double.MAX_VALUE, 0.0);
		assertEquals(vs.y, Double.MIN_VALUE, 0.0);
		assertEquals(vd.x, Double.MAX_VALUE, 0.0);
		assertEquals(vd.y, Double.MIN_VALUE, 0.0);

		vd.set(0.0, 0.0);
		vs.set(Double.MAX_VALUE, Double.NaN);
		vd.set(vs);
		assertEquals(vs.x, Double.MAX_VALUE, 0.0);
		assertEquals(vs.y, Double.NaN, 0.0);
		assertEquals(vd.x, Double.MAX_VALUE, 0.0);
		assertEquals(vd.y, Double.NaN, 0.0);

		vd.set(0.0, 0.0);
		vs.set(Double.NaN, Double.MAX_VALUE);
		vd.set(vs);
		assertEquals(vs.x, Double.NaN, 0.0);
		assertEquals(vs.y, Double.MAX_VALUE, 0.0);
		assertEquals(vd.x, Double.NaN, 0.0);
		assertEquals(vd.y, Double.MAX_VALUE, 0.0);

	}
	//==============================================================================================

	//==============================================================================================
	@Test
	public void testD2VectorDoubleDouble() {

		D2Vector v1 = new D2Vector(Double.NaN, Double.MIN_VALUE);
		assertEquals(v1.x, Double.NaN, 0.0);
		assertEquals(v1.y, Double.MIN_VALUE, 0.0);
		
		D2Vector v2 = new D2Vector(Double.MIN_VALUE, Double.NaN);
		assertEquals(v2.x, Double.MIN_VALUE, 0.0);
		assertEquals(v2.y, Double.NaN, 0.0);

		D2Vector v3 = new D2Vector(Double.NaN, Double.MAX_VALUE);
		assertEquals(v3.x, Double.NaN, 0.0);
		assertEquals(v3.y, Double.MAX_VALUE, 0.0);
		
		D2Vector v4 = new D2Vector(Double.MAX_VALUE, Double.NaN);
		assertEquals(v4.x, Double.MAX_VALUE, 0.0);
		assertEquals(v4.y, Double.NaN, 0.0);

		D2Vector v5 = new D2Vector(Double.MIN_VALUE, Double.MAX_VALUE);
		assertEquals(v5.x, Double.MIN_VALUE, 0.0);
		assertEquals(v5.y, Double.MAX_VALUE, 0.0);
		
		D2Vector v6 = new D2Vector(Double.MAX_VALUE, Double.MIN_VALUE);
		assertEquals(v6.x, Double.MAX_VALUE, 0.0);
		assertEquals(v6.y, Double.MIN_VALUE, 0.0);
		
	}
	//==============================================================================================

	//==============================================================================================
	@Test
	public void testSetD2Vector() {

		D2Vector vs = new D2Vector();
		D2Vector vd = new D2Vector();
		
		vs.set(Double.MIN_VALUE, Double.MAX_VALUE);
		vd.set(vs);
		assertEquals(vs.x, Double.MIN_VALUE, 0.0);
		assertEquals(vs.y, Double.MAX_VALUE, 0.0);
		assertEquals(vd.x, Double.MIN_VALUE, 0.0);
		assertEquals(vd.y, Double.MAX_VALUE, 0.0);

		vd.set(0.0, 0.0);
		vs.set(Double.MAX_VALUE, Double.MIN_VALUE);
		vd.set(vs);
		assertEquals(vs.x, Double.MAX_VALUE, 0.0);
		assertEquals(vs.y, Double.MIN_VALUE, 0.0);
		assertEquals(vd.x, Double.MAX_VALUE, 0.0);
		assertEquals(vd.y, Double.MIN_VALUE, 0.0);

		vd.set(0.0, 0.0);
		vs.set(Double.MAX_VALUE, Double.NaN);
		vd.set(vs);
		assertEquals(vs.x, Double.MAX_VALUE, 0.0);
		assertEquals(vs.y, Double.NaN, 0.0);
		assertEquals(vd.x, Double.MAX_VALUE, 0.0);
		assertEquals(vd.y, Double.NaN, 0.0);

		vd.set(0.0, 0.0);
		vs.set(Double.NaN, Double.MAX_VALUE);
		vd.set(vs);
		assertEquals(vs.x, Double.NaN, 0.0);
		assertEquals(vs.y, Double.MAX_VALUE, 0.0);
		assertEquals(vd.x, Double.NaN, 0.0);
		assertEquals(vd.y, Double.MAX_VALUE, 0.0);
		
	}
	//==============================================================================================

	//==============================================================================================
	@Test
	public void testSetDoubleDouble() {

		D2Vector v = new D2Vector();
		v.set(Double.MIN_VALUE, Double.MAX_VALUE);
		assertEquals(v.x, Double.MIN_VALUE, 0.0);
		assertEquals(v.y, Double.MAX_VALUE, 0.0);

		v.set(Double.MAX_VALUE, Double.MIN_VALUE);
		assertEquals(v.x, Double.MAX_VALUE, 0.0);
		assertEquals(v.y, Double.MIN_VALUE, 0.0);

		v.set(Double.MIN_VALUE, Double.NaN);
		assertEquals(v.x, Double.MIN_VALUE, 0.0);
		assertEquals(v.y, Double.NaN, 0.0);

		v.set(Double.NaN, Double.MIN_VALUE);
		assertEquals(v.x, Double.NaN, 0.0);
		assertEquals(v.y, Double.MIN_VALUE, 0.0);

		v.set(Double.MAX_VALUE, Double.NaN);
		assertEquals(v.x, Double.MAX_VALUE, 0.0);
		assertEquals(v.y, Double.NaN, 0.0);

		v.set(Double.NaN, Double.MAX_VALUE);
		assertEquals(v.x, Double.NaN, 0.0);
		assertEquals(v.y, Double.MAX_VALUE, 0.0);
		
	}
	//==============================================================================================

	//==============================================================================================
	@Test
	public void testLength() {

		D2Vector v1 = new D2Vector(Double.NaN, Double.NaN);
		double   r1 = v1.length();
		assertEquals(r1, Double.NaN, 0.0);

		D2Vector v2 = new D2Vector(Double.NaN, 2.0);
		double   r2 = v2.length();
		assertEquals(r2, Double.NaN, 0.0);

		D2Vector v3 = new D2Vector(2.0, Double.NaN);
		double   r3 = v3.length();
		assertEquals(r3, Double.NaN, 0.0);

		D2Vector v4 = new D2Vector(2.0, 5.0);
		double   r4 = v4.length();
		assertEquals(r4, Math.sqrt(2.0*2.0 + 5.0*5.0), 0.001);

		D2Vector v5 = new D2Vector(7.0, -3.0);
		double   r5 = v5.length();
		assertEquals(r5, Math.sqrt(7.0*7.0 + -3.0*-3.0), 0.001);

		D2Vector v6 = new D2Vector(-1.0, -4.0);
		double   r6 = v6.length();
		assertEquals(r6, Math.sqrt(-1.0*-1.0 + -4.0*-4.0), 0.001);

		D2Vector v7 = new D2Vector(Double.MAX_VALUE, 0.0);
		double   r7 = v7.length();
		assertEquals(r7, Double.MAX_VALUE, 0.0);

		D2Vector v8 = new D2Vector(0.0, Double.MAX_VALUE);
		double   r8 = v8.length();
		assertEquals(r8, Double.MAX_VALUE, 0.0);

		D2Vector v9 = new D2Vector(Double.MAX_VALUE, 1.0);
		double   r9 = v9.length();
		assertEquals(r9, Double.POSITIVE_INFINITY, 0.0);

		D2Vector v10 = new D2Vector(1.0, Double.MAX_VALUE);
		double   r10 = v10.length();
		assertEquals(r10, Double.POSITIVE_INFINITY, 0.0);
		
		D2Vector v11 = new D2Vector(Double.MAX_VALUE, Double.MAX_VALUE);
		double   r11 = v11.length();
		assertEquals(r11, Double.POSITIVE_INFINITY, 0.0);

	}
	//==============================================================================================

	//==============================================================================================
	@Test
	public void testLengthSquared() {

		fail("Not yet implemented");
	}
	//==============================================================================================

	//==============================================================================================
	@Test
	public void testDot() {

		fail("Not yet implemented");
	}
	//==============================================================================================

	//==============================================================================================
	@Test
	public void testNormalize() {

		fail("Not yet implemented");
	}
	//==============================================================================================

	//==============================================================================================
	@Test
	public void testMul() {

		fail("Not yet implemented");
	}
	//==============================================================================================

	//==============================================================================================
	@Test
	public void testDiv() {

		fail("Not yet implemented");
	}
	//==============================================================================================

	//==============================================================================================
	@Test
	public void testAdd() {

		fail("Not yet implemented");
	}
	//==============================================================================================

	//==============================================================================================
	@Test
	public void testSub() {

		fail("Not yet implemented");
	}
	//==============================================================================================

	//==============================================================================================
	@Test
	public void testMin() {

		fail("Not yet implemented");
	}
	//==============================================================================================

	//==============================================================================================
	@Test
	public void testMax() {

		fail("Not yet implemented");
	}
	//==============================================================================================

	//==============================================================================================
	@Test
	public void testClamp() {

		fail("Not yet implemented");
	}
	//==============================================================================================

	//==============================================================================================
	@Test
	public void testLerp() {

		fail("Not yet implemented");
	}
	//==============================================================================================

	//==============================================================================================
	@Test
	public void testAddScaled() {

		fail("Not yet implemented");
	}
	//==============================================================================================

}
//*************************************************************************************************
