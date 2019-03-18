/*
 * Class: Database
 * A class designed to simulate an actual database holding watch data
 */

package myapp2.wristwatches;

/**
 *
 * @author BHUIYAN
 */
public class Database {
	// default watch data
	public String[][] watchSpecs;
	public boolean[][] watchFeatures;

	// Constructor
	public Database() {

		watchSpecs = new String[3][];
		watchFeatures = new boolean[3][];

		// fill data into both classes
		createWatchData();
	}

	// All different watch database - add data to arrays
	private void createWatchData() {

		// First watch data
		watchSpecs[0] = new String[6];
		watchSpecs[0][0] = "Rolex";       // watch make
		watchSpecs[0][1] = "Air-King";    // watch model
		watchSpecs[0][2] = "Smoked Grey"; // watch color
		watchSpecs[0][3] = "rolex.jpg";   // watch image path
		watchSpecs[0][4] = "Steel";       // watch strap type
		watchSpecs[0][5] = "Smoked Grey"; // watch strap color

		watchFeatures[0] = new boolean[6];
		watchFeatures[0][0] = false;      // watch is digital or not
		watchFeatures[0][1] = false;      // watch has kinetic charging or not
		watchFeatures[0][2] = true;       // watch has timer or not
		watchFeatures[0][3] = true;       // watch has stop watch or not
		watchFeatures[0][4] = true;       // watch has water resistant or not
		watchFeatures[0][5] = false;      // watch has changeable strap or not

		// Second watch data
		watchSpecs[1] = new String[6];
		watchSpecs[1][0] = "Fossil";      // watch make
		watchSpecs[1][1] = "Explorist 3"; // watch model
		watchSpecs[1][2] = "Blue";        // watch color
		watchSpecs[1][3] = "fossil.jpg";  // watch image path
		watchSpecs[1][4] = "Leather";     // watch strap type
		watchSpecs[1][5] = "Grey";        // watch strap color

		watchFeatures[1] = new boolean[6];
		watchFeatures[1][0] = true;       // watch is digital or not
		watchFeatures[1][1] = false;      // watch has kinetic charging or not
		watchFeatures[1][2] = true;       // watch has timer or not
		watchFeatures[1][3] = true;       // watch has stop watch or not
		watchFeatures[1][4] = false;      // watch has water resistant or not
		watchFeatures[1][5] = true;       // watch has changeable strap or not

		// Third watch data
		watchSpecs[2] = new String[6];
		watchSpecs[2][0] = "Fossil";      // watch make
		watchSpecs[2][1] = "Explorist 4"; // watch model
		watchSpecs[2][2] = "Blue";        // watch color
		watchSpecs[2][3] = "watch1.jpg";  // watch image path
		watchSpecs[2][4] = "Leather";     // watch strap type
		watchSpecs[2][5] = "Grey";        // watch strap color

		watchFeatures[2] = new boolean[6];
		watchFeatures[2][0] = true;       // watch is digital or not
		watchFeatures[2][1] = false;      // watch has kinetic charging or not
		watchFeatures[2][2] = true;       // watch has timer or not
		watchFeatures[2][3] = true;       // watch has stop watch or not
		watchFeatures[2][4] = false;      // watch has water resistant or not
		watchFeatures[2][5] = true;       // watch has changeable strap or not
	}

	// return the watch specifications data array
	public String[][] getWatchSpecs() {
		return watchSpecs;
	}

	// return the watch features data array
	public boolean[][] getWatchFeatures() {
		return watchFeatures;
	}

	public int getNumberOfWatches() {
		return watchSpecs.length;
	}

}