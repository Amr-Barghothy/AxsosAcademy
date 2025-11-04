import java.util.ArrayList;
import java.util.Collections;

public class Museum {

    public static void main(String[] args) {
        Painting paint1 = new Painting("Scream","DeVinci1","An art","Acrylic");
        Painting paint2 = new Painting("Mona","DeVinci2","An art 2","WaterColor");
        Painting paint3 = new Painting("Scream2","DeVinci3","An art 3","Oil");
        Sculpture sculpture1 = new Sculpture("Scream3","DeVinci4","A Sculpture","Bronze");
        Sculpture sculpture2 = new Sculpture("Scream4","DeVinci5","A Sculpture 2","Concrete");
        ArrayList<Art> museum = new ArrayList<Art> ();
        museum.add(paint1);
        museum.add(paint2);
        museum.add(paint3);
        museum.add(sculpture1);
        museum.add(sculpture2);
        Collections.shuffle(museum);
        for (Art art : museum) {
            art.viewArt();
        }
    }
}
