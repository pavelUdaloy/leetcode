import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class M_207_Course_Schedule {

    public static void main(String[] args) {
        int[][] ints = {{1, 0}};
        System.out.println(new M_207_Course_Schedule().canFinish(2, ints));

        int[][] prerequisites2 = {{1, 0}, {0, 1}};
        System.out.println(new M_207_Course_Schedule().canFinish(2, prerequisites2)); // false
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] cources = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            cources[prerequisite[0]]++;
        }

        List<Integer> spazy = new LinkedList<>();
        for (int i = 0; i < cources.length; i++) {
            if (cources[i] == 0) {
                spazy.add(i);
            }
        }

        int finishedCourses = 0;

        while (!spazy.isEmpty()) {
            Integer i = spazy.removeFirst();
            finishedCourses++;
            for (int[] prerequisite : prerequisites) {
                if (prerequisite[1] == i) {
                    cources[prerequisite[0]]--;
                    if (cources[prerequisite[0]] == 0) {
                        spazy.add(prerequisite[0]);
                    }
                }
            }
        }

        return finishedCourses == numCourses;
    }
}
