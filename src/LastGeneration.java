public class LastGeneration {
    static public void main(String[] args) {
        final Generation firstGeneration = new Generation();
        for(final String name : Names.FAMILY_NAMES) {
            firstGeneration.addFamilyUnit(new FamilyUnit(name));
        }
        final Generations generations = new Generations(firstGeneration);
        generations.getCurrentGeneration().printGenerationStats();

        for(int i = 0; i < 10; i++) {
            generations.createNextGeneration();
            generations.getCurrentGeneration().printGenerationStats();
        }
    }
}