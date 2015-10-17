package com.babkamen.filterpattern;

import com.babkamen.filterpattern.criteria.*;
import com.babkamen.filterpattern.domain.Person;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        List<Person> persons = new ArrayList<Person>();

        persons.add(new Person("Robert", Person.Gender.MALE, Person.MaritalStatus.SINGLE));
        persons.add(new Person("John", Person.Gender.MALE, Person.MaritalStatus.MARRIED));
        persons.add(new Person("Laura", Person.Gender.FEMALE, Person.MaritalStatus.MARRIED));
        persons.add(new Person("Diana", Person.Gender.FEMALE, Person.MaritalStatus.SINGLE));
        persons.add(new Person("Mike", Person.Gender.MALE, Person.MaritalStatus.SINGLE));
        persons.add(new Person("Bobby", Person.Gender.MALE, Person.MaritalStatus.SINGLE));

        CriteriaBuilder criteriaBuilder = new CriteriaBuilder();
        System.out.println("Males:\n" + formatPersons(criteriaBuilder.male().filter(persons)));
        criteriaBuilder.clear();
        System.out.println("Female: \n" + formatPersons(criteriaBuilder.female().filter(persons)));
        criteriaBuilder.clear();
        System.out.println("Single male: \n" + formatPersons(criteriaBuilder.male().and().single().filter(persons)));
        criteriaBuilder.clear();
        System.out.println("Male Or Females: \n" + formatPersons(criteriaBuilder.male().or().female().filter(persons)));
    }

    private static String formatPersons(List<Person> persons) {
        StringBuilder sb=new StringBuilder();
        for(Person p:persons) {
            sb.append(p).append("\n");
        }
        return sb.toString();
    }

}