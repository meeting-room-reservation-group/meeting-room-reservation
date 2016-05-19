package com.github.mrrg.mrrserver;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class RfidTag {
	private String rfidStr;
//	private String regExpStr = "((([A-Za-z0-9]{2}).?){6})";
//	private String regExpStr = "([A-Za-z0-9]{2}).?{6}";
	private String xx = "([A-Za-z0-9]{2}).?";
	private String regExpStr = xx + xx + xx + xx + xx + xx;
	private List<String> samples = Arrays.asList(new String[] {
				""	
			});

	public RfidTag(final String rdifTagStr) {
		final String rfidTagStrCln = StringUtils.trimToNull(rdifTagStr);
		if (rfidTagStrCln == null) {
			throw new IllegalArgumentException("Argument 'rdifTagStr' should not be null.");
		}
		Pattern pattern = Pattern.compile(regExpStr);
		Matcher matcher = pattern.matcher(rfidTagStrCln);
		if (! matcher.matches()) {
			throw new IllegalArgumentException("Argument 'rdifTagStr' does not follow the expected "
					+ "regular expression pattern '" + regExpStr + "'.");
		}
		
		int groupCount = matcher.groupCount();
		int value = 0x65;
		System.out.println(groupCount + "    value " + value + "\n");
		
		int[] byteArray = new int[6];
		int result = 0;
		for (int counter = 0; counter < groupCount; counter++) {
			String hexVal = matcher.group(counter + 1);
			hexToInteger(hexVal.charAt(0));
			hexToInteger(hexVal.charAt(1));
			Integer hex = Integer.valueOf("65", 16);
			System.out.println(counter + "  '" + hexVal + "'  0x" + hexVal + "  int: " + Integer.parseInt(hexVal.trim(), 16) + "  hex: " + Integer.toHexString(Integer.parseInt(hexVal.trim(), 16)));
			
			byteArray[counter] = Integer.parseInt(hexVal.trim(), 16);
			if (counter < 5) {
				result ^= byteArray[counter];
				System.out.println("  " + Integer.toHexString(result) + "  " + Integer.toBinaryString(byteArray[counter]) 
						+ "  " + Integer.toBinaryString(result));
			}
			else if (counter == 5) {
				if (byteArray[counter] != result) {
					System.err.println("No checksum match!  (found: '" + result + "'  expected be '" + byteArray[counter] + "')");
				}
				else {
					System.out.println("Correct match");
				}
			}
		}
		System.out.println("byteArray[0]: " + Integer.toBinaryString(byteArray[0]));
		System.out.println("byteArray[0]: " + Integer.toBinaryString(Integer.parseInt("FFFF", 16)));
		final String rfidStrXxx = rfidTagStrCln.replace(" ", "").replace(".", "").replace("-", "");
		
	}


	public static int hexToInteger(char charAt) {
		if (! (Character.isAlphabetic(charAt)) && (! (Character.isDigit(charAt))) ) {
		}
		
		if (Character.isAlphabetic(charAt)) {
			switch (Character.toUpperCase(charAt)) {
			case 'A':
				return 10;
			case 'B':
				return 11;
			case 'C':
				return 12;
			case 'D':
				return 13;
			case 'E':
				return 14;
			case 'F':
				return 15;
			default:
				break;
			}
		}
		
		return Integer.valueOf(String.valueOf(charAt));
	}


	public static RfidTag create(String rdifTagStr) {
		return new RfidTag(rdifTagStr);
	}

}
