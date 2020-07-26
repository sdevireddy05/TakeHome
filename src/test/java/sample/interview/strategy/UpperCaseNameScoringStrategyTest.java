package sample.interview.strategy;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UpperCaseNameScoringStrategyTest {

    private NameScoringStrategy nameScoringStrategy;

    @Before
    public void setup() {
        nameScoringStrategy = new UpperCaseNameScoringStrategy();
    }

    @Test
    public void score_allUpperCaseNames() {
        assertEquals(1, nameScoringStrategy.score("A", 1).intValue());
        assertEquals(26, nameScoringStrategy.score("Z", 1).intValue());
        assertEquals(6, nameScoringStrategy.score("AAA", 2).intValue());
        assertEquals(160, nameScoringStrategy.score("LINDA", 4).intValue());
        assertEquals(150, nameScoringStrategy.score("APPLE", 3).intValue());
    }

    @Test
    public void score_allNames_withSpecialChars() {
        assertEquals(1, nameScoringStrategy.score("A !", 1).intValue());
        assertEquals(52, nameScoringStrategy.score("Z, z", 1).intValue());
        assertEquals(8, nameScoringStrategy.score("AAA  a", 2).intValue());
        assertEquals(160, nameScoringStrategy.score("LINDA@", 4).intValue());
        assertEquals(150, nameScoringStrategy.score("APPLE", 3).intValue());
        assertEquals(124, nameScoringStrategy.score("Roger Federer", 1).intValue());
    }
}