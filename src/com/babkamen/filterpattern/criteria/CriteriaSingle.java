package com.babkamen.filterpattern.criteria;

import com.babkamen.filterpattern.domain.Person;

import java.util.ArrayList;
import java.util.List;

public class CriteriaSingle implements Criteria {

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> singlePersons = new ArrayList<Person>();

        for (Person person : persons) {
            if(person.getMaritalStatus()== Person.MaritalStatus.SINGLE){
                singlePersons.add(person);
            }
        }
        return singlePersons;
    }
}