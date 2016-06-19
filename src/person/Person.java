package person;

/**
 * Created by Jihoon on 6/18/2016.
 */
public abstract class Person {
    protected GenderEnum genderEnum;

    private String familyName;

    public Person(String familyName, final GenderEnum genderEnum) {
        this.familyName = familyName;
        this.genderEnum = genderEnum;
    }

    public GenderEnum getGenderEnum() {
        return genderEnum;
    }

    public String getFamilyName() {
        return familyName;
    }

    @Override
    public String toString() {
        return "person.Person{" +
                "familyName='" + familyName + '\'' +
                '}';
    }
}
