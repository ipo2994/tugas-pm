import java.util.Stack;

public class TextEditor {
    private String currentText;
    private Stack<String> undoStack;
    private Stack<String> redoStack;

    public TextEditor() {
        this.currentText = "";
        this.undoStack = new Stack<>();
        this.redoStack = new Stack<>();
    }

    public void show() {
        System.out.println(currentText);
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            redoStack.push(currentText);
            currentText = undoStack.pop();
        } else {
            System.out.println("Tidak ada aksi undo yang dapat dilakukan.");
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            undoStack.push(currentText);
            currentText = redoStack.pop();
        } else {
            System.out.println("Tidak ada aksi redo yang dapat dilakukan.");
        }
    }

    public void write(String text) {
        undoStack.push(currentText);
        currentText += text;
        redoStack.clear();
    }

    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        editor.write("Hello, ");
        editor.show();

        editor.write("world!");
        editor.show();

        editor.undo();
        editor.show();

        editor.redo();
        editor.show();

        editor.write(" How are you?");
        editor.show();

        editor.undo();
        editor.show();

        editor.write(" Everyone!");
        editor.show();
    }
}
