package evg.testt.util.fullcalendar.factories;

import evg.testt.util.fullcalendar.builders.GroupEventBuilder;
import evg.testt.util.fullcalendar.builders.GroupEventBuilderImpl;

public class GroupEventBuilderFactoryImpl {
    private static GroupEventBuilderFactoryImpl instance;

    private GroupEventBuilderFactoryImpl(){}

    public static GroupEventBuilderFactoryImpl getInstance(){
        if(instance == null){
            instance = new GroupEventBuilderFactoryImpl();
        }
        return instance;
    }

    public GroupEventBuilder getGroupEventBuilder(){
        return new GroupEventBuilderImpl();
    }
}
