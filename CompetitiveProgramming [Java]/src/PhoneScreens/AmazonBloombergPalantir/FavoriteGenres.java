package PhoneScreens.AmazonBloombergPalantir;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-01-18
 */
public class FavoriteGenres {

    public static void main(String[] args) {

        Map<String, List<String>> userMap = new HashMap<>();
        userMap.putIfAbsent("David", new ArrayList<>());
        userMap.get("David").add("song1");
        userMap.get("David").add("song2");
        userMap.get("David").add("song3");
        userMap.get("David").add("song4");
        userMap.get("David").add("song8");

        userMap.putIfAbsent("Emma", new ArrayList<>());
        userMap.get("Emma").add("song5");
        userMap.get("Emma").add("song6");
        userMap.get("Emma").add("song7");

        Map<String, List<String>> genreMap = new HashMap<>();
        genreMap.putIfAbsent("Rock", new ArrayList<>());
        genreMap.get("Rock").add("song1");
        genreMap.get("Rock").add("song3");

        genreMap.putIfAbsent("Dubstep", new ArrayList<>());
        genreMap.get("Dubstep").add("song7");

        genreMap.put("Techno", new ArrayList<>());
        genreMap.get("Techno").add("song2");
        genreMap.get("Techno").add("song4");

        genreMap.put("Pop", new ArrayList<>());
        genreMap.get("Pop").add("song5");
        genreMap.get("Pop").add("song6");

        genreMap.put("Jazz", new ArrayList<>());
        genreMap.get("Jazz").add("song8");
        genreMap.get("Jazz").add("song9");

        System.out.println(favoritegenre(userMap, genreMap));
    }

    public static Map<String, List<String>> favoritegenre(Map<String, List<String>> userMap, Map<String, List<String>> genreMap) {
        Map<String, List<String>> userToFavGenres = new HashMap<>();

        if (userMap == null || userMap.isEmpty()) return userToFavGenres;
        if (genreMap == null || genreMap.isEmpty()) return userToFavGenres;

        Map<String, String> songToGenre = new HashMap<>();
        for (Map.Entry<String, List<String>> entry : genreMap.entrySet()) {
            List<String> songs = entry.getValue();
            for (String song : songs) {
                songToGenre.putIfAbsent(song, entry.getKey());
            }
        }

        Map<String, Integer> genreCount;
        for (Map.Entry<String, List<String>> entry : userMap.entrySet()) {
            genreCount = new HashMap<>();
            userToFavGenres.put(entry.getKey(), new ArrayList<>());

            List<String> songs = entry.getValue();
            int max = 0;
            for (String song : songs) {
                String genre = songToGenre.get(song);
                genreCount.putIfAbsent(genre, 0);
                int currCount = genreCount.get(genre) + 1;
                genreCount.put(genre, currCount);
                max = Math.max(max, currCount);
            }

            for (Map.Entry<String, Integer> gcEntry : genreCount.entrySet()) {
                if (gcEntry.getValue() == max) {
                    userToFavGenres.get(entry.getKey()).add(gcEntry.getKey());
                }
            }
        }


        return userToFavGenres;
    }
}
