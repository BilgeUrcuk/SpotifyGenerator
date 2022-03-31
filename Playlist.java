public class Playlist extends TrackBag<Tracks>{

    private int min_duration;
    // playlist constructor according to the min duration of the playlist.
    public Playlist(int min_duration){
      this.min_duration = min_duration;
    }

    public Playlist() {

    }
    // this generator works for created playlist.
    // this method takes playlist parameter that is created before and the popular genres according to their popularity order.
    public int playlist_generator(Playlist playlist, TrackBag<Tracks> popular_genre1,TrackBag<Tracks> popular_genre2,TrackBag<Tracks> popular_genre3 ) {
        int duration = 0;
        Tracks my_tracks = new Tracks();
        // first for loop adds and removes the tracks one by one with find_most_popular method.
        // if popular genre is null then loop breaks.
        for (int i = 0; i < popular_genre1.getCurrentSize(); i++) {
            while (duration <= playlist.getMin_duration()) {
                Tracks should_added = my_tracks.find_most_popular(popular_genre1);
                if (should_added == null) {
                    break;
                }
                playlist.add(should_added);
                duration = duration + should_added.getTrack_duration();
                popular_genre1.remove(should_added);
                i = 0;
            }
        }
        // same as first loop, the only difference is popular genre.
        for (int j = 0; j < popular_genre2.getCurrentSize(); j++) {
            while (duration <= playlist.getMin_duration()) {
                Tracks should_added2 = my_tracks.find_most_popular(popular_genre2);
                if (should_added2 == null) {
                    break;
                }
                playlist.add(should_added2);
                duration = duration + should_added2.getTrack_duration();
                popular_genre2.remove(should_added2);
                j = 0;
            }
        }

        // same as first loop, the only difference is popular genre.
        for (int k = 0; k < popular_genre3.getCurrentSize(); k++) {
            while (duration <= playlist.getMin_duration()) {
                Tracks should_added3 = my_tracks.find_most_popular(popular_genre3);
                if (should_added3 == null ) {
                    break;
                }
                playlist.add(should_added3);
                duration = duration + should_added3.getTrack_duration();
                popular_genre3.remove(should_added3);
                k = 0;
            }
        }
        return duration;
    }


    public int getMin_duration() {return min_duration;}

    public void setMin_duration(int min_duration) {this.min_duration = min_duration;}


}
