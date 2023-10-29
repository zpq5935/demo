package behave.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者模式
 * 
 * @author 22517
 *
 */
public class ObserverDemo {
    public static void main(String[] args) {
        Weather weather = new Weather();
        WeatherType weatherType = WeatherType.SUNNY;
        weather.addObserver(new Student());
        weather.addObserver(new Driver());
        weather.addObserver(new Farmer());
        //
        weather.setChanged();
        weather.notifyObservers(weatherType);
    }
}

/**
 * 学生
 * 
 * @author 22517
 *
 */
class Student implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        WeatherType weatherType = (WeatherType) arg;
        System.out.println("我是学生");
        switch (weatherType) {
        case WINDY:
            System.out.println("刮风了，得多加点衣服了");
            break;
        case SUNNY:
            System.out.println("晴天，哎，我不太喜欢体育课");
            break;
        case RAINY:
            System.out.println("xixi，不用上体育课了");
            break;
        default:
            break;
        }
    }
}

/**
 * 农民
 * 
 * @author 22517
 *
 */
class Farmer implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        WeatherType weatherType = (WeatherType) arg;
        System.out.println("我是农民");
        switch (weatherType) {
        case WINDY:
            System.out.println("刮风了，我得赶紧去看下我的命根子");
            break;
        case SUNNY:
            System.out.println("这太阳这么毒，我得多浇点水才行");
            break;
        case RAINY:
            System.out.println("这么久了终于下次雨了");
            break;
        default:
            break;
        }
    }
}

/**
 * 司机
 * 
 * @author 22517
 *
 */
class Driver implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        WeatherType weatherType = (WeatherType) arg;
        System.out.println("我是司机");
        switch (weatherType) {
        case WINDY:
            System.out.println("。。。");
            break;
        case SUNNY:
            System.out.println("这个大热天，应该会有挺多人打车吧");
            break;
        case RAINY:
            System.out.println("下雨了，得开慢点");
            break;
        default:
            break;
        }
    }
}

/**
 * 天气，被观察
 * 
 * @author 22517
 *
 */
class Weather extends Observable {
    private WeatherType weatherType;

    @Override
    protected synchronized void setChanged() {
        super.setChanged();
    }

    public WeatherType getWeatherType() {
        return weatherType;
    }

    public void setWeatherType(WeatherType weatherType) {
        this.weatherType = weatherType;
    }

    public Weather(WeatherType weatherType) {
        super();
        this.weatherType = weatherType;
    }

    public Weather() {
        super();
    }

}

enum WeatherType {
    RAINY, WINDY, SUNNY;
}