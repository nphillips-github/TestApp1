package net.nrp.test;

import net.nrp.models.AnswerOption;
import net.nrp.models.Question;

import java.util.ArrayList;

public class TestData {

    public Question setupTestQuestion()
    {
        Question testQ = new Question();
        testQ.imageURL = "https://googledrive.com/host/0B3DyoV8yZ-jLR3VFWGhOeHpwbVk/20131031_113621smaller.jpg";
        testQ.answerOptions = new ArrayList<AnswerOption>();
        testQ.answerOptions.add(createTestAnswer("Stefan Maurer","smaurer"));
        testQ.answerOptions.add(createTestAnswer("Anson Quoch","aquoch"));
        testQ.answerOptions.add(createTestAnswer("Gary Alfrey","galfrey"));
        testQ.answerOptions.add(createTestAnswer("Dennis Rauzan","drauzan"));
        testQ.correct_AnswerValue = "aquoch";
        return testQ;
    }

    public AnswerOption createTestAnswer(String oText, String oValue)
    {
        AnswerOption opt = new AnswerOption();
        opt.answerText = oText;
        opt.answerValue = oValue;
        return opt;
    }
}
