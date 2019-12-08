import java.lang.reflect.Array;
import java.util.*;

public class Main {

    //everything for normal work of dfs
    static ArrayList<Integer>[] graph;
    static boolean[] used;
    static boolean res = false;
    static int[] g;
    static int startVal;
    static ArrayList<Integer> path = new ArrayList<>();

    public static void main(String[] s) {
        Scanner in = new Scanner(System.in);

        int strap1, strap2;
        int n = in.nextByte(), m = in.nextByte();
        graph = new ArrayList[n+1];
        g = new int[n+1];
        used = new boolean[n+1];

        for(int i = 0; i < n+1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            strap1 = in.nextByte();
            strap2 = in.nextByte();
            graph[strap1].add(strap2);
            graph[strap2].add(strap1);
        }
        startVal = in.nextByte();
        int searchVal = in.nextByte();

        dfs(startVal , searchVal);

    }


    public static void dfs(int pos, int searchVal) {
        boolean res = false;
        used[pos] = true;
        for (int next : graph[pos]) {
            if (!used[next]) {
                  g[next] = pos;
                  if(next == searchVal)  {
                      used[next] = true;
                      res = true;
                      break;
                  }
                  dfs(next, searchVal);
            }
        }
        if (res) {
            for(int i = searchVal; i != startVal; i = g[i]) {
                path.add(i);
            }
            path.add(startVal);
            Collections.reverse(path);
            for (int i = 0; i < path.size(); i++) {
                System.out.print(path.get(i)+" ");
            }
        }
    }
}

