package no.hvl.dat109.proj2.yatzy.entities;

/**
 * 
 * @author jBach
 * 
 * The dice object
 *
 * @param value - value of dice 
 */
public class Dice {

	private int value;
	
	public int getValue() {
		return value;
	}
	
	/**
	 * 
	 * @param value assign a value to the dice (for test purposes)
	 */
	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value + "";
	}
	
	
}
