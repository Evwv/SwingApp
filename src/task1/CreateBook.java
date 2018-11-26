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
        super("TestApp");

        JTextField nameBook = createNameBook();

        JTextField nameAuthor = createNameAuthor();

        JTextField genderAuthor = createGenderAuthor();

        JTextField priceBook = createPriceBook();

        JTextField dateOfWriting = createDateOfWriting();

        JPanel jPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        jPanel.add(nameBook);
        jPanel.add(nameAuthor);
        jPanel.add(genderAuthor);
        jPanel.add(priceBook);
        jPanel.add(dateOfWriting);
        JButton create = create();
        jPanel.add(create,BorderLayout.AFTER_LAST_LINE);
        setContentPane(jPanel);
        setSize(550,220);
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

    private JButton create() {
        JButton create = new JButton("Внести книгу в хранилище");
        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                save(book);
                Swing swing = new Swing();
                dispose();
                swing.start();
            }
        });
        create.setBackground(Color.PINK);

        return create;
    }

    private JTextField createNameAuthor() {
        JTextField nameAuthor = new JTextField("Имя Автора",40);
        create(nameAuthor);
        nameAuthor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                book.setNameAuthor(nameAuthor.getText());
            }
        });
        return nameAuthor;
    }

    private JTextField createNameBook() {
        JTextField nameBook = new JTextField("Название книги",40);
        create(nameBook);
        nameBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                book.setName(nameBook.getText());
            }
        });
        return nameBook;
    }

    private JTextField createGenderAuthor() {
        JTextField genderAthor = new JTextField("Укажите пол автора",40);
        create(genderAthor);
        genderAthor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                book.setGenderAuthor(genderAthor.getText());
            }
        });
        return genderAthor;
    }

    private JTextField createPriceBook() {
        JTextField priceBook = new JTextField("Укажите стоимость книги",40);
        create(priceBook);
        priceBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                book.setPrice(Integer.parseInt(priceBook.getText()));
            }
        });
        return priceBook;
    }

    private JTextField createDateOfWriting() {
        JTextField dateOfWriting = new JTextField("Укажите дату написания книги",40);
        create(dateOfWriting);
        dateOfWriting.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                book.setDateOfWriting(dateOfWriting.getText());
            }
        });
        return dateOfWriting;
    }

    private void create(JTextField  textField) {
        textField.setFont(new Font("Dialog", Font.PLAIN, 14));
        textField.setHorizontalAlignment(JTextField.LEFT);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CreateBook();
            }
        });
    }
}