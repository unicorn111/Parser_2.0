import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveResults{
    File file;
    String result;
    public SaveResults(String result, int type) throws IOException {
        this.result = result;
        if (type == 1) {
            this.file = new File("parsing_reviews_results1.csv");
        }
        else if(type == 2) {
            this.file = new File("parsing_reviews_results2.csv");
        }
    }

    public void save(){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(this.file, true));
            writer.write(this.result);
            writer.flush();
            writer.close();
        }catch(IOException ex) {
            ex.printStackTrace();
        }
    }
}
