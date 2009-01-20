/*
 * See LICENSE file in distribution for copyright and licensing information.
 */
package org.yaml.snakeyaml.constructor;

import java.lang.reflect.Field;

import org.yaml.snakeyaml.error.YAMLException;

public class FieldProperty extends Property {
    private final Field field;

    public FieldProperty(Field field) {
        super(field.getName(), field.getType());
        this.field = field;
    }

    public void set(Object object, Object value) throws Exception {
        field.set(object, value);
    }

    public Object get(Object object) {
        try {
            return field.get(object);
        } catch (Exception e) {
            throw new YAMLException(e);
        }
    }
}