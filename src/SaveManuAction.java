import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaveManuAction implements ActionListener {
    Interaction interaction = new Interaction();
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        interaction.saveFile();
    }
}
