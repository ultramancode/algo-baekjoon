import java.io.*;
import java.util.*;

public class Main {

    static int[] teamLeader;

    static int findTeamLeader(int person) {
        if (teamLeader[person] == person) {
            return person;
        }
        teamLeader[person] = findTeamLeader(teamLeader[person]);
        return teamLeader[person];
    }

    static void mergeTeams(int personA, int personB) {
        int teamA = findTeamLeader(personA);
        int teamB = findTeamLeader(personB);

        if (teamA == teamB) {
            return;
        }

        teamLeader[teamB] = teamA;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        teamLeader = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            teamLeader[i] = i;
        }

        st = new StringTokenizer(bf.readLine());
        int truthCount = Integer.parseInt(st.nextToken());
        int[] truthPeople = new int[truthCount];
        for (int i = 0; i < truthCount; i++) {
            truthPeople[i] = Integer.parseInt(st.nextToken());
        }

        List<int[]> parties = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int partySize = Integer.parseInt(st.nextToken());

            int[] partyPeople = new int[partySize];
            for (int j = 0; j < partySize; j++) {
                partyPeople[j] = Integer.parseInt(st.nextToken());
            }
            parties.add(partyPeople);

            for (int j = 1; j < partySize; j++) {
                mergeTeams(partyPeople[0], partyPeople[j]);
            }
        }

        boolean[] isTruthTeamLeader = new boolean[n + 1];
        for (int i = 0; i < truthCount; i++) {
            int truthTeamLeader = findTeamLeader(truthPeople[i]);
            isTruthTeamLeader[truthTeamLeader] = true;
        }

        int answer = 0;

        for (int[] party : parties) {
            boolean possibleParty = true;

            for (int person : party) {
                int leader = findTeamLeader(person);
                if (isTruthTeamLeader[leader]) {
                    possibleParty = false;
                    break;
                }
            }

            if (possibleParty) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
