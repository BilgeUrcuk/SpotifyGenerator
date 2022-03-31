import java.io.*;
import java.util.Scanner;

public class FileIO {

    public TrackBag<Tracks> readFile(String filePath) throws IOException {
        // creating a general bag object for every track.
        TrackBag<Tracks> trackBag = new TrackBag<Tracks>();
        try {
            File myObj = new File(filePath);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String fileLine = myReader.nextLine();
                String[] line = fileLine.split(",");
                //reading the lines from the txt file and attaching them to their name.
                int genre_id = Integer.parseInt(line[0]);
                int track_id = Integer.parseInt(line[1]);
                int track_duration = Integer.parseInt(line[2]);
                int track_popularity = Integer.parseInt(line[3]);
                // adding the object to the bag.
                Tracks track = new Tracks(genre_id, track_id, track_duration, track_popularity);
                trackBag.add(track);
            }
            myReader.close();
        }
        catch (FileNotFoundException e ) {
            System.out.println("error");
            e.printStackTrace();
        }
        return trackBag;
    }

}
