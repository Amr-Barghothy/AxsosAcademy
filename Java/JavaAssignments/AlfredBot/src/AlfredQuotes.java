import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class AlfredQuotes {

    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }

    public String guestGreeting(String name) {
        // YOUR CODE HERE
        return "Hello, " + name + ". Lovely to see you";
    }

    public String dateAnnouncement() {
        // YOUR CODE HERE
        Date date = new Date();
        return "It is currently " + date;
    }

    public String respondBeforeAlexis(String conversation) {
        // YOUR CODE HERE
        if (conversation.contains("Alexis")) {
            return "Right away, sir. She certainly isn't sophisticated enough for that.";
        } else if (conversation.contains("Alfred")) {
            return ("At your service. As you wish, naturally.");
        } else {
            return ("Right. And with that I shall retire.");
        }
    }

    // NINJA BONUS
    // See the specs to overload the guestGreeting method
    public String guestGreeting(String name, String timeOfTheDay) {
        return "Good " + timeOfTheDay + "," + name + ". Lovely to see you";
    }

    public String guestGreeting() {
        SimpleDateFormat amPmFormat = new SimpleDateFormat("a");
        Date date = new Date();
        String time = amPmFormat.format(date);

        if (time.equals("AM")) {
            return ("Good Morning. It's lovely to see you");
        } else if (time.equals("PM")) {
            return ("Good afternoon. It's lovely to see you");
        } else {
            return ("Unable to determine AM/PM.");
        }

    }

    // SENSEI BONUS
    // Write your own AlfredQuote method using any of the String methods you have learned!
    public String alfredGreeting(String message) {
        System.out.println("Welcome to Alfred");
        System.out.println("what word are you looking for in your message?");
        Scanner scanner = new Scanner(System.in);
        String word = scanner.next();
        return String.format(message.toUpperCase() + " your word that you looking for is at index: %d", message.indexOf(word));
    }

}