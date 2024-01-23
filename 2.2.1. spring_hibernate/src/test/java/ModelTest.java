import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

class ModelTest {
    AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(AppConfig.class);

    UserService userService = context.getBean(UserService.class);

    @Test
    void shouldAddUserWithCar() {


        Car car1 = new Car("BMW", 3);
        Car car2 = new Car("Audi", 4);


        userService.add(new User("User1", "Lastname1", "user1@mail.ru", car1));
        userService.add(new User("User2", "Lastname2", "user2@mail.ru", car2));

    }

    @Test
    void shouldGetUserWithCar() {
        List<User> userList = userService.listUsers();
        System.out.println(userList);
    }

    @Test
    void shouldGetUserByModelAndSeries() {
        User user = userService.getUserByModelAndSeries("BMW", 3);
    }
}
