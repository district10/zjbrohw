package com.tangzhixiong.zjbrohw;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void change_income(Person p, int delta) {
        p.changeIncome(delta);
    }

    public static boolean equal_persons(List<Person> persons) {
        HashSet<String> names = new HashSet<>();
        for (Person person : persons) {
            names.add(person.getName());
        }
        return names.size() != persons.size();
    }
    
    public static int sum_income(List<Person> persons) {
        int sum = 0;
        for (Person person : persons) {
            sum += person.getIncome();
        }
        return sum;
    }

    public static String longest_name(List<Person> persons) {
        String ret = "";
        for (Person person : persons) {
            if (person.getName().length() > ret.length()) {
                ret = person.getName();
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            // System.err.println("Usage: java Admin <NAME> <INCOME>");
            System.out.println("Usage: java Admin <NAME> <INCOME>");
            System.exit(1);
        }
        if (!args[0].equals("Admin")) {
            // java Joe
            // System.err.print("ERROR: You are not an Admin.");
            System.out.print("ERROR: You are not an Admin.");
            System.exit(2);
        }
        if (args.length == 1) {
            // java Admin
            System.out.println(Person.magicString());
            System.exit(0);
        } else if (args.length == 2) {
            // java Admin xyz
            System.out.println(args[1]+ ": 0");
            System.exit(0);
        } else if (args.length == 3) {
            // java Admin xyz 25
            if (Person.processNameIncomePair(args[1], args[2])) {
                System.out.println(
                    Person.persons.get(args[1]).getName() + ": " +
                        Person.persons.get(args[1]).getIncome()
                );
            }
        } else if (args.length == 4) {
            // java Admin xyz 25 98
            if (Person.processNameIncomePair(args[1], args[2])) {
                if (Person.persons.get(args[1]).changeIncome(args[3])) {
                    // a deal
                    System.out.println(
                            Person.persons.get(args[1]).getName() + ": " +
                                    Person.persons.get(args[1]).getIncome()
                    );
                } else {
                    System.out.println("Failure.");
                }
            }
        } else {
            // Admin a 1 b 2 c 3
            // args[1] ~ args[i]
            boolean duplicate = false;
            for (int i = 1; i+1 < args.length; i+=2) {
                if (!Person.processNameIncomePair(args[i], args[i+1])) {
                    duplicate = true;
                }
            }
            // ArrayList<Person> persons = new ArrayList<>(Person.persons.values());
            ArrayList<Person> persons = Person.personsList;

            boolean equalPersons = duplicate; // or `equal_persons(persons)'
            int sumIncome = sum_income(persons);
            String longestName = longest_name(persons);
            System.out.println(equalPersons);
            System.out.println(sumIncome);
            System.out.println(longestName);
        }
    }
}
