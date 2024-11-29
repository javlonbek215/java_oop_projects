package library_application;

public class Floor {
    Closet[] shkaflar = new Closet[30];
    private int number;

    public Floor(int number) {
        this.number = number;
        for (int i = 0; i < 30; i++) {
            shkaflar[i] = new Closet("C" + (i + 1), this);
        }
    }


    public boolean addBook(Book book, String closet, int shelf) {
        Closet cl = this.getCloset(closet);
        if (cl != null) {
            return cl.add(book, shelf);
        }
        return false;
    }


    public Closet getCloset(String closetName) {
        for (Closet closet : this.shkaflar) {
            if (closetName.equals(closet.getName())) {
                return closet;
            }
        }
        return null;
    }

    public boolean closetContains(String closet, int shelf, Book book) {
        Closet cl = this.getCloset(closet);
        if (cl != null) {
            return cl.shelfContains(shelf, book);
        }
        return false;
    }

    public String getBooks(String closet) {
        Closet cl = this.getCloset(closet);
        if (cl != null) {
            return cl.getBooks();
        }
        return " ";
    }

    public int getNumber() {
        return number;
    }

    public Book find(String author, String title) {
        for (Closet closet : this.shkaflar) {
            Book b = closet.find(author, title);
            if (b != null) {
                return b;
            }
        }
        return null;
    }
}
