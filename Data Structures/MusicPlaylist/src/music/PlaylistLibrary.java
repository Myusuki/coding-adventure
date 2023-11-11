package music;

import java.util.ArrayList;

/**
 * This class represents a library of song playlists.
 *
 * An ArrayList of Playlist objects represents the various playlists 
 * within one's library.
 * 
 * @author Jeremy Hui
 * @author Vian Miranda
 */
public class PlaylistLibrary {

    private ArrayList<Playlist> songLibrary; // contains various playlists

    /**
     * DO NOT EDIT!
     * Constructor for Library.
     * 
     * @param songLibrary passes in ArrayList of playlists
     */
    public PlaylistLibrary(ArrayList<Playlist> songLibrary) {
        this.songLibrary = songLibrary;
    }

    /**
     * DO NOT EDIT!
     * Default constructor for an empty library. 
     */
    public PlaylistLibrary() {
        this(null);
    }

    /**
     * This method reads the songs from an input csv file, and creates a 
     * playlist from it.
     * Each song is on a different line.
     * 
     * 1. Open the file using StdIn.setFile(filename);
     * 
     * 2. Declare a reference that will refer to the last song of the circular linked list.
     * 
     * 3. While there are still lines in the input file:
     *      1. read a song from the file
     *      2. create an object of type Song with the song information
     *      3. Create a SongNode object that holds the Song object from step 3.2.
     *      4. insert the Song object at the END of the circular linked list (use the reference from step 2)
     *      5. increase the count of the number of songs
     * 
     * 4. Create a Playlist object with the reference from step (2) and the number of songs in the playlist
     * 
     * 5. Return the Playlist object
     * 
     * Each line of the input file has the following format:
     *      songName,artist,year,popularity,link
     * 
     * To read a line, use StdIn.readline(), then use .split(",") to extract 
     * fields from the line.
     * 
     * If the playlist is empty, return a Playlist object with null for its last, 
     * and 0 for its size.
     * 
     * The input file has Songs in decreasing popularity order.
     * 
     * DO NOT implement a sorting method, PRACTICE add to end.
     * 
     * @param filename the playlist information input file
     * @return a Playlist object, which contains a reference to the LAST song 
     * in the ciruclar linkedlist playlist and the size of the playlist.
     */
    public Playlist createPlaylist(String filename) {

        // WRITE YOUR CODE HERE
        Playlist playlist = new Playlist();
        int size = 1;
        StdIn.setFile(filename);
        SongNode lastSongRef = new SongNode();
        SongNode headSongRef = new SongNode();

        // check if StdIn is reading an empty file
        if( StdIn.isEmpty() )
        {
            playlist.setLast(null);
            playlist.setSize(0);
            return playlist;
        }
        
        while( StdIn.hasNextLine() )
        {
            // Read song metadata
            String[] data = StdIn.readLine().split(",");
            String name = data[0];
            String artist = data[1];
            int year = Integer.parseInt(data[2]);
            int popularity = Integer.parseInt(data[3]);
            String fileLink = data[4];
            
            // create and insert song into playlist
            Song newSong = new Song(name, artist, year, popularity, fileLink);
            if( playlist.getLast() == null )
            {
                SongNode newSongNode = new SongNode(newSong, null);
                newSongNode.setNext(newSongNode);
                lastSongRef = newSongNode;
                headSongRef = lastSongRef;
                playlist.setLast(lastSongRef);
            }
            else
            {
                SongNode newSongNode = new SongNode(newSong, headSongRef);
                lastSongRef.setNext(newSongNode);
                lastSongRef = newSongNode;
            }

            // increase playlist size
            playlist.setSize(size++);
        }
        playlist.setLast(lastSongRef);

        return playlist; // update this line with your returning Playlist
    }

