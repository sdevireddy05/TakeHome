package sample.interview.strategy;

public class UpperCaseNameScoringStrategy implements NameScoringStrategy {

    @Override
    public Integer score(String name, Integer weight) {
        Integer score = 0;
        String finalNameToScore = name.replaceAll("[^a-z A-Z]|\\s+", "").toUpperCase();
        for (int i = 0; i < finalNameToScore.length(); i++) {
            score += finalNameToScore.charAt(i) - 'A' + 1;
        }

        return score * weight;
    }
}
