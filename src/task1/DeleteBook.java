package task1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class DeleteBook extends JDialog {
    public DeleteBook() {

        JTextField nameBook = createNameBook();

        JTextField nameAuthor = createNameAuthor();


        JButton delete = new JButton("Подтвердить удаление");
        delete.setBackground(Color.PINK);
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (nameBook.getText().isEmpty() | nameAuthor.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(DeleteBook.this,"Заполните все поля ");
                } else {
                    try {
                        int x = JOptionPane.showConfirmDialog(DeleteBook.this,
                                "Вы действительно хотите удалить эту книгу? "
                                , "Error", JOptionPane.YES_NO_OPTION);
                        if (x == JOptionPane.YES_OPTION) {
                            JOptionPane.showMessageDialog(DeleteBook.this, "Книга удалена");
                            Delete(nameBook.getText(), nameAuthor.getText());
                            Swing swing = new Swing();
                            dispose();
                            swing.start();
                        } else {
                            JOptionPane.showMessageDialog(DeleteBook.this, "Мы спасли вас от случайного удаления");
                        }
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
        JPanel jPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        jPanel.add(new JLabel("Название книги"));
        jPanel.add(nameBook);
        jPanel.add(new JLabel("Имя автора"));
        jPanel.add(nameAuthor);
        jPanel.add(delete,BorderLayout.SOUTH);
        setContentPane(jPanel);
        setSize(400,200);
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
        JTextField nameAuthor = new JTextField(60);
        create(nameAuthor);
        nameAuthor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (nameAuthor.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(DeleteBook.this,"Поле не может быть пустым");
                } else {
                   String s = nameAuthor.getText();
                }
            }
        });
        return nameAuthor;
    }

    private JTextField createNameBook() {
        JTextField nameBook = new JTextField(60);
        create(nameBook);
        nameBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (nameBook.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(DeleteBook.this,"Поле не может быть пустым");
                } else {
                    String s = nameBook.getText();
                }
            }
        });
        return nameBook;
    }
    private void create(JTextField  textField) {
        textField.setFont(new Font("Dialog", Font.PLAIN, 14));
        textField.setHorizontalAlignment(JTextField.LEFT);
    }

}