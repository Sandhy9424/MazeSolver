/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PROJECT;

import java.util.List;

/**
 *
 * @author 91887
 */
public class Dfs {
    public static boolean method(int [][]maze,int x,int y,List<Integer>path){
        if(maze[x][y]==9){
            path.add(x);
            path.add(y);
            return true;
        }
        if(maze[x][y]==0){
            maze[x][y]=2;
        int []dx={1,0,-1,0};
        int []dy={0,-1,0,1};
        for(int i=0;i<dx.length;i++){
           int nx=x+dx[i];
            int ny=y+dy[i];
            if(nx>=0&&nx<maze.length&&ny>=0&&ny<maze[0].length&&method(maze,nx,ny,path)){
                path.add(x);
                path.add(y);
                return true;
            }
        }
        }
        return false;
    }
}

