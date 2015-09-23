package Chapter4;

import java.util.*;

/**
 * Created by Hao on 9/23/15.
 */
public class Solution47 {

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addDependencies("d", "a");
        graph.addDependencies("b", "f");
        graph.addDependencies("d", "b");
        graph.addDependencies("a", "f");
        graph.addDependencies("c", "d");
        List<String> buildOrder = getBuildOrder(graph);
        System.out.println(buildOrder);

    }

    public static List<String> getBuildOrder(Graph graph) {
        List<String> projectsDone = new ArrayList<>();
        while (graph.size() > 0) {
            Project proj = graph.removeNonDependencyProject();
            if (proj == null) {
                return null;
            }
            projectsDone.add(proj.getName());
            graph.removeAllDependencies(proj);
        }
        return projectsDone;
    }

    private static class Graph {
        public Graph() {
            projects = new HashMap<>();
        }

        public void addDependencies(String name1, String name2) {
            Project proj1 = projects.keySet().contains(name1)? projects.get(name1): new Project(name1);
            Project proj2 = projects.keySet().contains(name2)? projects.get(name2): new Project(name2);
            proj2.addDependency(proj1);
        }

        public Project getProject(String name) {
            return projects.get(name);
        }

        public int size() {
            return projects.size();
        }

        public void removeAllDependencies(Project proj) {
            for (Map.Entry<String, Project> entry: projects.entrySet()) {
                entry.getValue().removeDependency(proj);
            }
        }

        public Project removeNonDependencyProject() {
            for (Map.Entry<String, Project> entry : projects.entrySet()) {
                if (entry.getValue().getNumOfDependencies() == 0) {
                    Project temp = entry.getValue();
                    projects.remove(entry.getKey());
                    return temp;
                }
            }
            return null;
        }

        private HashMap<String, Project> projects;
    }

    private static class Project {
        public Project(String name) {
            this.name = name;
            this.dependencies = new HashSet<>();
        }

        public String getName() {
            return name;
        }

        public void addDependency(Project dependency) {
            dependencies.add(dependency);
        }

        public void removeDependency(Project dependency) {
            dependencies.remove(dependency);
        }

        public int getNumOfDependencies() {
            return dependencies.size();
        }

        private String name;
        private HashSet<Project> dependencies;
    }
}
