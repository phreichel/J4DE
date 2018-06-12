//**************************************************************************************************
package j4de.noise;
//**************************************************************************************************

//**************************************************************************************************
public class Perlin extends Module {

	//==============================================================================================
    public static final double       DEFAULT_PERLIN_FREQUENCY    = 1.0;
    public static final double       DEFAULT_PERLIN_LACUNARITY   = 2.0;
    public static final int          DEFAULT_PERLIN_OCTAVE_COUNT = 6;
    public static final double       DEFAULT_PERLIN_PERSISTENCE  = 0.5;
    public static final NoiseQuality DEFAULT_PERLIN_QUALITY      = NoiseQuality.STD;
    public static final int          DEFAULT_PERLIN_SEED         = 0;
    public static final int          PERLIN_MAX_OCTAVE           = 30;
	//==============================================================================================
    
	//==============================================================================================
    private double       frequency;
    private double       lacunarity;
    private int          octaveCount;
    private double       persistence;
    private NoiseQuality noiseQuality;
    private int          seed;
	//==============================================================================================
    
	//==============================================================================================
    public Perlin() {
    	super();
    	this.frequency    = DEFAULT_PERLIN_FREQUENCY;
    	this.lacunarity   = DEFAULT_PERLIN_LACUNARITY;
    	noiseQuality      = DEFAULT_PERLIN_QUALITY;
    	this.octaveCount  = DEFAULT_PERLIN_OCTAVE_COUNT;
    	this.persistence  = DEFAULT_PERLIN_PERSISTENCE;
    	this.seed         = DEFAULT_PERLIN_SEED;
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
	public double getLacunarity() {
		return lacunarity;
	}
	//==============================================================================================

	//==============================================================================================
	public void setLacunarity(double lacunarity) {
		this.lacunarity = lacunarity;
	}
	//==============================================================================================

	//==============================================================================================
	public int getOctaveCount() {
		return octaveCount;
	}
	//==============================================================================================

	//==============================================================================================
	public void setOctaveCount(int octaveCount) {
		this.octaveCount = octaveCount;
	}
	//==============================================================================================

	//==============================================================================================
	public double getPersistence() {
		return persistence;
	}
	//==============================================================================================

	//==============================================================================================
	public void setPersistence(double persistence) {
		this.persistence = persistence;
	}
	//==============================================================================================

	//==============================================================================================
	public NoiseQuality getNoiseQuality() {
		return noiseQuality;
	}
	//==============================================================================================

	//==============================================================================================
	public void setNoiseQuality(NoiseQuality noiseQuality) {
		this.noiseQuality = noiseQuality;
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
    protected double getCalculatedValue (double x, double y, double z) {
      double value          = 0.0;
      double signal         = 0.0;
      double curPersistence = 1.0;
      double nx, ny, nz;
      int seed;

      x *= this.frequency;
      y *= this.frequency;
      z *= this.frequency;

      for (int curOctave = 0; curOctave < octaveCount; curOctave++) {

        // Make sure that these floating-point values have the same range as a 32-
        // bit integer so that we can pass them to the coherent-noise functions.
        nx = NoiseGen.makeInt32Range (x);
        ny = NoiseGen.makeInt32Range (y);
        nz = NoiseGen.makeInt32Range (z);

        // Get the coherent-noise value from the input value and add it to the
        // final result.
        seed = (this.seed + curOctave) & 0xffffffff;
        signal = NoiseGen.gradientCoherentNoise3D (nx, ny, nz, seed, noiseQuality);
        value += signal * curPersistence;

        // Prepare the next octave.
        x *= lacunarity;
        y *= lacunarity;
        z *= lacunarity;
        curPersistence *= persistence;
      }

      return value;
    }    
	//==============================================================================================
 
}
//**************************************************************************************************
