package task1;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;


public class BookModel extends AbstractTableModel {
    private List<Book> books = new ArrayList<>();

    public BookModel() {
    }

    public void addBook(Book book) {
        books.add(book);
        fireTableDataChanged();
    }

    public Book returnBook() {
        for (Book book : books) {
            return book;
        }
        return null;
    }

    @Override
    public int getRowCount() {
        return books.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Book cur=books.get(rowIndex);
        switch (columnIndex){
            case 0:
                return cur.getName();
            case 1:
                return cur.getNameAuthor();
            case 2:
                return cur.getGenderAuthor();
            case 3:
                return cur.getPrice();
            case 4:
                return cur.getDateOfWriting();
        }
        return null;
    }

    public String getColumnName(int column) {
        switch (column){
            case 0:
                return "Book name";
            case 1:
                return "Author name";
            case 2:
                return "Author gender";
            case 3:
                return "Price";
            case 4:
                return "Date of writing";
        }
        return "";
    }

    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex){
            case 0:
                return String.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return Integer.class;
            case 4:
                return String.class;
        }
        return Object.class;
    }
}