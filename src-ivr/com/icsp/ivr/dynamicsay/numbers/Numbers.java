/**
 * This Code is a private work, Create for business need, You only can take idea of technolgy but not copy it
 * Because the full copy right reserved for Intelligent Communication Services Provider Company ICSP.CO
 */
package com.icsp.ivr.dynamicsay.numbers;

import com.icsp.ivr.dynamicsay.Units;
import com.icsp.ivr.exception.IvrException;
import com.icsp.ivr.util.Language;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Mostafa M.Shawky
 *         May 4, 2015 7:25:27 PM
 *
 */
public abstract class Numbers implements Units {
	
	/**
	 * 
	 */
	private static final long	serialVersionUID	= -6032377037181203488L;
	private final String[]		SHORT_SCALE_NAME	= { "hundred", "thousand", "million", "billion", "trillion", "quadrillion", "quintillion", "sextillion", "septillion" };
	private final String[]		TENS_NUMBERS		= { "", " ten", " twenty", " thirty", " forty", " fifty", " sixty", " seventy", " eighty", " ninety" };
	private final String[]		NATURAL_NUMBERS		= { "", " one", " two", " three", " four", " five", " six", " seven", " eight", " nine", " ten", " eleven", " twelve",
		" thirteen", " fourteen", " fifteen", " sixteen", " seventeen", " eighteen", " nineteen" };
	private final String		AND					= " and ";
	private final String		ZERO				= "zero";
	private Fraction			fraction;
	private boolean				isFraction;
	private double				number;
	private boolean				isNegative;
	
	/**
	 * 
	 */
	Numbers(Double number) {
	
		this.number = number;
	}
	
	/**
	 * This method for create Instance of Numbers class
	 * 
	 * @param number
	 * @param language
	 * @return
	 * @throws IvrException
	 */
	public static Numbers getInstance(double number, Language language) throws IvrException {
	
		Numbers numbers = null;
		try {
			Class<?> numberClass = Class.forName("com.icsp.ivr.dynamicsay.numbers." + language.name() + "Numbers");
			numbers = (Numbers) numberClass.getConstructor(Double.class).newInstance(number);
		} catch (ClassNotFoundException e) {
			throw new IvrException(language + " Not supported");
		} catch (InstantiationException e) {
			e.printStackTrace();
			throw new IvrException("Can't Load class " + language + "Numbers");
		} catch (Exception e) {
			throw new IvrException(e);
		}
		return numbers;
	}
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	private ArrayList<Integer> getBlocks(double number) throws IvrException {
	
		NumberFormat formatNumberFormat = DecimalFormat.getInstance();
		BigDecimal bigDecimal = new BigDecimal(String.valueOf(number));
		if (bigDecimal.signum() == -1) {
			setNegative(true);
			bigDecimal = bigDecimal.negate();
		}
		String bdString = bigDecimal.toPlainString();
		String fraction;
		if (bigDecimal.scale() > 0) {
			setFraction(true);
			fraction = bdString.substring(bdString.indexOf("."));
			bigDecimal = bigDecimal.subtract(new BigDecimal(fraction));
			bigDecimal = new BigDecimal(bigDecimal.longValue());
			long frac = Integer.valueOf(fraction.substring(fraction.indexOf(".") + 1));
			setFraction(new Fraction(frac));
		}
		String numberString = formatNumberFormat.format(bigDecimal);
		String[] blocksString = numberString.split(",");
		ArrayList<Integer> blocks = new ArrayList<Integer>();
		int index = 0;
		for (int i = (blocksString.length - 1); i >= 0; i--) {
			blocks.add(index++, Integer.valueOf(blocksString[i]));
		}
		return blocks;
	}
	
