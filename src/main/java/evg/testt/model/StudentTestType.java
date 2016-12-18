package evg.testt.model;

public enum StudentTestType {

    ENTRY_TEST(1), GRADUATE_TEST(2);

    private int testId;

    StudentTestType(int id){
        testId = id;
    }

    public int getTestId()
    {
        return testId;
    }
}