package evg.testt.model;

public enum CheckpointTypeEnum {

    ENTRY_TEST(1), CURRENT_TEST(2);

    private int testId;

    CheckpointTypeEnum(int id){
        testId = id;
    }

    public int getTestId()
    {
        return testId;
    }
}