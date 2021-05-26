package by.silebin.shapes.observer;

import by.silebin.shapes.entity.Cube;

import java.util.EventObject;

public class CubeEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public CubeEvent(Object source) {
        super(source);
    }

    @Override
    public Cube getSource() {
        return (Cube) super.getSource();
    }
}
