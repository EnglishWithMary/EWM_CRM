package evg.testt.model;

/**
 + * Created by oleksiy on 05.12.16.
 + */

        public enum TeacherLevelEnum {

        JUNIOR_1(0), JUNIOR_2(1),JUNIOR_3(2), MIDDLE_1(3), MIDDLE_2(4), MIDDLE_3(5), SENIOR_1(6), SENIOR_2(7), SENIOR_3(8);

        private int levelId;

        TeacherLevelEnum(int id){
            levelId = id;
        }

        public int getLevelId() {
            return levelId;
        }

        public static TeacherLevelEnum valueOf(int index) {
            TeacherLevelEnum level[] = TeacherLevelEnum.values();
            return level[index];
        }
}
