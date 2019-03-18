
/*
*Wrist watch interface
*example
*/
package myapp2.wristwatches;
/**
 * @author BHUIYAN
 *
 */ 
public class WristWatch extends Watch implements WatchFeatures {

	private final String make; //watch color
	private final String model;//watch model
	private final String watchColor;
	private final String imagePath;
	private final WatchStrap strap;
	private final boolean digitalWatch;
	private final boolean kineticCharging;

	private final boolean timer;
	private final boolean stopWatch;
	private final boolean waterResistant;

	public WristWatch(String[] watchSpecs, boolean[] watchFeatures)
        {
                this.make = watchSpecs[0];
		this.model = watchSpecs[1];
		this.watchColor = watchSpecs[2];
		this.imagePath = watchSpecs[3];
		this.digitalWatch = watchFeatures[0];
		this.kineticCharging = watchFeatures[1];
		this.timer = watchFeatures[2];
		this.stopWatch = watchFeatures[3];
		this.waterResistant = watchFeatures[4];
		strap = new WatchStrap(watchSpecs[4], watchSpecs[5], watchFeatures[5]);
        }
       //getter and setter
        @Override
	public void getWatchSystem() 
        {
	if (digitalWatch) 
        {
	System.out.println("Digital Watch");
	} 
        else 
        {
	System.out.println("Analog Watch");
	}
	}

	public String getMake()
        {
	return this.make;
	}

	public String getModel() 
        {
	return this.model;
	}

	public String getColor()
        {
	return watchColor;
	}

	public String getImagePath()
        {
	return imagePath;
	}

	public boolean hasKineticCharging() 
        {
	return kineticCharging;
	}

	public String getStrapType() 
        {
	return strap.getStrapType();
	}

	public String getStrapColor()
        {
	return strap.getStrapColor();
	}
        public boolean getStrapChangable() 
        {
	return strap.isChangableStrap();
	}

	// Method from interface implemented in the class
        @Override
	public boolean hasTimer() 
        {
	return this.timer;
	}

	// Method from interface implemented in the class
        @Override
	public boolean hasStopWatch() 
        {
	return this.stopWatch;
	}

	// Method from interface implemented in the class
        @Override
	public boolean isWaterResistance() 
        {
	return this.waterResistant;
	}
}
