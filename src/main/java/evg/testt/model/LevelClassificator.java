package evg.testt.model;

public enum LevelClassificator {
    A1(1), A2(2), B1(3), B2(4), C1(5), C2(6);

    private int levelId;

    LevelClassificator(int id){
        levelId = id;
    }

    public int getLevelClassificatorId()
    {
        return levelId;
    }
}