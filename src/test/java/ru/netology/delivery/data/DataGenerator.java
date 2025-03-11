package ru.netology.delivery.data;

import com.github.javafaker.Faker;
import lombok.Value;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(int shift) {
        return LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String generateCity() {
        String[] cities = new String[]{"Москва", "Санкт-Петербург", "Казань", "Нижний Новгород", "Новосибирск",
                "Екатеринбург", "Челябинск", "Омск", "Самара",
                "Уфа", "Красноярск", "Пермь", "Воронеж", "Волгоград",
                "Краснодар", "Тюмень", "Ижевск", "Барнаул",
                "Ульяновск", "Иркутск", "Хабаровск", "Владивосток", "Томск", "Оренбург", "Кемерово",
                "Рязань", "Астрахань", "Набережные Челны", "Пенза",
                "Киров", "Тула", "Калининград", "Севастополь", "Сочи", "Тверь", "Брянск", "Владимир"};
        return cities[new Random().nextInt(cities.length)];
    }

    public static String generateName(String locale) {
        Faker faker = new Faker(new Locale(locale));
        return faker.name().lastName() + " " + faker.name().firstName();
    }

    public static String generatePhone(String locale) {
        Faker faker = new Faker(new Locale(locale));
        return faker.phoneNumber().phoneNumber();
    }
        public static class Registration {
            private Registration() {
            }

            public static UserInfo genrateUser(String locale) {
                return new UserInfo(generateCity(), generateName(), generatePhone());
            }

        }
        @Value
        public static class UserInfo {
            String city;
            String name;
            String phone;
        }
    }



