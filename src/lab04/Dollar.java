package lab04;

/*
 * Lab 4
 * Names: Lucia Liu, Nithya Ramasubramonian
 * Due date: 6/1/24
 * Purpose: The purpose of this lab is to practice implementing Binary Search Trees through a Dollar modeling scenario.
 */
public class Dollar {
	private int wholeValue;
	private int fractionalValue;

	/*
	 * Pre:
	 * wholeValue - int whole part of Dollar, cannot be negative
	 * fractionalValue - int whole part of Dollar, cannot be negative or be greater than 99
	 * 
	 * Post:
	 * Throw exception if wholeValue or fractionalValue is negative 
	 * or if fractionalValue is greater than 99
	 */
	public Dollar(int wholeValue, int fractionalValue) {
		if (wholeValue < 0 || fractionalValue < 0) {
			throw new IllegalArgumentException("Negative whole or fractional value");
		} else if (fractionalValue > 99) {
        	throw new IllegalArgumentException("Fractional value out of range");
		}
		
		this.wholeValue = wholeValue;
		this.fractionalValue = fractionalValue;
	}

	/*
	 * Post: Returns the int whole value of the Dollar currency.
	 */
	public int getWholeValue() {
		return wholeValue;
	}

	/*
	 * Post: Returns the int fractional value of the Dollar currency.
	 */
	public int getFractionalValue() {
		return fractionalValue;
	}

	/*
	 * Pre: 
	 * wholeValue - int value of new whole part
	 * 
	 * Post: Sets whole value to the given new int whole value
	 */
	public void setWholeValue(int wholeValue) {
		this.wholeValue = wholeValue;
	}

	/*
	 * Pre: 
	 * fractionalValue - int value of new fractional part
	 * 
	 * Post: Sets fractional value to the given new int fractional value
	 */
	public void setFractionalValue(int fractionalValue) {
		this.fractionalValue = fractionalValue;
	}

	/*
	 * Post: Returns double value of Dollar object.
	 */
	public double getValue() {
		return wholeValue + (fractionalValue / 100.0);
	}

	/*
	 * Post: Returns a String for the Dollar object formatted as "$xx.xx"
	 */
	@Override
	public String toString() {
		return "$" + wholeValue + "." + String.format("%02d", fractionalValue);
	}
}
