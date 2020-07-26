package sample.interview.processor;

import org.junit.Before;
import org.junit.Test;
import sample.interview.strategy.NameScoringStrategy;
import sample.interview.strategy.UpperCaseNameScoringStrategy;

import java.io.InputStream;

import static org.junit.Assert.*;

public class IndexBasedScoreProcessorImplTest {

    private ScoreProcessor scoreProcessor;

    @Before
    public void setup() {
        NameScoringStrategy nameScoringStrategy = new UpperCaseNameScoringStrategy();
        scoreProcessor = new IndexBasedScoreProcessorImpl(nameScoringStrategy);
    }

    @Test
    public void processFileForScoring() {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("test-names.txt");

        Integer finalScore = scoreProcessor.processFile(inputStream);

        assertEquals(3194, finalScore.intValue());
    }
}