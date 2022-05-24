package LibraryManagement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.IOException;

public class LibraryManagementController {


    @FXML
    public TextField bookNameSearch, authorNameSearch, yearPublishedSearch, publisherNameSearch, bookNameEnter, authorNameEnter, yearPublishedEnter, publisherNameEnter;

    @FXML
    public TextArea txtRec, txtAreaEnter, txtAreaSearch;

    @FXML
    public RadioButton radioNonFiction, radioHistoricalFiction, radioScifi, radioRealFiction;

    @FXML
    public ToggleGroup genreGroup;

    LibraryManagement lm;

    //might have to delete these
    //public Parent SearchBook;
    //public Parent EnterBook;
    //public Parent LibraryManagement;

    public LibraryManagementController() {
        lm = new LibraryManagement();
        bookNameSearch = new TextField();
        authorNameSearch = new TextField();
        yearPublishedSearch = new TextField();
        publisherNameSearch = new TextField();
        bookNameEnter = new TextField();
        authorNameEnter = new TextField();
        yearPublishedEnter = new TextField();
        publisherNameEnter = new TextField();
    }


    //Main menu buttons (to switch screens)
    public void onBtnSearch(ActionEvent event) throws IOException {
        Parent LibraryManagement = FXMLLoader.load(getClass().getResource("SearchBook-view.fxml"));

        //this line could be a problem
        Scene scene = new Scene(LibraryManagement);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Search Book");
        stage.setScene(scene);
        stage.show();
    }

    public void onBtnEnter(ActionEvent event) throws IOException {
        Parent LibraryManagement = FXMLLoader.load(getClass().getResource("EnterBook-view.fxml"));

        //this line could be a problem
        Scene scene = new Scene(LibraryManagement);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Enter Book");
        stage.setScene(scene);
        stage.show();
    }

    public void onBtnRecommendations(ActionEvent event) throws IOException {
        Parent LibraryManagement = FXMLLoader.load(getClass().getResource("BookRecommendations-view.fxml"));

        //this line could be a problem
        Scene scene = new Scene(LibraryManagement);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Book Recommendations");
        stage.setScene(scene);
        stage.show();
    }

    public void onBackToMain(ActionEvent event) throws IOException {
        Parent LibraryManagement = FXMLLoader.load(getClass().getResource("LibraryManagement-view.fxml"));

        //this line could be a problem
        Scene scene = new Scene(LibraryManagement);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Library Management");
        stage.setScene(scene);
        stage.show();
    }


    //Methods for storing book info in array for SearchBook and EnterBook screens
    public void onBtnSearchBook() {
        if (lm.searchBook(bookNameSearch.getText()) && bookNameSearch.getText() != null) {
            txtAreaSearch.setText(
                    "Book found!\n" +
                    LibraryManagement.book[lm.index].toString()
                    + "\n" + lm.isFree());
        } else {
            txtAreaSearch.setText("Book not found. Try again.");
        }
    }

    public void onBtnEnterBook() {
        Book b = new Book();
        b.setBookName(bookNameEnter.getText());
        b.setAuthorName(authorNameEnter.getText());
        b.setYearPublished(Integer.parseInt(yearPublishedEnter.getText()));
        b.setPublisherName(publisherNameEnter.getText());
        lm.addBook(b);
        //lm.index += 1;
        txtAreaEnter.setText("Book added!\n" + b);
    }

    //radio group code

    public void genreGroup() {
        if (radioNonFiction.isSelected()) {
            txtRec.setText(
                    "Book Name: The C Programming Language (2nd Edition)\n"
                            + "Author: Brian W. Kernighan\n"
                            + "Year Published: 1988\n"
                            + "Publisher name: Pearson"
            );
        } else if (radioHistoricalFiction.isSelected()) {
            txtRec.setText(
                    "Book Name: The Grapes of Wrath\n"
                            + "Author: John Ernst Steinbeck\n"
                            + "Year Published: 1939\n"
                            + "Publisher name: The Viking Press"
            );
        } else if (radioScifi.isSelected()){
            txtRec.setText(
                    "Book Name: Foundation\n"
                            + "Author: Isaac Asimov\n"
                            + "Year Published: 1951\n"
                            + "Publisher name: Doubleday Science Fiction"
            );
        } else if (radioRealFiction.isSelected()) {
            txtRec.setText(
                    "Book Name: Holes\n"
                            + "Author: Louis Sachar\n"
                            + "Year Published: 1998\n"
                            + "Publisher name: Farrar"
            );
        }
    }



    //Book recommendations screen: radio buttons
    public void onNonFiction() {
        genreGroup();
    }

    public void onHistoricalFiction() {
        genreGroup();
    }

    public void onScifi() {
        genreGroup();
    }

    public void onRealFiction() {
        genreGroup();
    }


}
