import java.util.ArrayList;
import java.util.List;

public class Dependencies {
	public static void main(String[] args) {
		String[] projects = new String[] {"a", "b", "c", "d", "e", "f"};
        String[][] dependencies = new String[][]{{"a", "d"}, {"f", "b"}, {"b", "d"}, {"f", "a"}, {"d", "c"}};

        System.out.println("Dependency Order: " + dependencyOrder(projects, dependencies));
		
	}
	
	/*
	 * Build Order: You are given a list of projects and a list of dependencies
	 * 
	 * (which is a list of pairs of projects, where the second project is dependent
	 * 
	 * on the first project). All of a project's dependencies must be built before
	 * 
	 * the project is. Find a build order that will allow the projects to be built.
	 * 
	 * If there is no valid build order, return an error. Example: Input: projects:
	 * 
	 * a, b, c, d, e, f dependencies: (a, d), (f, b), (b, d), (f, a), (d, c) Output:
	 * 
	 * f, e, a, b, d, c
	 */
	
	public static List<String> dependencyOrder(String[] project, String[][] dependencies){
		List<String> order = new ArrayList<>();
		int c = 0;
		
		for(String i : project) {
			for(String[] j : dependencies) {
				if(!i.equals(j[1]))
					c++;
			}
			if (c == dependencies.length) {
                order.add(i);
            }
            c = 0;
		}
		for(int i=0; i<order.size(); i++) {
            for (String[] dependency : dependencies) {
                if (order.get(i).equals(dependency[0]) && !order.contains(dependency[1])) {
                    order.add(dependency[1]);
                }
            }
        }
		
		return order;
	}

}
