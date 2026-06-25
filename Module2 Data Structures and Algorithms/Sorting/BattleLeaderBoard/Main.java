public class Main {

    public static void main(String[] args) {

        Player p1 = new Player("Shadow", 4200);
        Player p2 = new Player("Blaze", 6100);
        Player p3 = new Player("Nova", 5700);
        Player p4 = new Player("Titan", 7300);
        Player p5 = new Player("Vortex", 6800);

        Player[] players = {p1, p2, p3, p4, p5};
        
Leaderboard leaderboard = new Leaderboard(players);
RankSystem ranking = new RankSystem(leaderboard);

        for (int i = 0; i < players.length - 1; i++) {

            for (int j = 0; j < players.length - i - 1; j++) {

                if (players[j].score < players[j + 1].score) {

                    Player temp = players[j];
                    players[j] = players[j + 1];
                    players[j + 1] = temp;
                }
            }
        }

        System.out.println("=== BATTLE ARENA RANKINGS ===");

        for (int i = 0; i < players.length; i++) {

            System.out.println(
                    (i + 1) + ". " +
                    players[i].name +
                    " - Score: " +
                    players[i].score
            );
        }

        System.out.println("\nChampion: " + players[0].name);
    }
}