    /**
     * ****DO NOT**** UPDATE THIS METHOD
     * This method is already implemented for you. 
     * 
     * Adds a new playlist into the song library at a certain index.
     * 
     * 1. Calls createPlayList() with a file containing song information.
     * 2. Adds the new playlist created by createPlayList() into the songLibrary.
     * 
     * Note: initialize the songLibrary if it is null
     * 
     * @param filename the playlist information input file
     * @param playlistIndex the index of the location where the playlist will 
     * be added 
     */
    public void addPlaylist(String filename, int playlistIndex) {
        
        /* DO NOT UPDATE THIS METHOD */

        if ( songLibrary == null ) {
            songLibrary = new ArrayList<Playlist>();
        }
        if ( playlistIndex >= songLibrary.size() ) {
            songLibrary.add(createPlaylist(filename));
        } else {
            songLibrary.add(playlistIndex, createPlaylist(filename));
        }
    }

    /**
     * ****DO NOT**** UPDATE THIS METHOD
     * This method is already implemented for you.
     * 
     * It takes a playlistIndex, and removes the playlist located at that index.
     * 
     * @param playlistIndex the index of the playlist to remove
     * @return true if the playlist has been deleted
     */
    public boolean removePlaylist(int playlistIndex) {
        /* DO NOT UPDATE THIS METHOD */

        if ( songLibrary == null || playlistIndex >= songLibrary.size() ) {
            return false;
        }

        songLibrary.remove(playlistIndex);
            
        return true;
    }
    
    /** 
     * 
     * Adds the playlists from many files into the songLibrary
     * 
     * 1. Initialize the songLibrary
     * 
     * 2. For each of the filenames
     *       add the playlist into songLibrary
     * 
     * The playlist will have the same index in songLibrary as it has in
     * the filenames array. For example if the playlist is being created
     * from the filename[i] it will be added to songLibrary[i]. 
     * Use the addPlaylist() method. 
     * 
     * @param filenames an array of the filenames of playlists that should be 
     * added to the library
     */
    public void addAllPlaylists(String[] filenames) {
        
        // WRITE YOUR CODE HERE
        songLibrary = new ArrayList<Playlist>();

        for( int i = 0; i < filenames.length; i++ )
        {
            addPlaylist(filenames[i], i);
        }

    }

    /**
     * This method adds a song to a specified playlist at a given position.
     * 
     * The first node of the circular linked list is at position 1, the 
     * second node is at position 2 and so forth.
     * 
     * Return true if the song can be added at the given position within the 
     * specified playlist (and thus has been added to the playlist), false 
     * otherwise (and the song will not be added). 
     * 
     * Increment the size of the playlist if the song has been successfully
     * added to the playlist.
     * 
     * @param playlistIndex the index where the playlist will be added
     * @param position the position inthe playlist to which the song 
     * is to be added 
     * @param song the song to add
     * @return true if the song can be added and therefore has been added, 
     * false otherwise. 
     */
    public boolean insertSong(int playlistIndex, int position, Song song) {
        // WRITE YOUR CODE HERE
        Playlist targetPlaylist = songLibrary.get(playlistIndex);
        SongNode lastNodeRef = null;
		int targetPlaylistsize = targetPlaylist.getSize(); 
        //check if song cannot be added
        if( position <= 0 || position > (targetPlaylist.getSize() + 1) )
        {
            return false;
        }

        // check if the user is inserting in an empty playlist 
        if( targetPlaylistsize == 0 )
        {
            SongNode newSong = new SongNode(song, null);
            lastNodeRef = newSong;
            lastNodeRef.setNext(newSong);
            targetPlaylist.setLast(lastNodeRef);
            targetPlaylist.setSize(targetPlaylistsize + 1);
            songLibrary.set(playlistIndex, targetPlaylist);
            return true;
        }

        SongNode headNodeRef = targetPlaylist.getLast().getNext();
        lastNodeRef = targetPlaylist.getLast();
        SongNode targetPositionNode = headNodeRef;
		SongNode targetPositionPrevNode = lastNodeRef;

        // check if user is inserting song at the end of the playlist 
        if( position == (targetPlaylist.getSize() + 1) )
        {
            SongNode newSong = new SongNode(song, headNodeRef);
            lastNodeRef.setNext(newSong);
            targetPlaylist.setLast(newSong);
			targetPlaylist.setSize(targetPlaylistsize + 1);
			songLibrary.set(playlistIndex, targetPlaylist);
            return true;
        }
		// check if user is inserting at the beginning of a song
		else if( position == 1 )
		{
            SongNode newSong = new SongNode(song, headNodeRef);
            lastNodeRef.setNext(newSong);
			targetPlaylist.setSize(targetPlaylistsize + 1);
			songLibrary.set(playlistIndex, targetPlaylist);
            return true;
		}
        else 
        {
            for( int i = 1; i < position; i++ )
            {
                targetPositionNode = targetPositionNode.getNext();
            }
            for( int i = 0; i < (position - 1); i++ )
            {
				targetPositionPrevNode = targetPositionPrevNode.getNext();
            }
            SongNode newSong = new SongNode(song, targetPositionNode);
			targetPositionPrevNode.setNext(newSong);
			targetPlaylist.setSize(targetPlaylistsize + 1);
			songLibrary.set(playlistIndex, targetPlaylist);
            return true;
        }

    }

