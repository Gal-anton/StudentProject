package edu.galichin.studentorder.domain.register;

import java.util.ArrayList;
import java.util.List;

public class AnswerCityRegister {
    private List<AnswerCityRegisterItem> items = null;

    public void addItem(AnswerCityRegisterItem item) {
        if (items == null) {
            items = new ArrayList<>(10);
        }
        items.add(item);
    }

    public List<AnswerCityRegisterItem> getItems() {
        return items;
    }

}
