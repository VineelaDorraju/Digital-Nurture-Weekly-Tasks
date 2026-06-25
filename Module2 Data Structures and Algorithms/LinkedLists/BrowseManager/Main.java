public class Main {

    public static void main(String[] args) {

        Page google = new Page("Google");
        Page youtube = new Page("YouTube");
        Page github = new Page("GitHub");
        Page linkedin = new Page("LinkedIn");

        google.next = youtube;

        youtube.prev = google;
        youtube.next = github;

        github.prev = youtube;
        github.next = linkedin;
        linkedin.prev = github;

        HistoryManager browser = new HistoryManager(google);
        System.out.println("Current Page : " + browser.current.title);

        browser.current = browser.current.next;

        System.out.println("Visited : " +browser.current.title);

        browser.current = browser.current.next;
        System.out.println("Visited : " +browser.current.title);
        browser.current = browser.current.prev;
        System.out.println("Back To : " + browser.current.title);
        browser.current = browser.current.next;

        System.out.println("Forward To : " +browser.current.title);

        browser.current = browser.current.next;
        System.out.println("Visited : " + browser.current.title);
    }
}