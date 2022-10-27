package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.CarServiceImp;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      CarService carService = context.getBean(CarService.class);

      carService.add(new Car("Audi",7980));
      carService.add(new Car("Porsh",5628));
      carService.add(new Car("BMW",2912));
      carService.add(new Car("Mazda",8117));

      List<Car> cars = carService.listCars();

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru",cars.get(0)));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru",cars.get(1)));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru",cars.get(2)));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru",cars.get(3)));


      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println(user.toString());
      }

      User ownerOfCar1 = carService.findByCar("Porsh",5628);
      System.out.println("The owner of Porsh 5628 is "+ ownerOfCar1.fioUser());
      context.close();
   }
}
