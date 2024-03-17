package com.mycompany.villagonzalo_lab2._oop;

class AdvancedTextEditor extends TextEditor {
    private final Stack<String> history;

    public AdvancedTextEditor(String initialText) {
        super(initialText);
        history = new Stack<>();
    }

    @Override
    public void append(String newText) {
        history.push(getText());
        super.append(newText);
    }

    @Override
    public void delete(int n) {
        history.push(getText());
        super.delete(n);
    }

    public void undo() {
        if (!history.isEmpty()) {
            setText(history.pop());
        }
    }
}