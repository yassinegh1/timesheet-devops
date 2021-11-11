package tn.esprit.spring.Bus;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Bus;
import tn.esprit.spring.services.BusServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BusApplicationTests {
	
	private static final Logger l = LogManager.getLogger(BusApplicationTests.class);
	
	@Autowired
	BusServiceImpl BS;
	
	@Test
	public void testAjouterBus() {
		try {
		Bus B = new Bus("Raoued", LocalTime.of(8,30,00), LocalTime.of(17,30,00));
		BS.ajouterBus(B);
		Long BusId = B.getId();
		assertNotNull(BusId);
		BS.deleteBus(BusId);
		l.info("End add Bus test method");
		} catch (NullPointerException e) {
			l.error(e.getMessage());
		}
	}
	
	@Test
	public void testUpdateBus() {
		try {
		Bus B = new Bus("Raoued", LocalTime.of(8,30,00), LocalTime.of(17,30,00));
		BS.ajouterBus(B);
		
		B.setDestination("Ben Arous");
		BS.ajouterBus(B);
		
		assertEquals("Ben Arous", B.getDestination());
		l.info("End Update Bus test method");
		} catch (NullPointerException e) {
			l.error(e.getMessage());
		}
	}
	
	@Test(timeout = 2500)
	public void testDeleteBusById()  {
		l.info("Starting delete Bus test method");
		Bus B = new Bus("Raoued", LocalTime.of(8,30,00), LocalTime.of(17,30,00));
		BS.ajouterBus(B);
		
		l.info("Adding new Bus with id : " + B.getId());
		
		Bus bus = BS.getBusByID(B.getId());
		assertNotNull(bus);
		int lengthBeforeDelete = BS.getAllBus().size();
		l.info("Department with id " + B.getId() + " exists" );
		BS.deleteBus(B.getId());
		assertEquals(lengthBeforeDelete-1 , BS.getAllBus().size());
		l.info("Bus with id: "+ B.getId() +" deleted successfuly");
	}
	
	@Test
	public void testGetBusByDestination(){
		l.info("Starting find Bus test method");
		Bus B = new Bus("Raoued", LocalTime.of(8,30,00), LocalTime.of(17,30,00));
		BS.ajouterBus(B);
		
		assertNotNull(BS.getBusByID(B.getId()));
		l.info("Bus with id " + B.getId() + " added" );
		
		Bus existingBus = BS.getBusByDestination(B.getDestination());
		assertNotNull(existingBus);	
		l.info("Bus with Destination " + existingBus.getDestination() + " found successfully" );
		BS.deleteBus(existingBus.getId());
		}
}
