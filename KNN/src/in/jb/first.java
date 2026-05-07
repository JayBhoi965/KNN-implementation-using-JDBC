package in.jb;

import java.sql.*;
import java.util.*;

class Neighbor {
    double distance;
    String genre;

    Neighbor(double distance, String genre) {
        this.distance = distance;
        this.genre = genre;
    }
}

public class first {

    public static void main(String[] args) throws Exception {

       
        String url = "jdbc:mysql://localhost:3306/KNN";
        String user = "root";
        String password = "123456789J";

        Connection con = DriverManager.getConnection(url, user, password);
        Statement stmt = con.createStatement();

        String query = "SELECT rating, duration, genre FROM movies";
        ResultSet rs = stmt.executeQuery(query);

        ArrayList<Double> ratingArr = new ArrayList<>();
        ArrayList<Integer> durationArr = new ArrayList<>();
        ArrayList<String> genreArr = new ArrayList<>();

        while (rs.next()) {
            ratingArr.add(rs.getDouble("rating"));
            durationArr.add(rs.getInt("duration"));
            genreArr.add(rs.getString("genre"));
        }

        con.close();
 
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter Rating: ");
        double inputRating = scan.nextDouble();

        System.out.print("Enter Duration: ");
        int inputDuration = scan.nextInt();

        scan.nextLine();  

        System.out.print("Enter Genre (optional, just for reference): ");
        String inputGenre = scan.nextLine();
 
        ArrayList<Neighbor> neighbors = new ArrayList<>();

        for (int i = 0; i < ratingArr.size(); i++) {

            double x1 = ratingArr.get(i);
            int y1 = durationArr.get(i);

            double distance = Math.sqrt(
                    Math.pow(inputRating - x1, 2) +
                    Math.pow(inputDuration - y1, 2)
            );

            neighbors.add(new Neighbor(distance, genreArr.get(i)));
        }

         
        Collections.sort(neighbors, (a, b) -> Double.compare(a.distance, b.distance));
 
        int k = 5;
 
        HashMap<String, Integer> voteMap = new HashMap<>();

        for (int i = 0; i < k; i++) {
            String g = neighbors.get(i).genre;
            voteMap.put(g, voteMap.getOrDefault(g, 0) + 1);
        }
 
        String predictedGenre = "";
        int maxVotes = 0;

        for (String g : voteMap.keySet()) {
            if (voteMap.get(g) > maxVotes) {
                maxVotes = voteMap.get(g);
                predictedGenre = g;
            }
        }
 
        System.out.println("\n Recommended Genre: " + predictedGenre);

        scan.close();
    }
}
