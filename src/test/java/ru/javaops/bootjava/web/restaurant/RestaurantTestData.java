package ru.javaops.bootjava.web.restaurant;

import ru.javaops.bootjava.model.Restaurant;
import ru.javaops.bootjava.web.MatcherFactory;

import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static java.time.LocalDateTime.of;

public class RestaurantTestData {
    public static final MatcherFactory.Matcher<Restaurant> RESTAURANT_MATCHER = MatcherFactory.usingEqualsComparator(Restaurant.class);

    public static final int RESTAURANT1_ID = 1;
    public static final int NOTFOUND_ID = 100;

    public static final Restaurant restaurant1 = new Restaurant(RESTAURANT1_ID, "Дядя Ваня", of(2023, Month.JUNE, 30, 6, 0));
    public static final Restaurant restaurant2 = new Restaurant(RESTAURANT1_ID + 1, "Суши-роллы", of(2023, Month.JUNE, 30, 7, 0));
    public static final Restaurant restaurant3 = new Restaurant(RESTAURANT1_ID + 2, "Пануччи", of(2023, Month.JUNE, 30, 8, 0));

    public static final List<Restaurant> restaurants = List.of(restaurant3, restaurant2, restaurant1);

    public static Restaurant getNew() {
        return new Restaurant(null,"Невкусно и грустно", of(2023, Month.JUNE, 30, 9, 0));
    }

    public static Restaurant getUpdated() {
        return new Restaurant(RESTAURANT1_ID,"Баба Клава", restaurant1.getDateTime().plus(2, ChronoUnit.MINUTES));
    }

}
