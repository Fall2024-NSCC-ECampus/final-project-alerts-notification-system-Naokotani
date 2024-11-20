package com.example.alerts.repository;

import com.example.alerts.model.Address;
import com.example.alerts.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findPersonByFireStationId(Long fireStationId);
//    @Query("FROM Person" +
//            " p WHERE p.address.streetNumber" +
//            " = ?1 AND p.address.street = ?2 AND p.address.city = ?3" +
//            "AND p.address.province = ?4 AND p.address.postalCode = ?5")
//    List<Person> findPersonByAddress(String streetNumber,
//                                     String street,
//                                     String city,
//                                     String province,
//                                     String postalCode);
    List<Person> findPersonByAddress(Address address);
}
