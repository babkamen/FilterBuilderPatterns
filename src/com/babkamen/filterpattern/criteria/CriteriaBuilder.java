package com.babkamen.filterpattern.criteria;

import com.babkamen.filterpattern.domain.Person;

import java.util.ArrayList;
import java.util.List;

public class CriteriaBuilder {

    private List<Criteria> criterias = new ArrayList<>();
    private boolean usedOr = false;

    public CriteriaBuilder and() {
        return this;
    }

    public void clear() {
        criterias.clear();
    }

    public CriteriaBuilder or() throws Exception {
        if (criterias.size() < 1) {
            throw new Exception("Please specify criteria before or");
        }
        usedOr = true;
        return this;
    }


    private void addCreteria(Criteria c) throws Exception {
        if (c instanceof OrCriteria) {
            throw new Exception("Please use or() instead adding OrCriteria to "+CriteriaBuilder.class.getName());
        }
        if (usedOr) {
            Criteria lastCriteria = criterias.get(criterias.size() - 1);
            criterias.remove(lastCriteria);
            c = new OrCriteria(lastCriteria, c);
            usedOr=false;
        }
        criterias.add(c);
    }

    public CriteriaBuilder single() throws Exception {
        addCreteria(new CriteriaSingle());
        return this;
    }

    public CriteriaBuilder male() throws Exception {
        addCreteria(new CriteriaMale());
        return this;
    }

    public CriteriaBuilder female() throws Exception {
        addCreteria(new CriteriaFemale());
        return this;
    }

    public List<Person> filter(List<Person> persons) {
        for (Criteria c : criterias) {
            persons = c.meetCriteria(persons);
        }
        return persons;
    }
}
