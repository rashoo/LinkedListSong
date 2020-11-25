import java.util.*;

/*
Playlist for a song, with Song class,
Title, and Durations for songs.
Albums stored in an ArrayList
Playlist can have different songs from
other albums.
Once a playlist is created, create a menu to
Quit, Skip, and forward to next song and backwards to
previous song.
 */
public class LinkedListSong {

    private static ArrayList<Album> albumCollection = new ArrayList<Album>();

    public static void main(String[] args) {
        Album album = new Album("folklore", "Taylor Swift");
        album.addSong("the 1", 3.30);
        album.addSong("cardigan", 3.59);
        album.addSong("the last great american dynasty", 3.59);
        album.addSong("exile", 4.45);
        album.addSong("my tears ricochet", 4.15);
        album.addSong("mirrorball", 3.29);
        album.addSong("seven", 3.28);
        album.addSong("august", 4.21);
        album.addSong("this is me trying", 3.15);
        album.addSong("illicit affairs", 3.10);
        album.addSong("mad woman", 3.57);
        album.addSong("epiphany", 4.49);
        album.addSong("betty", 4.54);
        album.addSong("peace", 3.54);
        album.addSong("hoax", 3.40);
        albumCollection.add(album);

        album = new Album("In Between Dreams", "Jack Johnson");
        album.addSong("Better Together", 3.27);
        album.addSong("Never Know", 3.32);
        album.addSong("Banana Pancakes", 3.12);
        album.addSong("Good People", 3.28);
        album.addSong("No Other Way", 3.09);
        album.addSong("Sitting, Waiting, Wishing", 3.03);
        album.addSong("Staple It Together", 3.17);
        album.addSong("Situations", 1.17);
        album.addSong("Crying Shame", 3.06);
        album.addSong("If I Could", 2.25);
        album.addSong("Breakdown", 3.32);
        album.addSong("Belle", 1.43);
        album.addSong("Do You Remember", 2.24);
        album.addSong("Constellations", 3.21);
        albumCollection.add(album);

        LinkedList<Song> playList = new LinkedList<Song>();
        albumCollection.get(0).addToPlayList("cardigan", playList);
        albumCollection.get(1).addToPlayList("Better Together", playList);
        play(playList);
    }

    private static void play(LinkedList<Song> playList) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();
        if (playList.size() == 0) {
            System.out.println("No songs in playlist");
            return;
        } else {
            System.out.println("Now playing " + listIterator.next().toString());
            printMenu();
        }

        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("Playlist complete.");
                    quit = true;
                    break;
                case 1:
                    if (!forward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.next().toString());
                    } else {
                        System.out.println("We have reached the end of the playlist.");
                        forward = false;
                    }
                    break;
                case 2:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now playing " + listIterator.previous().toString());
                    } else {
                        System.out.println("At the start of the playlist.");
                        forward = true;
                    }
                    break;
                case 3:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            System.out.println("Now replaying " + listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("Start of the list.");
                        }
                    }
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if (playList.size() > 0) {
                        listIterator.remove();
                        if (listIterator.hasNext()) {
                            System.out.println("Now playing " + listIterator.next());
                        } else if (listIterator.hasPrevious()) {
                            System.out.println("Now playing " + listIterator.previous());
                        }
                    }
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Available actions:\npress");
        System.out.println("0 - to quit\n" +
                "1 - play next song\n" +
                "2 - play previous song\n" +
                "3 - replay the current song\n" +
                "4 - list songs in the playlist\n" +
                "5 - print available actions.\n" +
                "6 - delete current song from playlist");
    }

    private static void printList(LinkedList<Song> playList) {
        Iterator<Song> iterator = playList.iterator();
        System.out.println("*********************************");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("*********************************");
    }
}
