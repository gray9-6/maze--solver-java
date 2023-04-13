import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Maze_Solver extends JFrame {
    /*It's a 2D array which represents our grid*/
    private int[][] maze =
            {       {1,1,1,1,1,1,1,1,1,1,1,1,1},
                    {1,0,1,0,1,0,1,0,0,0,0,0,1},
                    {1,0,1,0,0,0,1,0,1,1,1,0,1},
                    {1,0,1,1,1,1,1,0,0,0,0,0,1},
                    {1,0,0,1,0,0,0,0,1,1,1,0,1},
                    {1,0,1,0,1,1,1,0,1,0,0,0,1},
                    {1,0,1,0,1,0,0,0,1,1,1,0,1},
                    {1,0,1,0,1,1,1,0,1,0,1,0,1},
                    {1,0,0,0,0,0,0,0,0,0,1,9,1},
                    {1,1,1,1,1,1,1,1,1,1,1,1,1}
            };

    /*it will store the co-ordinates through which we will pass*/
    public ArrayList<Integer> path = new ArrayList<>();

    public Maze_Solver(){
        this.setTitle("Maze Solver");
        this.setBounds(300,100,600,400);
        this.getContentPane().setBackground(Color.GRAY);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /*calling the DFS function*/
        DepthFirst.searchPath(maze,1,1,path);
        System.out.println(path);
    }

    /*There is a predefined function paint,, which takes the graphics*/

    @Override
    public void paint(Graphics graphics){
        /*Translates the origin of the graphics context to the point (x, y) in the current coordinate system.
        Modifies this graphics context so that its new origin corresponds to the point (x, y) in this graphics
        context's original coordinate system. All coordinates used in subsequent rendering operations on this
        graphics context will be relative to this new origin.
        Params:
        x – the x coordinate. y – the y coordinate.*/
        graphics.translate(80,50);

        /*implementing loop on grid*/
        for(int i =0; i<maze.length; i++){
            for(int j =0; j<maze[0].length;j++){
                /*Now i want to set the color of grid*/
                Color color;
                /*we are using switch becoz we have only 3 choices
                * 0 --> accessible ,,,1 --> blocker,,,9 --> destination*/
                switch (maze[i][j]){
                    case 1: color = Color.BLACK;
                    break;
                    case 9: color = Color.RED;
                    break;
                    default: color = Color.WHITE;
                    break;
                }
                /*now we are setting the color of grid*/
                graphics.setColor(color);
                /*now we are filling the rectangle with this color*/
                graphics.fillRect(30*j,30*i,30,30);
                /*now segregating the grids ,,so grids can be visualized,,we had set the color, and draw a rectangle on grid*/
                graphics.setColor(Color.red);
                graphics.drawRect(30*j,30*i,30,30);
            }
        }
        /*now we are creating a path from starting point to ending/destination point*/
        /*here we are incrementing i by 2 becoz we have added both x and y in out path,, so after incrementing by 2
        i will get the x co-ordinate i.e. agar mai 11 ko 2 baar increment karunga tabhi mujhe wo same 11(x i.e. i) waala
        corrdinate mileaga.,,,[11, 8, 11, 7, 11, 6, 11, 5, 11, 4, 11, 3, 10, 3, 9, 3, 8, 3, 7, 3, 7, 4, 7, 5,]*/
        for(int i=0; i<path.size(); i+=2){
            int pathx = path.get(i);
            /*i will get the y by incrementing i+1;  i.e. agar mai i(jo 11 hai) ko i +1 karu toh mujhe y mil jaayega
            because we are adding x and then y ,, so after x(which is i) comes y.,, [11, 8, 11, 7, 11, 6, 11, 5]*/
            int pathy = path.get(i+1);
            System.out.println("X Co-ordinate" + pathx);
            System.out.println("Y Co-ordinate" + pathy);

            /*Now we will set the color of path and fill the rectangle of the path*/
            graphics.setColor(Color.GREEN);
            graphics.fillRect(30*pathx,30*pathy,20,20);

        }
    }

    public static void main(String[] args) {
        Maze_Solver solver = new Maze_Solver();

    }
}