package ru.javaops.bootjava.web.dish;

import ru.javaops.bootjava.model.Dish;
import ru.javaops.bootjava.web.MatcherFactory;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static ru.javaops.bootjava.web.restaurant.RestaurantTestData.RESTAURANT1_ID;

public class DishTestData {
    public static final MatcherFactory.Matcher<Dish> DISH_MATCHER = MatcherFactory.usingEqualsComparator(Dish.class);

    public static final int DISH1_ID = 1;
    public static final int NOTFOUND_ID = 100;

    public static final Dish dish1 = new Dish(DISH1_ID, RESTAURANT1_ID,  "Пельмени", LocalDate.now(), new BigDecimal(500));
    public static final Dish dish2 = new Dish(DISH1_ID + 1, RESTAURANT1_ID, "Блины", LocalDate.now(), new BigDecimal(500));
    public static final Dish dish3 = new Dish(DISH1_ID + 2, RESTAURANT1_ID, "Чай", LocalDate.now(), new BigDecimal(100));

    public static final Dish dish4 = new Dish(DISH1_ID + 3, RESTAURANT1_ID + 1, "Филадельфия ролл", LocalDate.now(),new BigDecimal(800));
    public static final Dish dish5 = new Dish(DISH1_ID + 4, RESTAURANT1_ID + 1, "Калифорния ролл", LocalDate.now(), new BigDecimal(700));
    public static final Dish dish6 = new Dish(DISH1_ID + 5, RESTAURANT1_ID + 1, "Сакэ", LocalDate.now(), new BigDecimal(500));

    public static final Dish dish7 = new Dish(DISH1_ID + 6, RESTAURANT1_ID + 2, "Маргарита пицца", LocalDate.now(),new BigDecimal(800));
    public static final Dish dish8 = new Dish(DISH1_ID + 7, RESTAURANT1_ID + 2, "Паста Карбонара", LocalDate.now(), new BigDecimal(500));
    public static final Dish dish9 = new Dish(DISH1_ID + 8, RESTAURANT1_ID + 2, "Каппучино", LocalDate.now(), new BigDecimal(200));


    public static final List<Dish> dishes = List.of(dish9, dish8, dish7, dish6, dish5, dish4, dish3, dish2, dish1);

    public static Dish getNew() {
        return new Dish(null, RESTAURANT1_ID,"Еда", LocalDate.now(),  new BigDecimal(800));
    }

    public static Dish getUpdated() {
        return new Dish(DISH1_ID, RESTAURANT1_ID,"Другая еда", dish1.getDate().plus(2, ChronoUnit.DAYS), new BigDecimal(900));
    }

}
