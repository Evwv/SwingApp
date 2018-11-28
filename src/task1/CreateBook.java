package task1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class CreateBook extends JFrame {

    private Book book = new Book();

    public CreateBook() {
        Swing swing = new Swing();
        swing.start();
        JTextField nameBook = createNameBook();

        JTextField nameAuthor = createNameAuthor();

        JTextField genderAuthor = createGenderAuthor();

        JTextField priceBook = createPriceBook();

        JTextField dateOfWriting = createDateOfWriting();

        JPanel jPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        jPanel.add(new JLabel("Название книги:"));
        jPanel.add(nameBook);
        jPanel.add(new JLabel("Имя автора"));
        jPanel.add(nameAuthor);
        jPanel.add(new JLabel("Пол автора"));
        jPanel.add(genderAuthor);
        jPanel.add(new JLabel("Цена книги:"));
        jPanel.add(priceBook);
        jPanel.add(new JLabel("Дата написания:"));
        jPanel.add(dateOfWriting);


        JButton create = new JButton("Внести книгу в хранилище");
        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean flag = false;
                if (nameBook.getText().isEmpty() | nameAuthor.getText().isEmpty()
                        | genderAuthor.getText().isEmpty() | priceBook.getText().isEmpty() | dateOfWriting.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(CreateBook.this, "Заполните все поля");
                } else {
                    book.setName(nameBook.getText());
                    book.setNameAuthor(nameAuthor.getText());
                    book.setGenderAuthor(genderAuthor.getText());
                    book.setDateOfWriting(dateOfWriting.getText());
                    try {
                        book.setPrice(Integer.parseInt(priceBook.getText()));
                        flag = true;
                    } catch (NumberFormatException e1) {
                        JOptionPane.showMessageDialog(CreateBook.this, "Цена должа быть числом");
                    }
                }
                if (flag) {
                    int x = JOptionPane.showConfirmDialog(CreateBook.this,
                            "Введеная информация вас устраивает? "
                            , "Error", JOptionPane.YES_NO_OPTION);
                    if (x == JOptionPane.YES_OPTION) {
                        JOptionPane.showMessageDialog(CreateBook.this, "Книга добавлена в хранилище");
                        save(book);
                        swing.close();
                        Swing swing = new Swing();
                        dispose();
                        swing.start();
                    } else {
                        JOptionPane.showMessageDialog(CreateBook.this, "У вас есть возможность исправиться");
                    }
                }
            }

        });
        create.setBackground(Color.PINK);

        jPanel.add(create,BorderLayout.AFTER_LAST_LINE);

        setContentPane(jPanel);
        setSize(550,400);
        setLocation(300,300);
        setVisible(true);

    }
    private void save(Book book) {
        try(FileWriter writer = new FileWriter("DateBase",true)) {
            writer.write(book.toString());
            writer.append('\n');
            writer.flush();
        } catch (IOException ew) {
            ew.fillInStackTrace();
        }
    }
    private JTextField createNameAuthor() {
        JTextField nameAuthor = new JTextField(40);
        create(nameAuthor);
        return nameAuthor;
    }

    private JTextField createNameBook() {
        JTextField nameBook = new JTextField(40);
        create(nameBook);
        return nameBook;
    }

    private JTextField createGenderAuthor() {
        JTextField genderAthor = new JTextField(40);
        create(genderAthor);
        return genderAthor;
    }

    private JTextField createPriceBook() {
        JTextField priceBook = new JTextField(40);
        create(priceBook);
        return priceBook;
    }

    private JTextField createDateOfWriting() {
        JTextField dateOfWriting = new JTextField(40);
        create(dateOfWriting);
        return dateOfWriting;
    }

    private void create(JTextField  textField) {
        textField.setFont(new Font("Dialog", Font.PLAIN, 14));
        textField.setHorizontalAlignment(JTextField.LEFT);
    }

}