	/**
	 * 
	 * @param number
	 * @return
	 * @throws Exception
	 */
	private List<String> convert(double number) throws IvrException {
	
		List<String> prompts = new ArrayList<String>(5);
		if (number == 0) {
			prompts.add(ZERO);
			return prompts;
		}
		ArrayList<Integer> integers = getBlocks(number);
		String result = "", trad = "";
		for (int i = integers.size() - 1; i > 0; i--) {
			switch (integers.get(i)) {
				case 0:
					trad = "";
				break;
				case 1:
					trad = "one-" + SHORT_SCALE_NAME[i] + " ";
				break;
				case 2:
					trad = "two-" + SHORT_SCALE_NAME[i] + " ";
				break;
				case 3:
				case 4:
				case 5:
				case 6:
				case 7:
				case 8:
				case 9:
				case 10:
					trad = convertHundredBlock(integers.get(i)) + " " + SHORT_SCALE_NAME[i] + "s ";
				break;
				default:
					trad = convertHundredBlock(integers.get(i)) + " " + SHORT_SCALE_NAME[i] + " ";
			}
			if (result != null && !result.isEmpty() && !trad.isEmpty()) {
				result = result + AND;
			}
			result = result + trad;
			trad = "";
		}
		String hundredResult = convertHundredBlock(integers.get(0));
		if (result != null && !result.isEmpty() && hundredResult != null && !hundredResult.isEmpty()) {
			result = result + AND;
		}
		result = result + " " + hundredResult;
		// remove unneeded spaces
		result = result.replaceAll("^\\s+", "").replaceAll("\\b\\s{2,}\\b", " ");
		prompts = Arrays.asList(result.split(" "));
		return prompts;
	}
	
	/**
	 * 
	 * @param number
	 * @return
	 */
	private String convertHundredBlock(int number) throws IvrException {
	
		String remain;
		if (number % 100 < 20) {
			remain = NATURAL_NUMBERS[number % 100];
			number /= 100;
		} else {
			remain = NATURAL_NUMBERS[number % 10];
			number /= 10;
			String tensnumber = TENS_NUMBERS[number % 10];
			remain = getDozensBlock(remain, tensnumber);
			number /= 10;
		}
		if (number == 0) {
			return remain;
		}
		String trad;
		switch (number) {
			case 1:
				trad = "one-" + SHORT_SCALE_NAME[0];
			break;
			case 2:
				trad = "two-" + SHORT_SCALE_NAME[0];
			break;
			default:
				trad = NATURAL_NUMBERS[number] + " " + SHORT_SCALE_NAME[0];
		}
		if (remain != null && !remain.isEmpty()) {
			trad += AND + remain;
		}
		return trad;
	}
	
	/**
	 * This method return list of prompt for given number
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<String> say() throws IvrException {
	
		return convert(getNumber());
	}
	
	/**
	 * 
	 * @param remain
	 * @param number
	 * @return
	 */
	protected abstract String getDozensBlock(String remain, String tensnumber);
	
	/**
	 * 
	 * @author Mostafa M.Shawky
	 *         May 9, 2015 2:07:52 PM
	 *
	 */
	public final class Fraction {
		
		private long	fraction;
		
		private Fraction(long fraction) {
		
			this.fraction = fraction;
		}
		
		public List<String> say() throws Exception {
		
			return convert(getFraction());
		}
		
		/**
		 * @return the fraction
		 */
		public long getFraction() {
		
			return fraction;
		}
		
		/**
		 * @param fraction
		 *            the fraction to set
		 */
		public void setFraction(long fraction) {
		
			this.fraction = fraction;
		}
		
		/*
		 * (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
		
			return "Fraction [fraction=" + fraction + "]";
		}
	}
	
	/**
	 * @return the isFraction
	 */
	public boolean isFraction() {
	
		return isFraction;
	}
	
	/**
	 * @param isFraction
	 *            the isFraction to set
	 */
	public void setFraction(boolean isFraction) {
	
		this.isFraction = isFraction;
	}
	
	/**
	 * @return the number
	 */
	public double getNumber() {
	
		return number;
	}
	
	/**
	 * @param number
	 *            the number to set
	 */
	public void setNumber(double number) {
	
		this.number = number;
	}
	
	/**
	 * @return the fraction
	 */
	public Fraction getFraction() {
	
		return fraction;
	}
	
	/**
	 * @param fraction
	 *            the fraction to set
	 */
	public void setFraction(Fraction fraction) {
	
		this.fraction = fraction;
	}
	
	/**
	 * @return the isNegative
	 */
	public boolean isNegative() {
	
		return isNegative;
	}
	
	/**
	 * @param isNegative
	 *            the isNegative to set
	 */
	public void setNegative(boolean isNegative) {
	
		this.isNegative = isNegative;
	}
}