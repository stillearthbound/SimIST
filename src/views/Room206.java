/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import models.CharacterMovement;
import models.Customer;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author qpm5006
 */
//public final class Room206 extends JPanel implements KeyListener{
    

public class Room206 extends JPanel {

    public static final int ShelfWidth = 60;
    public static final int ShelfHeight = 15;
    public static final int LongtableWidth = 175;
    public static final int MiddletableWidth = 90;
    public static final int ShorttableWidth = 18;
    public static final int TableHeight = 15;
    public static final int CornertableWidth = 30;
    public static final int CornertableHeight = 64;
    public static final int WallUDWidth = 450;
    public static final int WallUDHeight = 45;
    public static final int WallLRWidth= 15;
    public static final int WallLRHeight = 600;



    private Rectangle shelf1;
    private Rectangle shelf2;
    private Rectangle longtable;
    private Rectangle middletable1;
    private Rectangle middletable2;
    private Rectangle middletable3;
    private Rectangle middletable4;
    private Rectangle middletable5;
    private Rectangle middletable6;
    private Rectangle shorttable;
    private Rectangle cornertable1;
    private Rectangle cornertable2;
    private Rectangle key;
    private Rectangle wallUD1;
    private Rectangle wallUD2;
    private Rectangle wallLR1;
    private Rectangle wallLR2;
    
    private CharacterMovement characterMovement;
    private Customer student;

    private JLabel temp = new JLabel();
    private JLabel msg = new JLabel();

    public Room206(Customer inf_Student, CharacterMovement inf_charMovement) {
        super();
        student = inf_Student;
        characterMovement = inf_charMovement;
        setSize(537, 670);
        add(temp);
        temp.setBounds(200,200,200,200);
        msg.setLocation(200, 500);
        msg.setText("Room206 is lock! You need to find the key!");
        add(msg);
        init();
        placeStations();
//        this.addKeyListener(characterMovement);

        this.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e)
            {
                //System.out.println(e.getPoint());
           
                temp.setText(e.getPoint().toString());
                
            }
        });
        this.setFocusable(true);
    }

    private void init() {
        shelf1 = new Rectangle();
        shelf2 = new Rectangle();
        longtable = new Rectangle();
        middletable1 = new Rectangle();
        middletable2 = new Rectangle();
        middletable3 = new Rectangle();
        middletable4 = new Rectangle();
        middletable5 = new Rectangle();
        middletable6 = new Rectangle();
        shorttable = new Rectangle();
        cornertable1 = new Rectangle();
        cornertable2 = new Rectangle();
        key = new Rectangle();
        wallUD1 = new Rectangle();
        wallUD2 = new Rectangle();
        wallLR1 = new Rectangle();
        wallLR2 = new Rectangle();

   
        
        
    }

    private void placeStations() {
        student.setBounds(450, 150, student.width, student.height);
        shelf1.setBounds(43, 100, ShelfWidth, ShelfHeight);
        shelf2.setBounds(363,100,ShelfWidth, ShelfHeight);
        longtable.setBounds(142, 162, LongtableWidth, TableHeight);
        middletable1.setBounds(94,256,MiddletableWidth, TableHeight);
        middletable2.setBounds(266,256,MiddletableWidth, TableHeight);
        middletable3.setBounds(94,356,MiddletableWidth, TableHeight);
        middletable4.setBounds(266,356,MiddletableWidth, TableHeight);
        middletable5.setBounds(94,456,MiddletableWidth, TableHeight);
        middletable6.setBounds(266,456,MiddletableWidth, TableHeight);
        shorttable.setBounds(436, 449, ShorttableWidth, TableHeight);
        cornertable1.setBounds(444, 353, CornertableWidth, CornertableHeight);
        cornertable2.setBounds(413, 449, CornertableWidth, CornertableHeight);
        key.setBounds(29, 353, CornertableWidth, CornertableHeight);
        wallUD1.setBounds(23,2, WallUDWidth, WallUDHeight);
        wallUD2.setBounds(23, 544, WallUDWidth, WallUDHeight);
        wallLR1.setBounds(0,66, WallLRWidth, WallLRHeight);
        wallLR2.setBounds(458,226, WallLRWidth, WallLRHeight);
   
    }

    public Rectangle getShelf1()
    {
        return shelf1;
    }
    public Rectangle getShelf2()
    {
        return shelf2;
    }
    
    public Rectangle getShorttable()
    {
        return shorttable;
    }
    
    public Rectangle getLongtable()
    {
        return longtable;
    }
    
    public Rectangle getMiddletable1()
    {
        return middletable1;
    }
    public Rectangle getMiddletable2()
    {
        return middletable2;
    }
    public Rectangle getMiddletable3()
    {
        return middletable3;
    }
    public Rectangle getMiddletable4()
    {
        return middletable4;
    }
    public Rectangle getMiddletable5()
    {
        return middletable5;
    }
    public Rectangle getMiddletable6()
    {
        return middletable6;
    }
    public Rectangle getCornertable1()
    {
        return cornertable1;
    }
     public Rectangle getCornertable2()
    {
        return cornertable2;
    }
      public Rectangle getKey()
    {
        return key;
    }
     public Rectangle getWallUD1()
    {
        return wallUD1;
    }
       public Rectangle getWallUD2()
    {
        return wallUD2;
    }
      public Rectangle getWallLR1()
    {
        return wallLR1;
    }
        public Rectangle getWallLR2()
    {
        return wallLR2;
    }

    
   
    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        g.drawImage(new ImageIcon("room206.png").getImage(), 0, 0, null);
        g.drawImage(new ImageIcon(characterMovement.getAnimation()).getImage(), student.x, student.y, null);

    }

}


    
    
