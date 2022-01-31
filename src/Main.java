import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {


    public static void main (String[] args) throws IOException {
        JFrame jf=new JFrame("BRIGHTEN/DARKEN");
        String url= args[0];
        String choice=args[2];
        float val= Float.parseFloat(args[1]);
        if(choice.equals("brighter"))
        {
            BufferedImage src= ImageIO.read(new File(url));
            Brighten obj=new Brighten(src,val);
            Thread thread= new Thread(obj);
            thread.start();
            jf.getContentPane().add(obj);
            jf.setVisible(true);
            jf.setSize(325,270);
            jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
        }
        else if(choice.equals("darker"))
        {
            BufferedImage src= ImageIO.read(new File(url));
            Darken obj=new Darken(src,val);
            Thread thread= new Thread(obj);
            thread.start();
            jf.getContentPane().add(obj);
            jf.setVisible(true);
            jf.setSize(325,270);
            jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
        }
        else
            System.out.println("INVALID OPERATION ");




    }
}
