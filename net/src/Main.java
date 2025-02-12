import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        VideoContent video1 = new VideoContent("Action Movie 1", "Action", 120);
        VideoContent video2 = new VideoContent("Comedy Movie 1", "Comedy", 90);
        VideoContent video3 = new VideoContent("Action Movie 2", "Action", 130);
        VideoContent video4 = new VideoContent("Drama Movie 1", "Drama", 150);
        VideoContent video5 = new VideoContent("Comedy Movie 2", "Comedy", 80);


        List<VideoContent> allVideos = new ArrayList<>();
        allVideos.add(video1);
        allVideos.add(video2);
        allVideos.add(video3);
        allVideos.add(video4);
        allVideos.add(video5);

        // Create a user profile
        UserProfile user = new UserProfile("Raphael Magaso");


        user.addViewingHistory(video1);
        user.addViewingHistory(video2);
        user.addViewingHistory(video3);

        System.out.println(user.getUserName() + "'s Viewing History:");
        for (VideoContent video : user.getViewingHistory()) {
            System.out.println(video.getTitle() + " (" + video.getGenre() + ") - " + video.getDuration() + " mins");
        }


        RecommendationEngine recommendationEngine = new RecommendationEngine();


        List<VideoContent> recommendedVideos = recommendationEngine.getRecommendations(user, allVideos);


        System.out.println("\nRecommended Videos for " + user.getUserName() + ":");
        for (VideoContent video : recommendedVideos) {
            System.out.println(video.getTitle() + " (" + video.getGenre() + ") - " + video.getDuration() + " mins");
        }


        user.addSearchHistory("Action");
        user.addSearchHistory("Comedy");


        System.out.println("\nSearch History for " + user.getUserName() + ":");
        for (String searchTerm : user.getSearchHistory()) {
            System.out.println(searchTerm);
        }

        System.out.println("\nSearch Results for 'Comedy':");
        List<VideoContent> searchResults = recommendationEngine.searchVideos(allVideos, "Comedy");
        for (VideoContent video : searchResults) {
            System.out.println(video.getTitle() + " (" + video.getGenre() + ") - " + video.getDuration() + " mins");
        }


        System.out.println("\nSearch Results for 'Action':");
        searchResults = recommendationEngine.searchVideos(allVideos, "Action");
        for (VideoContent video : searchResults) {
            System.out.println(video.getTitle() + " (" + video.getGenre() + ") - " + video.getDuration() + " mins");
        }
    }
}
