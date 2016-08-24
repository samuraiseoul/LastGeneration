package person;

/**
 * Created by Jihoon on 6/18/2016.
 */
public abstract class Person {
    protected GenderEnum genderEnum;

    private boolean married;

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

    public boolean canMarry(final Person person) {
        return !this.familyName.equals(person.getFamilyName()) && !this.married;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    @Override
    public String toString() {
        return "person.Person{" +
                "familyName='" + familyName + '\'' +
                '}';
    }
}
