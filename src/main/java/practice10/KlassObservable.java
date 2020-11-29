package practice10;

import java.util.Observable;

public class KlassObservable extends Observable {
    private KlassObservableEvent event;

    public KlassObservableEvent getEvent() {
        return event;
    }

    public void setEvent(KlassObservableEvent event) {
        this.event = event;
    }
}
