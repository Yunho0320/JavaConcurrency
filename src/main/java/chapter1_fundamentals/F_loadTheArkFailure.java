package chapter1_fundamentals;

import java.util.Collection;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

/*
This class shows how we can fail to implement stack confinement
 */
public class F_loadTheArkFailure {
    private SortedSet<Animal> leakedAnimals; //  shared field!!!

    public int loadTheArk(Collection<Animal> candidates) {
        SortedSet<Animal> animals = new TreeSet<>(new SpeciesGenderComparator());
        animals.addAll(candidates);

        // Escaping: assigning local to shared field
        this.leakedAnimals = animals;
        return 1;
    }
}
class Animal{
}
class SpeciesGenderComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }
}
