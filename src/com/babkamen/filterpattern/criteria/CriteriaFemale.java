package com.babkamen.filterpattern.criteria;

import com.babkamen.filterpattern.domain.Person;

import java.util.ArrayList;
import java.util.List;

public class CriteriaFemale implements Criteria {

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> femalePersons = new ArrayList<Person>();

        for (Person person : persons) {
            if(person.getGender()== Person.Gender.FEMALE){
                femalePersons.add(person);
            }
        }
        return femalePersons;
    }
}