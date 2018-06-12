//**************************************************************************************************
package j4de.noise;
//**************************************************************************************************

//**************************************************************************************************
public class RidgedMulti extends Module {

	//==============================================================================================
    public static final double       DEFAULT_RIDGED_FREQUENCY    = 1.0;
    public static final double       DEFAULT_RIDGED_LACUNARITY   = 2.0;
    public static final int          DEFAULT_RIDGED_OCTAVE_COUNT = 6;
    public static final NoiseQuality DEFAULT_RIDGED_QUALITY      = NoiseQuality.STD;
    public static final int          DEFAULT_RIDGED_SEED         = 0;
    public static final int          RIDGED_MAX_OCTAVE           = 30;
	//==============================================================================================
    
	//==============================================================================================
    private double       frequency;
    private double       lacunarity;
    private int          octaveCount;
    double[]             spectralWeights;
    private NoiseQuality noiseQuality;
    private int          seed;
	//==============================================================================================
    
	//==============================================================================================
    public RidgedMulti() {
    	super();
    	this.frequency    = DEFAULT_RIDGED_FREQUENCY;
    	this.lacunarity   = DEFAULT_RIDGED_LACUNARITY;
    	noiseQuality      = DEFAULT_RIDGED_QUALITY;
    	this.octaveCount  = DEFAULT_RIDGED_OCTAVE_COUNT;
    	this.seed         = DEFAULT_RIDGED_SEED;
    	this.spectralWeights = new double[ RIDGED_MAX_OCTAVE ];
    	this.calcSpectralWeights();
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
		this.calcSpectralWeights();
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
      double value  = 0.0;
      double signal = 0.0;
      double weight = 1.0;
      double nx, ny, nz;
      int seed;

      // These parameters should be user-defined; they may be exposed in a
      // future version of libnoise.
      double offset = 1.0;
      double gain   = 2.0;
      
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
        seed = (this.seed + curOctave) & 0x7fffffff;
        signal = NoiseGen.gradientCoherentNoise3D (nx, ny, nz, seed, noiseQuality);

        // Make the ridges.
        signal = Math.abs(signal);
        signal = offset - signal;

        // Square the signal to increase the sharpness of the ridges.
        signal *= signal;

        // The weighting from the previous octave is applied to the signal.
        // Larger values have higher weights, producing sharp points along the
        // ridges.
        signal *= weight;

        // Weight successive contributions by the previous signal.
        weight = signal * gain;
        if (weight > 1.0) weight = 1.0;
        if (weight < 0.0) weight = 0.0;

        // Add the signal to the output value.
        value += (signal * spectralWeights[curOctave]);
        
        // Prepare the next octave.
        x *= lacunarity;
        y *= lacunarity;
        z *= lacunarity;
        
      }

      return (value * 1.25) - 1.0;
      
    }    
	//==============================================================================================

	//==============================================================================================
    private void calcSpectralWeights() {
    	double h         = 1.0;
    	double frequency = 1.0;
    	for (int i = 0; i < RIDGED_MAX_OCTAVE; i++) {
    		// Compute weight for each frequency.
    		spectralWeights[i] = Math.pow(frequency, -h);
    		frequency *= lacunarity;
    	}
    }
	//==============================================================================================
 
}
//**************************************************************************************************
