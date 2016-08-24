import person.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by scott on 8/23/16.
 */
public class Family {
    private String familyName;
    private List<FamilyUnit> familyUnits = new ArrayList<>();

    public Family(String familyName) {
        this.familyName = familyName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public Family addFamilyUnit(final FamilyUnit familyUnit) {
        this.familyUnits.add(familyUnit);
        return this;
    }

    public List<Person> getChildren() {
        final List<Person> children = new ArrayList<>();
        for(final FamilyUnit familyUnit : this.familyUnits) {
            children.addAll(familyUnit.getChildren());
        }
        return children;
    }

    public List<FamilyUnit> getFamilyUnits() {
        return familyUnits;
    }
}
