import java.util.List;

/**
 * Created by Jihoon on 6/18/2016.
 */
public class LastGeneration {

    static public void main(String[] args) {
        final Generation generation = new Generation();
        for(final String name : Names.FAMILY_NAMES) {
            generation.addFamily(new Family(name));
        }
        generation.print();
    }

}
