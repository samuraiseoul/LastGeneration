import person.GenderEnum;
import person.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jihoon on 6/18/2016.
 */
public class Generation {
    private final List<Family> families;
    private int numberOfMales = 0;
    private int numberOfFemales = 0;
    private int numberOfChildren = 0;
    private double averageNumberOfChildren;
    private double percentMale;
    private double percentFemale;
    private int familiesContinuing;
    private int familiesNotContinuing;
    private double percentContinuing;
    private double percentNotContinuing;


    public Generation() {
        this.families = new ArrayList<>();
    }

    public final void addFamily(final Family family) {
        this.families.add(family);
    }

    private void generateStats() {
        this.childrenStats();
        this.genderStats();
        this.continuingStats();
    }

    private void childrenStats() {
        for(final Family family : this.families) {
            this.numberOfChildren += family.getChildren().size();
        }

        this.averageNumberOfChildren = this.numberOfChildren * 1.0 / this.families.size();
    }

    private void genderStats() {
        this.numberOfMales = 0;
        for(final Family family : this.families) {
            for(Person person : family.getChildren()) {
                if(person.getGenderEnum() == GenderEnum.MALE) {
                    this.numberOfMales++;
                }
            }
        }
        this.numberOfFemales = this.numberOfChildren - this.numberOfMales;

        this.percentMale = 100.0 * this.numberOfMales / this.numberOfChildren;
        this.percentFemale = 100.00 - this.percentMale;
    }

    private void continuingStats() {
        this.familiesContinuing = 0;
        for(final Family family : this.families) {
            if(family.isContinuing()) {
                this.familiesContinuing++;
            }
        }
        this.familiesNotContinuing = this.numberOfChildren - this.familiesContinuing;
        this.percentContinuing = 100.0 * this.familiesContinuing / this.numberOfChildren;
        this.percentNotContinuing = 100.00 - this.percentContinuing;
    }

    public final void print() {
        this.generateStats();
        System.out.println("Generation Data:");
        System.out.println("Number of families: " + this.families.size());
        System.out.println("Number of children: " + this.numberOfChildren + " Average children per family: " + this.averageNumberOfChildren);
        System.out.println("Number of males: " + this.numberOfMales + " Number of females: " + this.numberOfFemales + " Percent male: " + this.percentMale + " Percent female: " + this.percentFemale);
        System.out.println("Familes continuing: " + this.familiesContinuing + " Families not continuing: " + this.familiesNotContinuing + " Percent continuing: " + this.percentContinuing + " Percent not continuing: " + this.percentNotContinuing);
//        System.out.println("Family Name         , Children, Male, Female, Continue");
//        for(final Family family : this.families) {
//            System.out.println(family.toString());
//        }
    }
}
