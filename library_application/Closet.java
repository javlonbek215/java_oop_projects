package library_application;

public class Closet {
    private Shelve[] javonlar = new Shelve[6];
    private String name;
    private Floor floor;

    public Closet(String name, Floor floor) {
        this.name = name;
        this.floor = floor;
        for (int i = 0; i < 6; i++) {
            this.javonlar[i] = new Shelve(i, this);
        }
    }


    public String getName() {
        return name;
    }

    public boolean add(Book book, int shelf) {
        return javonlar[shelf].add(book);
    }

    public boolean shelfContains(int shelf, Book book) {
        return this.javonlar[shelf].bookContains(book);
    }

    public String getBooks() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < this.javonlar.length; i++) {
            Shelve shelve = this.javonlar[i];
            result.append("Shelf ").append(i).append("\n");
            result.append(shelve.getBooks());
        }
        return result.toString();
    }

    public Floor getFloor() {
        return floor;
    }

    public Book find(String author, String title) {
        for (Shelve shelve : this.javonlar) {
            Book b = shelve.find(author, title);
            if (b != null) {
                return b;
            }
        }
        return null;
    }
}