    /**
     * This method removes a song at a specified playlist, if the song exists. 
     *
     * Use the .equals() method of the Song class to check if an element of 
     * the circular linkedlist matches the specified song.
     * 
     * Return true if the song is found in the playlist (and thus has been 
     * removed), false otherwise (and thus nothing is removed). 
     * 
     * Decrease the playlist size by one if the song has been successfully
     * removed from the playlist.
     * 
     * @param playlistIndex the playlist index within the songLibrary where 
     * the song is to be added.
     * @param song the song to remove.
     * @return true if the song is present in the playlist and therefore has 
     * been removed, false otherwise.
     */
    public boolean removeSong(int playlistIndex, Song song) {
        // WRITE YOUR CODE HERE
        Playlist targetPlaylist = songLibrary.get(playlistIndex);
        int songPosition = 1;
        int targetPlaylistsize = targetPlaylist.getSize();
        SongNode targetSongNode = null;
        SongNode targetPrevSongNode = null;
        SongNode checkSong = targetSongNode;
        boolean songFound = false;

        // check to make sure there are songs in the playlist
        if( targetPlaylistsize == 0 )
        {
            return false;
        }
        if( targetPlaylistsize == 1 )
        {
            targetSongNode = targetPlaylist.getLast();
            checkSong = targetSongNode;
            if( checkSong.getSong().equals(song) )
            {
                targetSongNode.setNext(null);
                targetPlaylist.setLast(null);
                targetPlaylist.setSize(targetPlaylistsize - 1);
                songLibrary.set(playlistIndex, targetPlaylist);
                return true;
            }
            else
                return false;
        }

        targetSongNode = targetPlaylist.getLast().getNext();
        targetPrevSongNode = targetPlaylist.getLast();
        checkSong = targetSongNode;
        songFound = false;

        while( songFound != true )
        {

            if( checkSong.getSong().equals(song) )
            {
                songFound = true;
                break;
            }

            if( songPosition == targetPlaylistsize )
            {
                break;
            }

            songPosition++;
            checkSong = checkSong.getNext();
        }

        // target song is not in playlist
        if( songFound == false )
        {
            return false;
        }
        
        // if target song is the head
        if( songPosition == 1 )
        {
            targetPrevSongNode.setNext(targetSongNode.getNext() );
            targetSongNode.setNext( null );
            targetPlaylist.setSize(targetPlaylistsize - 1);
            songLibrary.set(playlistIndex, targetPlaylist);
            return true;
        }
        else if( songPosition == targetPlaylistsize )
        {
            for( int i = 1; i < songPosition; i++ )
            {
                targetSongNode = targetSongNode.getNext();
                targetPrevSongNode = targetPrevSongNode.getNext();
            }
            targetPrevSongNode.setNext(targetSongNode.getNext() );
            targetSongNode.setNext( null );
            targetPlaylist.setLast(targetPrevSongNode);
            targetPlaylist.setSize(targetPlaylistsize - 1);
            songLibrary.set(playlistIndex, targetPlaylist);
            return true;
        }
        else
        {
            for( int i = 1; i < songPosition; i++ )
            {
                targetSongNode = targetSongNode.getNext();
                targetPrevSongNode = targetPrevSongNode.getNext();
            }
            targetPrevSongNode.setNext(targetSongNode.getNext() );
            targetSongNode.setNext( null );
            targetPlaylist.setSize(targetPlaylistsize - 1);
            songLibrary.set(playlistIndex, targetPlaylist);
            return true;
        }
    }

