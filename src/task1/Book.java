package task1;

public class Book {
    private String name;
    private String nameAuthor;
    private String genderAuthor;
    private int price;
    private String dateOfWriting;

    public Book () {

    }
    public Book(String name, String nameAuthor,String genderAuthor, int price, String dateOfWriting) {
        this.name = name;
        this.nameAuthor = nameAuthor;
        this.genderAuthor = genderAuthor;
        this.price = price;
        this.dateOfWriting = dateOfWriting;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }

    public String getGenderAuthor() {
        return genderAuthor;
    }

    public void setGenderAuthor(String genderAuthor) {
        this.genderAuthor = genderAuthor;
    }


    public String getName() {
        return name;
    }


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    public String getDateOfWriting() {
        return dateOfWriting;
    }

    public void setDateOfWriting(String dateOfWriting) {
        this.dateOfWriting = dateOfWriting;
    }


    @Override
    public String toString() {
        return   "!" + name +"!"+"!" + nameAuthor +"!"+"!" + genderAuthor +"!"+"!" + price +"!"+"!" + dateOfWriting +"!";
    }
}