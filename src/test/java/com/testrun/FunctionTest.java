package com.testrun;

import org.testng.annotations.Test;

import com.webtable.PremierLeagaueTable;

public class FunctionTest {
	
	@Test
	public void getWebTable() {
		PremierLeagaueTable obj = new PremierLeagaueTable();
		obj.getDataFromWebTable();
		
	}

}
