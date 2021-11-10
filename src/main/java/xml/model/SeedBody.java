package xml.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SeedBody {

    private static List<Seed> seeds = new ArrayList<>();

    public SeedBody(List<Seed> seeds) {
        SeedBody.seeds = seeds;
    }

    public static List<Seed> getSeeds() {
        return seeds;
    }

    public static void setSeeds(Seed seed) {
        seeds.add(seed);

//        SeedBody.seeds = seeds;
    }
}
