package task1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Thread.sleep;

public class Swing extends JFrame {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Swing swing = new Swing();
                swing.start();
            }
        });
    }
    public void start() {
        setSize(700,600);
        setLocation(100,100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel grid = new JPanel(new GridLayout(1,2,20,10));
        JButton create = create();
        JButton change= change();
        JButton delete = delete();
        grid.add(create);
        grid.add(change);
        grid.add(delete);
        JPanel flow = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        flow.add(grid);
        add(flow,BorderLayout.SOUTH);
        JTable jTable = new JTable(createBook());
        JScrollPane jScrollPane = new JScrollPane(jTable);
        add(jScrollPane,BorderLayout.CENTER);
        setVisible(true);
    }

    public JButton change() {
        JButton change= new JButton("Изменить книгу");
        change.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ChangeBook();
                dispose();
            }
        });
        change.setBackground(Color.PINK);

        return change;
    }

    public JButton delete() {
        JButton delete= new JButton("Удалить книгу");
        delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new DeleteBook();
                dispose();
            }
        });
        delete.setBackground(Color.PINK);

        return delete;
    }

    public JButton create() {
        JButton create = new JButton("Создать книгу");
        create.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new CreateBook();
                dispose();
            }
        });
        create.setBackground(Color.PINK);

        return create;
    }
    public BookModel createBook() {
        BookModel bookModel = new BookModel();
        try(FileInputStream reader = new FileInputStream("DateBase")) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(reader));
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(str,"!");
                while (st.hasMoreTokens()) {
                    Book book = new Book();
                    book.setName(st.nextToken());
                    book.setNameAuthor(st.nextToken());
                    book.setGenderAuthor(st.nextToken());
                    String s = st.nextToken();
                    String s1 = s.substring(0,s.length()-1);
                    int x = Integer.parseInt(s);
                    book.setPrice(x);
                    book.setDateOfWriting(st.nextToken());
                    bookModel.addBook(book);
                }
            }
        } catch (IOException e) {
            e.fillInStackTrace();
        }
        return bookModel;
    }

    public void close() {
        dispose();
    }


}