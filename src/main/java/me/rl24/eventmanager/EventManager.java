package me.rl24.eventmanager;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class EventManager {

    private static final Map<Class<? extends IEventListener>, IEventListener> LISTENERS = new HashMap<>();

    public static void register(IEventListener listener) {
        LISTENERS.put(listener.getClass(), listener);
    }

    public static void deregister(IEventListener listener) {
        LISTENERS.remove(listener.getClass());
    }

    public static <T extends IEventListener> T getListener(Class<T> listenerClass) {
        return listenerClass.cast(LISTENERS.get(listenerClass));
    }

    public static void dispatch(AbstractEvent event) {
        LISTENERS.values().stream()
                .filter((listener) -> listener.getClass().isAnnotationPresent(EventListenerDescriptor.class)
                        && Arrays.asList(listener.getClass().getAnnotation(EventListenerDescriptor.class).value()).contains(event.getClass())
                        && !event.isCancelled())
                .sorted(Comparator.comparingInt(IEventListener::priority))
                .forEach((listener) -> listener.dispatch(event));
    }

}
