package sample.interview.strategy;

@FunctionalInterface
public interface NameScoringStrategy {
    Integer score(String name, Integer weight);
}
