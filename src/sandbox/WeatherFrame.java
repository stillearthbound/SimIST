package sandbox;
import javax.swing.*;
/**
 *
 * @author Matthew
 */
public class WeatherFrame extends JFrame{
    private ImageIcon sunnyImage;
    private ImageIcon cloudyImage;
    private ImageIcon rainyImage;
    private ImageIcon snowyImage;
    WeatherFrame(){
        JFrame f = new JFrame();
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(150,150);
        f.setResizable(false);
        sunnyImage = new ImageIcon("src/sandbox/WeatherImages/Sunny.gif");
        cloudyImage = new ImageIcon("src/sandbox/WeatherImages/Cloudy.gif");
        rainyImage = new ImageIcon("src/sandbox/WeatherImages/Rainy.gif");
        snowyImage = new ImageIcon("src/sandbox/WeatherImages/Snowy.gif");
        
    }
}
