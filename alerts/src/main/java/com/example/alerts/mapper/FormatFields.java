package com.example.alerts.mapper;

import com.example.alerts.model.Person;

public class FormatFields {
    public static String formatAddrss(Person p) {
        return p.getAddress().getStreetNumber() + ' ' +
                p.getAddress().getStreet() + ' ' +
                p.getAddress().getCity()+ ", " +
                p.getAddress().getProvince() + ", " +
                p.getAddress().getPostalCode();
    }
}
