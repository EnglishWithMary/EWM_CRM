package evg.testt.util.fullcalendar.factories;


import evg.testt.util.fullcalendar.builders.*;

public class FullcalendarBuilderFactoryImpl {
    private static FullcalendarBuilderFactoryImpl instance;

    public static FullcalendarBuilderFactoryImpl getInstance() {
        if (instance == null) {
            instance = new FullcalendarBuilderFactoryImpl();
        }
        return instance;
    }

    public DisabledFullcalendarBuilder getDisabledFullcalendarBuilder() {
        return new DisabledFullcalendarBuilderImpl();
    }

    public SimpleFullcalendarBuider getSimpleFullcalendarBuider() {
        return new SimpleFullcalendarBuilderImpl();
    }

    public SimpleFullcalendarBuiderWithUrl getSimpleFullcalendarBuiderWithUrl() {
        return new SimpleFullcalendarWithUrlBuilderImpl();
    }
}
