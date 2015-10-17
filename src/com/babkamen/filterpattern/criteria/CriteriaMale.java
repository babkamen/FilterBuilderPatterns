package com.babkamen.filterpattern.criteria;

import com.babkamen.filterpattern.domain.Person;

import java.util.ArrayList;
import java.util.List;

public class CriteriaMale implements Criteria {

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> malePersons = new ArrayList<Person>();

        for (Person person : persons) {
            if(person.getGender()== Person.Gender.MALE){
                malePersons.add(person);
            }
        }
        return malePersons;
    }
}