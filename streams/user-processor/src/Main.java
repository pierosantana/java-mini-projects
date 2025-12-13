import model.Gender;
import model.User;
import service.UserProcessor;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        List<User> users = new ArrayList<User>();

        User u1 = new User("Piero", 32, Gender.MALE);
        User u2 = new User("Isabel", 18, Gender.FEMALE);
        User u3 = new User("Lupe", 26, Gender.OTHER);
        User u4 = new User("Diego", 16, Gender.MALE);
        User u5 = new User("Ross", 14, Gender.FEMALE);
        User u6 = new User("Candas", 21, Gender.MALE);

        users.add(u1);
        users.add(u2);
        users.add(u3);
        users.add(u4);
        users.add(u5);
        users.add(u6);

        UserProcessor usPro = new UserProcessor();

        System.out.println(usPro.filterAdults(users));

        System.out.println(usPro.groupByGender(users));

        System.out.println(usPro.averageAge(users));





    }
}