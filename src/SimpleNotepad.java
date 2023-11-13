import javax.swing.*;
import java.awt.*;

public class SimpleNotepad extends JFrame{
    private JMenuBar menuBar;
    private JMenuItem newMenuItem, openMenuItem,saveMenuItem,exitMenuItem;
    private JMenu fileMenu;
    private static JTextArea textArea;
    public static JTextArea getTextArea(){
        return textArea;
    }
    public SimpleNotepad(){
        super("Prosty Notatnik");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textArea = new JTextArea();
        textArea.setFont(new Font("Calibri", Font.PLAIN, 12));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollPane);

        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        fileMenu = new JMenu("Plik");
        menuBar.add(fileMenu);

        newMenuItem = new JMenuItem("Nowy");
        openMenuItem = new JMenuItem("Otwórz");
        saveMenuItem = new JMenuItem("Zapisz");
        exitMenuItem = new JMenuItem("Wyjść");

        NewMenuAction newMenuAction = new NewMenuAction();
        newMenuItem.addActionListener(newMenuAction);

        OpenMenuAction openMenuAction = new OpenMenuAction();
        openMenuItem.addActionListener(openMenuAction);

        SaveManuAction saveManuAction = new SaveManuAction();
        saveMenuItem.addActionListener(saveManuAction);

        ExitMenuAction exitMenuAction = new ExitMenuAction();
        exitMenuItem.addActionListener(exitMenuAction);

        fileMenu.add(newMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.add(exitMenuItem);

        setSize(400, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try{
                SimpleNotepad test = new SimpleNotepad();
                test.setVisible(true);
            } catch (Exception e ){
                e.printStackTrace(System.err);
            }
        });
    }
}