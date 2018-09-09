package me.rl24.eventmanager;

public interface IEventListener {

    int priority();

    void dispatch(AbstractEvent event);

}
