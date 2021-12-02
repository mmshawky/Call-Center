/**
 * This Code is a private work, Create for business need, You only can take idea of technolgy but not copy it
 * Because the full copy right reserved for Intelligent Communication Services Provider Company ICSP.CO
 */
package com.icsp.ivr.util;

import java.util.List;
import java.util.Random;

import com.icsp.ivr.dynamicsay.digits.Digits;

/**
 * @author Mostafa M.Shawky
 *         May 9, 2015 2:14:42 PM
 *
 */
public class Test {
	
	/**
	 * 
	 */
	public Test() {
	
		// TODO Auto-generated constructor stub
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
	
		int randomInt = 0;
		for (int i = 0; i < 1; i++) {
			try {
				Random random = new Random();
				double min = 0.0;
				double max = 999999.0;
				// double value = min + random.nextDouble() * max;
				// double value = min + (max - min) * random.nextDouble();
				// randomInt = randInt(0, 999999999);
				// Numbers numbers = new ArabicNumbers(1978.56963);
				// System.out.println(numbers.say());
				// System.out.println(numbers.getFraction().say());
				// System.out.println("--------------");
				//Numbers numbersAr = Numbers.getInstance(789, Language.Ar);
				Digits digits = new Digits("20");
				List<String > list = digits.say();
				for (String string : list) {
					System.out.println(string);
				}
				
				
//				Numbers numbersEn = new EnglishNumbers(2198784512.0);
//				List<String> strings = numbersAr.say();
//				for (String string : strings) {
//					System.out.println(string);
//				}
				// System.out.println(numbersEn.say());
				// System.out.println(numbersEn.getFraction());
				// System.out.println(numbersEn.isNegative());
				// numbersEn.setNumber(-10);
				// System.out.println(numbersEn.say());
				// System.out.println(numbersEn.getFraction());
				// System.out.println(numbersEn.isNegative());
				// System.out.println(numbers.convert());
				// System.out.println(numbers.getFraction());
				// System.out.println("Number Is " + value + " " + numbers.convert());
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e + "  Number Is [" + randomInt + "]");
			}
		}
	}
}
