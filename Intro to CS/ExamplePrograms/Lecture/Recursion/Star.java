public class Star{
  public static void main(String[] args){
		StdDraw.setScale(-25, 25);
		drawStar(0,0,20);
   }

	public static void drawStar( int x, int y, int size ){
		int endX, endY ;
 
		//IF STATEMENT HERE TO STOP
		if( size < 1 )
			return;

		int r = (int)(Math.random()*255);
		int g =  (int)(Math.random()*255);
		int b =  (int)(Math.random()*255);
		StdDraw.setPenColor(r,g,b);
		// Six lines radiating from (x,y)
		for ( int i = 0; i< 6; i++ ){
			endX = x + (int)(size*Math.cos( (2*Math.PI/6)*i ));
			endY = y - (int)(size*Math.sin( (2*Math.PI/6)*i ));
			StdDraw.line( x, y, endX, endY );
			//Recursive call here
			drawStar(endX, endY, size/ 3 );	
		} 
	}
}


