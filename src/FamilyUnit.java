import person.Person;
import person.PersonFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Jihoon on 6/18/2016.
 */
public class FamilyUnit {

    private static final int CHILDREN_MAX = 4;

    private static final Random RANDOM = new Random();

    private Person father;

    private Person mother;

    private List<Person> children = new ArrayList<>();

    public FamilyUnit(final String familyName) {
        this(PersonFactory.male(familyName), PersonFactory.female(familyName));
    }

    public FamilyUnit(Person father, Person mother) {
        this.father = father;
        this.mother = mother;

        this.createChildren();
    }

    private void createChildren() {
        for(int i = 0; i < FamilyUnit.RANDOM.nextInt(FamilyUnit.CHILDREN_MAX + 1) ; i++) {
            this.children.add(PersonFactory.randomSex(this.father.getFamilyName()));
        }
    }

    public List<Person> getChildren() {
        return children;
    }

    public String getFamilyName() {
        return this.father.getFamilyName();
    }
}
