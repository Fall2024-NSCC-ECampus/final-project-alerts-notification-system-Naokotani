package com.example.alerts;


import com.example.alerts.controller.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ControllerBeanTest {
    @Autowired
    private ChildAlertController childAlertController;
    @Autowired
    private CommunityEmailController communityEmailController;
    @Autowired
    private FireController fireController;
    @Autowired
    private FloodController floodController;
    @Autowired
    private PersonInfoController personInfoController;
    @Autowired
    private PhoneAlertController phoneAlertController;
    @Autowired
    private StationController stationController;

    @Test
    void contextLoads() {
        assertThat(childAlertController).isNotNull();
        assertThat(communityEmailController).isNotNull();
        assertThat(fireController).isNotNull();
        assertThat(floodController).isNotNull();
        assertThat(personInfoController).isNotNull();
        assertThat(phoneAlertController).isNotNull();
        assertThat(stationController).isNotNull();
    }
}
