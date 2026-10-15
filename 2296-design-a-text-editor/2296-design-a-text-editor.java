class TextEditor {
    StringBuilder l, r;

    public TextEditor() {
        l = new StringBuilder();
        r = new StringBuilder();
    }

    public void addText(String text) {
        l.append(text);
    }

    public int deleteText(int k) {
        int n = Math.min(k, l.length());
        l.delete(l.length() - n, l.length());
        return n;
    }

    public String cursorLeft(int k) {
        while (k-- > 0 && l.length() > 0) {
            r.append(l.charAt(l.length() - 1));
            l.deleteCharAt(l.length() - 1);
        }
        return get();
    }

    public String cursorRight(int k) {
        while (k-- > 0 && r.length() > 0) {
            l.append(r.charAt(r.length() - 1));
            r.deleteCharAt(r.length() - 1);
        }
        return get();
    }

    private String get() {
        return l.substring(Math.max(0, l.length() - 10));
    }
}

/**
 * Your TextEditor object will be instantiated and called as such:
 * TextEditor obj = new TextEditor();
 * obj.addText(text);
 * int param_2 = obj.deleteText(k);
 * String param_3 = obj.cursorLeft(k);
 * String param_4 = obj.cursorRight(k);
 */