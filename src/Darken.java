import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;


@SuppressWarnings("serial")
public class Darken extends JPanel implements Runnable
{
    BufferedImage src;
    BufferedImage dest;
    float val;
    public Darken(BufferedImage image,float val) throws IOException
    {
        this.src=image;
        this.val=val;
    }

    @Override
    public void run()
    {
        dest=changeBrightness(src,val);
    }
    @Override
    public void paintComponent(Graphics g)
    {
        Graphics2D g2d=(Graphics2D)g;
        try{

            g2d.drawImage(dest,0,0,this);
            //writing new image to a file in jpeg format
            ImageIO.write(dest,"jpeg",new File("C:\\Users\\Asus\\Desktop\\SENG 383\\hw3\\src\\new.jpg"));
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public BufferedImage changeBrightness(BufferedImage src,float val)
    {
        RescaleOp brighterOp = new RescaleOp(val, 0, null);
        return brighterOp.filter(src,null); //filtering
    }



}


