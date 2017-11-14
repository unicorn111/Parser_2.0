import java.io.IOException;

public class Parser {
    public static void main(String[] args) throws IOException {
        ParseReviews p1 = new ParseReviews("https://hard.rozetka.com.ua/ua/computers/c80095/filter/");
        p1.get_result();
    }
}
