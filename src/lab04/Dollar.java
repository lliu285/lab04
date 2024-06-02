package lab04;

public class Dollar {
	private int wholeValue;
	private int fractionalValue;

	public Dollar(int wholeValue, int fractionalValue) {
		if (wholeValue < 0 || fractionalValue < 0) {
            throw new IllegalArgumentException("Negative whole or fractional value");
        } else if (fractionalValue > 99) {
        	throw new IllegalArgumentException("Fractional value out of range");
        }
		
		this.wholeValue = wholeValue;
		this.fractionalValue = fractionalValue;
	}

	public int getWholeValue() {
		return wholeValue;
	}

	public int getFractionalValue() {
		return fractionalValue;
	}

	public void setWholeValue(int wholeValue) {
		this.wholeValue = wholeValue;
	}

	public void setFractionalValue(int fractionalValue) {
		this.fractionalValue = fractionalValue;
	}

	public double getValue() {
		return wholeValue + (fractionalValue / 100.0);
	}

	@Override
	public String toString() {
		return "$" + wholeValue + "." + String.format("%02d", fractionalValue);
	}

	// might need to create more functions here ...
}
