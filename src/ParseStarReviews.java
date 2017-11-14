import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class ParseStarReviews{
    Document doc;
    Elements items;
    String result, url;

    public ParseStarReviews(String url)throws IOException {
        this.url = url;
        this.doc = Jsoup.connect(url).get();
        this.items = this.doc.getElementsByAttributeValue("class", "sprite g-rating-stars");
    }
    public void get_result() throws IOException {
        int  count = 0;
        for(Element item : items){
            int n_rev = Integer.parseInt(item.child(0).attr("content"));
            count += n_rev;
        }
        String result = count + " star_reviews from " + url + " \n";
        System.out.print(result);
        new SaveResults(result, 2).save();

    }
}
