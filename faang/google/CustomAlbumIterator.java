package faang.google;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CustomAlbumIterator {

    List<String> album = new ArrayList<>();
    List<String> favourites = new ArrayList<>();
    int favouriteIndex = 0;
    int albumIndex = 0;

    HashSet<String> seen = new HashSet<>();


    public CustomAlbumIterator(List<String> album, List<String> favourites, int favouriteIndex, int albumIndex, HashSet<String> seen) {
        this.album = album;
        this.favourites = favourites;
        this.favouriteIndex = favouriteIndex;
        this.albumIndex = albumIndex;
        this.seen = seen;
    }

    public boolean hasNext(){
        return favouriteIndex < favourites.size() || albumIndex < album.size();
    }

    public String next(){
        if (favouriteIndex < favourites.size()){
            String photo = favourites.get(favouriteIndex++);
            seen.add(photo);
            return photo;
        }

        while(albumIndex < album.size()){
            String photo = album.get(albumIndex++);
            if (!seen.contains(photo)){
                seen.add(photo);
                return photo;
            }
        }

        return "No photo";
    }
}
