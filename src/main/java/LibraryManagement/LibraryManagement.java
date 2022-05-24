package LibraryManagement;

public class LibraryManagement {

    /**
     * In here, have all the methods that the controller will call upon that have to do with scene builder
     * The methods needed will be the array logic: entering info into the array, and withdrawing it.
     */

    static Book[] book = new Book[100];
    int index = 0;


    public int getIndex() {
        return index;
    }

    public void addBook(Book b){
        if(index < book.length){
            book[index] = b;
            index++;
        }
    }
    public void setIndex(int index) {
        this.index = index;
    }

    public boolean searchBook(String text) {
        for (int i = 0; i < book.length; i++) {
            if (text.equalsIgnoreCase(book[i].getBookName()) && book[i] != null) {
                return true;
            }
        }
        return false;
    }

    public String isFree() {
        double random = Math.random();
        if (random >= 0.5) {
            return "Book is available to check out in library.";
        } else {
            return "Book is not available to checkout in library.";
        }
    }

}
