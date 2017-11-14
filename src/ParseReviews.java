import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class ParseReviews{
    Document doc;
    Elements items;
    String result, url;

    public ParseReviews(String url) throws IOException {
        this.url = url;
        this.doc = Jsoup.connect(url).get();
        this.items = doc.getElementsByAttributeValue("class", "g-rating");
    }

    public void get_result() throws IOException {
        for (Element item : this.items) {
            String n_url = item.child(0).attr("href");
            String n_rev = item.child(0).attr("data-count");
            if (n_rev.equals("")) {
                n_rev = "0";
            }
            result = n_rev + " reviews from " + n_url + " \n";
            System.out.println(result);
            new SaveResults(result, 1).save();
            new ParseStarReviews(n_url).get_result();
        }
    }
}
