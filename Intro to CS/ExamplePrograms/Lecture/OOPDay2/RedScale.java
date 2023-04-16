import java.awt.Color;
public class RedScale{
   public static void main(String[] args) {
      Picture pic = new Picture(args[0]);
    	// pic.show();

      for (int col = 0; col < pic.width(); col++) {
        for (int row = 0; row < pic.height(); row++)
        {
					Color c = pic.get( col, row );
					int red = c.getRed();
					Color newC = new Color( red, 0, 0 );
					pic.set(col, row, newC);
        }
			}
    	pic.show();
   }   
}