    /**
     * This method reverses the playlist located at playlistIndex
     * 
     * Each node in the circular linked list will point to the element that 
     * came before it.
     * 
     * After the list is reversed, the playlist located at playlistIndex will 
     * reference the first SongNode in the original playlist (new last).
     * 
     * @param playlistIndex the playlist to reverse
     */
    public void reversePlaylist(int playlistIndex) {
        // WRITE YOUR CODE HERE
        Playlist targetPlaylist = songLibrary.get(playlistIndex);
        SongNode last = targetPlaylist.getLast();
        SongNode headNode = last.getNext();

		if( targetPlaylist.getSize() == 0 )
		{
			return;
		}

        SongNode left = last;
        SongNode head = last.getNext();
        SongNode right = null;

        int songPosition = 0;

        while( right != headNode )
        {
            songPosition++;
            right = head.getNext();
            head.setNext(left);
            left = head;
            head = right;
        }
        targetPlaylist.setLast(head);
        songLibrary.set(playlistIndex, targetPlaylist);
    }

    /**
     * This method merges two playlists.
     * 
     * Both playlists have songs in decreasing popularity order. The resulting 
     * playlist will also be in decreasing popularity order.
     * 
     * You may assume both playlists are already in decreasing popularity 
     * order. If the songs have the same popularity, add the song from the 
     * playlist with the lower playlistIndex first.
     * 
     * After the lists have been merged:
     *  - store the merged playlist at the lower playlistIndex
     *  - remove playlist at the higher playlistIndex 
     * 
     * 
     * @param playlistIndex1 the first playlist to merge into one playlist
     * @param playlistIndex2 the second playlist to merge into one playlist
     */
    public void mergePlaylists(int playlistIndex1, int playlistIndex2) {
      
        // WRITE YOUR CODE HERE
		Playlist playlist1 = songLibrary.get(playlistIndex1);
		Playlist playlist2 = songLibrary.get(playlistIndex2);
        Playlist resultPlaylist = new Playlist();
        int playlist1Index = playlistIndex1;
        int playlist2Index = playlistIndex2;
		if( playlistIndex1 > playlistIndex2 )
		{
			playlist1 = songLibrary.get(playlistIndex2);
            playlist1Index = playlistIndex2;
            playlist2 = songLibrary.get(playlistIndex1);
            playlist2Index = playlistIndex1;
		}

        int playlist1Size = playlist1.getSize();
        int playlist2Size = playlist2.getSize();
        
        if( playlist1Size == 0 && playlist2Size == 0 )
        {
            songLibrary.remove(playlist2Index);
            return;
        }
        if( playlist2Size == 0 )
        {
            songLibrary.remove(playlist2Index);
            return;
        }
        else if( playlist1Size == 0 )
        {
            songLibrary.set(playlist1Index, playlist2);
            songLibrary.remove(playlist2Index);
            return;
        }

        SongNode resultPlaylistNode = new SongNode();
        SongNode resultPlaylistLastNode = new SongNode();

        while( playlist1Size > 0 && playlist2Size > 0 )
        {
            SongNode playlist1Head = playlist1.getLast().getNext();
            SongNode playlist2Head = playlist2.getLast().getNext();
            if( playlist1Head.getSong().getPopularity() >= playlist2Head.getSong().getPopularity() )
            {
                if( resultPlaylist.getSize() == 0 )
                {
                    removeSong(playlist1Index, playlist1Head.getSong() );
                    playlist1Size--;
                    resultPlaylistLastNode = playlist1Head;
                    resultPlaylistLastNode.setNext(resultPlaylistLastNode);
                    resultPlaylist.setLast(resultPlaylistLastNode);
                    resultPlaylist.setSize(resultPlaylist.getSize() + 1);
                }
                else
                {
                    removeSong(playlist1Index, playlist1Head.getSong() );
                    playlist1Size--;
                    playlist1Head.setNext(resultPlaylistLastNode.getNext() );
                    resultPlaylistLastNode.setNext(playlist1Head);
                    resultPlaylistLastNode = playlist1Head;
                    resultPlaylist.setLast(resultPlaylistLastNode);
                    resultPlaylist.setSize(resultPlaylist.getSize() + 1);
                }
            }
            else if( playlist1Head.getSong().getPopularity() < playlist2Head.getSong().getPopularity() )
            {
                if( resultPlaylist.getSize() == 0 )
                {
                    removeSong(playlist2Index, playlist2Head.getSong() );
                    playlist2Size--;
                    resultPlaylistLastNode = playlist2Head;
                    resultPlaylistLastNode.setNext(resultPlaylistLastNode);
                    resultPlaylist.setLast(resultPlaylistLastNode);
                    resultPlaylist.setSize(resultPlaylist.getSize() + 1);
                }
                else
                {
                    removeSong(playlist2Index, playlist2Head.getSong() );
                    playlist2Size--;
                    playlist2Head.setNext(resultPlaylistLastNode.getNext() );
                    resultPlaylistLastNode.setNext(playlist2Head);
                    resultPlaylistLastNode = playlist2Head;
                    resultPlaylist.setLast(resultPlaylistLastNode);
                    resultPlaylist.setSize(resultPlaylist.getSize() + 1);
                }
            }
        }
            
        if( playlist1Size == 0 && playlist2Size != 0 )
        {
            while( playlist2Size > 0 )
            {
                SongNode playlist2Head = playlist2.getLast().getNext();
                removeSong(playlist2Index, playlist2Head.getSong() );
                playlist2Size--;
                playlist2Head.setNext(resultPlaylistLastNode.getNext() );
                resultPlaylistLastNode.setNext(playlist2Head);
                resultPlaylistLastNode = resultPlaylistNode;
                resultPlaylist.setLast(resultPlaylistLastNode);
                resultPlaylist.setSize(resultPlaylist.getSize() + 1);
            }
        }
        else if( playlist1Size != 0 && playlist2Size == 0 )
        {
            while( playlist1Size > 0 )
            {
                System.out.println( "Hello" );
                SongNode playlist1Head = playlist1.getLast().getNext();
                removeSong(playlist1Index, playlist1Head.getSong() );
                playlist1Size--;
                playlist1Head.setNext(resultPlaylistLastNode.getNext() );
                resultPlaylistLastNode.setNext(playlist1Head);
                resultPlaylistLastNode = playlist1Head;
                resultPlaylist.setLast(resultPlaylistLastNode);
                resultPlaylist.setSize(resultPlaylist.getSize() + 1);
            }
        }

        songLibrary.set(playlist1Index, resultPlaylist);
        removePlaylist(playlist2Index);
    }

