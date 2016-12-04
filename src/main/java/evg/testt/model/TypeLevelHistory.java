package evg.testt.model;

public enum TypeLevelHistory {

    ENTRY_TEST(1), CURRENT_TEST(2);

    private int testId;

    TypeLevelHistory(int id){
        testId = id;
    }

    public int getTestId()
    {
        return testId;
    }
}