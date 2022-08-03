import java.util.HashMap;
import java.util.Set;

public class TrackList {
    public static void main(String[] args){
        HashMap<String, String> myTrackList = new HashMap<String, String>();

        myTrackList.put("Mr. Moom", "Its a real cold moon...");
        myTrackList.put("Dog Day", "Dog day baybee");
        myTrackList.put("For whom the bell", "Look to the sky rhy befor u die");
        myTrackList.put("LALAL", "Who boy hahah LALA");


        System.out.println(myTrackList);
        System.out.println(myTrackList.get("Dog Day"));
    }


}
