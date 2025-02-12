import java.util.ArrayList;
import java.util.List;

public class UserProfile {
    private String userName;
    private List<VideoContent> viewingHistory;
    private List<String> preferredGenres;
    private List<String> searchHistory; // New field for search history

    public UserProfile(String userName) {
        this.userName = userName;
        this.viewingHistory = new ArrayList<>();
        this.preferredGenres = new ArrayList<>();
        this.searchHistory = new ArrayList<>(); // Initialize search history
    }


    public String getUserName() {
        return userName;
    }

    public List<VideoContent> getViewingHistory() {
        return viewingHistory;
    }

    public List<String> getPreferredGenres() {
        return preferredGenres;
    }

    public List<String> getSearchHistory() {
        return searchHistory;
    }


    public void addViewingHistory(VideoContent video) {
        viewingHistory.add(video);
        updatePreferredGenres(video);
    }


    private void updatePreferredGenres(VideoContent video) {
        String genre = video.getGenre();
        if (!preferredGenres.contains(genre)) {
            preferredGenres.add(genre);
        }
    }


    public void addSearchHistory(String searchTerm) {
        searchHistory.add(searchTerm);
    }

    public int getTotalWatchTime() {
        int totalTime = 0;
        for (VideoContent video : viewingHistory) {
            totalTime += video.getDuration();
        }
        return totalTime;
    }
}