//    int max = 3;
//    int[] [] map,maptmp;
//    int manX, manY,boxnum;
//    Image[] myImage;
//    Readmap map1;
//    Readmap maptmp1;
//    int len = 30;
//    int level = 1;
//    Stack mystack = new Stack();
//    
//    public Room206(Customer inf_Student, CharacterMovement inf_charMovement) {
//        super();
//        student = inf_Student;
//        characterMovement = inf_charMovement;
//        setSize(800, 600);
//        setLayout(null);
//        add(temp);
//        temp.setBounds(200, 200, 200, 200);
//        init();
//        placeStations();
//        this.addKeyListener(characterMovement);
//
//        this.addMouseMotionListener(new MouseAdapter() {
//            @Override
//            public void mouseMoved(MouseEvent e)
//            {
////                System.out.println(e.getPoint());
//                temp.setText(e.getPoint().toString());
//            }
//        });
//        this.setFocusable(true);
//    }
//    Room206(){
//        setSize(600,620);
//        setBounds(15,50,600,600);
//        setBackground(Color.white);
//        addKeyListener(this);
//       //  myImage = new Image[10];
//       // for(int i=0; i<10; i++){
//       //     myImage[i] = Toolkit.getDefaultToolkit().getImage("pic\\"+i+".gif");
//       // }
//        setVisible(true);
//        this.pushboxes(this.level);
//        this.requestFocus();
//        validate();
//    }
//    
//    void pushboxes(int i){
//        map1 = new Readmap(i);
//        maptmp1 = new Readmap(i);
//        map = map1.getmap();
//        manX = map1.getmanX();
//        manY = map1.getmanY();
//        maptmp = maptmp1.getmap();
//        repaint();
//        
//    }
//    
//   
//    
//    public void paint(Graphics g){
//         super.paint(g);
//
//        g.drawImage(new ImageIcon("new_Room.png").getImage(), 0, 0, null);
//        }
//       
//    
//    @Override
//    public void keyTyped(KeyEvent ke) {
//    }
//
//    @Override
//    public void keyPressed(KeyEvent ke) {
//        if (ke.getKeyCode() == KeyEvent.VK_UP){
//            moverup();
//        }
//        if (ke.getKeyCode() == KeyEvent.VK_DOWN){
//            movedown();
//        }
//        if(ke.getKeyCode() == KeyEvent.VK_LEFT){
//            moveleft();
//        }
//        if(ke.getKeyCode() == KeyEvent.VK_RIGHT){
//            moveright();
//            
//        }
//        if(unlock()){
//           
//                JOptionPane.showMessageDialog(this, "The Door Opened!");
//                mystack.removeAllElements();
//        }
//    }
//
//    @Override
//    public void keyReleased(KeyEvent ke) {
//    }
//    
//    boolean isMystackEmpty(){
//        return mystack.isEmpty();
//    }
//    void remove(){
//        mystack.removeAllElements();
//    }
//    int back() {
//        return (int) mystack.pop();
//    }
//
//    private void moverup() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    private void movedown() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    private void moveleft() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    private void moveright() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    private boolean unlock() {
//        boolean num = false;
//        out: for(int i = 0; i<20; i++)
//                for (int j = 0; j<20; j++){
//            if(maptmp [i][j] == 4 || maptmp[i][j] ==9)
//                    if (map[i][j] ==9)
//                        num = true;
//                    else {
//                        num = false;
//                        break out;
//                            }
//            }
//        return num;            
//    }
//                
//
//}
//    
//
//
//class Readmap{
//    private int level , mx, my;
//    private int [] [] mymap = new int[20][20];
//    FileReader r;
//    BufferedReader br;
//    String bb="";
//    int []x;int c = 0;
//    Readmap(int k){
//        level = k;
//        String s;
//        try {
//            File f = new File("maps\\"+level+".map");
//            r = new FileReader (f);
//            br = new BufferedReader(r);
//        }
//        catch (IOException e){
//            System.out.println(e);
//        }
//    
//    try{
//     while ((s=br.readLine())!=null){
//	bb=bb+s;
//        }
//    }
//    catch (IOException g){
//	System.out.println(g);
//	}
//    
//    byte [] d = bb.getBytes();
//    int len = bb.length();
//    int [] x = new int[len];
//    for (int i=0; i<bb.length();i++)x[i] = d[i]-48;
//    for (int i=0; i<20; i++){
//        for(int j = 0; i <20; j++){
//            mymap[i][j]= x[c];
//            if(mymap [i][j] == 5){
//                mx = j;
//                my = i;
//            }
//            c++;
//        }
//    }
//    }
//    int [][] getmap(){
//        return mymap;
//    }
//    int getmanX(){
//        return mx;
//    }
//    int getmanY(){
//        return my;
//    }
//}
