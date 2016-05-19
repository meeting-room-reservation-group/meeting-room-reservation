package com.github.mrrg.mrrserver;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.github.mrrg.mrrserver.RfidTag;

public class RfidTagTest {

	@Test
	public void createRfidTag() throws Exception {
//		RfidTag rfidTag = RfidTag.create("3C 01");
//		RfidTag rfidTag = RfidTag.create("FF 3C 00 CE 75 CB");
		RfidTag rfidTag = RfidTag.create("3C 00 CE 75 4C CB");
		
	}
	
	@Test
	public void hexToInt() throws Exception {
		assertEquals(RfidTag.hexToInteger('A'), 10);
		Integer.valueOf(RfidTag.hexToInteger('A'));
		System.out.println("int as hex: " + Integer.toHexString(RfidTag.hexToInteger('A')));
		assertEquals(RfidTag.hexToInteger('C'), 12);
		assertEquals(RfidTag.hexToInteger('E'), 14);
		Integer.valueOf(RfidTag.hexToInteger('C'));
		Integer.valueOf(RfidTag.hexToInteger('E'));
		
		
		Integer parseInt = Integer.parseInt("AB", 16);
		System.out.println(parseInt + "   " + Integer.toHexString(parseInt) + "  " + parseInt.byteValue());
		
		System.out.println("".format("0x%x", parseInt.byteValue()));
	}

}
