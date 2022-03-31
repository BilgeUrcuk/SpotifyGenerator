import java.io.IOException;
import java.util.Scanner;

public class FileManager {

    public void starsHere() throws IOException {
        FileIO fio = new FileIO();
        String filePath = "src/tracks.txt";
        TrackBag<Tracks> tr = new TrackBag<>();
        tr = fio.readFile(filePath);

        //creating the genre bags.
        TrackBag<Tracks> acoustic_tr1 = new TrackBag<>();
        TrackBag<Tracks> instrumental_tr1 = new TrackBag<>();
        TrackBag<Tracks> rock_tr1 = new TrackBag<>();
        TrackBag<Tracks> rap_tr1 = new TrackBag<>();
        TrackBag<Tracks> jazz_tr1 = new TrackBag<>();
        TrackBag<Tracks> pop_tr1 = new TrackBag<>();

        // adding bags to their tracks.
        for (int i =0; i<tr.getCurrentSize(); i++) {
            if (tr.get(i).getGenre_id()==1) { acoustic_tr1.add(tr.get(i));}
            else if (tr.get(i).getGenre_id()==2) { instrumental_tr1.add(tr.get(i));}
            else if (tr.get(i).getGenre_id()==3) { rock_tr1.add(tr.get(i));}
            else if (tr.get(i).getGenre_id()==4) { rap_tr1.add(tr.get(i));}
            else if (tr.get(i).getGenre_id()==5) { jazz_tr1.add(tr.get(i));}
            else if (tr.get(i).getGenre_id()==6) { pop_tr1.add(tr.get(i));}

        }

        System.out.println("Acoustic number of track is : " + acoustic_tr1.getCurrentSize());
        System.out.println("Instrumental number of track is : " + instrumental_tr1.getCurrentSize());
        System.out.println("Rock number of track is : " + rock_tr1.getCurrentSize());
        System.out.println("Rap number of track is : " + rap_tr1.getCurrentSize());
        System.out.println("Jazz number of track is : " + jazz_tr1.getCurrentSize());
        System.out.println("Pop number of track is : " + pop_tr1.getCurrentSize());

        System.out.println("_____________________________________________________________________________");
        int acoustic_total_duration = 0;
        int instrumental_total_duration = 0 ;
        int rock_total_duration = 0 ;
        int rap_total_duration = 0 ;
        int jazz_total_duration = 0 ;
        int pop_total_duration = 0 ;

        // calculating each genre tracks duration.
        for (int i = 0; i<acoustic_tr1.getCurrentSize(); i++ ) {acoustic_total_duration += acoustic_tr1.get(i).getTrack_duration();}
        for (int i = 0; i<instrumental_tr1.getCurrentSize(); i++ ) { instrumental_total_duration += instrumental_tr1.get(i).getTrack_duration();}
        for (int i = 0; i<rock_tr1.getCurrentSize(); i++ ) { rock_total_duration += rock_tr1.get(i).getTrack_duration();}
        for (int i = 0; i<rap_tr1.getCurrentSize(); i++ ) { rap_total_duration += rap_tr1.get(i).getTrack_duration();}
        for (int i = 0; i<jazz_tr1.getCurrentSize(); i++ ) { jazz_total_duration += jazz_tr1.get(i).getTrack_duration();}
        for (int i = 0; i<pop_tr1.getCurrentSize(); i++ ) { pop_total_duration += pop_tr1.get(i).getTrack_duration();}
        ;

        System.out.println("Acoustic total duration is "+ acoustic_total_duration);
        System.out.println("Instrumental total duration is "+ instrumental_total_duration );
        System.out.println("Rock total duration is "+ rock_total_duration);
        System.out.println("Rap total duration is "+ rap_total_duration);
        System.out.println("Jazz total duration is "+ jazz_total_duration);
        System.out.println("Pop total duration is "+ pop_total_duration );

        System.out.println("_____________________________________________________________________________");



        int playlist_number = 999999999;

        while (playlist_number!= 0) {
            // in the loop, genre contents will be change so this is a new genre creation to printing their new contents.
            TrackBag<Tracks> acoustic_tr = new TrackBag<>();
            TrackBag<Tracks> instrumental_tr = new TrackBag<>();
            TrackBag<Tracks> rock_tr = new TrackBag<>();
            TrackBag<Tracks> rap_tr = new TrackBag<>();
            TrackBag<Tracks> jazz_tr = new TrackBag<>();
            TrackBag<Tracks> pop_tr = new TrackBag<>();


            for (int i =0; i<tr.getCurrentSize(); i++) {
                if (tr.get(i).getGenre_id()==1) { acoustic_tr.add(tr.get(i));}
                else if (tr.get(i).getGenre_id()==2) { instrumental_tr.add(tr.get(i));}
                else if (tr.get(i).getGenre_id()==3) { rock_tr.add(tr.get(i));}
                else if (tr.get(i).getGenre_id()==4) { rap_tr.add(tr.get(i));}
                else if (tr.get(i).getGenre_id()==5) { jazz_tr.add(tr.get(i));}
                else if (tr.get(i).getGenre_id()==6) { pop_tr.add(tr.get(i));}

            }


            Scanner playlist_num = new Scanner(System.in);
            System.out.println("Enter the playlist number : ");
            playlist_number = playlist_num.nextInt();
            // this playlist creation to be able to use the playlist_generator method. That's all reason.
            Playlist playlist = new Playlist();

            // for average popularity program just adds the all number of popularity.
            if (playlist_number == 1){
                Playlist sleeping_playlist = new Playlist(2700);
                playlist.playlist_generator(sleeping_playlist, instrumental_tr,acoustic_tr, jazz_tr );
                int average_popularity =0;
                for ( int i = 0 ; i< sleeping_playlist.getCurrentSize(); i++) {
                    average_popularity += sleeping_playlist.get(i).getTrack_popularity();

                }
                System.out.println("Average popularity of sleeping playlist is : " + average_popularity);
                System.out.println("_____________________________________________________________________________");

            }
            else if (playlist_number == 2){
                Playlist workout_playlist = new Playlist(3600);
                int my_playlist = playlist.playlist_generator(workout_playlist, rap_tr, rock_tr, pop_tr );
                int average_popularity =0;


                for ( int i = 0 ; i< workout_playlist.getCurrentSize(); i++) {
                    average_popularity += workout_playlist.get(i).getTrack_popularity();

                }
                System.out.println("Average popularity of workout playlist is : " + average_popularity);
                System.out.println("_____________________________________________________________________________");
            }
            else if (playlist_number == 3) {
                Playlist dining_playlist = new Playlist(5400);
                int my_playlist = playlist.playlist_generator(dining_playlist, jazz_tr, acoustic_tr, instrumental_tr);
                int average_popularity =0;
                for ( int i = 0 ; i< dining_playlist.getCurrentSize(); i++) {
                    average_popularity += dining_playlist.get(i).getTrack_popularity();

                }
                System.out.println("Average popularity of dining playlist is : " + average_popularity);
                System.out.println("_____________________________________________________________________________");
            }
            else if (playlist_number == 4) {
                Playlist meditation_playlist = new Playlist(7200);
                int my_playlist = playlist.playlist_generator(meditation_playlist, instrumental_tr, acoustic_tr, jazz_tr);
                int average_popularity =0;
                for ( int i = 0 ; i< meditation_playlist.getCurrentSize(); i++) {
                    average_popularity += meditation_playlist.get(i).getTrack_popularity();
                }
                System.out.println("Average popularity of meditation playlist is : " + average_popularity);
                System.out.println("_____________________________________________________________________________");
            }
            else if (playlist_number == 5) {
                Playlist roadTrip_playlist = new Playlist(10800);
                int my_playlist = playlist.playlist_generator(roadTrip_playlist, rock_tr, pop_tr, acoustic_tr);
                int average_popularity =0;
                for ( int i = 0 ; i< roadTrip_playlist.getCurrentSize(); i++) {
                    average_popularity += roadTrip_playlist.get(i).getTrack_popularity();
                }
                System.out.println("Average popularity of road trip playlist is : " + average_popularity);
                System.out.println("_____________________________________________________________________________");
            }
            else {
                break;
            }

            // After the all calculations printing the new contents.
            System.out.println("Acoustic number of track is : " + acoustic_tr.getCurrentSize());
            System.out.println("Instrumental number of track is : " + instrumental_tr.getCurrentSize());
            System.out.println("Rock number of track is : " + rock_tr.getCurrentSize());
            System.out.println("Rap number of track is : " + rap_tr.getCurrentSize());
            System.out.println("Jazz number of track is : " + jazz_tr.getCurrentSize());
            System.out.println("Pop number of track is : " + pop_tr.getCurrentSize());

            System.out.println("_____________________________________________________________________________");
            // these initializations for set to zero the total duration for every round.
            int acoustic_total_duration2 = 0;
            int instrumental_total_duration2 = 0 ;
            int rock_total_duration2 = 0 ;
            int rap_total_duration2 = 0 ;
            int jazz_total_duration2 = 0 ;
            int pop_total_duration2 = 0 ;

            for (int i = 0; i<acoustic_tr.getCurrentSize(); i++ ) {acoustic_total_duration2 += acoustic_tr.get(i).getTrack_duration();}
            for (int i = 0; i<instrumental_tr.getCurrentSize(); i++ ) { instrumental_total_duration2 += instrumental_tr.get(i).getTrack_duration();}
            for (int i = 0; i<rock_tr.getCurrentSize(); i++ ) { rock_total_duration2 += rock_tr.get(i).getTrack_duration();}
            for (int i = 0; i<rap_tr.getCurrentSize(); i++ ) { rap_total_duration2 += rap_tr.get(i).getTrack_duration();}
            for (int i = 0; i<jazz_tr.getCurrentSize(); i++ ) { jazz_total_duration2 += jazz_tr.get(i).getTrack_duration();}
            for (int i = 0; i<pop_tr.getCurrentSize(); i++ ) { pop_total_duration2 += pop_tr.get(i).getTrack_duration();}
            ;

            System.out.println("Acoustic total duration is "+ acoustic_total_duration2);
            System.out.println("Instrumental total duration is "+ instrumental_total_duration2 );
            System.out.println("Rock total duration is "+ rock_total_duration2);
            System.out.println("Rap total duration is "+ rap_total_duration2);
            System.out.println("Jazz total duration is "+ jazz_total_duration2);
            System.out.println("Pop total duration is "+ pop_total_duration2 );

            System.out.println("_____________________________________________________________________________");

        }
    }
}
