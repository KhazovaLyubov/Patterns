package ru.netology;


import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
public class CardDeliveryOrder {
    private final String city;
    private final String name;
    private final String phoneNumber;
}

