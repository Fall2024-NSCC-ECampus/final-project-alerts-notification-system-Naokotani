package com.example.alerts.service;

import com.example.alerts.dto.child_alert.ChildAlertDto;


public interface ChildAlertService {
    ChildAlertDto getChildAlert(String streetNumber,
                                String street,
                                String city,
                                String province,
                                String postalCode);
}
