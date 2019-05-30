package com.service.test;

import org.junit.After;
import  org.junit.Assert;

import org.junit.Before;
import org.junit.Test;

import com.entity.Slot;
import com.entity.Station;
import com.model.SlotState;
import com.service.ScooterService;

public class StationServiceTest {
	Station stationFull;
	Station stationNotFull;
	
	@Before
	public void createAfullStation() {
		stationFull=new Station("full");
		stationNotFull=new Station("notFull");
		
		for(int i=0;i<8;i++) {
			Slot slot1=new Slot(""+(i+1));
			slot1.setSlotState(SlotState.LOCK_HAS_SCOOTER);
			stationFull.getSlots().add(slot1);
			
			Slot slot2=new Slot(""+(i+1));
			slot2.setSlotState(SlotState.LOCK_HAS_SCOOTER);
			stationNotFull.getSlots().add(slot2);
		}
		
		stationNotFull.getSlots().get(0).setSlotState(SlotState.LOCK_EMPTY);
	}
	
	@Test
	public void testIsAllSlotFull() {
		Assert.assertEquals(true,new ScooterService().isAllSlotFull(stationFull));
		Assert.assertEquals(false, new ScooterService().isAllSlotFull(stationNotFull));
	}
	
	@After
	public void clear() {
		
		stationFull=null;
		stationNotFull=null;
		
	}
}


















