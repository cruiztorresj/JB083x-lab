package com.redhat.training.ui;

import java.util.Set;
import java.util.HashSet;
import java.util.function.Predicate;

import jakarta.faces.component.UIComponent;
import jakarta.faces.component.UISelectItems;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

import com.redhat.training.model.PersonaGroup;

@FacesConverter(value = "SelectItemToEntityConverter")
public class SelectItemConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext ctx, UIComponent comp, String value) {

        Object o = null;
        if (!(value == null || value.isEmpty())) {

            o = this.getSelectedItemAsEntity(comp, value);
        }

        return o;
    }

    @Override
    public String getAsString(FacesContext ctx, UIComponent comp, Object value) {

        String s = "";
        if (value != null) {

            s = ((PersonaGroup) value).getId().toString();
        }

        return s;
    }

    private PersonaGroup getSelectedItemAsEntity(UIComponent comp, String value) {

        PersonaGroup item = null;

        Set<PersonaGroup> selectItems = new HashSet<>();
        for (UIComponent uic : comp.getChildren()) {

            if (uic instanceof UISelectItems uisi) {
                
                Long itemId = Long.valueOf(value);

                if (uisi.getValue() instanceof Set<?> groups && !groups.isEmpty()) {

                    for (Object o : groups) {

                        if (o instanceof PersonaGroup pg) {

                            selectItems.add(pg);
                        }
                    }
                    

                    if (itemId != null) {

                        Predicate<PersonaGroup> predicate = i -> i.getId().equals(itemId);
                        item = selectItems.stream().filter(predicate).findFirst().orElse(null);
                    }
                }
            }
        }

        return item;

    }
}
