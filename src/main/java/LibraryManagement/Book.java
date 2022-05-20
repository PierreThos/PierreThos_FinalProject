package LibraryManagement;

public class Book {

    String bookName;
    String authorName;
    int yearPublished;
    String publisherName;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    @Override
    public String toString() {
        return
                "Book Name: " + bookName +
                "\nAuthor name: " + authorName +
                "\nYear published: " + yearPublished +
                "\nPublisher name: " + publisherName;
    }


}
