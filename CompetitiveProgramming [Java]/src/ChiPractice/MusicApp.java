package ChiPractice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MusicApp {

}
/*
 * How would you design a music app like Spotify?
 * (Classes and connections between them)
 */

// download music
// listening to music
// creating a playlist


class Song {
    private Long id;
    private String name;
    private String artist;
    private String genre;
    private String url;
    Song () {}

    void listen(){
        System.out.println("Listening to "+name);
    }

    String getName() {
        return this.name;
    }
}

class Playlist {
    private Long id;
    private String name;
    private List<String> songNames;

    Playlist(String name){

    }

    void addSong(String songName){
        songNames.add(songName);
    }

    void removeSong (String songName) {
        songNames.remove(songName);
    }
}


class Person {
    private Map<String, Song> mapOfSongs = new HashMap<>();
    private Map<String, Playlist> mapOfPlaylists = new HashMap<>();


    List<Song> searchForSongOnCloud(String songName){
        return Arrays.asList(new Song()); //Possible URLs to be used for download;
    }

    void download(String url){
        Song newSong = new Song();//Some impl to get song from URL
        this.mapOfSongs.put(newSong.getName() ,newSong);
    }


    void listen(String songName){
        Song song = searchForSongLocally(songName);
        if(song == null){
            throw new IllegalArgumentException ("Song does not exist");
        }

        song.listen();
    }

    Song searchForSongLocally(String songName) {
        return this.mapOfSongs.getOrDefault(songName, new Song());
    }

    Playlist createPlaylist (String name){
        Playlist playlist = new Playlist(name);
        return playlist;
    }

    Playlist addToPlaylist (String songToAdd, String playListName) {
        Playlist playlist = mapOfPlaylists.getOrDefault(playListName, new Playlist("New Playlist"));
        if(playlist == null){
            throw new IllegalArgumentException ("Playlist does not exist");
        }

        if(!mapOfSongs.containsKey(songToAdd)){
            throw new IllegalArgumentException ("User needs to download song");
        }
        playlist.addSong(songToAdd);

        return playlist;
    }


}
