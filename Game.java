package ScrollingGame;

import java.util.ArrayList;
import java.util.Random;

public class Game
{
  private Grid grid;
  private int userRow;
  private int msElapsed;
  private int timesGet;
  private int timesAvoid;
  private int score;
  private int row=5;
  private int col=10;
  private int left=9;
  private int left1=11;
  private int left2=14;
  private int left3=19;
  private final int goLeft=9;
 
  
  public Game()
  {
	  
    grid = new Grid(row,col);
    userRow = 2;
    msElapsed = 0;
    timesGet = 0;
    timesAvoid = 0;
    updateTitle();
   
  }
  
  public void play()
  {
    while (!isGameOver())
    {
      Grid.pause(100);
      handleKeyPress();
     
      if (msElapsed % 300 == 0)
      {
    	  
        scrollLeft();
        populateRightEdge();
       
        
        
       
      }
      updateTitle();
      msElapsed += 100;
    }
  }
  
  public void handleKeyPress()
  {
	  int key=grid.checkLastKeyPressed();
	  handleCollision();
	  grid.setImage(new Location(userRow, 0), "user.gif");
	  if(key==38&&userRow>0)/*up key*/{
		  grid.setImage(new Location(userRow, 0), null);
		  userRow=userRow-1;
		  grid.setImage(new Location(userRow, 0), "user.gif");
		  
		  
	  }
	  if(key==40&&userRow<4)/*down key*/{
		  grid.setImage(new Location(userRow, 0), null);
		  userRow=userRow+1;
		  
		  grid.setImage(new Location(userRow, 0), "user.gif");
	  }
  }
  
  public int getRandomAvoid(){
	  Random r=new Random();
	  int Low = 0;
	  int High = 5;
	  int R = r.nextInt(High-Low) + Low;
	  return R;
  }
  public int getRandomGet(){
	  Random r=new Random();
	  int Low = 0;
	  int High = 5;
	  int R = r.nextInt(High-Low) + Low;
	  return R;
  }
  public int getRandomAvoid1(){
	  Random r=new Random();
	  int Low = 0;
	  int High = 5;
	  int R = r.nextInt(High-Low) + Low;
	  return R;
  }
  public int getRandomGet1(){
	  Random r=new Random();
	  int Low = 0;
	  int High = 5;
	  int R = r.nextInt(High-Low) + Low;
	  return R;
  }
  public int getRandomAvoid2(){
	  Random r=new Random();
	  int Low = 0;
	  int High = 5;
	  int R = r.nextInt(High-Low) + Low;
	  return R;
  }
  public int getRandomGet2(){
	  Random r=new Random();
	  int Low = 0;
	  int High = 5;
	  int R = r.nextInt(High-Low) + Low;
	  return R;
  }
 
 
 
  int avoidX=getRandomAvoid();
  int getX=getRandomGet();
  int avoidX1=getRandomAvoid1();
  int getX1=getRandomGet1();
  int avoidX2=getRandomAvoid2();
  int getX2=getRandomGet2();
 
  
  
  public void populateRightEdge()
  {
	  
	 
	 if(left<9&&left>=0){
		 grid.setImage(new Location(getX, left), "get.gif");
		 grid.setImage(new Location(avoidX, left), "avoid.gif");
		 
	
		 grid.setImage(new Location(getX, left+1), null);
		 grid.setImage(new Location(avoidX, left+1), null);
		 
	 }
	 if(left1<9&&left1>=0){
		 grid.setImage(new Location(getX1, left1), "get.gif");
		 grid.setImage(new Location(avoidX1, left1), "avoid.gif");
		 
		 
		 grid.setImage(new Location(getX1, left1+1), null);
		 grid.setImage(new Location(avoidX1, left1+1), null);
		 
	 }
	 if(left2<9&&left2>=0){
		 grid.setImage(new Location(getX2, left2), "get.gif");
		 grid.setImage(new Location(avoidX2, left2), "avoid.gif");
		 
		 
		 grid.setImage(new Location(getX2, left2+1), null);
		 grid.setImage(new Location(avoidX2, left2+1), null);
		 
	 }
	  
	  if(left<0){
		 
		  grid.setImage(new Location(getX, left+1), null);
		  grid.setImage(new Location(avoidX, left+1), null);
		  left=goLeft;
		  Random r=new Random();
		  int Low = 0;
		  int High = 5;
		  int R = r.nextInt(High-Low) + Low;
		  int R2 = r.nextInt(High-Low) + Low;
		  getX=R;
		  avoidX=R2;
		 }
	  if(left1<0){
			 
		  grid.setImage(new Location(getX1, left1+1), null);
		  grid.setImage(new Location(avoidX1, left1+1), null);
		  left1=goLeft;
		  Random r=new Random();
		  int Low = 0;
		  int High = 5;
		  int R = r.nextInt(High-Low) + Low;
		  int R2 = r.nextInt(High-Low) + Low;
		  getX1=R;
		  avoidX1=R2;
		 }
	  if(left2<0){
			 
		  grid.setImage(new Location(getX2, left2+1), null);
		  grid.setImage(new Location(avoidX2, left2+1), null);
		  left2=goLeft;
		  Random r=new Random();
		  int Low = 0;
		  int High = 5;
		  int R = r.nextInt(High-Low) + Low;
		  int R2 = r.nextInt(High-Low) + Low;
		  getX2=R;
		  avoidX2=R2;
		 }
	 
	 
	  
  }
  
  
  public void scrollLeft()
  {
	  handleCollision();
	 

	  if(left>=0){
	  left=left-1;
	  }
	  if(left1>=0){
		  left1=left1-1;
		  }
	  if(left2>=0){
		  left2=left2-1;
		  }
	  
		 
  }
   

	  

	  
	 
	  
  

  
  public void handleCollision()
  {
	  if(userRow==getX&&left==0){
		  timesGet=timesGet+1;
		  
	  }
	  else if(userRow==getX1&&left1==0){
		  timesGet=timesGet+1;
	  }
	  else if(userRow==getX2&&left2==0){
		  timesGet=timesGet+1;
	  }
	  else if(userRow==avoidX&&left==0){
		  timesAvoid=timesAvoid+1;
	  }
	  else  if(userRow==avoidX1&&left1==0){
		  timesAvoid=timesAvoid+1;
	  }
	  else if(userRow==avoidX2&&left2==0){
		  timesAvoid=timesAvoid+1;
	  }
	  else{
		  timesAvoid=timesAvoid;
		  timesGet=timesGet;
		  
	  }
	 
	  
  }
  
  public int getScore()
  {
	  score=timesGet-timesAvoid;
	  
    return score ;
  }
  
  public void updateTitle()
  {
    grid.setTitle("Game:  " + getScore());
  }
  
  public boolean isGameOver()
  {if(score<0){
	  return true;
  }
    return false;
  }
  
  public static void test()
  {
    Game game = new Game();
    game.play();
  }
  
  public static void main(String[] args)
  {
    test();
  }
}
