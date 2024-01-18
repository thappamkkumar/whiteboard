import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.*;
import java.util.*;
import javax.swing.border.Border;
import java.awt.geom.*;


class White_Board extends JFrame implements ActionListener
{
	JMenuBar mbar;
	JMenu size,shape,text,font_size;
	JMenuItem sl_shape,text_it;
	JTextField tb;
	JButton black,red,green,blue,erase,save,next,previous,s4,s6,s8,s10,s2,rect,circle,tri,dimond,fill_rect,fill_circle,fill_tri,fill_dimond,errow,mcolor,add ;  
	int i=1,a=0,b=0;
ArrayList<BufferedImage>image=new ArrayList<BufferedImage>();
ArrayList<panel>pp=new ArrayList<panel>();
Container pane;
public static Color c=new Color(0,0,0);
public static String line, display_text,rect_s,circle_s,sqr_s,ellipse_s,dim_s,tri_s,dtext;	
public static int line_size=2,text_font_size;
Graphics g;

White_Board()
{
		super("llll");

			

//*************************************************
//***********************************************
	mbar=new JMenuBar();
	mbar.setLayout(new FlowLayout(FlowLayout.CENTER,20,10));
	mbar.setBackground(new Color(255,255,255));
	
	
	Icon BLACK=new ImageIcon("black.png");
	black=new JButton(BLACK);
				black.setPreferredSize(new Dimension(45,65));
				black.setBackground(new Color(255,255,255));
				Border border_black=BorderFactory.createLineBorder(new Color(255,255,255));
				black.setBorder(border_black);
				black.setActionCommand("black");
				black.addActionListener(this);
	
				Icon RED=new ImageIcon("red.png");
				red=new JButton(RED);
				red.setPreferredSize(new Dimension(45,65));
				red.setBackground(new Color(255,255,255));
				Border border_red=BorderFactory.createLineBorder(new Color(255,255,255));
				red.setBorder(border_red);
				red.setActionCommand("red");
				red.addActionListener(this);
				
				Icon GREEN=new ImageIcon("green.png");
				green=new JButton(GREEN);
				green.setPreferredSize(new Dimension(45,65));
				green.setBackground(new Color(255,255,255));
				Border border_green=BorderFactory.createLineBorder(new Color(255,255,255));
				green.setBorder(border_green);
				green.setActionCommand("green");
				green.addActionListener(this);
				
				Icon BLUE=new ImageIcon("blue.png");
				blue=new JButton(BLUE);
				blue.setPreferredSize(new Dimension(45,65));
				blue.setBackground(new Color(255,255,255));
				Border border_blue=BorderFactory.createLineBorder(new Color(255,255,255));
				blue.setBorder(border_blue);
				blue.setActionCommand("blue");
				blue.addActionListener(this); 

				Icon SIZE=new ImageIcon("size.png");
				size=new JMenu();
				size.setIcon(SIZE);
				size.setVerticalTextPosition(JMenu.BOTTOM);
				size.setPreferredSize(new Dimension(60,45));
				
				Icon S2=new ImageIcon("s2.png");
				s2=new JButton(S2);
				//size.setPreferredSize(new Dimension(45,60));
				s2.setBackground(new Color(255,255,255));
				s2.setActionCommand("2");
				s2.addActionListener(this);
				
				Icon S4=new ImageIcon("s4.png");
				s4=new JButton(S4);
				//size.setPreferredSize(new Dimension(45,60));
				s4.setBackground(new Color(255,255,255));
				s4.setActionCommand("4");
				s4.addActionListener(this);
				
				Icon S6=new ImageIcon("s6.png");
				s6=new JButton(S6);
				//size.setPreferredSize(new Dimension(45,60));
				s6.setBackground(new Color(255,255,255));
				s6.setActionCommand("6");
				s6.addActionListener(this);
				
				Icon S8=new ImageIcon("s8.png");
				s8=new JButton(S8);
				//size.setPreferredSize(new Dimension(45,100));
				s8.setBackground(new Color(255,255,255));
				s8.setActionCommand("8");
				s8.addActionListener(this);
				
				Icon S10=new ImageIcon("s10.png");
				s10=new JButton(S10);
				//size.setPreferredSize(new Dimension(55,45));
				s10.setBackground(new Color(255,255,255));
				s10.setActionCommand("10");
				s10.addActionListener(this);
				
				
				size.add(s2);
				size.add(s4);
				size.add(s6);
				size.add(s8);
				size.add(s10);
				
				
				Icon ERASE=new ImageIcon("erase.jpg");
				erase=new JButton(ERASE);
				erase.setPreferredSize(new Dimension(50,65));
				erase.setBackground(new Color(255,255,255));
				Border border_erase=BorderFactory.createLineBorder(new Color(255,255,255));
				erase.setBorder(border_erase);
				erase.setActionCommand("erase");
				erase.addActionListener(this);
				
			Icon TEXT=new ImageIcon("text.png");
				text=new JMenu();
				text.setIcon(TEXT);
				text.setPreferredSize(new Dimension(45,50));
				text.setBackground(new Color(255,255,255));
				Border border_text=BorderFactory.createLineBorder(new Color(255,255,255));
				text.setBorder(border_text);
				
				
					
			tb=new JTextField("enter");
			//tb.setBounds(10,10,120,120);
			tb.setPreferredSize(new Dimension(150,30));
			text.add(tb);
			
				
				
				text_it=new JMenuItem("               ADD ");
				text_it.setPreferredSize(new Dimension(150,20));
				text_it.setBackground(new Color(255,255,0));
				Border border_text_it=BorderFactory.createLineBorder(new Color(255,255,255));
				text_it.setBorder(border_text_it);
				text_it.setActionCommand("text");
				text_it.addActionListener(this);
					text.add(text_it);
			
			
			Icon SAVE=new ImageIcon("save.gif");
				save=new JButton(SAVE);
				save.setPreferredSize(new Dimension(40,40));
				save.setBackground(new Color(255,255,255));
				Border border_save=BorderFactory.createLineBorder(new Color(255,255,255));
				save.setBorder(border_save);
				save.setActionCommand("save");
				save.addActionListener(this);
				
				Icon SHAPE=new ImageIcon("shapes.png");
				shape=new JMenu();
				shape.setIcon(SHAPE);
				shape.setPreferredSize(new Dimension(50,50));
				
				sl_shape=new JMenuItem();
				sl_shape.setPreferredSize(new Dimension(300,100));
				sl_shape.setBackground(new Color(255,255,255));
				//sl_shape.setLayout(new FlowLayout(FlowLayout.LEFT));
				sl_shape.setLayout(new GridLayout(2,5,0,0));
				sl_shape.setEnabled(false);
				shape.add(sl_shape);
				
				Icon RECT=new ImageIcon("rectangle.png");
				rect=new JButton(RECT);
				rect.setPreferredSize(new Dimension(50,50));
				rect.setBackground(new Color(255,255,255));
				Border border_rect=BorderFactory.createLineBorder(new Color(255,255,255));
				rect.setBorder(border_rect);
				rect.setActionCommand("rect");
				rect.addActionListener(this);
				sl_shape.add(rect);
				
				Icon TRIAGLE=new ImageIcon("triangle.png");
				tri=new JButton(TRIAGLE);
			tri.setPreferredSize(new Dimension(50,50));
				tri.setBackground(new Color(255,255,255));
				Border border_tri=BorderFactory.createLineBorder(new Color(255,255,255));
				tri.setBorder(border_tri);
				tri.setActionCommand("tri");
				tri.addActionListener(this);
				sl_shape.add(tri);
				
				
				Icon CIRCLE=new ImageIcon("circle.png");
				circle=new JButton(CIRCLE);
				circle.setPreferredSize(new Dimension(50,50));
				circle.setBackground(new Color(255,255,255));
				Border border_cr=BorderFactory.createLineBorder(new Color(255,255,255));
				circle.setBorder(border_cr); 
				circle.setActionCommand("circle");
				circle.addActionListener(this);
				sl_shape.add(circle);
				
				
				Icon DIAMOND=new ImageIcon("diamond.png");
				dimond=new JButton(DIAMOND);
			dimond.setPreferredSize(new Dimension(50,50));
				dimond.setBackground(new Color(255,255,255));
				Border border_di=BorderFactory.createLineBorder(new Color(255,255,255));
				dimond.setBorder(border_di);
				dimond.setActionCommand("dimond");
				dimond.addActionListener(this);
				sl_shape.add(dimond);
				
				
				Icon FILLED_RECT=new ImageIcon("filled_rectangle.png");
				fill_rect=new JButton(FILLED_RECT);
				rect.setPreferredSize(new Dimension(50,50));
				fill_rect.setBackground(new Color(255,255,255));
				Border border_frect=BorderFactory.createLineBorder(new Color(255,255,255));
				fill_rect.setBorder(border_frect);
				fill_rect.setActionCommand("fill_rect");
				fill_rect.addActionListener(this);
				sl_shape.add(fill_rect);
				
				
				
				
				
				
				Icon FILLED_TRIAGLE=new ImageIcon("filled_triangle.png");
				fill_tri=new JButton(FILLED_TRIAGLE);
				tri.setPreferredSize(new Dimension(50,50));
				fill_tri.setBackground(new Color(255,255,255));
				Border border_ftri=BorderFactory.createLineBorder(new Color(255,255,255));
				fill_tri.setBorder(border_ftri);
				fill_tri.setActionCommand("fill_tri");
				fill_tri.addActionListener(this);
				sl_shape.add(fill_tri);
				
				
				
				
				
				Icon FILLED_CIRCLE=new ImageIcon("filled_circle.png");
				fill_circle=new JButton(FILLED_CIRCLE);
				circle.setPreferredSize(new Dimension(50,50));
				fill_circle.setBackground(new Color(255,255,255));
				Border border_fcr=BorderFactory.createLineBorder(new Color(255,255,255));
				  fill_circle.setBorder(border_fcr);
				fill_circle.setActionCommand("fill_circle");
				fill_circle.addActionListener(this);
				sl_shape.add(fill_circle);
				
				
				
				
				
				Icon FILLED_DIAMOND=new ImageIcon("filled_diamond.png");
		fill_dimond=new JButton(FILLED_DIAMOND);
		fill_dimond.setPreferredSize(new Dimension(50,50));
			fill_dimond.setBackground(new Color(255,255,255));
				Border border_filldi=BorderFactory.createLineBorder(new Color(255,255,255));
				fill_dimond.setBorder(border_filldi);
			fill_dimond.setActionCommand("fill_dimond");
		fill_dimond.addActionListener(this);
				sl_shape.add(fill_dimond);
				
				
				
				
					Icon NEXT=new ImageIcon("next.png");
					next=new JButton(NEXT);
			next.setPreferredSize(new Dimension(40,60));
			next.setBackground(new Color(255,255,255));
			Border border_next=BorderFactory.createLineBorder(new Color(255,255,255));
				next.setBorder(border_next);
				next.setActionCommand("next");
				next.addActionListener(this);

			Icon PREVIOUS=new ImageIcon("previous.png");
			  previous=new JButton(PREVIOUS);
				previous.setPreferredSize(new Dimension(40,60));
				previous.setBackground(new Color(255,255,255));
				Border border_previous=BorderFactory.createLineBorder(new Color(255,255,255));
				previous.setBorder(border_previous);
				previous.setActionCommand("previous");
				previous.addActionListener(this);
			//	previous.setLayout(new BorderLayout(EAST));
	
			Icon MCOLOR=new ImageIcon("color.png");
			mcolor=new JButton(MCOLOR);
		mcolor.setPreferredSize(new Dimension(50,50));
			mcolor.setBackground(new Color(255,255,255));
				Border border_mc=BorderFactory.createLineBorder(new Color(255,255,255));
				mcolor.setBorder(border_mc);
			mcolor.setActionCommand("mcolor");
		mcolor.addActionListener(this);
				sl_shape.add(mcolor);
	
			mbar.add(previous);			
			mbar.add(blue);
				mbar.add(red);
				mbar.add(green);
				mbar.add(black);
				
				mbar.add(erase);
				mbar.add(size);
				mbar.add(shape);
				mbar.add(mcolor);
				mbar.add(text);
				mbar.add(save);
				
				
				mbar.add(next);
	
	
setJMenuBar(mbar);
//**********************************
//***********panel**************



pane=getContentPane();
CardLayout card=new CardLayout();
pane.setLayout(card);


panel p=new panel("page"+i);
pp.add(p);
pane.add(p);



}
void page()
{
	i=i+1;
panel p=new panel("page"+i);
pp.add(p);
pane.add(p);




}



//******************************************************
public void actionPerformed(ActionEvent action_performed_eve)
{
Graphics ga=getGraphics();



String s=action_performed_eve.getActionCommand();
if(s.equals("mcolor"))
	{
		
		c= JColorChooser.showDialog( White_Board.this, "Choose a color", c );

		
	}
	if(s.equals("text"))
	{
		dtext="text";
		display_text=tb.getText();
		line="li";
		
	}
	if(s.equals("f10"))
	{
		text_font_size=10;
	}
	if(s.equals("f20"))
	{
		text_font_size=20;
	}
	if(s.equals("f30"))
	{
		text_font_size=30;
	}
if(s.equals("black"))
	{
		line="line";
		c=new Color(0,0,0);
		return;
	}
if(s.equals("red"))
	{
		line="line";
	c=new Color(255,0,0);
		return;
	}

if(s.equals("green"))
	{
		line="line";
		c=new Color(0,255,0);
		return;
	}
if(s.equals("blue"))
	{
			line="line";
		c=new Color(0,0,255);
		return;
	}




if(s.equals("save"))
{
	if(b==1)
	{
	
	image.clear();
	b=0;
	}
	if(b==0){
		
		saveimage();
	}
		
}

if(s.equals("rect"))
	{
			rect_s="rect";
		line="li";
		return;
	}
	if(s.equals("circle"))
	{
	circle_s="circle";
		line="li";
		return;
	}
	if(s.equals("tri"))
	{
			tri_s="tri";
		line="li";
		return;
	}
	
	if(s.equals("fill_rect"))
	{
			rect_s="fill_rect";
		line="li";
		return;
	}
	if(s.equals("fill_circle"))
	{
			circle_s="fill_circle";
		line="li";
		return;
	}if(s.equals("fill_tri"))
	{
			tri_s="fill_tri";
			line="li";
		return;
	}
	
	if(s.equals("dimond"))
	{
			dim_s="diamond";
		line="li";
		return;
	}
	if(s.equals("fill_dimond"))
	{
			dim_s="fill_diamond";
		line="li";
		return;
	}
	if(s.equals("errow"))
	{
			line="errow";
		return;
	}



if(s.equals("erase"))
{
	c=new Color(255,255,255);
	line="erase";
}

CardLayout cl = (CardLayout) (pane.getLayout());
if(s.equals("next"))
	{
		if(a<=0)
		{	page();
		
		}
		else
		{
			a=a-1;
			
		}		
		cl.next(pane); 
		
			
	}
if(s.equals("previous"))
	{
			a=a+1;
			 cl.previous(pane);
	
	}
	
	
	
	
	
//************************************************************************************
//**************LINE SIZE
	
if(s.equals("2"))
{
	line_size=2;
		
}

if(s.equals("4"))
{
	line_size=4;
		
}

if(s.equals("6"))
{
	line_size=6;
		
}

if(s.equals("8"))
{
	line_size=8;
		
}

if(s.equals("10"))
{
	line_size=10;
		
}
}


//****************************************************


public BufferedImage getScreenShot(Component c)
		{
			BufferedImage img=new BufferedImage(c.getWidth(), c.getHeight(), BufferedImage.TYPE_INT_ARGB);
			c.paint(img.getGraphics());
			return img;
		}
		
