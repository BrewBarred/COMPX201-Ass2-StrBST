import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
https://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram-in-java
*/

public class StrBSTPrinter {

    public static void printNode(Node root) {
        int maxLevel = StrBSTPrinter.maxLevel(root);
        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    public static void printNodeInternal(List<Node> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || StrBSTPrinter.isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int edgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        StrBSTPrinter.printWhitespaces(firstSpaces);

        List<Node> newNodes = new ArrayList<>();
        for (Node node : nodes) {
            if (node != null) {
                System.out.print(node.value);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            StrBSTPrinter.printWhitespaces(betweenSpaces);
        }

        System.out.println();

        for (int i = 1; i <= edgeLines; i++) {
            for (Node node : nodes) {
                StrBSTPrinter.printWhitespaces(firstSpaces - i);
                if (node == null) {
                    StrBSTPrinter.printWhitespaces(edgeLines + edgeLines + i + 1);
                    continue;
                }

                if (node.left != null)
                    System.out.print("/");
                else
                    StrBSTPrinter.printWhitespaces(1);

                StrBSTPrinter.printWhitespaces(i + i - 1);

                if (node.right != null)
                    System.out.print("\\");
                else
                    StrBSTPrinter.printWhitespaces(1);

                StrBSTPrinter.printWhitespaces(edgeLines + edgeLines - i);

            } // end for

            System.out.println();

        } // end for

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    public static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    public static int maxLevel(Node node) {
        if (node == null)
            return 0;

        return Math.max(StrBSTPrinter.maxLevel(node.left), StrBSTPrinter.maxLevel(node.right)) + 1;
    }

    public static boolean isAllElementsNull(List<Node> list) {
        for (Node node : list) {
            if (node != null)
                return false;
        }
        return true;
    }

}