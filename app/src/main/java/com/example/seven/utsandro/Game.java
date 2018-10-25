package com.example.seven.utsandro;

public class Game {

    private int ID;
    private String Nama;
    private String Genre;
    private String Rating ;
    private String Developer ;


    public Game(int id, String nama, String genre, String rating, String developer){
        ID = id;
        Nama = nama;
        Genre = genre;
        Rating = rating;
        Developer = developer;
    }

    public int getID(){
        return ID;
    }
    public void setID(int id){ ID = id; }

    public String getNama(){
        return Nama;
    }
    public void setNama(String nama){
        Nama = nama;
    }

    public String getGenre(){
        return Genre;
    }
    public void setGenre(String genre){
        Genre = genre;
    }

    public String getRating(){
        return Rating;
    }
    public void setUkuran(String rating){ Rating = rating; }

    public String getDeveloper(){
        return Developer;
    }
    public void setDeveloper(String developer){
        Developer = developer;
    }
}