		public void saveScreenShot(Component com) 
		{
			BufferedImage i=getScreenShot(com);
			image.add(i);
			b=1;
		}
	
		public void saveimage()
		{
			for(int n=0;n< pp.size();n=n+1)
			{	Component comm=pp.get(n);
				saveScreenShot(comm);
			}

				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Save Title");
				int returnVal = fileChooser.showSaveDialog(White_Board.this);
				
				if(returnVal == fileChooser.APPROVE_OPTION)
				{
					File file = fileChooser.getSelectedFile();
					
					
					String snapshotLocation = file.getAbsolutePath();
					
				       File imageFile = new File(file.getAbsolutePath()+".png");
				   
				    
					
				
			
			for(int j=0;j<image.size();j=j+1)
			{
				BufferedImage save_image=image.get(j);
				try{
			ImageIO.write(save_image,"png", new File(file.getAbsolutePath()+(j+1)+".png"));
			}
			catch(IOException e)
			{
				System.out.println("Error: " + e);
			}
		fileChooser.disable();
			}
				
			}
	
		}
//****************************************************


	
		
public static void main(String ss[])
{


White_Board l=new White_Board();
l.setTitle("whiteBoard");
l.setSize(1300,700);
l.setVisible(true);
l.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


SwingUtilities.invokeLater(new Runnable(){
		public void run()
		{
			System.out.println("created GUI on EDT"+SwingUtilities.isEventDispatchThread());
		}
	});

}

}



