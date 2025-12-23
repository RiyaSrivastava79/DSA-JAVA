package Graph;
import java.util.*;

public class FloodFill {

    public void helper(int[][] image, int sr, int sc, int color, boolean vis[][], int orgCol) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length
                || vis[sr][sc] || image[sr][sc] != orgCol) {
            return;
        }

        // mark visited
        vis[sr][sc] = true;

        // fill with new color
        image[sr][sc] = color;

        // recursive calls (4-directionally)
        // left
        helper(image, sr, sc - 1, color, vis, orgCol);
        // right
        helper(image, sr, sc + 1, color, vis, orgCol);
        // up
        helper(image, sr - 1, sc, color, vis, orgCol);
        // down
        helper(image, sr + 1, sc, color, vis, orgCol);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean vis[][] = new boolean[image.length][image[0].length];
        int orgCol = image[sr][sc];

        // if color is already same, no need to do anything
        if (orgCol == color) return image;

        helper(image, sr, sc, color, vis, orgCol);
        return image;
    }

    public static void main(String args[]) {
        FloodFill sol = new FloodFill();  // ✅ fixed class name
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int[][] ans = sol.floodFill(image, 1, 1, 2);

        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
