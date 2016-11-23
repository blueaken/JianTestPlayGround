package type;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: blueaken
 * Date: 10/18/15 1:00 AM
 */
public class UndirectedGraphNode {
    public int label;
    public List<UndirectedGraphNode> neighbors;
    public UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
}
