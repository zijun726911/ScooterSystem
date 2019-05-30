package com.service.test;

import org.junit.After;
import  org.junit.Assert;

import org.junit.Before;
import org.junit.Test;

import com.entity.Slot;
import com.entity.Station;
import com.model.SlotState;
import com.service.ScooterService;

public class ScooterServiceTest {

	Station station;
	
	@Before
	public void createAfullStation() {
		
		station=new Station("S");
		
		for(int i=0;i<8;i++) {
			
			Slot slot=new Slot(""+(i+1));
			slot.setSlotState(SlotState.LOCK_HAS_SCOOTER);
			station.getSlots().add(slot);
		}
		
		
	}
	
	@Test
	public void testIsAllSlotFull() {
		station.getSlots().get(3).setSlotState(SlotState.LOCK_EMPTY);
		Assert.assertEquals("4",new ScooterService().findEmptySlot(station).getId());
	}
	
	@After
	public void clear() {
		
		station=null;
		
	}
}


















