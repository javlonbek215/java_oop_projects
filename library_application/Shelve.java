package library_application;

public class Shelve {
    Book[] kitoblar = new Book[10];
    int currentIndex = 0;

    private Closet closet;
    private int number;

    public Shelve(int number, Closet closet) {
        this.number = number;
        this.closet = closet;
    }

    public boolean add(Book book) {
        if (this.currentIndex < 10) {
            kitoblar[this.currentIndex] = book;
            book.setShelve(this);
            this.currentIndex++;
            return true;
        }
        return false;
    }


    public boolean bookContains(Book book) {
        for (Book b : this.kitoblar) {
            if (b != null) {
                if (b.equals(book)) {
                    return true;
                }
            }
        }
        return false;
    }


    public String getBooks() {
        StringBuilder result = new StringBuilder();
        for (Book book : this.kitoblar) {
            if (book != null) {
                result.append(book).append("\n");
            }
        }
        return result.toString();
    }

    public int getNumber() {
        return number;
    }

    public Closet getCloset() {
        return closet;
    }

    public Book find(String author, String title) {
        for (Book b : this.kitoblar) {
            if (b != null && b.equals(author, title)) {
                return b;
            }
        }

        return null;
    }
}