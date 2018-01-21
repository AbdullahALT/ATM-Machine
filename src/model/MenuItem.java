package model;

import view.State;

public class MenuItem {

    private String label;
    private OnChoseListener onChoseListener;

    public MenuItem(String label, OnChoseListener onChoseListener) {
        this.label = label;
        this.onChoseListener = onChoseListener;
    }

    public interface OnChoseListener {
        void OnChose(State state);
    }

    public String getLabel() {
        return label;
    }

    public OnChoseListener getOnChoseListener() {
        return onChoseListener;
    }
}
