package com.nicobrailo.pianoli;

public class AllSongsMelody implements Melody {

    public static final Melody[] songs = new Melody[] {
            SingleSongMelody.twinkle_twinkle_little_star,
            SingleSongMelody.insy_winsy_spider,
            SingleSongMelody.im_a_little_teapot
    };

    private int song_idx = 0;

    /**
     * Cycle through all available {@link SingleSongMelody} songs, and when the last note of the
     * last melody is hit, go back to the first again.
     */
    @Override
    public String nextNote() {

        if (songs[song_idx].hasNextNote()) {
            return songs[song_idx].nextNote();
        }

        song_idx = (song_idx + 1) % songs.length;

        // If we have cycled through all the songs, this songs internal pointer will be at the last
        // note. That is okay, because this will cause it to wrap around to the beginning again.
        return songs[song_idx].nextNote();
    }

    @Override
    public boolean hasNextNote() {
        return song_idx < songs.length - 1 || songs[song_idx].hasNextNote();
    }
}
