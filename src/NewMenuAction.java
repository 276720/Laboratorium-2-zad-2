import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewMenuAction implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        SimpleNotepad.getTextArea().setText("");
    }
}
