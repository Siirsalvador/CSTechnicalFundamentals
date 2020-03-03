package PhoneScreens.Palantir;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-02-22
 */
public class ResourceControl {

    //Nodes to parent nodes
    Map<String, Node> idToNode;

    ResourceControl() {
        idToNode = new HashMap<>();
    }

    boolean askAccess(String resource) {

        Node curr = idToNode.get(resource);
        int time = curr.time;
        //boolean hasAccess = curr.hasAccess;

        Queue<Node> ancestors = new ArrayDeque<>();
        ancestors.offer(curr.ancestor);

        while (!ancestors.isEmpty()) {
            Node p = ancestors.poll();

            if (p == null) continue;

            if (p.time > curr.time) {
                curr.time = p.time;
                curr.hasAccess = p.hasAccess;
            }

            ancestors.offer(p.ancestor);
        }

        curr.time = time;
        return curr.hasAccess;
    }

    void grantAccess(String resource) {
        Node curr = idToNode.get(resource);
        curr.hasAccess = true;
        //Set current time
    }

    void revokeAccess(String resource) {
        Node curr = idToNode.get(resource);
        curr.hasAccess = false;
        //Set current time
    }


}


class Node {
    String name;
    boolean hasAccess;
    Integer time;
    Node ancestor;
}