package com.example.alerts.repository;

import com.example.alerts.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
    Address findAddressBystreetNumberAndStreetAndCityAndProvinceAndPostalCode(String streetNumber,
                                                                                        String street,
                                                                                        String city,
                                                                                        String province,
                                                                                        String postalCode
    );

}
