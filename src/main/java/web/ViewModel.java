package web;

import java.util.HashMap;
import java.util.Map;

public class ViewModel {
    private final String view;
    private final Map<String, Object> model = new HashMap<>();


    public ViewModel(String view) {
        this.view = view;
    }

    public String getView() {
        return view;
    }

    public Map<String, Object> getModel() {
        return model;
    }

    public static ViewModel of(String view) {
        return new ViewModel(view);
    }
}
