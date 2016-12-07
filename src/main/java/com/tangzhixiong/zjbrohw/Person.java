package com.tangzhixiong.zjbrohw;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by tzx on 2016/12/7.
 */
public class Person {
    public static String magicString() { return "ephXdT3tie"; }
    public static HashMap<String, Person> persons = new HashMap<>();
    public static ArrayList<Person> personsList = new ArrayList<>();

    public static boolean processNameIncomePair(String name, String income) throws NumberFormatException {
        int i = 0;
        try {
            i = Integer.valueOf(income);
        } catch (NumberFormatException e) {
            i = 0;
            throw new NumberFormatException();
        } finally {
            return processNameIncomePair(name, i);
        }
    }

    public static boolean processNameIncomePair(String name, int income) {
        if (persons.containsKey(name)) {
            persons.get(name).changeIncome(income);
            return false; // no new person
        } else {
            Person p = new Person(name, income);
            persons.put(name, p);
            personsList.add(p);
            return true; // created a new person
        }
    }

    // personal
    private String name; // name is not mutable
    private int income = 0;

    private Person() { }
    public Person(String name, int income){
        if (income < 0) { income = 0; }
        this.name = name;
        this.income = income;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object rhs) {
        if (rhs == null) {
            return false;
        }
        if (!Person.class.isAssignableFrom(rhs.getClass())) {
            return false;
        }
        final Person p = (Person)rhs;
        if (!this.getName().equals(p.getName())) {
            return false;
        }
        return true;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public boolean changeIncome(int delta) {
        Long num = Long.valueOf(this.income);
        num += Long.valueOf(delta);
        if (num > Integer.MAX_VALUE || num < Integer.MIN_VALUE) {
            return false;
        }
        this.income += delta;
        if (this.income < 0) {
            this.income = 0;
        }
        return true;
    }

    public boolean changeIncome(String delta) throws NumberFormatException {
        boolean deal = true;
        int d = 0;
        try {
            d = Integer.valueOf(delta);
        } catch (NumberFormatException e) {
            d = 0;
            deal = false;
            throw new NumberFormatException();
        } finally {
            return deal && changeIncome(d);
        }
    }
}
