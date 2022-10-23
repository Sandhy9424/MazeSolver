/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import PROJECT.Dfs;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author 91887
 */
public class View extends JFrame implements ActionListener,MouseListener {
    private int [][]maze={ 
        {1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,0,1,0,1,0,1,0,0,0,0,0,1},
        {1,0,1,0,0,0,1,0,1,1,1,0,1},
        {1,0,0,0,1,1,1,0,0,0,0,0,1},
        {1,0,1,0,0,0,0,0,1,1,1,0,1},
        {1,0,1,0,1,1,1,0,1,0,0,0,1},
        {1,0,1,0,1,0,0,0,1,1,1,0,1},
        {1,0,1,0,1,1,1,0,1,0,1,0,1},
        {1,0,0,0,0,0,0,0,0,0,1,9,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1}
};
    private List<Integer>path=new ArrayList<>();
    private int []target={8,11};
    JButton sumbit;
    JButton cancel;
    JButton clear;
    View(){
     this.setSize(520,500);
     this.setTitle("MAZE SOLVER");
     this.setLayout(null);
     this.setLocationRelativeTo(null);
     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    sumbit =new JButton("Start");
    sumbit.addActionListener(this);
    sumbit.setBounds(110, 400, 80, 30);
    cancel =new JButton("Cancel");
    cancel.addActionListener(this);
    cancel.setBounds(210, 400, 80, 30);
    clear =new JButton("Clear");
    clear.addActionListener(this);
    clear.setBounds(310, 400, 80, 30);
    this.add(sumbit);
    this.add(cancel);
    this.add(clear);
    this.addMouseListener(this);
    }
    
    @Override
   public void actionPerformed(ActionEvent e){
       if(e.getSource()==sumbit){
           try{
               Dfs.method(maze, 1, 1,path);
               this.repaint();
           }
           catch(Exception excp){
               JOptionPane.showMessageDialog(null, excp.toString());
           }
       }
       if(e.getSource()==cancel){
          int flag= JOptionPane.showConfirmDialog(null,"Do you want to exit", "Sumbit", JOptionPane.YES_NO_OPTION);
         if(flag==0){
             System.exit(0);
         }
       }
       if(e.getSource()==clear){
           path.clear();
           for(int i=0;i<maze.length;i++){
               for(int j=0;j<maze[0].length;j++){
                   if(maze[i][j]==2){
                       maze[i][j]=0;
                   }
               }
               this.repaint();
           }
       }
   }
    @Override
  public void mouseClicked(MouseEvent e){
      if(e.getX()>=0&&e.getX()<=520&&e.getY()>=0&&e.getY()<=440){
          int x=e.getY()/40;
          int y=e.getX()/40;
          if(maze[x][y]==1){
              return;
          }
          Graphics g= getGraphics();
          g.setColor(Color.WHITE);
          g.fillRect(40*target[1],40*target[0],40,40);
          g.setColor(Color.RED);
          maze[target[0]][target[1]]=0;
          maze[x][y]=9;
          g.fillRect(40*y, 40*x, 40, 40);
          g.setColor(Color.BLACK);
          g.drawRect(40*y, 40*x, 40, 40);
          target[0]=x;
          target[1]=y;
      }
  }

    /**
     *
     * @param e
     */
    @Override
  public void mousePressed(MouseEvent e){
      
  }
    @Override
  public void mouseReleased(MouseEvent e){
      
  }
    @Override
  public void mouseEntered(MouseEvent e){
      
  }
    @Override
  public void mouseExited(MouseEvent e){
      
  }
    @Override
  public void paint(Graphics g){
      super.paint(g);
      for(int r=0;r<maze.length;r++){
          for(int c=0;c<maze[0].length;c++){
              Color color;
              color = switch (maze[r][c]) {
                  case 1 -> Color.BLACK;
                  case 9 -> Color.RED;
                  default -> Color.WHITE;
              };
              g.setColor(color);
              g.fillRect(40*c, 40*r, 40, 40);
              g.setColor(Color.BLACK);
              g.drawRect(40*c, 40*r, 40, 40);
              }
          }
      System.out.println(path);
      for(int i=0;i<path.size();i=i+2){
                  int pathx=path.get(i);
                  int pathy=path.get(i+1);
                  g.setColor(Color.GREEN);
                  g.fillRect(40*pathy, 40*pathx, 40, 40);
      }
  }
    public static void main(String[] args) {
        View view=new View();
        view.setVisible(true);
    }
}
