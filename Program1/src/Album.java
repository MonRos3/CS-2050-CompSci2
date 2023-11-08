/***
 *Album.java
 *Monica Ball - CS 2050-001
 *Professor Cohen
 *v1.0
 *
 *This class creates the Album object and its setter, getter, toString methods.
 ***/
public class Album {
    private String title;
    private String artist;
    private String genre;
    private int numSongs;

    public Album() {
        this.title = "Renaissance";
        this.artist = "Beyonce";
        this.genre = "easy listening";
        this.numSongs = 10;
    }

    public Album(String title, String artist, String genre, int numSongs) {
        this.title = title;
        this.artist = artist;
        this.genre  = genre;
        this.numSongs = numSongs;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setSongs(int numSongs){
        this.numSongs = numSongs;
    }

    public String getTitle(){
        return this.title;
    }

    public String getArtist(){
        return this.artist;
    }

    public String getGenre(){
        return this.genre;
    }

    public int getSongs(){
        return this.numSongs;
    }

    public String toString(){
        return "Artist: " + artist + "\nTitle: " + title +"\nGenre: "+ genre +
                "\nNumber of Songs In Album: " + numSongs;
    }
}