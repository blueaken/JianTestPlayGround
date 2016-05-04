package type;

import java.util.ArrayList;

/**
 * Author: blueaken
 * Date: 5/4/16 14:37
 */
public class DirectedGraphNode {
    public int label;
    public ArrayList<DirectedGraphNode> neighbors;
    public DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<>(); }
}
