public class Playlist {
    private class Song {
        String title;
        Song next;

        public Song(String title) {
            this.title = title;
            this.next = null;
        }
    }

    private Song head;

    public Playlist() {
        this.head = null;
    }

    public void addSong(String title) {
        Song newSong = new Song(title);
        if (head == null) {
            head = newSong;
        } else {
            Song current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newSong;
        }
    }

    public void displayPlaylist() {
        if (head == null) {
            System.out.println("Playlist kosong.");
        } else {
            Song current = head;
            while (current != null) {
                System.out.println(current.title);
                current = current.next;
            }
        }
    }

    public static void main(String[] args) {
        Playlist playlist = new Playlist();
        playlist.addSong("Dissolve");
        playlist.addSong("Magadir");
        playlist.addSong("Memories");

        playlist.displayPlaylist();
    }
}
