import acm.graphics.*;
import acm.gui.DoubleField;
import acm.gui.IntField;
import acm.gui.TableLayout;
import javax.swing.JButton;
import java.awt.event.*; 
import javax.swing.*; 
import acm.program.*;
import acm.util.RandomGenerator;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

//importing packages necessary to this Assignment.

/**
 * The bSim class takes aBall objects created in this class and generates several 
 * instances of aBalls with randomized parameters(using Graphics Program).
 * @author George
 *
 */

    public class bSim extends GraphicsProgram {

    	
    	private double VoMIN;
    	//defines minimum velocity
    	private double VoMAX;
    	//defines maximum velocity.
    	private double EMIN;
    	//defines minimum energy loss coefficient.
    	private double EMAX;
    	//defines maximum energy loss coefficients.
    	private int NUMBALLS;
    	//defines number of balls.
    	private double ThetaMIN;
    	//defines minimum angle.
    	private double ThetaMAX;
    	//defines maximum angle.
    	private double MAXSIZE;
    	//defines maximum radius of balls.
    	private double MINSIZE;
    	//defines minimum radius of balls.
		private int WIDTH=1200+583;
		// Defines wifth of screen in pixels.
		//width is updated to the precise pixel in order to include 
		//all of the ground+panel in simulation run.
		private int HEIGHT=600;
		// Defines height of screen in pixels.
		private int OFFSET=200;
		// distance from bottom of screen to ground plane 
		private double XMAX=100.0;
		//Maximum value of X
		private double SCALE=HEIGHT/XMAX;
		//Pixels/meter
		private RandomGenerator rgen=RandomGenerator.getInstance();
        //random generator
			
	
	//sourced from Assignment 2 pdf.
		
		
		private IntField intfield1;
		private DoubleField doublefield2;
		private DoubleField doublefield3;
		private DoubleField doublefield4;
		private DoubleField doublefield5;
		private DoubleField doublefield6;
		private DoubleField doublefield7;
		private DoubleField doublefield8;
		private DoubleField doublefield9;
		
		//defining  8 doublefields and an intfield.
		
		
		JButton button1;
		JButton button2;
		JButton button3;
		JButton button4;
		JButton button5;
		JToggleButton ToggleButton;
		
		
		// defining 5 different JButtons and a toggle button.
		
		
		
		
		public boolean simEnable=false;
		public boolean trace1=false;
		
		// boolean instance variable.
		
		
		
		
		/**
		 * Creation of a two JPanels where  5JButtons, and IntField and 8 DoubleFields
		 * will be arranged. A JToggleButton will also be set at the SOUTH position relative to the setup.
		 */
		
		
		public void init() {
			
			simEnable=false;
			
			rgen.setSeed((long)424242);
			//setting up Seed	
			
			JPanel panel=new JPanel();
			add(panel,BorderLayout.NORTH);
			
			//creation of JPanel
			
			
			button1= new JButton("Run");
		    panel.add(button1);
		    
		   
		    
		    
		    button2= new JButton("Stack");
		    panel.add(button2);
		    
		   
		    
		    
		    button3= new JButton("Quit");
		    panel.add(button3);
		    
		 
		
		    
		    button4= new JButton("Clear");
		    panel.add(button4);
		    
		    
		   
		    
		    button5= new JButton("Stop");
		    panel.add(button5);
		    
		    //addition of 5 JButtons
		    
		  
            JPanel panel1= new JPanel(new TableLayout(9,2));
            add(panel1,BorderLayout.EAST);
            
            //creation of second JPanel to the EAST.
			
			intfield1=new IntField();
			panel1.add(new JLabel("NUMBALLS"));
			panel1.add(intfield1);
		 
			
		
			doublefield2=new DoubleField();
			panel1.add(new JLabel("MAXSIZE"));       
			panel1.add(doublefield2);
			
			
			
			
			doublefield3=new DoubleField();
			panel1.add(new JLabel("MINSIZE"));       
			panel1.add(doublefield3);
			
			
			
			doublefield4=new DoubleField();
			panel1.add(new JLabel("VoMIN"));         
		    panel1.add(doublefield4);
			
			
			
		    doublefield5=new DoubleField();
			panel1.add(new JLabel("VoMAX"));             
			panel1.add(doublefield5);
			
			
			doublefield6=new DoubleField();
			panel1.add(new JLabel("ThetaMIN"));       
			panel1.add(doublefield6);
			
			
			
			
			doublefield7=new DoubleField();
			panel1.add(new JLabel("ThetaMAX"));        
			panel1.add(doublefield7);
			
			
			
			doublefield8=new DoubleField();
			panel1.add(new JLabel("EMIN"));       
			panel1.add(doublefield8);
			
			
			
			doublefield9=new DoubleField();
			panel1.add(new JLabel("EMAX"));       
			panel1.add(doublefield9);
			
			//addition of 8 doublefields and an intfield to this JPanel.
			
			  
		    ToggleButton=new JToggleButton(("Trace"));
		    add(ToggleButton,SOUTH);
            //ToggleButton for Trace function added to the SOUTH.
		    
		    addActionListeners();
			
			
		}
		
		/**
		 * this method allows for the stacking of the balls after the simulation is stopped.
		 */
		
		
		
		public void doStack() {
			myTree.Stop();
			myTree.stackBalls();
		}
		
		   /** 
		    * A series of responses to different performed actions are established for the 6 buttons
		    * created previously
		    */
		
		 
		   public void actionPerformed(ActionEvent e) {
		
	
			
			if (e.getActionCommand().equals("Trace")) { 
				
				
				//trace if simulation is running and ActionCommand=Trace
			
				if (ToggleButton.isSelected()){
					
					myTree.traceOn();
					
					//trace is on if ToggleButton is selected.
				}
				
				else {
					
					myTree.traceOff();
					
					//otherwise, trace function will be off.
				}
						
				
			}
			
			
			    
			else	
				
			
			{
				  	
				if(e.getActionCommand().equals("Run")) {
			
					simEnable=true;
					
					   NUMBALLS= intfield1.getValue();
		   		       MAXSIZE= doublefield2.getValue();
		   		       MINSIZE= doublefield3.getValue();
		   		       VoMIN= doublefield4.getValue();
		   		       VoMAX= doublefield5.getValue();
		   		       ThetaMIN= doublefield6.getValue();
		   		       ThetaMAX= doublefield7.getValue();
		   		       EMIN= doublefield8.getValue();
		   		       EMAX= doublefield9.getValue(); 
		   		       
		   		     //run simulation with following retrieved values from this ActionCommand..  				
				}
				
				
				else {
					
					if(e.getActionCommand().equals("Stop")) {
						
						myTree.Stop();
						
						
						
						//Stop going through bTree through this ActionCommand. 
												
					}
				
				else {
					
					if(e.getActionCommand().equals("Clear")) {
						
						
						removeAll();
						
						 GRect myRect= new GRect(0,HEIGHT,WIDTH,3); 
							
							//initial position of plank and its dimensions
							
							add(myRect);                         //creates plank
							
							
							//this ActionCommand clears through the GraphicsProgram method removeAll()
							//and leaves only the plank on the screen.
					
					}
					
					else {
						
						if(e.getActionCommand().equals("Stack")) {
						
						doStack();
						
						//ActionCommand which permits for the stacking of the balls once simulation is paused.
						
					}
					
						else {
							
							if(e.getActionCommand().equals("Quit")) { 
								
								System.exit(0);
								
								//exit the screen through this ActionCommand.
							}
						}
	
				}
				
			
			
			 
					
					{	
					addMouseListeners(this);  
					  //enabling Mouse listeners.
					
			
        }
					
				
				}
				
				}			
				
			}			       
			
				}
					
						
		   
		   private bTree myTree = new bTree();
				
				
		   /** The run method generates a plank, resizes the screen and 
		    * includes a while loop which helps the simulation occur.
			 */	
			
	         	
		     
	        	  public void run() {		  
	        
	        		  GRect myRect= new GRect(0,HEIGHT,WIDTH,3); 
			
			//initial position of plank and its dimensions
			
			add(myRect);                         //creates plank
		
		
			
			this.resize(WIDTH,HEIGHT+OFFSET);

			//resetting pixel measurements for display canvas
			
			/**
			 * Through this while loop the simulation wil not only run, but
			 * update the screen as well.
			 */
			
			 while (true) {
				  
				  pause(200);
				  if(simEnable) {
					  
					  doSim();
					  simEnable=false;
					  
				//format of this while looped-sourced from Assignment 4 pdf.	   
				  }
			  }
			
	        	  }
	    
			 
	  
	        	  
	        	  
	        	//setting up loop that will randomly simulate 100 balls that will bounce concurrently
	  			
	  			/** Balls are created with randomized parameters in this loop and 
	  			 * are concurrently generated and added to the simulation.
	  			 */
	        	
	        	  private void doSim() {
			
			for(int i=0;i<NUMBALLS;i++) {
				
				

				double bSize=rgen.nextDouble(MINSIZE,MAXSIZE);
				//randomizing bSize of each of the balls.
				Color bColor=rgen.nextColor();
				//randomizing bSize of each of the balls.
				double bLoss=rgen.nextDouble( EMIN , EMAX );
				//randomizing bSize of each of the balls.
				double Vo=rgen.nextDouble(VoMIN,VoMAX);
				//randomizing bSize of each of the balls.
				double theta=rgen.nextDouble(ThetaMIN,ThetaMAX);
				//randomizing bSize of each of the balls.
			
			
			
		
			
			
				//Creates ball and adds it to screen.
				
			
			
				
				aBall myBall=new aBall(WIDTH/2/SCALE,bSize,Vo,theta,bSize,bColor,bLoss,this);   
				add(myBall.getBall());
				myTree.addNode(myBall);
				myBall.start(); 
				
			}
			
			
	        	 
	        	  }
   
    }
	        	 
			
			
				
		
		
	   	
			 			  
			 
			  
				
	          
		
           			
		
			
		
 
    


