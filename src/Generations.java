import java.util.ArrayList;
import java.util.List;

public class Generations {
    private List<Generation> generations;

    public Generations(final Generation startingGeneration) {
        this.generations = new ArrayList<>();
        this.generations.add(startingGeneration);
    }

    public void createNextGeneration() {
        final Generation currentGeneration = this.generations.get(this.generations.size() - 1);

        this.generations.add(currentGeneration.nextGeneration());
    }

    public Generation getCurrentGeneration() {
        return this.generations.get(this.generations.size() - 1);
    }
}