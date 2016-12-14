import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Admin {
    public static void main(final String[] args) {
        Integer i = 5;
        if (args.length == 0) {
            // java Admin
            System.out.println(Person.message);
        } else if (args.length == 1) {
            // java Admin xyz
            final Person p = new Person(args[0]);
            System.out.println(p);
        } else if (args.length == 2) {
            // java Admin xyz 25
            final Person p = new Person(args[0], Integer.valueOf(args[1]));
            System.out.println(p);
        } else if (args.length == 3) {
            // java Admin xyz 25 98
            final Person p = new Person(args[0], Integer.valueOf(args[1]));
            if (change_income(p, Integer.valueOf(args[2]))) {
                System.out.println(p);
            } else {
                System.out.println("Failure.");
            }
        } else {
            // java Admin a 1 b 2 c 3
            // args[1] ~ args[i]
            ArrayList<Person> persons = new ArrayList<Person>();
            for (int j=0; j+1 < args.length; j+=2) {
                persons.add( new Person(args[j], Integer.valueOf(args[j+1])) );
            }
            boolean equalPersons = equal_persons(persons);
            int sumIncome = sum_income(persons);
            String longestName = longest_name(persons);
            System.out.println(equalPersons);
            System.out.println(sumIncome);
            System.out.println(longestName);
        }
    }

    public static boolean change_income(final Person p, int delta) {
        if (delta > 0) {
            return p.increase(delta);
        } else {
            return p.decrease(-delta);
        }
    }

    public static boolean equal_persons(List<Person> persons) {
        HashSet<String> names = new HashSet<String>();
        for (Person person : persons) {
            names.add(person.name);
        }
        return names.size() != persons.size();
    }

    public static int sum_income(List<Person> persons) {
        int sum = 0;
        for (Person person : persons) {
            sum += person.income();
        }
        return sum;
    }

    public static String longest_name(List<Person> persons) {
        String ret = "";
        for (Person person : persons) {
            if (person.name.length() > ret.length()) {
                ret = person.name;
            }
        }
        return ret;
    }
}
