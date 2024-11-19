package com.example.alerts;

import com.example.alerts.model.*;
import com.example.alerts.repository.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.HashSet;
import java.util.Set;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PersonInfoControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    PersonRepository personRepository;
    Person person = new Person();
    Address address = new Address();
    Medication medication = new Medication();
    Allergy allergy = new Allergy();
    FireStation fireStation = new FireStation();

    /**
     * Creates all the entities needed for the test
     */
    public PersonInfoControllerTest() {
        fireStation.setCommunity("Post Hastings");
        person.setFireStation(fireStation);

        // Set allergies
        allergy.setName("peanuts");
        Set<Allergy> allergies = new HashSet<>();
        allergies.add(allergy);
        person.setAllergy(allergies);

        // Set medications
        medication.setName("Tylenol");
        medication.setDosage("3 a day");

        Set<Medication> medications = new HashSet<>();
        medications.add(medication);

        person.setMedication(medications);

        // Set Address
        address.setStreet("Nscc Way.");
        address.setCity("Port Hawksbury");
        address.setProvince("Nova scotia");
        address.setPostalCode("B0B 1X6");
        address.setStreetNumber("387");

        // Set personal info
        person.setFirstName("John");
        person.setLastName("Doe");
        person.setEmail("john.doe@gmail.com");
        person.setPhone("123456789");
        person.setAge(21);
        person.setAddress(address);
    }

    /**
     * This method runs before each test. It deletes teh db and then saves the person.
     * This way the db is always in a state read for use before the test/s run.
     * @throws IllegalAccessError It sure does, idk why it would buy it does!
     */
    @BeforeEach
    void setup() throws IllegalAccessError {
        personRepository.deleteAll();
        personRepository.save(person);
    }

    /**
     * This is what actually hits the controller and checks the result
     * @throws Exception Not sure. Maybe if there is an exception in the controller?
     */
    @Test
    void personController() throws Exception {
        ResultActions result = mockMvc.perform(get("/personInfo"));
        result.andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))

                //Personal info
                .andExpect(jsonPath("$[0].firstName").value(person.getFirstName()))
                .andExpect(jsonPath("$[0].lastName").value(person.getLastName()))
                .andExpect(jsonPath("$[0].email").value(person.getEmail()))
                .andExpect(jsonPath("$[0].phone").value(person.getPhone()))

                // Address
                .andExpect(jsonPath("$[0].address.street").value(address.getStreet()))
                .andExpect(jsonPath("$[0].address.city").value(address.getCity()))
                .andExpect(jsonPath("$[0].address.province").value(address.getProvince()))
                .andExpect(jsonPath("$[0].address.postalCode").value(address.getPostalCode()))
                .andExpect(jsonPath("$[0].address.streetNumber").value(address.getStreetNumber()))

                // Fire Station
                .andExpect(jsonPath("$[0].fireStation.community").value(fireStation.getCommunity()))

                // Medications
                .andExpect(jsonPath("$[0].medication[0].name").value(medication.getName()))
                .andExpect(jsonPath("$[0].medication[0].dosage").value(medication.getDosage()))

                // Allergies
                .andExpect(jsonPath("$[0].allergy[0].name").value(allergy.getName()));
    }
}
