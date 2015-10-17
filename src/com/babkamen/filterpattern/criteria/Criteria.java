package com.babkamen.filterpattern.criteria;

import com.babkamen.filterpattern.domain.Person;

import java.util.List;

public interface Criteria {
    public List<Person> meetCriteria(List<Person> persons);
}