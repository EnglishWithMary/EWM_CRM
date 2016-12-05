package evg.testt.model;

/**
 * Created by oleksiy on 05.12.16.
 */

public enum TeacherLevelEnum {

    JUNIOR_1(1), JUNIOR_2(2),JUNIOR_3(3), MIDDLE_1(4), MIDDLE_2(5), MIDDLE_3(6), SENIOR_1(7), SENIOR_2(8), SENIOR_3(9);

    private int levelId;

    TeacherLevelEnum(int id){
        levelId = id;
    }

    public int getLevelId()
    {
        return levelId;
    }
}