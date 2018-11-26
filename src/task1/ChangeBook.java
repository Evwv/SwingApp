package task1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class ChangeBook extends JFrame {
    private Book book = new Book();
    private Book bookNew = new Book();

    public ChangeBook() {
        super("TestApp");

        JTextField nameBook = createNameBook();

        JTextField nameAuthor = createNameAuthor();

        JTextField genderAuthor = createGenderAuthor();

        JTextField priceBook = createPriceBook();

        JTextField dateOfWriting = createDateOfWriting();

        JTextField newNameBook = createNewNameBook();

        JTextField newNameAuthor = createNewNameAuthor();

        JTextField newGenderAuthor = createNewGenderAuthor();

        JTextField newPriceBook = createNewPriceBook();

        JTextField newDateOfWriting = createNewDateOfWriting();

        JButton create = create();
        JPanel jPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        jPanel.add(nameBook);
        jPanel.add(newNameBook);
        jPanel.add(nameAuthor);
        jPanel.add(newNameAuthor);
        jPanel.add(genderAuthor);
        jPanel.add(newGenderAuthor);
        jPanel.add(priceBook);
        jPanel.add(newPriceBook);
        jPanel.add(dateOfWriting);
        jPanel.add(newDateOfWriting);

        jPanel.add(create,BorderLayout.SOUTH);
        setContentPane(jPanel);
        setSize(550,220);
        setLocation(300,300);
        setVisible(true);
    }
    private void save(String book, String newBook) throws IOException {
        File sourceFile = new File("DateBase");
        File outputFile = new File("DateBase2");
        BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
        String line;
        while (( line = reader.readLine()) != null) {
            if (!(line.equals(book))) {
                writer.write(line);
                writer.newLine();
            }
        }
        writer.write(newBook);
        writer.newLine();
        reader.close();
        writer.close();
        sourceFile.delete();
        outputFile.renameTo(sourceFile);
    }

    private JButton create() {
        JButton create = new JButton("Сохранить внесенные изменения");
        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String oldBook = book.toString();
                String newBook = bookNew.toString();
                try {
                    save(oldBook,newBook);
                    Swing swing = new Swing();
                    dispose();
                    swing.start();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        create.setBackground(Color.PINK);

        return create;
    }

    private JTextField createNameAuthor() {
        JTextField nameAuthor = new JTextField("Cтарое имя Автора",20);
        create(nameAuthor);
        nameAuthor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                book.setNameAuthor(nameAuthor.getText());
            }
        });
        return nameAuthor;
    }

    private JTextField createNewNameAuthor() {
        JTextField nameAuthor = new JTextField("Измененное имя автора",20);
        create(nameAuthor);
        nameAuthor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bookNew.setNameAuthor(nameAuthor.getText());
            }
        });
        return nameAuthor;
    }

    private JTextField createNameBook() {
        JTextField nameBook = new JTextField("Старое название книги",20);
        create(nameBook);
        nameBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                book.setName(nameBook.getText());
            }
        });
        return nameBook;
    }

    private JTextField createNewNameBook() {
        JTextField nameBook = new JTextField("Измененное название книги",20);
        create(nameBook);
        nameBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bookNew.setName(nameBook.getText());
            }
        });
        return nameBook;
    }

    private JTextField createGenderAuthor() {
        JTextField genderAthor = new JTextField("Старый пол автора",20);
        create(genderAthor);
        genderAthor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                book.setGenderAuthor(genderAthor.getText());
            }
        });
        return genderAthor;
    }

    private JTextField createNewGenderAuthor() {
        JTextField genderAthor = new JTextField("Измененный пол автора",20);
        create(genderAthor);
        genderAthor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bookNew.setGenderAuthor(genderAthor.getText());
            }
        });
        return genderAthor;
    }

    private JTextField createPriceBook() {
        JTextField priceBook = new JTextField("Старая стоимость книги",20);
        create(priceBook);
        priceBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                book.setPrice(Integer.parseInt(priceBook.getText()));
            }
        });
        return priceBook;
    }

    private JTextField createNewPriceBook() {
        JTextField priceBook = new JTextField("Измененная стоимость",20);
        create(priceBook);
        priceBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bookNew.setPrice(Integer.parseInt(priceBook.getText()));
            }
        });
        return priceBook;
    }

    private JTextField createDateOfWriting() {
        JTextField dateOfWriting = new JTextField("Старая дата написания",20);
        create(dateOfWriting);
        dateOfWriting.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                book.setDateOfWriting(dateOfWriting.getText());
            }
        });
        return dateOfWriting;
    }

    private JTextField createNewDateOfWriting() {
        JTextField dateOfWriting = new JTextField("Измененная дата написания",20);
        create(dateOfWriting);
        dateOfWriting.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bookNew.setDateOfWriting(dateOfWriting.getText());
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
                new ChangeBook();
            }
        });
    }
}