    /**
     * This method shuffles a specified playlist using the following procedure:
     * 
     * 1. Create a new playlist to store the shuffled playlist in.
     * 
     * 2. While the size of the original playlist is not 0, randomly generate a number 
     * using StdRandom.uniformInt(1, size+1). Size contains the current number
     * of items in the original playlist.
     * 
     * 3. Remove the corresponding node from the original playlist and insert 
     * it into the END of the new playlist (1 being the first node, 2 being the 
     * second, etc). 
     * 
     * 4. Update the old playlist with the new shuffled playlist.
     *    
     * @param index the playlist to shuffle in songLibrary
     */
    public void shufflePlaylist(int playlistIndex) {
        // WRITE YOUR CODE HERE
        Playlist targetPlaylist = songLibrary.get(playlistIndex);
        Playlist shuffledPlaylist = new Playlist();
        int targetPlaylistSize = targetPlaylist.getSize();

        SongNode targetSong = targetPlaylist.getLast();
        while( targetPlaylistSize > 0 )
        {
            // int targetSongPosition = StdRandom.uniformInt(1, (targetPlaylistSize + 1) );
            int targetSongPosition = StdRandom.uniformInt(1, (targetPlaylistSize + 1) );
            for( int i = 0; i < targetSongPosition; i++ )
            {
                targetSong = targetSong.getNext();
            }

            removeSong(playlistIndex, targetSong.getSong() );
            
            if( shuffledPlaylist.getSize() == 0 )
            {
                shuffledPlaylist.setLast(targetSong);
                shuffledPlaylist.getLast().setNext(targetSong);
                shuffledPlaylist.setSize(shuffledPlaylist.getSize() + 1);
                targetPlaylistSize--;
            }
            else
            {
                targetSong.setNext(shuffledPlaylist.getLast().getNext() );
                shuffledPlaylist.getLast().setNext(targetSong);
                shuffledPlaylist.setLast(targetSong);
                shuffledPlaylist.setSize(shuffledPlaylist.getSize() + 1);
                targetPlaylistSize--;
            }
            targetSong = targetPlaylist.getLast();
        }

        songLibrary.set(playlistIndex, shuffledPlaylist);

    }

