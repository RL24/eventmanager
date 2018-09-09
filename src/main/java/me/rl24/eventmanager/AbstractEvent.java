package me.rl24.eventmanager;

public abstract class AbstractEvent<T extends AbstractEvent> {

    private Class<T> cls;
    private EventType eventType;
    private boolean cancelled = false;

    public AbstractEvent(Class<T> cls) {
        this.cls = cls;
    }

    public EventType getEventType() {
        return eventType;
    }

    public T setEventType(EventType eventType) {
        this.eventType = eventType;
        return cls.cast(this);
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public T setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
        return cls.cast(this);
    }

}