class panel extends JPanel implements MouseListener, MouseMotionListener
{
String l="line",p;
Color cl;
ArrayList<ppp>oo=new ArrayList<ppp>();
ppp ob;
ppp obb=new ppp();
int size;



double str_x=0,str_y=0,w=1,h=1;
ArrayList<rectangless>shapes=new ArrayList<rectangless>();   
rectangless rect,rect2;
ArrayList<ellipsess>shapes2=new ArrayList<ellipsess>();   
ellipsess ell1,ell2;
ArrayList<diamondss>shapes3=new ArrayList<diamondss>();   
diamondss dia1,dia2;
ArrayList<triangless>shapes4=new ArrayList<triangless>();   
triangless tri1,tri2;
ArrayList<labless>text=new ArrayList<labless>();   
labless lab1,lab2;

int s_shape=0,m,ell_s_shape=0,ell_m,dia_s_shape=0,dia_m,tri_s_shape=0,tri_m,lab_s_shape=0,lab_m;

Rectangle2D left_top_rect,right_bottom_rect,ell_left_top_rect,ell_right_bottom_rect,dia_left_top_rect,dia_right_bottom_rect,tri_left_top_rect,tri_right_bottom_rect,lab_left_top_rect,lab_right_bottom_rect;
Point2D left_top_pt,right_bottom_pt,ell_left_top_pt,ell_right_bottom_pt,dia_left_top_pt,dia_right_bottom_pt,tri_left_top_pt,tri_right_bottom_pt,lab_left_top_pt,lab_right_bottom_pt;

int R_resizer=0,ell_resizer=0,dia_resizer=0, tri_resizer=0,lab_resizer=0;


panel(String s)
{
	setBackground(new Color(255,255,255));
	
	p=s;
	
	addMouseMotionListener(this);
addMouseListener(this);
}



	

public void paintComponent(Graphics g)
{
super.paintComponent(g);
g.drawString("Developer Contact:- thappamkkumar@gmail.com, 6005819576",20,20);
g.drawString(p,20,40);


Graphics2D g2 = ( Graphics2D ) g;


for(int j=0;j<oo.size();j++)
{
	
	ob=oo.get(j);
	
		l=ob.line;
	
size=ob.size;


				cl=ob.color;
			g.setColor(cl); 
			
			if(l=="line"||l=="erase"){
	
	for(int i=0;i<ob.point.size()-3;i++)
	{
	Point p1=ob.point.get(i);
	Point p2=ob.point.get(i+1);
	
	
		g2.setStroke(new BasicStroke(size));

	DrawShapes.drawline(g,p1,p2);
	}
	}
	
	}



 for(int i=0;i<shapes.size();i++)
 {
	rectangless  ob=shapes.get(i);
	 ob.draw(g);
	 if(s_shape==1)
	 {
		 int SIZE=15;
		left_top_rect=new Rectangle2D.Double();
		 left_top_rect.setFrame(left_top_pt.getX()-SIZE,left_top_pt.getY()-SIZE,SIZE,SIZE);
		right_bottom_rect=new Rectangle2D.Double();
		right_bottom_rect.setFrame(right_bottom_pt.getX(),right_bottom_pt.getY(),SIZE,SIZE);
		
		g2.setColor(new Color(0,0,0));
		 g2.fill(left_top_rect);
		 g2.fill(right_bottom_rect);
	 }
 }
 
 for(int i=0;i<shapes2.size();i++)
 {
	ellipsess  ob=shapes2.get(i);
	 ob.draw(g);
	 if(ell_s_shape==1)
	 {
		 int SIZE=15;
		ell_left_top_rect=new Rectangle2D.Double();
		 ell_left_top_rect.setFrame(ell_left_top_pt.getX()-SIZE,ell_left_top_pt.getY()-SIZE,SIZE,SIZE);
		ell_right_bottom_rect=new Rectangle2D.Double();
		ell_right_bottom_rect.setFrame(ell_right_bottom_pt.getX(),ell_right_bottom_pt.getY(),SIZE,SIZE);
		
		g2.setColor(new Color(0,0,0));
		 g2.fill(ell_left_top_rect);
		 g2.fill(ell_right_bottom_rect);
		
		 Rectangle2D dr=new Rectangle2D.Double();
		dr.setFrame(Math.min(ell_left_top_pt.getX(),ell_right_bottom_pt.getX()),Math.min(ell_left_top_pt.getY(),ell_right_bottom_pt.getY()),Math.abs(ell_left_top_pt.getX()-ell_right_bottom_pt.getX()),Math.abs(ell_left_top_pt.getY()-ell_right_bottom_pt.getY()));
				g2.setStroke(new BasicStroke(2));
				g2.draw(dr);
				g2.setColor(new Color(0,0,0,6));
		 g2.fill(dr);
	 }
 }

for(int i=0;i<shapes3.size();i++)
 {
	 
	diamondss  ob=shapes3.get(i);
	
	
	 ob.draw(g);
	
	 
	 if(dia_s_shape==1)
	 {
		 int SIZE=15;
		dia_left_top_rect=new Rectangle2D.Double();
		 dia_left_top_rect.setFrame(dia_left_top_pt.getX()-SIZE,dia_left_top_pt.getY()-SIZE,SIZE,SIZE);
		dia_right_bottom_rect=new Rectangle2D.Double();
		dia_right_bottom_rect.setFrame(dia_right_bottom_pt.getX(),dia_right_bottom_pt.getY(),SIZE,SIZE);
		
		g2.setColor(new Color(0,0,0));
		 g2.fill(dia_left_top_rect);
		 g2.fill(dia_right_bottom_rect);
		
		 Rectangle2D dr=new Rectangle2D.Double();
		dr.setFrame(Math.min(dia_left_top_pt.getX(),dia_right_bottom_pt.getX()),Math.min(dia_left_top_pt.getY(),dia_right_bottom_pt.getY()),Math.abs(dia_left_top_pt.getX()-dia_right_bottom_pt.getX()),Math.abs(dia_left_top_pt.getY()-dia_right_bottom_pt.getY()));
			g2.setStroke(new BasicStroke(2));			
			g2.draw(dr);
			g2.setColor(new Color(0,0,0,6));
		 g2.fill(dr);
	 }
 }
 
 
 for(int i=0;i<shapes4.size();i++)
 {
	 
	triangless  ob=shapes4.get(i);
	
	
	 ob.draw(g);
	
	 
	 if(tri_s_shape==1)
	 {
		 int SIZE=15;
		tri_left_top_rect=new Rectangle2D.Double();
		 tri_left_top_rect.setFrame(tri_left_top_pt.getX()-SIZE,tri_left_top_pt.getY()-SIZE,SIZE,SIZE);
		tri_right_bottom_rect=new Rectangle2D.Double();
		tri_right_bottom_rect.setFrame(tri_right_bottom_pt.getX(),tri_right_bottom_pt.getY(),SIZE,SIZE);
		
		g2.setColor(new Color(0,0,0));
		 g2.fill(tri_left_top_rect);
		 g2.fill(tri_right_bottom_rect);
		  
Rectangle2D dr=new Rectangle2D.Double();
		dr.setFrame(Math.min(tri_left_top_pt.getX(),tri_right_bottom_pt.getX()),Math.min(tri_left_top_pt.getY(),tri_right_bottom_pt.getY()),Math.abs(tri_left_top_pt.getX()-tri_right_bottom_pt.getX()),Math.abs(tri_left_top_pt.getY()-tri_right_bottom_pt.getY()));
					g2.setStroke(new BasicStroke(2));
		g2.draw(dr);		
		g2.setColor(new Color(0,0,0,6));
		 g2.fill(dr);	
	}
 }
 
  for(int i=0;i<text.size();i++)
 {
	 
	labless  ob=text.get(i);
	
	
	 ob.draw(g);
	 this.add(ob.lable);
	 
	 if(lab_s_shape==1)
	 {
		 int SIZE=15;
		lab_left_top_rect=new Rectangle2D.Double();
		 lab_left_top_rect.setFrame(lab_left_top_pt.getX()-SIZE,lab_left_top_pt.getY()-SIZE,SIZE,SIZE);
		lab_right_bottom_rect=new Rectangle2D.Double();
		lab_right_bottom_rect.setFrame(lab_right_bottom_pt.getX(),lab_right_bottom_pt.getY(),SIZE,SIZE);
		
		g2.setColor(new Color(0,0,0));
		 g2.fill(lab_left_top_rect);
		 g2.fill(lab_right_bottom_rect);
		 
		 Rectangle2D dr=new Rectangle2D.Double();
		dr.setFrame(Math.min(lab_left_top_pt.getX(),lab_right_bottom_pt.getX()),Math.min(lab_left_top_pt.getY(),lab_right_bottom_pt.getY()),Math.abs(lab_left_top_pt.getX()-lab_right_bottom_pt.getX()),Math.abs(lab_left_top_pt.getY()-lab_right_bottom_pt.getY()));
					g2.setStroke(new BasicStroke(2));
		g2.draw(dr);
		 g2.setColor(new Color(0,0,0,6));
		 g2.fill(dr);
	 }
 }

}  



//**********************************************************
//					draw rectangle on corner

void draw_knob(rectangless  rrr)
{
	left_top_pt=new Point2D.Double(rrr.rectangle.getX(),rrr.rectangle.getY());
	right_bottom_pt=new Point2D.Double(rrr.rectangle.getX()+rrr.rectangle.getWidth(),rrr.rectangle.getY()+rrr.rectangle.getHeight());
	s_shape=1;
	repaint();
}


void draw_knob2(ellipsess  rrr)
{
	ell_left_top_pt=new Point2D.Double(rrr.ellipse.getX(),rrr.ellipse.getY());
	ell_right_bottom_pt=new Point2D.Double(rrr.ellipse.getX()+rrr.ellipse.getWidth(),rrr.ellipse.getY()+rrr.ellipse.getHeight());
	ell_s_shape=1;
	repaint();
}


void draw_knob3(diamondss rrr)
{
	dia_left_top_pt=new Point2D.Double(rrr.dia_rect.getX(),rrr.dia_rect.getY());
	dia_right_bottom_pt=new Point2D.Double(rrr.dia_rect.getX()+rrr.dia_rect.getWidth(),rrr.dia_rect.getY()+rrr.dia_rect.getHeight());
	dia_s_shape=1;
	repaint();
}
void draw_knob4(triangless rrr)
{
	tri_left_top_pt=new Point2D.Double(rrr.tri_rect.getX(),rrr.tri_rect.getY());
	tri_right_bottom_pt=new Point2D.Double(rrr.tri_rect.getX()+rrr.tri_rect.getWidth(),rrr.tri_rect.getY()+rrr.tri_rect.getHeight());
	tri_s_shape=1;
	repaint();
}

void draw_knob_text(labless rrr)
{
	lab_left_top_pt=new Point2D.Double(rrr.lab_rect.getX(),rrr.lab_rect.getY());
	lab_right_bottom_pt=new Point2D.Double(rrr.lab_rect.getX()+rrr.lab_rect.getWidth(),rrr.lab_rect.getY()+rrr.lab_rect.getHeight());
	lab_s_shape=1;
	repaint();
}
//********************************select the shape*************
void select(double x,double y)
{
	
 for(int i=0;i<shapes.size();i++)
 {
	 
	rectangless  ob=shapes.get(i);
	if(ob.rectangle.contains(x,y))
	{
		
		s_shape=1;
		m=1;
	
		draw_knob(ob);
		rect2=ob;
		repaint();
		break;
	}
	else
	{
		
		
		m=0;
		
		R_resizer=0;
    	s_shape=0;
	  repaint();
	}
	
 }
 
  for(int i=0;i<shapes2.size();i++)
 {
	 
	ellipsess  ob=shapes2.get(i);
	if(ob.ellipse.contains(x,y))
	{
		
		
		draw_knob2(ob);
		ell2=ob;
		ell_s_shape=1;
		ell_m=1;
		repaint();
		break;
	}
	else
	{
		
		
		ell_m=0;
		ell_resizer=0;
	ell_s_shape=0;
	repaint();
	}
	
 }
	
	
	for(int i=0;i<shapes3.size();i++)
 {
	 
	diamondss  ob=shapes3.get(i);
	if(ob.dia_rect.contains(x,y))
	{
		
		
		draw_knob3(ob);
		dia2=ob;
		dia_s_shape=1;
		dia_m=1;
		repaint();
		break;
	}
	else
	{
		
		
		dia_m=0;
		dia_resizer=0;
	dia_s_shape=0;
	repaint();
	}
}
 
 	
 for(int i=0;i<shapes4.size();i++)
 {
	 
	triangless  ob=shapes4.get(i);
	if(ob.tri_rect.contains(x,y))
	{
	
		draw_knob4(ob);
		tri2=ob;
		tri_s_shape=1;
		tri_m=1;
		repaint();
		break;
	}
	else
	{
		
		tri_m=0;
		tri_resizer=0;
	tri_s_shape=0;
	repaint();
	}
	
 }
 
	
 for(int i=0;i<text.size();i++)
 {
	 
	labless  ob=text.get(i);
	if(ob.lab_rect.contains(x,y))
	{
		draw_knob_text(ob);
		lab2=ob;
		lab_s_shape=1;
		lab_m=1;
		repaint();
		break;
	}
	else
	{
		
		lab_m=0;
		lab_resizer=0;
	lab_s_shape=0;
	repaint();
	}
	
 }
	
	
}




//************************************8

void remove(double x,double y)
{
	
 for(int i=0;i<shapes.size();i++)
 {
	 
	rectangless  ob=shapes.get(i);
	if(ob.rectangle.contains(x,y))
	{
		
			R_resizer=0;
		s_shape=0;		
		shapes.remove(i);
		repaint();
		break;
	}
 }
 	
 for(int i=0;i<shapes2.size();i++)
 {
	 
	ellipsess ob=shapes2.get(i);
	if(ob.ellipse.contains(x,y))
	{
		ell_resizer=0;
		ell_s_shape=0;
		shapes2.remove(i);
		repaint();
		break;
	}
 }
 
 for(int i=0;i<shapes3.size();i++)
 {
	 
	diamondss ob=shapes3.get(i);
	if(ob.dia_rect.contains(x,y))
	{
		dia_resizer=0;
		dia_s_shape=0;
		shapes3.remove(i);
		repaint();
		break;
	}
 }
 
 	
 for(int i=0;i<shapes4.size();i++)
 {
	 
	triangless ob=shapes4.get(i);
	if(ob.tri_rect.contains(x,y))
	{
		tri_resizer=0;
		tri_s_shape=0;
		shapes4.remove(i);
		repaint();
		break;
	}
 }
 
 for(int i=0;i<text.size();i++)
 {
	 
	labless ob=text.get(i);
	if(ob.lab_rect.contains(x,y))
	{
		lab_resizer=0;
		lab_s_shape=0;
		ob.lable.setText(" ");
		text.remove(i);
		repaint();
		break;
	}
 }
} 
void select_rect(double x,double y)
{
if(s_shape==1)
	{
	if(left_top_rect.contains(x,y))
	{
		m=0;
		R_resizer=1;
		s_shape=1;
	}
	if(right_bottom_rect.contains(x,y))
	{m=0;
		s_shape=1;
				R_resizer=2;
		
	}
	}
	
	if(ell_s_shape==1)
	{
	if(ell_left_top_rect.contains(x,y))
	{	ell_m=0;
		ell_resizer=1;
		ell_s_shape=1;
	}
	if(ell_right_bottom_rect.contains(x,y))
	{	ell_m=0;
		ell_s_shape=1;
		ell_resizer=2;
		
	}
	}
	if(dia_s_shape==1)
	{
	if(dia_left_top_rect.contains(x,y))
	{	dia_m=0;
		dia_resizer=1;
		dia_s_shape=1;
	}
	if(dia_right_bottom_rect.contains(x,y))
	{	dia_m=0;
		dia_s_shape=1;
	dia_resizer=2;
		
	}
	}
	if(tri_s_shape==1)
	{
		if(tri_left_top_rect.contains(x,y))
	{	tri_m=0;
		tri_resizer=1;
		tri_s_shape=1;
	}
	if(tri_right_bottom_rect.contains(x,y))
	{	tri_m=0;
		tri_s_shape=1;
	tri_resizer=2;
		
	}
	}
	if(lab_s_shape==1)
	{
		if(lab_left_top_rect.contains(x,y))
	{	lab_m=0;
		lab_resizer=1;
		lab_s_shape=1;
	}
	if(lab_right_bottom_rect.contains(x,y))
	{	lab_m=0;
		lab_s_shape=1;
	lab_resizer=2;
		
	}
		
	}
}
//MOUSE
public void mouseClicked(MouseEvent me) {
if(me.getClickCount() ==1)
{
	select(me.getX(),me.getY());
}
if(me.getClickCount() ==3)
{
	remove(me.getX(),me.getY());
}

} 
 
public void mouseEntered(MouseEvent me) {

} 
 
public void mouseExited(MouseEvent me) {} 
 
public void mouseMoved(MouseEvent me){}
public void mousePressed(MouseEvent me) 
{
	
obb=new ppp();
obb.point.add(me.getPoint());	

oo.add(obb);
repaint();

	
str_x=me.getX();
str_y=me.getY();

if(White_Board.rect_s=="rect"||White_Board.rect_s=="fill_rect")
{
	str_x=me.getX();
str_y=me.getY();
rect=new rectangless();

rect.size(str_x,str_y,w,h);

rect.rectangle=new Rectangle2D.Double();
shapes.add(rect);
 }
if(White_Board.circle_s=="circle"||White_Board.circle_s=="fill_circle")
{
	str_x=me.getX();
str_y=me.getY();
ell1=new ellipsess();
ell1.size(str_x,str_y,w,h);
ell1.ellipse=new Ellipse2D.Double();
shapes2.add(ell1);
	
}
 if(White_Board.dim_s=="diamond"||White_Board.dim_s=="fill_diamond")
{
	
	str_x=me.getX();
str_y=me.getY();
dia1=new diamondss();
dia1.diamond=new Polygon();
dia1.size(str_x,str_y,w,h);
dia1.dia_rect=new Rectangle2D.Double();

shapes3.add(dia1);
 }
  if(White_Board.tri_s=="tri"||White_Board.tri_s=="fill_tri")
{
	str_x=me.getX();
str_y=me.getY();
	tri1=new triangless();
tri1.triangle=new Polygon();
tri1.size(str_x,str_y,w,h);
tri1.tri_rect=new Rectangle2D.Double();

shapes4.add(tri1);
}
if(White_Board.dtext=="text")
{
	str_x=me.getX();
str_y=me.getY();
	lab1=new labless();

lab1.size(str_x,str_y,w,h);
lab1.lab_rect=new Rectangle2D.Double();
lab1.lable=new JLabel();
text.add(lab1);
}

 if(s_shape==1||ell_s_shape==1||dia_s_shape==1||lab_s_shape==1||tri_s_shape==1)
 {
	 
	 select_rect(me.getX(),me.getY());
 }


}

public void mouseReleased(MouseEvent me) 
{ 
//White_Board.line="line";
White_Board.rect_s=null;
White_Board.circle_s=null;
White_Board.dim_s=null;
White_Board.tri_s=null;
White_Board.dtext=null;
}
public void mouseDragged(MouseEvent me) 
{
	if(l=="line"||l=="erase"){
	obb.point.add(me.getPoint());
	repaint();
	}
	
	if(White_Board.rect_s=="rect"||White_Board.rect_s=="fill_rect")
{
	double x=Math.min(str_x,me.getX());
	double y=Math.min(str_y,me.getY());
	double wi=Math.abs(str_x-me.getX());
	double he=Math.abs(str_y-me.getY());
	rect.size(x,y,wi,he);
	repaint();
}

if(White_Board.circle_s=="circle"||White_Board.circle_s=="fill_circle")
{
double x=Math.min(str_x,me.getX());
	double y=Math.min(str_y,me.getY());
	double wi=Math.abs(str_x-me.getX());
	double he=Math.abs(str_y-me.getY());
	ell1.size(x,y,wi,he);
	repaint();
}

if(White_Board.dim_s=="diamond"||White_Board.dim_s=="fill_diamond")
{

	double x=Math.min(str_x,me.getX());
	double y=Math.min(str_y,me.getY());
	double wi=Math.abs(str_x-me.getX());
	double he=Math.abs(str_y-me.getY());
	dia1.size(x,y,wi,he);
	repaint();
}
 if(White_Board.tri_s=="tri"||White_Board.tri_s=="fill_tri")
{
	double x=Math.min(str_x,me.getX());
	double y=Math.min(str_y,me.getY());
	double wi=Math.abs(str_x-me.getX());
	double he=Math.abs(str_y-me.getY());
	tri1.size(x,y,wi,he);
	repaint();
}
if(White_Board.dtext=="text")
{
	double x=Math.min(str_x,me.getX());
	double y=Math.min(str_y,me.getY());
	double wi=Math.abs(str_x-me.getX());
	double he=Math.abs(str_y-me.getY());
	lab1.size(x,y,wi,he);
	repaint();
}
	if(s_shape==1||ell_s_shape==1||dia_s_shape==1||tri_s_shape==1||lab_s_shape==1)
	{
		double dx=me.getX();
	double dy=me.getY();
	
		
		move(dx,dy);
		repaint();
	}
	

}

 

 
void move(double x,double y)
{
	
	
	if(R_resizer==2)
	{	right_bottom_pt=new Point2D.Double(x,y);
		rect2.WIDTH=Math.abs(rect2.START_X-right_bottom_rect.getX());
		rect2.HEIGHT=Math.abs(rect2.START_Y-right_bottom_rect.getY());
		repaint();
	}
	if(R_resizer==1)
	{	
		left_top_pt=new Point2D.Double(x,y);
		rect2.START_X=x;
	rect2.START_Y=y;
		rect2.WIDTH=Math.abs(rect2.START_X-right_bottom_pt.getX());
		rect2.HEIGHT=Math.abs(rect2.START_Y-right_bottom_pt.getY());
		
		
	repaint();
		}
	
	if(m==1)
	{
	rect2.START_X=x;
	rect2.START_Y=y;
	
	draw_knob(rect2);
	repaint();
	}
	
	
	
	if(ell_resizer==2)
	{	ell_right_bottom_pt=new Point2D.Double(x,y);
		ell2.WIDTH=Math.abs(ell2.START_X-ell_right_bottom_rect.getX());
		ell2.HEIGHT=Math.abs(ell2.START_Y-ell_right_bottom_rect.getY());
		repaint();
	}
	if(ell_resizer==1)
	{	
		ell_left_top_pt=new Point2D.Double(x,y);
		ell2.START_X=x;
		ell2.START_Y=y;
		ell2.WIDTH=Math.abs(ell2.START_X-ell_right_bottom_pt.getX());
		ell2.HEIGHT=Math.abs(ell2.START_Y-ell_right_bottom_pt.getY());
		
		
	repaint();
	}
	if(ell_m==1)
	{
	ell2.START_X=x;
	ell2.START_Y=y;
	
	draw_knob2(ell2);
	repaint();
	}
	
	if(dia_resizer==2)
	{	dia_right_bottom_pt=new Point2D.Double(x,y);
		dia2.WIDTH=Math.abs(dia2.START_X-dia_right_bottom_rect.getX());
		dia2.HEIGHT=Math.abs(dia2.START_Y-dia_right_bottom_rect.getY());
		repaint();
	}
	if(dia_resizer==1)
	{	
		dia_left_top_pt=new Point2D.Double(x,y);
		dia2.START_X=x;
		dia2.START_Y=y;
		dia2.WIDTH=Math.abs(dia2.START_X-dia_right_bottom_pt.getX());
		dia2.HEIGHT=Math.abs(dia2.START_Y-dia_right_bottom_pt.getY());
		
		
	repaint();
	}
	if(dia_m==1)
	{
	dia2.START_X=x;
	dia2.START_Y=y;
	
	draw_knob3(dia2);
	repaint();
	}
if(tri_resizer==2)
	{	tri_right_bottom_pt=new Point2D.Double(x,y);
		tri2.WIDTH=Math.abs(tri2.START_X-tri_right_bottom_rect.getX());
		tri2.HEIGHT=Math.abs(tri2.START_Y-tri_right_bottom_rect.getY());
		repaint();
	}
	if(tri_resizer==1)
	{	
		tri_left_top_pt=new Point2D.Double(x,y);
		tri2.START_X=x;
		tri2.START_Y=y;
		tri2.WIDTH=Math.abs(tri2.START_X-tri_right_bottom_pt.getX());
		tri2.HEIGHT=Math.abs(tri2.START_Y-tri_right_bottom_pt.getY());
		
		
	repaint();
	}
	if(tri_m==1)
	{
	tri2.START_X=x;
	tri2.START_Y=y;
	
	draw_knob4(tri2);
	repaint();
	}
	if(lab_resizer==2)
	{	lab_right_bottom_pt=new Point2D.Double(x,y);
		lab2.WIDTH=Math.abs(lab2.START_X-lab_right_bottom_rect.getX());
		lab2.HEIGHT=Math.abs(lab2.START_Y-lab_right_bottom_rect.getY());
		repaint();
	}
	if(lab_resizer==1)
	{	
		lab_left_top_pt=new Point2D.Double(x,y);
		lab2.START_X=x;
		lab2.START_Y=y;
		lab2.WIDTH=Math.abs(lab2.START_X-lab_right_bottom_pt.getX());
		lab2.HEIGHT=Math.abs(lab2.START_Y-lab_right_bottom_pt.getY());
		
		
	repaint();
	}
	if(lab_m==1)
	{
	lab2.START_X=x;
	lab2.START_Y=y;
	
	draw_knob_text(lab2);
	repaint();
	}
	
}

void Update(Graphics g)
{
	paint(g);
	
} 
}

