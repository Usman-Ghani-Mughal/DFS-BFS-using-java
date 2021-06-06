
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dfs_bfs;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author usman
 */


class Graph
{
    private Stack<Integer> stack;
    private Queue<Integer> queue;
    private List<Integer> visitied_vertices;
    private int [][]GRAPH;
    private int number_of_nodes;
    
    Scanner input=new Scanner(System.in);
        
    public Graph() 
    {
        this.initializeSQV();
        this.makeGraph();
    }
    private void initializeSQV()
    {
        this.stack = new Stack<>();
        this.queue = new LinkedList<>(); 
        visitied_vertices = new ArrayList<>();
    }
    private void displayGraph()
    {
        System.out.println("\n<<<< ==================================================================================  >>>>\n");
        
        for(int row = 0; row < this.number_of_nodes; row++)
        {
            System.out.print("Node "+row+" : ");
            for(int col = 0; col < this.number_of_nodes; col++)
            {
                System.out.print(this.GRAPH[row][col]+" -> ");
            }
            System.out.println("");
        }
        
        System.out.println("\n<<<< ==================================================================================  >>>>\n");
        
        
    }
    private void makeGraph()
    {
        System.out.println("************ Welcome ***************");
        System.out.println("<====   First We need to make Graph    ====>");
        System.out.print("Enter the Number of Nodes In Graph : ");
        this.number_of_nodes = this.input.nextInt();
        this.GRAPH = new int[this.number_of_nodes][this.number_of_nodes];
        
        System.out.println("\n===========================================================================");
        System.out.println("Now I will Ask you about Edges from One node to another");
        System.out.println("Press  1 if edges is there");
        System.out.println("Press  0 if edges is not there");
        System.out.println("============================================================================\n");
        
        for(int node = 0; node < this.number_of_nodes; node++)
        {
            System.out.println("===========================================");
            System.out.println("Edges for Node : "+node);
            System.out.println("===========================================");
            for(int edge = 0; edge < this.number_of_nodes; edge++)
            {
                System.out.print("Edge from Node : "+node+"  to  Node : "+edge+" Goes Or Not: 0/1 : ");
                this.GRAPH[node][edge] = this.input.nextInt();
            }
        }
        
        System.out.println("<<< ******************************************************** >>>");
        System.out.println("\t Thanks For Makeing Graph with me");
        System.out.println("\t I am Strong Artificial Inteligence .... HAHAHAHA");
        System.out.println("\t.... Kidding :)  I am just a dump Code Written By Usman Ghani.");
        System.out.println("<<< ******************************************************** >>>");
    }
    public void BFS()
    {
        System.out.println("\n<<<< ==================================================================================  >>>>");
        System.out.println("\t<<<<\t  ***Welcome to BFS***  \t>>>>");
        System.out.println("<<<< ==================================================================================  >>>>\n");
        System.out.println("<<< ***This is Our Graph*** >>>");
        this.displayGraph();
        System.out.print("Please Enter the Start Node : ");
        int start_node = this.input.nextInt();
        System.out.print("Please Enter the Goal Node  : ");
        int goal_node = this.input.nextInt();
        
        this.queue.add(start_node);
        
        while(!this.queue.isEmpty())
        {
            int first_in_queue = this.queue.remove();
            this.visitied_vertices.add(first_in_queue);
            
            if(first_in_queue == goal_node)
            {
                System.out.println("::::::: -> Congrats Your are Reached to your Goal Node <- :::::::");
                System.out.print("Visited Nodes During BFS : ");
                System.out.println(visitied_vertices);
                this.initializeSQV();
                return;
            }
            
            for(int edge = 0; edge < this.number_of_nodes; edge++)
            {
                if(this.GRAPH[first_in_queue][edge] == 1)
                {
                    if(!queue.contains(edge) && !this.visitied_vertices.contains(edge))
                    {
                        this.queue.add(edge);
                    }
                }
            }
        }
        System.out.println("::::::: -> Sorry Your are Not Reached to your Goal Node <- :::::::");
        System.out.println("::::::: -> Goal Node Is Not Found <- :::::::");
        System.out.print("Visited Nodes During BFS : ");
        System.out.println(visitied_vertices);
        this.initializeSQV();
        
    }
    
    public void DFS()
    {
        System.out.println("\n<<<< ==================================================================================  >>>>");
        System.out.println("\t<<<<\t  ***Welcome to DFS***  \t>>>>");
        System.out.println("<<<< ==================================================================================  >>>>\n");
        System.out.println("<<< ***This is Our Graph*** >>>");
        this.displayGraph();
        System.out.print("Please Enter the Start Node : ");
        int start_node = this.input.nextInt();
        System.out.print("Please Enter the Goal Node  : ");
        int goal_node = this.input.nextInt();
        
        this.stack.add(start_node);
        this.visitied_vertices.add(start_node);
        
        while(!stack.isEmpty())
        {
            int top_of_satck = this.stack.peek();
            if(top_of_satck == goal_node)
            {
                System.out.println("::::::: -> Congrats Your are Reached to your Goal Node <- :::::::");
                System.out.print("Visited Nodes During DFS : ");
                System.out.println(visitied_vertices);
                this.initializeSQV();
                return;
            }
            boolean pop_node = true;
            for(int i = 0; i < this.number_of_nodes; i++)
            {
              if(this.GRAPH[top_of_satck][i]==1 && !this.visitied_vertices.contains(i))
              {
                  this.stack.add(i);
                  this.visitied_vertices.add(i);
                  pop_node = false;
                  break;
              }
              
            }
            if(pop_node)
            {
                System.out.println("Poped Node : "+this.stack.pop());
            }
        }
        System.out.println("::::::: -> Sorry Your are Not Reached to your Goal Node <- :::::::");
        System.out.println("::::::: -> Goal Node Is Not Found <- :::::::");
        System.out.print("Visited Nodes During DFS : ");
        System.out.println(visitied_vertices);
        this.initializeSQV();
        
        
    }
     
}



public class DFS_BFS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Graph mygraph = new Graph();
        boolean end_of_program = false;
        while(!end_of_program)
        {
            System.out.println("Press 1 for DFS");
            System.out.println("Press 2 for BFS");
            System.out.println("Press 3 for Exit");
            int choice = mygraph.input.nextInt();
            switch(choice)
            {
                case 1:
                {
                    mygraph.DFS();
                    break;
                }
                case 2:
                {
                    mygraph.BFS();
                    break;
                }
                case 3:
                {
                    end_of_program = true;
                    break;
                }
                default:
                {
                    end_of_program = true;
                }
            }
        }
    }
    
}
