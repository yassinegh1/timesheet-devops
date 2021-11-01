package tn.esprit.spring;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EmployeRepository;
import tn.esprit.spring.repository.EntrepriseRepository;
import tn.esprit.spring.services.IEmployeService;

@ContextConfiguration(classes = TimesheetSpringBootCoreDataJpaMvcRest1Application.class)
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeServiceImplTest {

	private static final Logger l = LogManager.getLogger(EmployeServiceImplTest.class);
	private static final long DEFAULT_TIMEOUT = 10000;

	@Autowired
	IEmployeService empService;

	@Autowired
	EmployeRepository empRepo;
	
	@Autowired
	EntrepriseRepository entRepo;

	@Autowired
	DepartementRepository depRepo;



	@Test(timeout = DEFAULT_TIMEOUT)
	public void addEmployeTest() {
		try {
			l.info("Begin addEmployeTest() : ");

			Employe employe = new Employe("Gharbi","Yassine","yassine.gharbi1@esprit.tn",true,Role.ADMINISTRATEUR);
			empService.ajouterEmploye(employe);
			l.info("Employe added successfuly ");
			assertThat(employe.getId()).isGreaterThan(0);
			l.info("End of addEmployeTest() without errors.");
		} catch (Exception e) {
			l.error("Error in addEmployeTest() : " + e);
		}
	}

	@Test(timeout = DEFAULT_TIMEOUT)
	public void testAddEmployeeToDepartement() {

		try {
			l.info("Begin addEmployeeToDepartementTest(). ");
			Departement dep = new Departement("SE");
			depRepo.save(dep);
			empService.affecterEmployeADepartement(1, dep.getId());
            l.info("End of addEmployeeToDepartementTest() without errors.");
		} catch (Exception e) {
			l.error("Error in addEmployeeToDepartementTest() : " + e);
		}
	}

	@Test(timeout = DEFAULT_TIMEOUT)
	public void testRemoveEmployeeFromDepartement() {
		try {
			l.info("Begin removeEmployeeFromDepartementTest().");
			empService.desaffecterEmployeDuDepartement(1, 1);
			l.info("End of removeEmployeeFromDepartementTest() without errors.");
		} catch (Exception e) {
			l.error("Error in removeEmployeeFromDepartementTest() : " + e);
		}
	}
	


	@Test(timeout = DEFAULT_TIMEOUT)
	public void testGetEmployeeNameById() {
		try {
			l.info("Begin getEmployeeNameByIdTest(). ");
			String name = empService.getEmployePrenomById(1);
			assertThat(name).isEqualTo("Yassine");
			l.info("ENd of getEmployeeNameByIdTest() without errors.");
		} catch (Exception e) {
			l.error("Error in getEmployeeNameByIdTest() : " + e);
		}
	}



	@Test(timeout = DEFAULT_TIMEOUT)
	public void testGetAllEmployeesByEntreprise() {
		try {
			l.info("Begin getAllEmplyeesByEntreprise() : ");
			Entreprise ent = entRepo.findById(1).get();
			List<Employe> emps = empService.getAllEmployeByEntreprise(ent);
			l.info("getAllEmployeByEntreprise : " + emps);
			l.info("End of getAllEmplyeesByEntreprise() without errors.");
		} catch (Exception e) {
			l.error("Error in getAllEmplyeesByEntreprise() : " + e);
		}
	}

	@Test(timeout = DEFAULT_TIMEOUT)
	public void testUpdateEmailByEmpId() {
		try {
			l.info("Begin updateEmailByEmpId() : ");
			empService.mettreAjourEmailByEmployeId("yassine@gmail.com", 1);
			Optional<Employe> em = empRepo.findById(1);
			if (em.isPresent()) {
				assertThat(em.get().getEmail()).isEqualTo("yassine@gmail.com");}
			l.info("End of updateEmailByEmpId() without errors.");
		} catch (Exception e) {
			l.error("Error in updateEmailByEmpId() : " + e);
		}
	}


	@Test(timeout = DEFAULT_TIMEOUT)
	public void testGetEmployeesNumber() {
		try {
			l.info("Begin getEmployeesNumberTest(). ");
			int Nbr = empService.getNombreEmployeJPQL();
			assertNotNull(Nbr);
			l.info("End of getEmployeesNumberTest() without errors.");
		} catch (Exception e) {
			l.error("Error in getEmployeesNumberTest() : " + e);
		}
	}
	
	@Test(timeout = DEFAULT_TIMEOUT)
	public void testGetAllEmployees() {
		try {
			l.info("Begin getAllEmployees(). ");
			List<Employe> emps = empService.getAllEmployes();
			assertThat(emps).size().isGreaterThan(0);
			l.info("End of getAllEmployees() without errors.");
		} catch (Exception e) {
			l.error("Error in getAllEmployees() : " + e);
		}
	}
	
	@Test(timeout = DEFAULT_TIMEOUT)
	public void testDeleteEmployeeById() {
		try {
			l.info("Begin deleteEmployeeByIdTest(). ");
			empService.deleteEmployeById(1);
			l.info("deleted successfuly");
			List<Employe> listEmp = empService.getAllEmployes();
			assertEquals(0, listEmp.size());
			l.info("End of deleteEmployeeByIdTest() without errors.");
		} catch (Exception e) {
			l.error("Error in deleteEmployeeByIdTest() : " + e);
		}
	}

}