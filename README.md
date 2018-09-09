# Event Manager
![](https://forthebadge.com/images/badges/designed-in-ms-paint.svg)

A simple Java based event manager

### Usage:

```java
@EventListenerDescriptor({ ExampleEvent.class })
class Example implements IEventListener {
    public Example() {
        EventManager.register(this);
        EventManager.dispatch(new ExampleEvent().setEventType(EventType.PRE_EVENT)
    }
    
    @Override
    public void dispatch(AbstractEvent event) {
        // Handle events
    }
}

class ExampleEvent extends AbstractEvent<ExampleEvent> {
    public ExampleEvent() {
        super(ExampleEvent.class);
    }
}
```