class ppp
{
	ArrayList<Point>point=new ArrayList<Point>();
	
	
	Color color=new Color(0,0,0);
	String line="line",str;
	int size,f_size;
	int x1,y1,x2,y2;
	public ppp()
	{
		color=White_Board.c;
size=White_Board.line_size;
		str=White_Board.display_text;
		line=White_Board.line;
		f_size=White_Board.text_font_size;
	}
}




class DrawShapes
{
	

static void drawline(Graphics g,Point p1, Point p2)
{
	g.drawLine(p1.x,p1.y,p2.x,p2.y);
		
		
}
	
}

class rectangless 
{
String s,ss;
double START_X,START_Y,WIDTH,HEIGHT;
Color color;
Rectangle2D rectangle;
void size(double x, double y, double w, double h)	
{
	START_X=x;
START_Y=y;
WIDTH=w;
HEIGHT=h;	
//rectangle=new Rectangle2D.Double();
	s=White_Board.rect_s;
	color=White_Board.c;
}

void draw(Graphics g)
{
	Graphics2D g2d = (Graphics2D) g;
	g2d.setStroke(new BasicStroke(4));
	rectangle.setFrame(START_X,START_Y,WIDTH,HEIGHT);
	g.setColor(color);
	if(s=="rect")
	{g2d.draw(rectangle);}
	if(s=="fill_rect")
	{g2d.fill(rectangle);}
}
}

