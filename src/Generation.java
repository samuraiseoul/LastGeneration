import person.GenderEnum;
import person.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Generation {
    private final Map<String , Family> families;

    public Generation() {
        this.families = new HashMap<>();
    }

    public void addFamilyUnit(final FamilyUnit familyUnit) {
        if(!this.families.containsKey(familyUnit.getFamilyName())){
            this.families.put(familyUnit.getFamilyName(), new Family(familyUnit.getFamilyName()));
        }
        this.families.get(familyUnit.getFamilyName()).addFamilyUnit(familyUnit);
    }

    public Map<String, Family> getFamilies() {
        return families;
    }

    public Generation nextGeneration() {
        final Map<GenderEnum, List<Person>> genders = this.getChildrenGenderMap(this.getChildren());

        final GenderEnum leastPlentifulGender = (genders.get(GenderEnum.MALE).size() > genders.get(GenderEnum.FEMALE).size() ? GenderEnum.FEMALE : GenderEnum.MALE);
        final GenderEnum mostPlentifulGender = (genders.get(GenderEnum.MALE).size() > genders.get(GenderEnum.FEMALE).size() ? GenderEnum.MALE : GenderEnum.FEMALE);

        return this.createNextGenerate(genders.get(leastPlentifulGender), genders.get(mostPlentifulGender));
    }

    public void printGenerationStats() {
        int familyUnits = 0;
        int maximumNumberOfFamilyUnits = 1;
        for(final Family family : this.families.values()) {
            familyUnits += family.getFamilyUnits().size();
            if(family.getFamilyUnits().size() > maximumNumberOfFamilyUnits) {
                maximumNumberOfFamilyUnits = family.getFamilyUnits().size();
            }
        }
        double averageFamilyUnits = (double)familyUnits / this.families.size();
        System.out.println("Number of families: " + this.getFamilies().size() + " Average Family Units per Family: " + averageFamilyUnits + " Most Family Units in a Family: " + maximumNumberOfFamilyUnits);
    }

    private List<Person> getChildren() {
        final List<Person> children = new ArrayList<>();

        for(final Family family : this.families.values()) {
            children.addAll(family.getChildren());
        }

        return children;
    }

    private Map<GenderEnum, List<Person>> getChildrenGenderMap(List<Person> children) {
        final Map<GenderEnum, List<Person>> genders = new HashMap<>();
        genders.put(GenderEnum.FEMALE, new ArrayList<>());
        genders.put(GenderEnum.MALE, new ArrayList<>());

        for(final Person person : children) {
            genders.get(person.getGenderEnum()).add(person);
        }
        return genders;
    }

    private Person getSpouse(Person person, List<Person> mostPlentifulGender) {
        for(int i = 0 ; i < mostPlentifulGender.size(); i++) {
            if(person.canMarry(mostPlentifulGender.get(i))) {
                return mostPlentifulGender.get(i);
            }
        }
        return null;
    }

    private Generation createNextGenerate(List<Person> leastPlentifulGender, List<Person> mostPlentifulGender) {
        final Generation nextGeneration = new Generation();

        for(int i = 0; i < leastPlentifulGender.size(); i++) {
            final Person spouse = this.getSpouse(leastPlentifulGender.get(i), mostPlentifulGender);
            if(spouse == null) {
                continue;
            }
            nextGeneration.addFamilyUnit(new FamilyUnit(leastPlentifulGender.get(i), spouse));
        }

        return nextGeneration;
    }
}
