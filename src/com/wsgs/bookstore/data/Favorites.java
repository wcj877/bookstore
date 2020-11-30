package com.wsgs.bookstore.data;

public class Favorites {
    int favoritesID;
    int bookID;
    String userID;

    public int getFavoritesID() {
        return favoritesID;
    }

    public void setFavoritesID(int favoritesID) {
        this.favoritesID = favoritesID;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    @Override
    public String toString() {
        return "Favorites{" +
                "favoritesID=" + favoritesID +
                ", bookID=" + bookID +
                ", userID='" + userID + '\'' +
                '}';
    }
}