package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args){
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      CarService carService = context.getBean(CarService.class);

      User user1 = new User("User1", "Lastname1", "user1@mail.ru");
      userService.add(user1);
      Car car1 = new Car("car1", 3586);
      user1.setCar(car1);
      car1.setUser(user1);
      carService.add(car1);

      User user2 = new User("User2", "Lastname2", "user2@mail.ru");
      userService.add(user2);
      Car car2 = new Car("car2", 9158);
      user2.setCar(car2);
      car2.setUser(user2);
      carService.add(car2);

      User user3 = new User("User3", "Lastname3", "user3@mail.ru");
      userService.add(user3);
      Car car3 = new Car("car3", 1232);
      car3.setUser(user3);
      user3.setCar(car3);
      carService.add(car3);

      User user4 = new User("User4", "Lastname4", "user4@mail.ru");
      userService.add(user4);
      Car car4 = new Car("car4", 9242);
      car4.setUser(user4);
      user4.setCar(car4);
      carService.add(car4);

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println(user.getCar());
         System.out.println();
      }

      List<Car> cars = carService.listCars();
      for (Car car : cars) {
         System.out.println("Model = "+car.getModel());
         System.out.println("Series = "+car.getSeries());
         System.out.println(car.getUser());
         System.out.println();
      }
      System.out.println(carService.getUserByCar("car1", 3586));

      context.close();
   }
}