class ellipsess
{
String s;
double START_X,START_Y,WIDTH,HEIGHT;
Color color;
Ellipse2D ellipse;
void size(double x, double y, double w, double h)	
{
	START_X=x;
START_Y=y;
WIDTH=w;
HEIGHT=h;	
//rectangle=new Rectangle2D.Double();
	s=White_Board.circle_s;
	color=White_Board.c;
}

void draw(Graphics g)
{
	Graphics2D g2d = (Graphics2D) g;
	g2d.setStroke(new BasicStroke(4));
	ellipse.setFrame(START_X,START_Y,WIDTH,HEIGHT);
	g.setColor(color);
	if(s=="circle")
	{g2d.draw(ellipse);}
if(s=="fill_circle")
{g2d.fill(ellipse);}
}
}


class diamondss
{
String str;
double START_X,START_Y,WIDTH,HEIGHT;
Color color;
Rectangle2D dia_rect;
Polygon diamond;
void size(double x, double y, double w, double h)	
{
	START_X=x;
START_Y=y;
WIDTH=w;
HEIGHT=h;	
	str=White_Board.dim_s;
color=White_Board.c;
}

void draw(Graphics g)
{
	Graphics2D g2d = (Graphics2D) g;
	g2d.setStroke(new BasicStroke(1));
	dia_rect.setFrame(START_X,START_Y,WIDTH,HEIGHT);
	g.setColor(new Color(255,255,255,0));
	g2d.fill(dia_rect);
	
	g2d.setStroke(new BasicStroke(4));
	int x1=(int)(dia_rect.getX());
	int y1=(int)(dia_rect.getY()+dia_rect.getHeight()/2);
	int x3=(int)(dia_rect.getX()+dia_rect.getWidth());
	int y3=(int)(dia_rect.getY()+dia_rect.getHeight()/2);
	int x2=(int)(dia_rect.getX()+dia_rect.getWidth()/2);
	int y2=(int)(dia_rect.getY()+dia_rect.getHeight());
	int x4=(int)(dia_rect.getX()+dia_rect.getWidth()/2);
	int y4=(int)(dia_rect.getY());
	int arrx[]={x1,x2,x3,x4};
		int arry[]={y1,y2,y3,y4};
g.setColor(color);
if(str=="diamond")
{
		
	g2d.setStroke(new BasicStroke(4));
		g.drawPolygon(arrx,arry,4);
}
if(str=="fill_diamond")
{
		g.setColor(color);
	g.fillPolygon(arrx,arry,4);
}
	
	}
}


