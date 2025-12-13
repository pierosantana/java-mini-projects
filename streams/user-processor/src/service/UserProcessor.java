package service;

import model.Gender;
import model.User;

import java.util.*;
import java.util.stream.Collectors;

public class UserProcessor {

    public UserProcessor() {
    }

    /**
     * Filter users older than 18
     * @param users
     * @return List
     */
    public List<User> filterAdults(List<User> users){
        if(users == null){
            return Collections.emptyList();
        }
            return users.stream()
                    .filter(u -> u.getAge() >= 18)
                    .toList();
    }


    public Map<Gender, List<User>> groupByGender(List<User> users){
        if(users == null){
            return Collections.emptyMap();
        }

        return users.stream()
                .collect(Collectors.groupingBy(User::getGender));
    }


    public OptionalDouble averageAge(List<User> users){

        if(users == null){
            return OptionalDouble.empty();
        }

        return users.stream()
                .mapToInt(User::getAge)
                .average();
    }
}
