package evg.testt.model;

public enum StudentLevelPoints {
    A1(1), A2(2), B1(3), B2(4), C1(5), C2(6);

    private int levelId;

    StudentLevelPoints(int id){
        levelId = id;
    }

    public int getLevelClassifierId()
    {
        return levelId;
    }
}