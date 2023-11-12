import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;

public class Interaction extends JFrame{
    private JFileChooser fileChooser = new JFileChooser();

    public void openFile() {
        int returnValue = fileChooser.showOpenDialog(this);
        fileChooser.setFileFilter(new FileNameExtensionFilter("Текстовые файлы (*.txt)", "txt"));
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
                String line;
                SimpleNotepad.getTextArea().setText("");
                while ((line = reader.readLine()) != null) {
                    SimpleNotepad.getTextArea().append(line + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void saveFile() {
        int returnValue = fileChooser.showSaveDialog(this);
        fileChooser.setFileFilter(new FileNameExtensionFilter("Текстовые файлы (*.txt)", "txt"));
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(selectedFile))) {
                String text = SimpleNotepad.getTextArea().getText();
                writer.write(text);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
