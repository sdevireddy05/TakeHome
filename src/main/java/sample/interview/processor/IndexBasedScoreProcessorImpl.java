package sample.interview.processor;

import sample.interview.strategy.NameScoringStrategy;
import sample.interview.util.IndexedElement;

import java.io.InputStream;
import java.util.stream.Stream;

public class IndexBasedScoreProcessorImpl implements ScoreProcessor {

    private final NameScoringStrategy nameScoringStrategy;

    public IndexBasedScoreProcessorImpl(NameScoringStrategy nameScoringStrategy) {
        this.nameScoringStrategy = nameScoringStrategy;
    }

    @Override
    public Integer processFile(InputStream inputStream) {
        Stream<String> nameStreams = streamScanner(inputStream);
        return nameStreams
                .map(IndexedElement.indexed())
                .map(name -> nameScoringStrategy.score(name.value(), name.index()))
                .reduce(0, Integer::sum);
    }
}
