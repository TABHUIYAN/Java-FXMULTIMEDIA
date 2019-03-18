
/*
*watchstrap class
*contain all strap detail
*/
package myapp2.wristwatches;

/**
  * @author BHUIYAN
 *
 */
public class WatchStrap {
    
    private final String type;
    private final String color;
    private final boolean changableStrap;
    public WatchStrap(String type, String color, boolean changable)
    {
        this.type = type;
	this.color = color;
        this.changableStrap = changable;
    }
	
    // Overridden toString function
    @Override
    public String toString()
    {
       String data = "";
        data = "----------------------- ";
        data += "Strap Type : " + this.type;
        data += "Strap Color : " + this.color;
        data += "Strap Changable1 :  " + this.changableStrap;
        
        return data;
    }
	
	public String getStrapType() 
        {
	return this.type;
	}
	
	public String getStrapColor() 
        {
	return this.color;
	}
	public boolean isChangableStrap() 
        {
	return this.changableStrap;
	}
    }
