import java.util.ArrayList;

public class DepthFirst {
    /*maze ---> our 2D grid,, x & y ---> are the idx of grid,,, path ---> will store the co-ordinates*/
    public static boolean searchPath(int[][] maze, int x , int y, ArrayList<Integer> path){
        /*if we reached our destination*/
        if(maze[y][x] == 9){
            path.add(x);
            path.add(y);
            return true;
        }

        /*if we can access the index*/
        if(maze[y][x] == 0){
            /*mark it visited with any random value,, we are marking with 2*/
            maze[y][x] = 2;
            /*Now if i can access the idx , i will marked it true ,, so i don't visit it again,, after that i can
            * go in any of the four directions,,, but i have to check on which direction i can move,, means which is
            * suitable for me*/

            /*if i can move upward*/
            int dx = -1;
            int dy = 0;
            if(searchPath(maze,x+dx,y+dy,path)){
                /*if i can acess in that direction then i will add that to the path*/
                path.add(x);
                path.add(y);
                return true;
            }

            /*if i can move downward*/
             dx = 1;
             dy = 0;
            if(searchPath(maze,x+dx,y+dy,path)){
                /*if i can acess in that direction then i will add that to the path*/
                path.add(x);
                path.add(y);
                return true;
            }

            /*if i can move left*/
             dx = 0;
             dy = -1;
            if(searchPath(maze,x+dx,y+dy,path)){
                /*if i can acess in that direction then i will add that to the path*/
                path.add(x);
                path.add(y);
                return true;
            }

            /*if i can move right*/
            dx = 0;
            dy = 1;
            if(searchPath(maze,x+dx,y+dy,path)){
                /*if i can acess in that direction then i will add that to the path*/
                path.add(x);
                path.add(y);
                return true;
            }
        }

        /*if we can't access any of the four directions or we hit the blocker i.e 1,, then return false*/
        return false;
    }
}
