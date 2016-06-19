import person.GenderEnum;
import person.Person;
import person.PersonFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Jihoon on 6/18/2016.
 */
public class Family {

    private static final int CHILDREN_MAX = 4;

    private static final Random RANDOM = new Random();

    private Person father;

    private Person mother;

    private int numberOfMales = 0;

    private int numberOfFemales = 0;

    private int numberOfChildren;

    private boolean continuing;

    private List<Person> children = new ArrayList<>();

    public Family(final String familyName) {
        this(PersonFactory.male(familyName), PersonFactory.female(familyName));
    }

    public Family(Person father, Person mother) {
        this.father = father;
        this.mother = mother;

        this.createChildren();

        this.generateStats();
    }

    private void generateStats() {
        for(Person person : this.children) {
            if (person.getGenderEnum() == GenderEnum.MALE) {
                this.numberOfMales++;
            } else {
                this.numberOfFemales++;
            }
        }
        this.numberOfChildren = this.numberOfMales + this.numberOfFemales;
        this.continuing = this.numberOfMales > 1;
    }

    private void createChildren() {
        for(int i = 0 ; i < Family.RANDOM.nextInt(Family.CHILDREN_MAX + 1) ; i++) {
            this.children.add(PersonFactory.randomSex(this.father.getFamilyName()));
        }
    }

    public int getNumberOfMales() {
        return numberOfMales;
    }

    public int getNumberOfFemales() {
        return numberOfFemales;
    }

    public int getNumberOfChildren() {
        return numberOfChildren;
    }

    public boolean isContinuing() {
        return continuing;
    }

    @Override
    public String toString() {
        String returnString = this.father.getFamilyName();
        for(int i = returnString.length() ; i < 22 ; i++) {
            returnString += " ";
        }
        returnString += this.children.size();
        for(int i = returnString.length() ; i < 32 ; i++) {
            returnString += " ";
        }
        returnString += this.numberOfMales + "     " + this.numberOfFemales + "       " + ((this.continuing) ? "Yes" : "No");
        return returnString;
    }

    public List<Person> getChildren() {
        return this.children;
    }
}
