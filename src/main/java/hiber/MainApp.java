package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

//      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
//      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
//      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
//      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

      User user1 = new User();
      user1.setFirstName("User1");
      user1.setLastName("Lastname1");
      user1.setEmail("user1@mail.ru");
      Car car1 = new Car();
      car1.setModel("Car1");
      car1.setSeries(911);
      user1.setCar(car1);
      car1.setUser(user1);
      User user2 = new User();
      user2.setFirstName("User2");
      user2.setLastName("Lastname2");
      user2.setEmail("user2@mail.ru");
      Car car2 = new Car();
      car2.setModel("Car2");
      car2.setSeries(412);
      user2.setCar(car2);
      car2.setUser(user2);

      userService.add(user1);
      userService.add(user2);

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car Name = "+user.getCar().getModel());
         System.out.println("Car Series = "+user.getCar().getSeries());
         System.out.println();
      }

      context.close();
   }
}