    /**
     * This method sorts a specified playlist using linearithmic sort.
     * 
     * Set the playlist located at the corresponding playlistIndex
     * in decreasing popularity index order.
     * 
     * This method should  use a sort that has O(nlogn), such as with merge sort.
     * 
     * @param playlistIndex the playlist to shuffle
     */
    public void sortPlaylist ( int playlistIndex ) {

        // WRITE YOUR CODE HERE
        
    }

    /**
     * ****DO NOT**** UPDATE THIS METHOD
     * Plays playlist by index; can use this method to debug.
     * 
     * @param playlistIndex the playlist to print
     * @param repeats number of times to repeat playlist
     * @throws InterruptedException
     */
    public void playPlaylist(int playlistIndex, int repeats) {
        /* DO NOT UPDATE THIS METHOD */

        final String NO_SONG_MSG = " has no link to a song! Playing next...";
        if (songLibrary.get(playlistIndex).getLast() == null) {
            StdOut.println("Nothing to play.");
            return;
        }

        SongNode ptr = songLibrary.get(playlistIndex).getLast().getNext(), first = ptr;

        do {
            StdOut.print("\r" + ptr.getSong().toString());
            if (ptr.getSong().getLink() != null) {
                StdAudio.play(ptr.getSong().getLink());
                for (int ii = 0; ii < ptr.getSong().toString().length(); ii++)
                    StdOut.print("\b \b");
            }
            else {
                StdOut.print(NO_SONG_MSG);
                try {
                    Thread.sleep(2000);
                } catch(InterruptedException ex) {
                    ex.printStackTrace();
                }
                for (int ii = 0; ii < NO_SONG_MSG.length(); ii++)
                    StdOut.print("\b \b");
            }

            ptr = ptr.getNext();
            if (ptr == first) repeats--;
        } while (ptr != first || repeats > 0);
    }

    /**
     * ****DO NOT**** UPDATE THIS METHOD
     * Prints playlist by index; can use this method to debug.
     * 
     * @param playlistIndex the playlist to print
     */
    public void printPlaylist(int playlistIndex) {
        StdOut.printf("%nPlaylist at index %d (%d song(s)):%n", playlistIndex, songLibrary.get(playlistIndex).getSize());
        if (songLibrary.get(playlistIndex).getLast() == null) {
            StdOut.println("EMPTY");
            return;
        }
        SongNode ptr;
        for (ptr = songLibrary.get(playlistIndex).getLast().getNext(); ptr != songLibrary.get(playlistIndex).getLast(); ptr = ptr.getNext() ) {
            StdOut.print(ptr.getSong().toString() + " -> ");
        }
        if (ptr == songLibrary.get(playlistIndex).getLast()) {
            StdOut.print(songLibrary.get(playlistIndex).getLast().getSong().toString() + " - POINTS TO FRONT");
        }
        StdOut.println();
    }

    public void printLibrary() {
        if (songLibrary.size() == 0) {
            StdOut.println("\nYour library is empty!");
        } else {
                for (int ii = 0; ii < songLibrary.size(); ii++) {
                printPlaylist(ii);
            }
        }
    }

    /*
     * Used to get and set objects.
     * DO NOT edit.
     */
     public ArrayList<Playlist> getPlaylists() { return songLibrary; }
     public void setPlaylists(ArrayList<Playlist> p) { songLibrary = p; }
}
