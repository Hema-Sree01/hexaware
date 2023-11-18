package com.hexaware.medicalbillingsystems.test;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.medicalbillingsystems.dto.PatientsDTO;
import com.hexaware.medicalbillingsystems.entities.Patients;
import com.hexaware.medicalbillingsystems.service.PatientsServiceImp;

@SpringBootTest
public class PatientsServiceTest {

    @Autowired
    private PatientsServiceImp patientService;

    @Test
    public void testAddPatient() {
        PatientsDTO patientDto = new PatientsDTO("", "", "password123");
        patientService.addPatients(patientDto);
        assertNotNull(patientDto.getId());
    }

    @Test
    public void testUpdatePatient() {
        PatientsDTO patientDto = new PatientsDTO("", "", "password456");
        patientService.addPatient(patientDto);

       
        patientDto.setEmail("jane.updated@example.com");
        patientService.updatePatient(patientDto);

        Patients updatedPatient = patientService.getPatientById(patientDto.getId());
        assertEquals("jane.updated@example.com", updatedPatient.getPatientEmail());
    }

    @Test
    public void testDeletePatient() {
        PatientDTO patientDto = new PatientDTO("", "", "password789");
        patientService.addPatient(patientDto);

        Long patientId = patientDto.getId();
        patientService.deletePatient(patientId);

        Patients deletedPatient = patientService.getPatientById(patientId);
        assertNull(deletedPatient);
    }

    @Test
    public void testGetPatientByName() {
        PatientsDTO patientDto = new PatientsDTO("", "", "passwordABC");
        patientService.addPatient(patientDto);

        String patientName = patientDto.getPatientName();
        Patients foundPatient = patientService.getPatientByName(patientName);
        assertNotNull(foundPatient);
        assertEquals(patientName, foundPatient.getPatientName());
    }

    @Test
    public void testGetAllPatients() {
        PatientsDTO patient1 = new PatientsDTO("", "", "passwordXYZ");
        PatientsDTO patient2 = new PatientsDTO("", "", "password456");

        patientService.addPatients(patient1);
        patientService.addPatients(patient2);

        List<Patients> patients = patientService.getAllPatients();
        assertEquals(2, patients.size());
    }

    @Test
    public void testLoginPatient() {
        PatientsDTO patientDto = new PatientsDTO("", "", "securePassword");
        patientService.addPatients(patientDto);

        String email = patientDto.getPatientEmail();
        String password = patientDto.getPatientPassword();
        Patients loggedInPatient = patientService.loginPatient(email, password);

        assertNotNull(loggedInPatient);
        assertEquals(email, loggedInPatient.getPatientEmail());
    }
}
