/***
 *Program1.java
 *Monica Ball - CS 2050-001
 *Professor Cohen
 *v1.0
 *
 *This class enables a user to input 3 albums describing its title, artist, genre, and number of songs.
 ***/
import java.util.Scanner;

public class Program1 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        System.out.println("Welcome to the Favorite Album Compilation Program. " +
                "\n Please enter album information for your favorite three albums. ");

        Album[] albums = new Album[3];
        for (int albumCount = 0; albumCount <= 2; albumCount++) {
            Album album = new Album();
            System.out.println("What is the album's title? ");
            String title = stdIn.nextLine();
            album.setTitle(title);
            System.out.println("What the first album's artist? ");
            String artist = stdIn.nextLine();
            album.setArtist(artist);
            System.out.println("What is the first album's genre? Please choose hip-hop, easy listening, orchestral, your parents, or theatre only. ");
            String genre = stdIn.nextLine();
            while (!genre.equals("hip-hop") && !genre.equals("easy listening") && !genre.equals("orchestral") && !genre.equals("your parents") && !genre.equals("theatre")){
                genre = "easy listening";
            }
            album.setGenre(genre);
            System.out.println("How many songs are on the album? ");
            int numSongs = stdIn.nextInt();
            album.setSongs(numSongs);

            System.out.println(album.toString());

            stdIn.nextLine();
            albums[albumCount] = album;
        }
    }
}