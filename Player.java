import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {


    public String currMvt ;

    Player(){
        this.currMvt = "LEFT" ; 
    }

    public void setMvt(String mvt){
        this.currMvt = mvt ; 
    }
     
    public void escapeWall(int x , int y){


        if ( x + 1 == 30 && y  == 0  ){

            if(this.currMvt.equals("RIGHT")){
                this.setMvt("DOWN");
            }
            else{
                this.setMvt("LEFT");
            }
            
        }

        else if ( x == 0 && y == 0){
            
            if(this.currMvt.equals("LEFT")){
                this.setMvt("DOWN");
            }
            else{
                this.setMvt("RIGHT");
            }
            
        }

        else if ( x + 1 == 30 && y + 1 == 20 ){

            if(this.currMvt.equals("DOWN")){
                this.setMvt("LEFT");
            }
            else{
                this.setMvt("UP");
            }
            
        }


        else if(x == 0 && y + 1  == 20 ){
            if(this.currMvt.equals("LEFT")){
                this.setMvt("UP");
            }
            else{
                this.setMvt("RIGHT");
            }
        }



        else if( x + 1 == 30 || x  == 0 ){
            if(this.currMvt.equals("DOWN")){
                this.setMvt("DOWN");
            }
            else{
                this.setMvt("UP");
            }
            
        }

        

        
    }


    public static ArrayList<ArrayList<Integer>> boardGen(){

       ArrayList<ArrayList<Integer>> board = new ArrayList<ArrayList<Integer>>();


       //INIT BORDURE
       for(int i = 0 ; i<21;i++){
           ArrayList<Integer> tmp2 = new ArrayList<Integer>() ;
           if(i == 0 || i ==20 ){
               int value = 1 ;
               for( int j = 0 ; j<31 ; j++){
                   tmp2.add(value) ; 
               }
           }
           else{
               for(int j = 0 ; j<31 ; j++){
                   if(j == 0 || j == 30 ){
                       tmp2.add(1) ;
                   }
                   else{
                       tmp2.add(0) ; 
                   }
               }
           }
        
            board.add(tmp2) ; 

        }
       return board ; 
    }

    public static void main(String args[]) {

        Scanner in = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> board = Player.boardGen(); 
        Player player1 = new Player() ; 


        // game loop
        while (true) {

            int N = in.nextInt(); // total number of players (2 to 4).
            int P = in.nextInt(); // your player number (0 to 3).
            int tours = 0 ; 

            int[] p1 = new int[2] ;
            int[] p2 = new int[2] ; 


            for (int i = 0; i < N; i++) {
                int X0 = in.nextInt(); // starting X coordinate of lightcycle (or -1)
                int Y0 = in.nextInt(); // starting Y coordinate of lightcycle (or -1)
                int X1 = in.nextInt(); // starting X coordinate of lightcycle (can be the same as X0 if you play before this player)
                int Y1 = in.nextInt(); // starting Y coordinate of lightcycle (can be the same as Y0 if you play before this player)

                if(i == 0){
                    System.err.println("J1 => ");
                    System.err.println(X1);
                    System.err.println(Y1);
                    p1[0] = X1 ; 
                    p1[1] = Y1 ; 
                }
                else{
                    System.err.println("J2 => ");
                    System.err.println(X1);
                    System.err.println(Y1);
                    p2[0] = X1 ; 
                    p2[1] = Y1 ; 
                }
            }

            
            if( P == 0){
                player1.escapeWall(p1[0], p1[1]);
            }
            else{
                player1.escapeWall(p2[0], p2[1]);
            }
            System.out.println(player1.currMvt);

        
        }
    }
}