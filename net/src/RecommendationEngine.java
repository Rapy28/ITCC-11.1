import java.util.ArrayList;
import java.util.List;

public class RecommendationEngine {


    public List<VideoContent> getRecommendations(UserProfile user, List<VideoContent> allVideos) {
        List<VideoContent> recommendedVideos = new ArrayList<>();


        List<String> preferredGenres = user.getPreferredGenres();


        for (VideoContent video : allVideos) {
            if (preferredGenres.contains(video.getGenre())) {
                recommendedVideos.add(video);
            }
        }


        recommendedVideos.sort((v1, v2) -> v2.getDuration() - v1.getDuration()); // Sort in descending order of duration

        return recommendedVideos;
    }


    public List<VideoContent> searchVideos(List<VideoContent> allVideos, String searchTerm) {
        List<VideoContent> searchResults = new ArrayList<>();

        for (VideoContent video : allVideos) {
            if (video.getTitle().toLowerCase().contains(searchTerm.toLowerCase()) ||
                    video.getGenre().toLowerCase().contains(searchTerm.toLowerCase())) {
                searchResults.add(video);
            }
        }

        return searchResults;
    }
}