class triangless
{
String str;
double START_X,START_Y,WIDTH,HEIGHT;
Color color;
Rectangle2D tri_rect;
Polygon triangle;
void size(double x, double y, double w, double h)	
{
	START_X=x;
START_Y=y;
WIDTH=w;
HEIGHT=h;	
str=White_Board.tri_s;
color=White_Board.c;
}

void draw(Graphics g)
{
	Graphics2D g2d = (Graphics2D) g;
	g2d.setStroke(new BasicStroke(4));
	tri_rect.setFrame(START_X,START_Y,WIDTH,HEIGHT);
	g.setColor(new Color(255,255,255,0));
	g2d.fill(tri_rect);
	int x1=(int)(tri_rect.getX());
	int y1=(int)(tri_rect.getY()+tri_rect.getHeight()-10);
	int x2=(int)(tri_rect.getX()+tri_rect.getWidth());
	int y2=(int)(tri_rect.getY()+tri_rect.getHeight()-10);
	int x3=(int)(tri_rect.getX()+tri_rect.getWidth()/2);
	int y3=(int)(tri_rect.getY());
	int arrx[]={x3,x2,x1};
		int arry[]={y3,y2,y1};
g.setColor(color);
		if(str=="tri")
{
		
	g2d.setStroke(new BasicStroke(4));
		g.drawPolygon(arrx,arry,3);
}
if(str=="fill_tri")
{
		g.setColor(color);
	g.fillPolygon(arrx,arry,3);
}
	
	}
}

class labless
{
String str;
double START_X,START_Y,WIDTH,HEIGHT;
Color color;
Rectangle2D lab_rect;
JLabel lable;
void size(double x, double y, double w, double h)	
{
	START_X=x;
START_Y=y;
WIDTH=w;
HEIGHT=h;	
//rectangle=new Rectangle2D.Double();
	str=White_Board.display_text;
	color=White_Board.c;
}

void draw(Graphics g)
{
	Graphics2D g2d = (Graphics2D) g;
lab_rect.setFrame(START_X,START_Y,WIDTH,HEIGHT);
	g.setColor(new Color(255,255,255,0));
	g2d.fill(lab_rect);
	lable.setText(str);
	lable.setForeground(color);
	lable.setBounds((int)START_X,(int)START_Y,(int)WIDTH,(int)HEIGHT);
	lable.setFont(new Font("TimesRoman",Font.PLAIN,(int)HEIGHT));
	}
}