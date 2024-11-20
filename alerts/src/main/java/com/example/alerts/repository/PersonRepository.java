package com.example.alerts.repository;

import com.example.alerts.model.Address;
import com.example.alerts.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findPersonByFireStationId(Long fireStationId);
    List<Person> findPersonByAddress(Address address);

    @Query("FROM Person p JOIN p.address a WHERE a.city = ?1")
    List<Person> findPersonByCity(String city);
}
