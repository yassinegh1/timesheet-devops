package tn.esprit.spring.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.spring.entities.Mission;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MissionApplicationTests {

    private static final Logger l = LogManager.getLogger(MissionApplicationTests.class);

    @Autowired
    TimesheetServiceImpl ds;

    @Test
    public void testAjouterMission() {
        try {

            Mission D = new Mission("hello","hello");

            int Id = ds.ajouterMission(D);
            assertNotNull(Id);
            ds.deleteMissionById(Id);
            l.info("End add Mission test method");
        } catch (NullPointerException e) {
            l.error(e.getMessage());
        }
    }
    @Test
    public void testDeleteMissionById()  {
        l.info("Starting delete Mission test method");
        Mission D = new Mission("youssef","jemjem");
        int Id  = ds.ajouterMission(D);
        l.info("Adding new Mission with id : " + Id);
        Mission Miss = ds.getMissionById(Id);
        assertNotNull(Miss);
        int lengthBeforeDelete = ds.getAllMission(Id).size();
        l.info("Mission with id " + Id + " exists" );
        ds.deleteMissionById(Id);
        assertEquals(lengthBeforeDelete-1 , ds.getAllMission(Id).size());
        l.info("Mission deleted successfuly by id"+ Id);
    }
    @Test
    public void testUpdateMission() {
        try {
            Mission M = new Mission("mission 1","premiere mission");
            int Id = ds.ajouterMission(M);
            M.setName("mission 2");
            ds.ajouterMission(M);
            assertEquals("mission 2", M.getName());
            l.info("End Update Mission test method");
        } catch (NullPointerException e) {
            l.error(e.getMessage());
        }
    }
    @Test
    public void testGetMissionById(){
        l.info("Starting find Mission test method");
        Mission D = new Mission();
        int Id = ds.ajouterMission(D);
        assertNotNull(ds.getMissionById(Id));
        l.info("Mission with id " + Id + " added" );
        Mission Miss = ds.getMissionById(Id);
        assertNotNull(Miss);
        l.info("Mission with id " + Miss.getId() + " found successfully" );
        ds.deleteMissionById(Id);
    }
    @Test
    public void testGetAllMissionById(){
        l.info("Starting find all Mission test method");
        Mission D = new Mission();
        int Id = ds.ajouterMission(D);
        assertNotNull(ds.getMissionById(Id));
        l.info("Mission with id " + Id + " added" );
        List<Mission> Miss = ds.getAllMission(Id);
        assertNotNull(Miss);
        l.info("All missions with Ids " + Miss + " found successfully" );
        ds.deleteMissionById(Id);
    }


}
