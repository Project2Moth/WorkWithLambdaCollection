package example;

import static java.util.stream.Collectors.joining;

import com.google.gson.Gson;
import example.entity.Person;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Comparator {

  public static void main(String[] args) {
    List<Person> personList = new ArrayList<Person>();
    Person person = new Person("Jack", "Man", 18, "dancer");
    Person person1 = new Person("Hong", "Man", 29, "dancer");
    Person person2 = new Person("Tiffy", "Jean", 40, "singer");
    Person person3 = new Person("Nguyen", "Nghiem", 50, "singer");
    Person person4 = new Person("Tran", "Ha", 21, "singer");
    Collections.addAll(personList, person, person1, person2, person3, person4);

   /* // Sort object theo tuoi
    personList.sort(java.util.Comparator.comparing(Person::getAge));
    for (Person p : personList) {
      System.out.println(p.getLastName());
    }*/

    // Get list by firstName
    List<String> firstNames = personList.stream().map(Person::getFirstName)
        .collect(Collectors.toList());
    for (String str : firstNames) {
      System.out.println(str);
    }

    Set<String> jobSet = personList.stream().map(Person::getJob).collect(Collectors.toSet());

    Map<String, List<Person>> personMapGroup = personList.stream()
        .collect(Collectors.groupingBy(Person::getJob));

    Map<String, String> postsPerType = personList.stream().collect(Collectors.groupingBy(Person::getFirstName,
        Collectors.mapping(Person::getLastName, joining(", ", "Post titles: [", "]"))));

    List<Long> ages = new ArrayList<>();
    Gson gson = new Gson();
    for (String s : jobSet) {
      if (s.equals("dancer")) {
        List<Person> personSort = personMapGroup.get(s);
        for (Person person5 : personSort) {
          String personString = gson.toJson(personSort);
          System.out.println(personString);
        }
      }
    }
  }

}
