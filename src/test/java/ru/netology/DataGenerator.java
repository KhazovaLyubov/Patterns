package ru.netology;

import com.github.javafaker.Faker;
import lombok.Data;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Random;

@Data
public class DataGenerator {
    private DataGenerator() {
    }

    public static class GenerateObjects {
        private GenerateObjects() {
        }

        public static CardDeliveryOrder generateCardowner(String locale) {
            Faker faker = new Faker(new Locale("ru"));
            return new CardDeliveryOrder(
                    generateCity(),
                    faker.name().lastName() + " " + faker.name().firstName(),
                    faker.phoneNumber().phoneNumber()
            );
        }
    }

    public static String generateDateOfMeeting(int plusDays) {
        LocalDate date1 = LocalDate.now().plusDays(plusDays);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return date1.format(formatter);
    }

    public static String generateCity() {
        Random random = new Random();
        List<String> cityValid = Arrays.asList("Москва", "Санкт-Петербург", "Новосибирск", "Екатеринбург", "Казань", "Нижний Новгород", "Челябинск", "Самара", "Калининград");
        String city = cityValid.get(random.nextInt(cityValid.size()));
        return city;
    }
}