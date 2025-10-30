import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, String> trackList = new HashMap<>();
        trackList.put("ten duel commandments", " One, two, three, four, five, six, seven, eight, nine" +
                " It's the ten duel commandments" +
                " It's the ten duel commandments" +
                " Number one!" +
                " The challenge: demand satisfaction" +
                " If they apologize, no need for further action" +
                "Number two!" +
                " If they don't, grab a friend, that's your second" +
                " Your Lieutenant, when there's reckoning to be reckoned");

        trackList.put("Bad Liar", " Oh, hush, my dear, it's been a difficult year" +
                " And terrors don't prey on innocent victims" +
                " Trust me, darlin', trust me, darlin'" +
                " It's been a loveless year, I'm a man of three fears" +
                " Integrity, faith, and crocodile tears" +
                " Trust me, darlin', trust me, darlin'");

        trackList.put("The Duck Song", " A duck walked up to a lemonade stand" +
                " And he said to the man, running the stand" +
                " \"Hey! (Bum bum bum) Got any grapes?\"" +
                " The man said \"No, we just sell lemonade" +
                " But it’s cold and it's fresh, and it’s all home-made." +
                " Can I get you a glass?\"" +
                " The duck said “I’ll pass.”" +
                " Then he waddled away, waddle waddle" +
                " 'Til the very next day, bum bum bum bum bum ba-dum");

        trackList.put("Open Arms"," I know that you're tired of the war and bloodshed" +
                " Tell me, is this how we're supposed to live?" +
                " Look at how you grip your sword, enough said" +
                " Why should we take when we could give?" +
                " You can show a person that you trust them" +
                " When you stop and lower your guard" +
                " Here we have a chance for some adjustment" +
                " Give it a try, it's not that hard" +
                " I'm telling you" +
                " This life is amazing when you greet it with open arms" +
                " Whatever we face, we'll be fine if we're leading from the heart" +
                " No matter the place, we can light up the world" +
                " Here's how to start" +
                " Greet the world with open arms" +
                " Greet the world with open arms");

        System.out.println(trackList.get("ten duel commandments")+"\n\n");

        for (String key : trackList.keySet()) {
            System.out.println(key + ": " + trackList.get(key));
        }
    }
}
