import java.util.*;
 import java.util.ArrayList;
 import java.util.List;

public class MusicPlayerInterface {
    public static void main(String[] args) {
        while(true){
        System.out.println("-------------Music Player Interface-------------");
        System.out.println("Enter your choice:\n1. Play Music\n2. Pause Music\n3. Stop Music\n4. Add Song\n5. Remove Song\n6. Display Songs\n7. Create Playlist\n8. Delete Playlist\n9. Display Playlists\n10. Exit");
        Scanner scanner = new Scanner(System.in);
        MyMusicPlayer musicPlayer = new MyMusicPlayer();
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                musicPlayer.play();
                break;
            case 2:
                musicPlayer.pause();
                break;
            case 3:
                musicPlayer.stop();
                break;
            case 4:
                System.out.println("Enter song name to add:");
                String songToAdd = scanner.nextLine();
                System.out.println("Adding song: " + songToAdd);
                musicPlayer.addSong(songToAdd);
                break;
            case 5:
                System.out.println("Enter song name to remove:");
                String songToRemove = scanner.nextLine();
                System.out.println("Removing song: " + songToRemove);
                musicPlayer.removeSong(songToRemove);
                break;
            case 6:
                musicPlayer.displaySongs();
                break;
            case 7:
                System.out.println("Enter playlist name to create:");
                String playlistToCreate = scanner.nextLine();
                System.out.println("Creating playlist: " + playlistToCreate);
                musicPlayer.createPlaylist(playlistToCreate);
                break;
            case 8:
                System.out.println("Enter playlist name to delete:");
                String playlistToDelete = scanner.nextLine();
                System.out.println("Deleting playlist: " + playlistToDelete);
                musicPlayer.deletePlaylist(playlistToDelete);
                break;
            case 9:
                musicPlayer.displayPlaylists();
                break;
            case 10:
                System.out.println("Exiting Music Player Interface.---------->");
                return;
            default:
                System.out.println("Invalid choice.");
        } // swtich
    } // while loop
    } //main
}// MusicPlayerInterface class

interface MusicPlayer {
    void play();
    void pause();
    void stop();
    void addSong(String song);
    void removeSong(String song);
    void createPlaylist(String playList);
    void deletePlaylist(String playList);
}
class MyMusicPlayer implements MusicPlayer {
    static List<String> songs = new ArrayList<>();
    static List<String> playlists = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    @Override
    public void play() {
        System.out.println(" Playing is music.");
    }
    @Override
    public void pause() {
        System.out.println("Music is paused.");
    }
    @Override
    public void stop(){
        System.out.println("Music is stopped.");
    }
    @Override
    public void addSong(String song) {
        songs.add(song);
        System.out.println("Song " + song + " is added");
    }
    @Override
    public void removeSong(String song){
        boolean found = false;
        if (songs.isEmpty()) {
                System.out.println("No songs available to remove.");
                //break; 
            }else{
        for (String s : songs) {
                        //System.out.println(i++);
            if (s.equals(song)){
                songs.remove(s);
                System.out.println("Song " + song + " is removed");
                found = true;
                break;
            }
            }
            if (!found){
                System.out.println("Song " + song + " not found");
        }
        }
    }
    
    public void displaySongs(){
        if(songs.isEmpty()){
            System.out.println("No songs available to display.");
            return;
        }else{
        System.out.println("Songs in the list:");
        for (String s : songs){
            System.out.println(s);
        }
    }
    }
    @Override
    public void createPlaylist(String playList) {
        playlists.add(playList);
        System.out.println("Playlist " + playList + " is created");
    }
    @Override
    public void deletePlaylist(String playList){
        boolean found = false;
        if (playlists.isEmpty()){
            System.out.println("No playlists available to delete.");
        }else {
        for (String p : playlists){
            if (p.equals(playList)){
                playlists.remove(p);            
                System.out.println("Playlist " + playList + " is deleted");
                found = true;
                break;
            }
            }
            }
        if (!found){
            System.out.println("Playlist " + playList + " not found");
        }
    }
    public void displayPlaylists(){
        if(playlists.isEmpty()){
            System.out.println("No playlists available to display.");
            return;
        }else{
        System.out.println("Playlists in the music player:");
        for (String p : playlists){
            System.out.println(p);
        }
    }
    }  
}               // MyMusicPlayer class