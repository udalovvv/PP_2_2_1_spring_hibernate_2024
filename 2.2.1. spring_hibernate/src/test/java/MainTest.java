import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class MainTest {

    AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(AppConfig.class);

    UserService userService = context.getBean(UserService.class);

    @Test
    void shouldAddUserWithCarAndReturnUserByModelAndSeries() {

        try {
            Car car1 = new Car("BMW", 3);
            Car car2 = new Car("Audi", 4);

            userService.add(new User("User1", "Lastname1", "user1@mail.ru", car1));
            userService.add(new User("User2", "Lastname2", "user2@mail.ru", car2));
        } catch (Exception e) {
            Assertions.fail("Во время добавления пользователя произошло исключение " + e);
        }



        User user = userService.getUserByModelAndSeries("BMW", 3);

        if (!user.getCar().getModel().equals("BMW") | user.getCar().getSeries() != 3) {
            Assertions.fail("Получен некорректный пользователь");
        }

    }
}
