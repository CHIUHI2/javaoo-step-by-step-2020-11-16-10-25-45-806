package practice10;

import java.util.Observable;
import java.util.Observer;

public interface PractiseObserver extends Observer {
    void notifyForAction(Observable observable, Object o, String actionType);
}
