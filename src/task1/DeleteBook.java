package task1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class DeleteBook extends JFrame {
    public DeleteBook() {
        super("DeleteBook");

        JTextField nameBook = createNameBook();

        JTextField nameAuthor = createNameAuthor();


        JButton delete = new JButton("Подтвердить удаление");
        delete.setBackground(Color.PINK);
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Delete(nameBook.getText(),nameAuthor.getText());
                    Swing swing = new Swing();
                    dispose();
                    swing.start();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        JPanel jPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        jPanel.add(nameBook);
        jPanel.add(nameAuthor);
        jPanel.add(delete,BorderLayout.SOUTH);
        setContentPane(jPanel);
        setSize(400,130);
        setLocation(300,300);
        setVisible(true);
    }

    private void Delete(String nameB,String nameA) throws IOException {
        File sourceFile = new File("DateBase");
        File outputFile = new File("DateBase2");
        BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
        String line;
        while (( line = reader.readLine()) != null) {
            if (!(line.startsWith("!" +nameB+"!"+"!" + nameA+"!"))) {
                writer.write(line);
                writer.newLine();
            }
        }
        reader.close();
        writer.close();
        sourceFile.delete();
        outputFile.renameTo(sourceFile);
    }


    private JTextField createNameAuthor() {
        JTextField nameAuthor = new JTextField("Имя Автора",60);
        create(nameAuthor);
        return nameAuthor;
    }

    private JTextField createNameBook() {
        JTextField nameBook = new JTextField("Название книги",60);
        create(nameBook);
        return nameBook;
    }
    private void create(JTextField  textField) {
        textField.setFont(new Font("Dialog", Font.PLAIN, 14));
        textField.setHorizontalAlignment(JTextField.LEFT);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DeleteBook();
            }
        });
    }
}