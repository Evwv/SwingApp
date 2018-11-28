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
        Swing swing = new Swing();
        swing.start();

        JTextField nameBook = createNameBook();

        JTextField nameAuthor = createNameAuthor();

        JTextField genderAuthor = createGenderAuthor();

        JTextField priceBook = createPriceBook();

        JTextField dateOfWriting = createDateOfWriting();

        JButton create = new JButton("Сохранить внесенные изменения");
        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean flag = false;
                if (nameBook.getText().isEmpty() | nameAuthor.getText().isEmpty()
                        | genderAuthor.getText().isEmpty() | priceBook.getText().isEmpty() | dateOfWriting.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(ChangeBook.this, "Заполните все поля");
                } else {
                    try {
                        StringTokenizer stringTokenizer = new StringTokenizer(priceBook.getText(),",");
                        int x = Integer.parseInt(stringTokenizer.nextToken());
                        int y = Integer.parseInt(stringTokenizer.nextToken());
                        flag = true;
                    } catch (NumberFormatException n) {
                        JOptionPane.showMessageDialog(ChangeBook.this,"Цена доджна быть числом");
                    }
                    if (flag) {
                        String str = nameBook.getText() + "," + nameAuthor.getText() + "," + genderAuthor.getText() + "," + priceBook.getText() + "," + dateOfWriting.getText();
                        StringTokenizer st = new StringTokenizer(str, ",");
                        while (st.hasMoreTokens()) {
                            book.setName(st.nextToken());
                            bookNew.setName(st.nextToken());
                            book.setNameAuthor(st.nextToken());
                            bookNew.setNameAuthor(st.nextToken());
                            book.setGenderAuthor(st.nextToken());
                            bookNew.setGenderAuthor(st.nextToken());
                            book.setPrice(Integer.parseInt(st.nextToken()));
                            bookNew.setPrice(Integer.parseInt(st.nextToken()));
                            book.setDateOfWriting(st.nextToken());
                            bookNew.setDateOfWriting(st.nextToken());
                        }
                        try {
                            int x = JOptionPane.showConfirmDialog(ChangeBook.this,
                                    "Уверенны что хотите сохранить изменения? "
                                    , "Error", JOptionPane.YES_NO_OPTION);
                            if (x == JOptionPane.YES_OPTION) {
                                JOptionPane.showMessageDialog(ChangeBook.this, "Изменения успешно внесены");
                                save(book.toString(), bookNew.toString());
                                swing.close();
                                dispose();
                                Swing swing = new Swing();
                                swing.start();
                            } else {
                                JOptionPane.showMessageDialog(ChangeBook.this, "У вас есть возможность исправиться");
                            }
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
            }
        });
        create.setBackground(Color.PINK);
        JPanel jPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        jPanel.add(new JLabel("Формат ввода~>Старое значение,Новое значение"));
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
        setSize(400,350);
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


    private JTextField createNameAuthor() {
        JTextField nameAuthor = new JTextField(30);
        create(nameAuthor);
        return nameAuthor;
    }

    private JTextField createNameBook() {
        JTextField nameBook = new JTextField(30);
        create(nameBook);
        return nameBook;
    }

    private JTextField createGenderAuthor() {
        JTextField genderAuthor = new JTextField(30);
        create(genderAuthor);
        return genderAuthor;
    }

    private JTextField createPriceBook() {
        JTextField priceBook = new JTextField(30);
        create(priceBook);
        return priceBook;
    }

    private JTextField createDateOfWriting() {
        JTextField dateOfWriting = new JTextField(30);
        create(dateOfWriting);
        return dateOfWriting;
    }
    private void create(JTextField  textField) {
        textField.setFont(new Font("Dialog", Font.PLAIN, 14));
        textField.setHorizontalAlignment(JTextField.LEFT);
    }


}