/*
*Class data controller
* call data from database
*/

package myapp2;

import myapp2.wristwatches.WristWatch;
import myapp2.wristwatches.Database;
/**
 *
 * @author BHUIYAN
 */
public class DataController {

	Database watchData = new Database();
	
	// get the respective watch data available in arrays
	String[][] watchSpecs = watchData.getWatchSpecs();
	boolean[][] watchFeatures = watchData.getWatchFeatures();

	// create a wrist watch object
	WristWatch myWristWatches[];

	int numWatches ;

	public DataController() {

		System.out.println("DataController constructor");
		
		numWatches = watchData.getNumberOfWatches();
		
		myWristWatches = new WristWatch[numWatches];
		
		for(int i = 0; i < numWatches; i++) {
			myWristWatches[i] = new WristWatch(watchSpecs[i], watchFeatures[i]);
		}		
	}

	public WristWatch[] getMyWristWatchObjects() {

		return myWristWatches;
	}
	
	public int getNumWatches() {
		return numWatches;
	}
}
