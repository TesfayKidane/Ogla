package company.uber;

import java.util.*;

/**
 *
 * Let's write a simple mark-and-sweep garbage collector.
 *
 * 1. Mark phase:
 * You're given a list of all "known alive" objects, or "roots".
 * i.e. static objects, objects that are currently on the ds.linkedlist.stack, etc.
 *
 * Given these root objects, you traverse the object graph to mark the
 * objects that are reachable from any of them as "alive".
 *
 * Any object in the heap that cannot be reached by any of these roots
 * are marked as "dead" in this phase.
 *
 * 2. Sweep phase:
 * Go through all objects, if they are marked as "dead", free them.
 */
public class MarkNSweep {

    // define input  params:
    // knowAlive/roots: [0 - n]
    // connected objects [0 - m]
    // knowAlive Map<Integer, List<Integer>> knownAlive
    // All objects List<Integer>

    static class HeapObject {
        Object underlying;
        boolean isAlive;
        String name;
        List<HeapObject> refs;

        public HeapObject(String name) {
            this.name = name;
            isAlive = true;
            refs = new ArrayList<>();
        }
    }
    public static void mark(List<HeapObject> allObjects, List<HeapObject> roots) {
        if (allObjects == null || allObjects.isEmpty()) {
            return;
        }

        // first add all object to dead set, and remove it if any other object is refers it.
        Set<HeapObject> deadObjects = new HashSet<>(allObjects);

        // use dfs to check for each object in the graph
        dfs(roots, deadObjects);

        // remove objects form allObjects if they are in the deadObjects set.
        allObjects.removeIf(deadObjects::contains);

        for(HeapObject ho : allObjects) {
            System.out.println(ho.name + "--" + ho.isAlive);
        }
    }

    private static void dfs(List<HeapObject> roots, Set<HeapObject> deadObjects) {
        if(roots == null || roots.isEmpty()) return;
        for(HeapObject ho : roots) {
            deadObjects.remove(ho);
            dfs(ho.refs, deadObjects);
        }
    }

    public static void main(String[] args) {
        HeapObject a = new HeapObject("a");
        HeapObject b = new HeapObject("b");
        HeapObject c = new HeapObject("c");
        HeapObject d = new HeapObject("d");
        a.refs.add(b);
        b.refs.add(c);

        List<HeapObject> allObjects = new ArrayList<>();
        List<HeapObject> roots = new ArrayList<>();
        allObjects.add(a);
        allObjects.add(b);
        allObjects.add(c);
        allObjects.add(d);
        roots.add(a);

        mark(allObjects, roots);
    }
}
