package sample.interview;

import sample.interview.exception.AppException;
import sample.interview.exception.ResourceNotFoundException;
import sample.interview.processor.ScoreProcessor;
import sample.interview.processor.IndexBasedScoreProcessorImpl;
import sample.interview.strategy.UpperCaseNameScoringStrategy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MainApplication {
    public static void main(String[] args) throws Exception {
        if (0 < args.length) {
            String fileAbsolutePath = args[0];
            System.out.println("file name: " + fileAbsolutePath);

            try (
                    FileInputStream inputStream = new FileInputStream(fileAbsolutePath)
            ) {
                ScoreProcessor processor = new IndexBasedScoreProcessorImpl(new UpperCaseNameScoringStrategy());
                Integer totalScore = processor.processFile(inputStream);

                System.out.println(totalScore);
            } catch (FileNotFoundException e) {
                throw new ResourceNotFoundException(String.format("File not found at given path=%s", fileAbsolutePath), e);
            }
        } else {
            throw new AppException("expecting file name in args arrays but its empty, hence exiting...");
        }
    }
}
