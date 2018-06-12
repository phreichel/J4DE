//**************************************************************************************************
package j4de.noise;
//**************************************************************************************************

//**************************************************************************************************
public class Voronoi extends Module {

    //==============================================================================================
    public static final double DEFAULT_VORONOI_DISPLACEMENT = 1.0;
    public static final double DEFAULT_VORONOI_FREQUENCY    = 1.0;
    public static final int    DEFAULT_VORONOI_SEED         = 0;
    //==============================================================================================

	//==============================================================================================
    private boolean distance;
    private double  displacement;
    private double  frequency;
    private int     seed;
	//==============================================================================================

	//==============================================================================================
    public Voronoi() {
    	super();
    	this.distance     = false;
    	this.displacement = DEFAULT_VORONOI_DISPLACEMENT;
    	this.frequency    = DEFAULT_VORONOI_FREQUENCY;
    	this.seed         = DEFAULT_VORONOI_SEED;
	}
	//==============================================================================================

	//==============================================================================================
    public boolean getDistance() {
    	return this.distance;
    }
	//==============================================================================================
    
	//==============================================================================================
    public void setDistance(boolean distance) {
    	this.distance = distance;
    }
	//==============================================================================================
    
	//==============================================================================================
	public double getDisplacement() {
		return displacement;
	}
	//==============================================================================================

	//==============================================================================================
	public void setDisplacement(double displacement) {
		this.displacement = displacement;
	}
	//==============================================================================================
    
	//==============================================================================================
	public double getFrequency() {
		return frequency;
	}
	//==============================================================================================

	//==============================================================================================
	public void setFrequency(double frequency) {
		this.frequency = frequency;
	}
	//==============================================================================================

	//==============================================================================================
	public int getSeed() {
		return seed;
	}
	//==============================================================================================

	//==============================================================================================
	public void setSeed(int seed) {
		this.seed = seed;
	}
	//==============================================================================================

	//==============================================================================================
	protected double getCalculatedValue(double x, double y, double z) {
	// This method could be more efficient by caching the seed values.  Fix
	// later.

		x *= frequency;
		y *= frequency;
		z *= frequency;

		int xInt = (x > 0.0? (int)x: (int)x - 1);
		int yInt = (y > 0.0? (int)y: (int)y - 1);
		int zInt = (z > 0.0? (int)z: (int)z - 1);

		double minDist = 2147483647.0;
		double xCandidate = 0;
		double yCandidate = 0;
		double zCandidate = 0;

		// Inside each unit cube, there is a seed point at a random position.  Go
		// through each of the nearby cubes until we find a cube with a seed point
		// that is closest to the specified position.
		for (int zCur = zInt - 2; zCur <= zInt + 2; zCur++) {
			for (int yCur = yInt - 2; yCur <= yInt + 2; yCur++) {
				for (int xCur = xInt - 2; xCur <= xInt + 2; xCur++) {

					// Calculate the position and distance to the seed point inside of
					// this unit cube.
					double xPos  = xCur + NoiseGen.valueNoise3D(xCur, yCur, zCur, seed    );
					double yPos  = yCur + NoiseGen.valueNoise3D(xCur, yCur, zCur, seed + 1);
					double zPos  = zCur + NoiseGen.valueNoise3D(xCur, yCur, zCur, seed + 2);
					double xDist = xPos - x;
					double yDist = yPos - y;
					double zDist = zPos - z;
					double dist  = xDist * xDist + yDist * yDist + zDist * zDist;

					if (dist < minDist) {
						// This seed point is closer to any others found so far, so record
						// this seed point.
						minDist = dist;
						xCandidate = xPos;
						yCandidate = yPos;
						zCandidate = zPos;
					}
				}
			}
		}

		double value;
		if (distance) {
			// Determine the distance to the nearest seed point.
			double xDist = xCandidate - x;
			double yDist = yCandidate - y;
			double zDist = zCandidate - z;
			value = (Math.sqrt(xDist*xDist + yDist*yDist + zDist*zDist)) * NoiseGen.SQRT_3 - 1.0;
		} else {
			value = 0.0;
		}

		// Return the calculated distance with the displacement value applied.
		return value + (displacement * (double) NoiseGen.valueNoise3D(
			(int) Math.floor(xCandidate),
			(int) Math.floor(yCandidate),
			(int) Math.floor(zCandidate),
			0
		));
	}
	//==============================================================================================

}
//**************************************************************************************************
