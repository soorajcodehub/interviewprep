package test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.Node;
import main.TopologicalSort;

import org.junit.Assert;
import org.junit.Test;

public class TopologicalSortTest {
  @Test
  public void test() {
    Node zero = new Node(0);
    Node one = new Node(1);
    Node two = new Node(2);
    Node three = new Node(3);
    Node four = new Node(4);
    Node five = new Node(5);
    Node six = new Node(6);

    zero.neighbors.add(one);
    zero.neighbors.add(two);
    zero.neighbors.add(five);
    one.neighbors.add(four);
    three.neighbors.add(two);
    three.neighbors.add(four);
    three.neighbors.add(five);
    three.neighbors.add(six);
    five.neighbors.add(two);
    six.neighbors.add(zero);
    six.neighbors.add(four);

    Map<Integer, Node> directedGraph = new HashMap<Integer, Node>();
    directedGraph.put(0, zero);
    directedGraph.put(1, one);
    directedGraph.put(2, two);
    directedGraph.put(3, three);
    directedGraph.put(4, four);
    directedGraph.put(5, five);
    directedGraph.put(6, six);

    TopologicalSort ts = new TopologicalSort(directedGraph);
    List<Node> result = ts.sort(directedGraph);
    Assert.assertEquals(3, result.get(0).label);
    Assert.assertEquals(6, result.get(1).label);
    Assert.assertEquals(0, result.get(2).label);
    Assert.assertEquals(5, result.get(3).label);
    Assert.assertEquals(2, result.get(4).label);
    Assert.assertEquals(1, result.get(5).label);
    Assert.assertEquals(4, result.get(6).label);
  }
}
