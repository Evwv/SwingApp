package task1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.StringTokenizer;

public class ChangeBook extends JDialog {
    private Book book = new Book();
    private Book bookNew = new Book();

    public ChangeBook() {

        JTextField nameBook = createNameBook();

        JTextField nameAuthor = createNameAuthor();

        JTextField genderAuthor = createGenderAuthor();

        JTextField priceBook = createPriceBook();

        JTextField dateOfWriting = createDateOfWriting();

        JButton create = create();
        JPanel jPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        jPanel.add(new JLabel("Старое название книги,Новое название:"));
        jPanel.add(nameBook);
        jPanel.add(new JLabel("Старое имя автора,Новое имя:"));
        jPanel.add(nameAuthor);
        jPanel.add(new JLabel("Старый пол автора,Новый пол:"));
        jPanel.add(genderAuthor);
        jPanel.add(new JLabel("Старая цена,Новая цена:"));
        jPanel.add(priceBook);
        jPanel.add(new JLabel("Старая дата написания,Новая дата:"));
        jPanel.add(dateOfWriting);
        jPanel.add(create,BorderLayout.SOUTH);
        setContentPane(jPanel);
        setSize(350,350);
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
                    int x = JOptionPane.showConfirmDialog(ChangeBook.this,
                                "Уверенны что хотите сохранить изменения? "
                            ,"Error",JOptionPane.YES_NO_OPTION);
                    if (x == JOptionPane.YES_OPTION) {
                        JOptionPane.showMessageDialog(ChangeBook.this,"Изменения успешно внесены");
                        save(oldBook,newBook);
                        Swing swing = new Swing();
                        dispose();
                        swing.start();
                    } else {
                        JOptionPane.showMessageDialog(ChangeBook.this,"У вас есть возможность исправиться");
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        create.setBackground(Color.PINK);

        return create;
    }

    private JTextField createNameAuthor() {
        JTextField nameAuthor = new JTextField(20);
        create(nameAuthor);
        nameAuthor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StringTokenizer st = new StringTokenizer(nameAuthor.getText(),",");
                book.setNameAuthor(st.nextToken());
                bookNew.setNameAuthor(st.nextToken());
            }
        });
        return nameAuthor;
    }

    private JTextField createNameBook() {
        JTextField nameBook = new JTextField(20);
        create(nameBook);
        nameBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StringTokenizer st = new StringTokenizer(nameBook.getText(),",");
                book.setName(st.nextToken());
                bookNew.setName(st.nextToken());
            }
        });
        return nameBook;
    }


    private JTextField createGenderAuthor() {
        JTextField genderAthor = new JTextField(20);
        create(genderAthor);
        genderAthor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StringTokenizer st = new StringTokenizer(genderAthor.getText(),",");
                book.setGenderAuthor(st.nextToken());
                bookNew.setGenderAuthor(st.nextToken());
            }
        });
        return genderAthor;
    }


    private JTextField createPriceBook() {
        JTextField priceBook = new JTextField(20);
        create(priceBook);
        priceBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StringTokenizer st = new StringTokenizer(priceBook.getText(),",");
                book.setPrice(Integer.parseInt(st.nextToken()));
                bookNew.setPrice(Integer.parseInt(st.nextToken()));
            }
        });
        return priceBook;
    }


    private JTextField createDateOfWriting() {
        JTextField dateOfWriting = new JTextField(20);
        create(dateOfWriting);
        dateOfWriting.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StringTokenizer st = new StringTokenizer(dateOfWriting.getText(),",");
                book.setDateOfWriting(st.nextToken());
                bookNew.setDateOfWriting(st.nextToken());
            }
        });
        return dateOfWriting;
    }


    private void create(JTextField  textField) {
        textField.setFont(new Font("Dialog", Font.PLAIN, 14));
        textField.setHorizontalAlignment(JTextField.LEFT);
    }


}