package com.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

public class TimeUtilTest {

	@Test
	public void test() {
		Assert.assertEquals(true, TimeUtil.isSameDay(new Date(), new Date()));
		SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
		
		try {
			Date d1=fmt.parse("20190101");
			Date d2=fmt.parse("20120101");
			Assert.assertEquals(false, TimeUtil.isSameDay(d1, d2));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
