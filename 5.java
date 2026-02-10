Check if given four points form a square 
Input: p1 = { 20, 10 }, p2 = { 10, 20 }, p3 = { 20, 20 }, p4 = { 10, 10 }
Output: Yes

package info;

class Point {
    int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Pri {
    public static void main(String[] args) {

        Point p1 = new Point(20, 10);
        Point p2 = new Point(10, 20);
        Point p3 = new Point(20, 20);
        Point p4 = new Point(10, 10);

        System.out.println(isSquare(p1, p2, p3, p4) ? "Yes" : "No");
    }

    static boolean isSquare(Point p1, Point p2, Point p3, Point p4) {

        int d1 = dist(p1, p2);
        int d2 = dist(p1, p3);
        int d3 = dist(p1, p4);
        int d4 = dist(p2, p3);
        int d5 = dist(p2, p4);
        int d6 = dist(p3, p4);

        int[] d = { d1, d2, d3, d4, d5, d6 };
        java.util.Arrays.sort(d);

        return d[0] > 0 &&
               d[0] == d[1] &&
               d[1] == d[2] &&
               d[2] == d[3] &&
               d[4] == d[5];
    }

    static int dist(Point a, Point b) {
        return (a.x - b.x) * (a.x - b.x) +
               (a.y - b.y) * (a.y - b.y);
    }
}
