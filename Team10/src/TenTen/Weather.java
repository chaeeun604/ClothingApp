package TenTen;

import java.util.*;

public class Weather {
    private Date date;
    private double temperatureHigh;
    private double temperatureLow;
    private String condition;
    private double precipitation;

    public Weather(Date date, double temperatureHigh, double temperatureLow, String condition, double precipitation) {
        this.date = date;
        this.temperatureHigh = temperatureHigh;
        this.temperatureLow = temperatureLow;
        this.condition = condition;
        this.precipitation = precipitation;
    }  

    public double getAverageTemp() {
        return (temperatureHigh + temperatureLow) / 2.0;
    }

    public String getCondition() {
        return condition;
    }

    public static Weather getTodayWeather() {
        return new Weather(new Date(), 24, 18, "맑음", 10);
    }
}
