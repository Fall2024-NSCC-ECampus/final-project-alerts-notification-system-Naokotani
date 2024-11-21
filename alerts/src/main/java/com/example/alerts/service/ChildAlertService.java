package com.example.alerts.service;

import com.example.alerts.dto.child_alert.ChildAlertDto;
import org.springframework.stereotype.Service;

public interface ChildAlertService {
    ChildAlertDto getChildAlert(String streetNumber,
                                String street,
                                String city,
                                String province,
                                String postalCode);
}
