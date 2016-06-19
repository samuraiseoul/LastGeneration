package person;

import java.util.Random;

/**
 * Created by Jihoon on 6/18/2016.
 */
public class PersonFactory {

    private static final Random RANDOM = new Random();

    public static final Person randomSex(final String familyName) {
        if(PersonFactory.RANDOM.nextBoolean()){
            return PersonFactory.male(familyName);
        } else {
            return PersonFactory.female(familyName);
        }
    }

    public static final Person male(final String familyName) {
        return new Male(familyName);
    }

    public static final Person female(final String familyName) {
        return new Female(familyName);
    }
}
