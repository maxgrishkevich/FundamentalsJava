import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Music track1 = new Music("Yamakasi", "Minor", AudioType.mp3,
                "C:/ProgramFiles/Users/Tracks", "2:35", 3.57f, "09-07-2019");
        Music track2 = new Music("Brooklyn", "Atlant", AudioType.ogg,
                "C:/ProgramFiles/Users/Tracks", "3:44", 3.57f, "07-11-2020");
        Music track3 = new Music("Gold Edition", "Good luck", AudioType.flac,
                "C:/ProgramFiles/Users/Tracks", "4:55", 5.77f, "01-05-2016");
        Music track4 = new Music("Good morning", "Good day", AudioType.wav,
                "C:/ProgramFiles/Users/Tracks", "4:06", 5.00f, "24-03-2007");
        HashMap<Integer, Music> playlist = new HashMap<>();
        playlist.put(1, track1);
        playlist.put(2, track2);
        playlist.put(3, track3);
        playlist.put(4, track4);

        while(true) {
            System.out.println("Enter what you would to do:\n1.)Watch the playlist\n2.)Add track to list\n3.)Delete track from list\n4.)Exit the program");
            int choice = in.nextInt();
            if(choice>4 || choice<1){
                System.out.println("Input error!");
                System.exit(0);
            }
            switch (choice) {
                case (1):
                    Music obj1 = new Music();
                    obj1.showList(playlist);
                    break;
                case (2):
                    Music obj2 = new Music();
                    playlist = obj2.addToList(playlist);
                    obj2.showList(playlist);
                    break;
                case (3):
                    Music obj5 = new Music();
                    playlist = obj5.deleteFromList(playlist);
                    obj5.showList(playlist);
                    break;

                case (4):
                    System.out.println("Good luck)");
                    System.exit(0);
                    break;
            }
        }
    }
}
