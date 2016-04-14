package sandbox;
import javax.swing.*;
/**
 *
 * @author Matthew
 */
public class WeatherFrame extends JFrame{
    ImageIcon sunnyImage;
    ImageIcon cloudyImage;
    ImageIcon rainyImage;
    ImageIcon snowyImage;
    JLabel tempLable;
    JButton weatherIcon;
    WeatherFrame(){
        JFrame f = new JFrame();
        JPanel p = new JPanel();
        tempLable = new JLabel();
        weatherIcon = new JButton();
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(150,150);
        f.setResizable(false);
        f.add(p);
        p.add(tempLable);
        p.add(weatherIcon);
        
        sunnyImage = new ImageIcon("src/sandbox/WeatherImages/Sunny.gif");
        cloudyImage = new ImageIcon("src/sandbox/WeatherImages/Cloudy.gif");
        rainyImage = new ImageIcon("src/sandbox/WeatherImages/Rainy.gif");
        snowyImage = new ImageIcon("src/sandbox/WeatherImages/Snowy.gif");
        
    }
}
