/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jogenderyadav
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.*;
import javax.swing.*;

public class Login implements ActionListener {
	JFrame f, signupf, loginf, web;
	JButton login, login1, register, signin, signup, logout, generate, show,cancel,newinvoicebutton;
	JButton mailid,phn,webname;
	JLabel imgf, imgp, user, user2, pass, pass2, forgot, fn, ln, mob, email;
	JLabel home, homelogin, Web, webhome, coupongenerate,addnewbill,bill,header1,header2,header3,header4,header5,header6;
	JLabel emailid,phno,sitename,newinvoicelabel,useridlabel;
	JTextField username, username2, fname, lname, mail, cg,newinvoicetext,useridtext,loginusertext;

	JPasswordField p, p2, p3;
	JLabel pic, newc, store, contact, menu, foot, showing;
	JLabel flipkart, amazon, myntra, dominos,allstore,contact1,contact2,contact3;
	ImageIcon storepanelback, loginpanelback, signuppanelback,panelback;
	Timer tm, tm2;
	int x = 0, count = 0;
	PreparedStatement pst, ps,idps;
	Connection con;
	ResultSet rs;
	String d1, d2;
	JPanel panel,stores, loginpanel, signuppanel,contactpanel;

	// Images Path In Array
	String[] list = { "1.jpeg", // 0
			"2.jpeg", // 1
			"3.jpeg", // 2
			"4.jpeg", // 3
			"5.jpeg", // 4
			"6.jpeg", // 5
			"7.jpeg" // 6
	};

	Login() {
		f = new JFrame("Get Coupons");
		Image iconf;
		iconf = Toolkit.getDefaultToolkit().getImage("logo.png");

		f.setIconImage(iconf);

		imgf = new JLabel(new ImageIcon("logo.png"));
		imgp = new JLabel(new ImageIcon("logo.png"));
		f.setContentPane(new JLabel(new ImageIcon("loginback.jpg")));

		f.setLayout(null);
		f.setBounds(0, 0, 1600, 1200);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBackground(Color.red);
		f.add(imgf);
		header1=new JLabel(new ImageIcon("header1.png"));
		f.add(header1);
		header2=new JLabel(new ImageIcon("header2.png"));
		f.add(header2);
		header3=new JLabel(new ImageIcon("header3.png"));
		f.add(header3);
		header4=new JLabel(new ImageIcon("header4.jpeg"));
		f.add(header4);
		
		header1.setBounds(240, 0,220, 100);
		header3.setBounds(500, 0,220, 100);
		header2.setBounds(750, 0,220, 100);
		header4.setBounds(995, 0,220, 100);
		
		imgf.setBounds(5, 4, 150, 100);
		imgp.setBounds(0, 0, 150, 110);

		/*
		 * signupf = new JFrame("New User"); signupf.setLayout(null);
		 * signupf.setBounds(1300, 50, 400,450);
		 * signupf.setBackground(Color.GREEN); signupf.setContentPane(new
		 * JLabel(new ImageIcon("signup.png"))); signupf.setVisible(false); //
		 * signupf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 * 
		 * 
		 * 
		 * loginf = new JFrame("Login"); loginf.setLayout(null);
		 * loginf.setBounds(1300, 50, 400, 300); loginf.setContentPane(new
		 * JLabel(new ImageIcon("loback2.jpg"))); loginf.setVisible(false); //
		 * loginf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 */
		
		
				// Login Panel
		loginpanelback = new ImageIcon("loback2.jpg");
		loginpanel = new JPanel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			protected void paintComponent(Graphics g) {
				g.drawImage(loginpanelback.getImage(), 0, 0, null);
				super.paintComponent(g);
			}
		};
		loginpanel.setOpaque(false);
		// loginpanel.setPreferredSize(new Dimension(100, 100));

		loginpanel.setLayout(null);
		f.add(loginpanel);
		loginpanel.setBackground(Color.lightGray);
		loginpanel.setBounds(1100, 100, 400, 300);
		// loginpanel.add(imgp);
		loginpanel.setVisible(false);

		// Signup Panel
		signuppanelback = new ImageIcon("signup.png");
		signuppanel = new JPanel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			protected void paintComponent(Graphics g) {
				g.drawImage(signuppanelback.getImage(), 0, 0, null);
				super.paintComponent(g);
			}
		};
		signuppanel.setOpaque(false);
		// loginpanel.setPreferredSize(new Dimension(100, 100));

		signuppanel.setLayout(null);
		f.add(signuppanel);
		signuppanel.setBackground(Color.lightGray);
		signuppanel.setBounds(1100,100, 400, 450);
		// loginpanel.add(imgp);
		signuppanel.setVisible(false);

		
		panelback = new ImageIcon("store-background3.jpg");
		panel = new JPanel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			protected void paintComponent(Graphics g) {
				g.drawImage(panelback.getImage(), 0, 0, null);
				super.paintComponent(g);
			}
		};
		panel.setOpaque(false);
		// loginpanel.setPreferredSize(new Dimension(100, 100));

		panel.setLayout(null);
		f.add(panel);
		panel.setBackground(Color.lightGray);
		panel.setBounds(240, 140, 970, 450);
		panel.setVisible(true);
		panel.setOpaque(false);


		// JPanel for Stores

		storepanelback = new ImageIcon("store-background3.jpg");
		stores = new JPanel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			protected void paintComponent(Graphics g) {
				g.drawImage(storepanelback.getImage(), 0, 0, null);
				super.paintComponent(g);
			}
		};
		stores.setOpaque(false);
		// stores.setPreferredSize(new Dimension(100, 100));

		stores.setLayout(null);
		f.add(stores);
		stores.setBackground(Color.lightGray);
		stores.setBounds(240, 140, 970, 450);
		stores.add(imgp);
		stores.setVisible(false);
		flipkart = new JLabel(new ImageIcon("flipkart-offers.png"));
		amazon = new JLabel(new ImageIcon("amazon-coupon-codes.png"));
		myntra = new JLabel(new ImageIcon("myntra-coupon-codes.png"));
		dominos = new JLabel(new ImageIcon("dominos-coupons.jpg"));
		allstore=new JLabel(new ImageIcon("top-ecommerce-website-india.png"));
		

		// stores.setContentPane(new JLabel(new ImageIcon("loginback.jpg")));

		stores.add(amazon);
		stores.add(flipkart);
		stores.add(myntra);
		stores.add(dominos);
		stores.add(allstore);
		// panelback.setBounds(0, 0, 970,450);
		flipkart.setBounds(210, 20, 150, 50);
		amazon.setBounds(370, 80, 150, 50);
		myntra.setBounds(570, 20, 150, 50);
		dominos.setBounds(730, 80, 150, 50);
		allstore.setBounds(200, 140, 600,300);
		// End Stores
		
		//Contact us Panel
		contactpanel = new JPanel(); 
		contactpanel.setOpaque(false);
		// stores.setPreferredSize(new Dimension(100, 100));

		contactpanel.setLayout(null);
		f.add(contactpanel);
		contactpanel.setBackground(Color.lightGray);
		contactpanel.setBounds(240, 140, 970, 970);
		//contactpanel.add(imgp);
		contactpanel.setVisible(false);
		contact1=new JLabel(new ImageIcon("contact2.png"));
		contact3=new JLabel(new ImageIcon("contact3.jpg"));
		contact2=new JLabel(new ImageIcon("contact4.png"));

		emailid=new JLabel("info@getCoupon.com");
		emailid.setFont(new Font("Serif",Font.ITALIC,34));
		phno=new JLabel("8800221084");
		phno.setFont(new Font("Serif",Font.ITALIC,34));
		sitename=new JLabel("www.getCoupon.com");
		sitename.setFont(new Font("Serif",Font.ITALIC,34));
		mailid=new JButton();
		phn=new JButton();
		webname=new JButton();
		
		contactpanel.add(mailid);
		contactpanel.add(phn);
		contactpanel.add(webname);
		
		contactpanel.add(contact1);
		contactpanel.add(contact2);
		contactpanel.add(contact3);
		
		contactpanel.add(emailid);
		contactpanel.add(phno);
		contactpanel.add(sitename);
		
		contact1.setBounds(10,0, 850,266);
		contact3.setBounds(10,266,670,200);
		contact2.setBounds(10,460, 346,189);
		

		emailid.setBounds(300,200,500,100);
		emailid.setVisible(false);
		phno.setBounds(300,200,500,100);
		phno.setVisible(false);
		sitename.setBounds(300,200,500,100);
		sitename.setVisible(false);
		
		mailid.setBounds(150, 300, 100,100);
		mailid.setContentAreaFilled(false);
		mailid.setBorder(null);
		
		phn.setBounds(330, 335, 100, 100);
		phn.setContentAreaFilled(false);
		phn.setBorder(null);
		
		webname.setBounds(430,320, 100,100);
		webname.setContentAreaFilled(false);
		webname.setBorder(null);
		
		//Contact Panel End
		
		
		
		web = new JFrame("Get Coupons");
		web.setLayout(null);
		web.setBounds(0, 0, 1000, 1000);
		web.setVisible(false);
		web.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Main Frame Label Text Field Button
		Web = new JLabel("Webiste");
		webhome = new JLabel("Home");
		newc = new JLabel("New");
		store = new JLabel("Store");
		contact = new JLabel("Contact us");
		menu = new JLabel("Flipkart");

		cg = new JTextField();
		newinvoicetext=new JTextField();
		useridtext=new JTextField();
		useridlabel=new JLabel("UserId");
		coupongenerate = new JLabel("Generate New Coupon");
		addnewbill=new JLabel("Add New Invoice no");
		
		bill = new JLabel("Enter the Invoice number");
		newinvoicelabel=new JLabel("Enter New Invoice to add");
		foot = new JLabel("Welcome ");

		generate = new JButton("Generate");
		newinvoicebutton=new JButton("Add");
		login = new JButton("Login");
		register = new JButton("Register");
		logout = new JButton("Logout");
		
		login1 = new JButton("");
		show = new JButton("Show Your Coupons");

		f.add(login);
		f.add(register);
		f.add(Web);
		f.add(newc);
		f.add(store);
		f.add(contact);
		f.add(menu);
		f.add(logout);
		f.add(coupongenerate);
		//coupongenerate.setVisible(false);
		f.add(addnewbill);
		//addnewbill.setVisible(false);
		
		panel.add(cg);
		panel.add(bill);
		panel.add(generate);
		panel.add(newinvoicelabel);
		panel.add(newinvoicetext);
		panel.add(newinvoicebutton);
		panel.add(useridtext);
		panel.add(useridlabel);
		panel.add(foot);
		

		logout.setVisible(false);
		menu.setVisible(false);

		web.add(webhome);

		login.setBounds(1220, 60, 100, 40);
		login.setBackground(Color.RED);
		
		register.setBounds(1320, 60, 100, 40);
		logout.setBounds(1300, 60, 100, 40);
		newc.setBounds(250, 100, 100, 40);
		store.setBounds(360, 100, 100, 40);
		contact.setBounds(470, 100, 100, 40);
		menu.setBounds(229, 140, 100, 30);
		coupongenerate.setBounds(580, 100, 150, 40);
		addnewbill.setBounds(730,100,200,40);

		//Coupon Generator
		bill.setBounds(240, 200, 200, 40);
		bill.setVisible(false);
		cg.setBounds(440, 200, 150, 40);
		cg.setVisible(false);
		generate.setBounds(250, 250, 100, 40);
		generate.setVisible(false);
		
		newinvoicelabel.setBounds(240, 200, 200, 40);
		newinvoicelabel.setVisible(false);
		newinvoicetext.setBounds(440, 200, 150, 40);
		newinvoicetext.setVisible(false);
		newinvoicebutton.setBounds(250, 250, 100, 40);
		newinvoicebutton.setVisible(false);
		useridlabel.setBounds(240,100,150,40);
		useridlabel.setVisible(false);
		useridtext.setBounds(440, 100, 150, 40);
		useridtext.setVisible(false);
		foot.setBounds(0, 500, 100, 30);

		foot.setBackground(Color.BLUE);
		foot.setForeground(Color.GREEN);

		Web.setBounds(1, 2, 50, 20);
		webhome.setBounds(1, 10, 100, 20);
		// Initialize Label
		user = new JLabel("Username");
		user2 = new JLabel("Username");
		fn = new JLabel("First Name");
		ln = new JLabel("Last Name");
		pass = new JLabel("Password");
		pass2 = new JLabel("Password");
		email = new JLabel("E-mail");
		mob = new JLabel("Mobile No.");
		forgot = new JLabel("Forgot Password ?");
		home = new JLabel("Home");
		homelogin = new JLabel("Home");

		// Initialize TextFileds
		username = new JTextField(); // Text Filed in login frame
		username2 = new JTextField();

		fname = new JTextField(); // Text Field in Registr frame
		lname = new JTextField();
		mail = new JTextField();
		p = new JPasswordField();
		p2 = new JPasswordField();
		p3 = new JPasswordField();
		loginusertext=new JTextField("User Id");

		signup = new JButton(""); // Enter Button for Register/Signup
		signin = new JButton(""); // Enter Button for Login
		cancel=new JButton("Cancel");
		
		/*
		 * // Adding Component to Signup frame signupf.add(home);
		 * signupf.add(login1); login1.setBounds(17,77,40,15);
		 * login1.setContentAreaFilled(false); login1.setBorder(null);
		 * signupf.add(user); signupf.add(username); signupf.add(fn);
		 * signupf.add(fname); signupf.add(ln); signupf.add(lname);
		 * signupf.add(pass); signupf.add(p); signupf.add(email);
		 * signupf.add(mail); signupf.add(mob); signupf.add(p3);
		 * signupf.add(forgot); signupf.add(signup);
		 * 
		 * // Login frame loginf.add(homelogin);
		 * 
		 * loginf.add(user2); loginf.add(username2);
		 * 
		 * loginf.add(pass2); loginf.add(p2);
		 */

		// Signup panel
		signuppanel.add(home);
		signuppanel.add(login1);
		login1.setBounds(17, 80, 40, 15);
		login1.setContentAreaFilled(false);
		login1.setBorder(null);
		
		signuppanel.add(username);
		signuppanel.add(fname);
		signuppanel.add(lname);
		signuppanel.add(p);
		signuppanel.add(mail);
		signuppanel.add(p3);
		signuppanel.add(forgot);
		signuppanel.add(signup);

		// Login Panel
		loginpanel.add(homelogin);

		loginpanel.add(username2);
		loginpanel.add(p2);
		loginpanel.add(signin);
		loginpanel.add(cancel);
		
		f.add(show); // Coupon Show Button
		f.add(loginusertext);
		show.setVisible(false);
		loginusertext.setVisible(false);
		loginusertext.setBounds(1240, 150, 150, 40);
		show.setBounds(1240,200, 150, 40);
		

		// Setbounds for signup frame

		homelogin.setBounds(1, 1, 50, 20);
		// user.setBounds(20, 10, 100, 20);
		username.setBounds(147, 120, 158, 30);
		username.setOpaque(false);
		username.setBackground(new Color(0, 0, 0, 0));
		username.setBorder(null);

		// fn.setBounds(20, 40, 100, 20);
		p.setBounds(147, 156, 158, 30);
		p.setOpaque(false);
		p.setBackground(new Color(0, 0, 0, 0));
		p.setBorder(null);

		// ln.setBounds(20, 70, 100, 20);
		p3.setBounds(147, 191, 156, 30);
		p3.setOpaque(false);
		p3.setBackground(new Color(0, 0, 0, 0));
		p3.setBorder(null);

		// pass.setBounds(20, 100, 100, 20);
		mail.setBounds(147, 228, 158, 30);
		mail.setOpaque(false);
		mail.setBackground(new Color(0, 0, 0, 0));
		mail.setBorder(null);

		// email.setBounds(20, 130, 100, 20);
		fname.setBounds(147, 264, 158, 30);
		fname.setOpaque(false);
		fname.setBackground(new Color(0, 0, 0, 0));
		fname.setBorder(null);

		// mob.setBounds(20, 160, 100, 20);
		lname.setBounds(147, 300, 158, 30);
		lname.setOpaque(false);
		lname.setBackground(new Color(0, 0, 0, 0));
		lname.setBorder(null);

		forgot.setBounds(10, 350, 150, 20);
		home.setBounds(1, 1, 50, 20);

		// Login Panel
		username2.setBounds(100, 70, 150, 45);
		username2.setOpaque(false);
		username2.setBackground(new Color(0, 0, 0, 0));
		username2.setBorder(null);

		p2.setBounds(100, 120, 150, 45);
		p2.setOpaque(false);
		p2.setBackground(new Color(0, 0, 0, 0));
		p2.setBorder(null);

		// Signup button SetBounds
		signup.setBounds(164, 397, 71, 35);
		signup.setContentAreaFilled(false);
		signup.setBorder(null);
		// sign in button SetBounds
		signin.setBounds(100, 170, 200, 50);
		signin.setContentAreaFilled(false);
		signin.setBorder(null);
		

		cancel.setBounds(40,230,220,50);
		cancel.setContentAreaFilled(false);
		cancel.setBackground(new Color(0,0,0,0));
		cancel.setBorder(null);
		
		login.addActionListener((ActionListener) this);
		register.addActionListener(this);
		signin.addActionListener(this);
		signup.addActionListener(this);
		logout.addActionListener(this);
		generate.addActionListener(this);
		show.addActionListener(this);
		login1.addActionListener(this);
		newinvoicebutton.addActionListener(this);
	

		// Home Label on Login frame
		home.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent m) {
				if (m.getSource() == home) {
					f.setVisible(true);
					signuppanel.setVisible(false);
					loginpanel.setVisible(false);
				}
			}
		});
		//Flipkart offer
		flipkart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent m) {
				if (m.getSource() == flipkart)
					try {				
							new Flipkart1();			
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		});
		
		
		// Home label on Signup frame
		homelogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent m) {
				if (m.getSource() == homelogin) {
					f.setVisible(true);
					loginpanel.setVisible(false);
					signuppanel.setVisible(false);
					username2.setText("");
					p2.setText("");
				}
			}
		});
		// Image label on main frame
		imgf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent m) {
				if (m.getSource() == imgf) {
					web.setVisible(true);
					signuppanel.setVisible(false);
					loginpanel.setVisible(false);
				}
			}
		});
		// Home button on main frame
		webhome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent m) {
				if (m.getSource() == webhome) {
					f.setVisible(true);
					signuppanel.setVisible(false);
					web.dispose();
					signuppanel.setVisible(false);
					loginpanel.setVisible(false);
				}
			}
		});
		cancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent m) {
				if (m.getSource() ==cancel) {
					f.setVisible(true);
					signuppanel.setVisible(false);
					loginpanel.setVisible(false);
				}
			}
		});
		
		newc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent m) {
				if (m.getSource() == newc) {
					try {
						new Webpage();
					} catch (IOException | URISyntaxException e) {
						//  Auto-generated catch block
						e.printStackTrace();
					}
					/*
					 * if(count==0){ menu.setVisible(true); count=1; } else{
					 * menu.setVisible(false); count=0; }
					 */
				}
			}
		});
		store.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent m) {
				if (m.getSource() == store) {
					if (count == 0) {
						stores.setVisible(true);
						panel.setVisible(false);
						cg.setVisible(false);
						bill.setVisible(false);
						generate.setVisible(false);
						
						contactpanel.setVisible(false);
						count = 1;
					} else {
						stores.setVisible(false);
						panel.setVisible(true);
						count = 0;
					}
				}
			}
		});
		contact.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent m) {
				if (m.getSource() == contact) {
					if (count == 0) {
						stores.setVisible(false);
						panel.setVisible(false);
						contactpanel.setVisible(true);
						cg.setVisible(false);
						bill.setVisible(false);
						generate.setVisible(false);
						count = 1;
					} else {
						contactpanel.setVisible(false);
						panel.setVisible(true);
						count = 0;
					}
				}
			}
		});
		mailid.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent m) {
				if (m.getSource() == mailid) {
					if (count == 0) {
						contactpanel.setVisible(true);
						emailid.setVisible(true);
						phno.setVisible(false);
						sitename.setVisible(false);
						count = 1;
					} else {
						emailid.setVisible(false);
						count = 0;
					}
				}
			}
		});
		phn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent m) {
				if (m.getSource() == phn) {
					if (count == 0) {
						contactpanel.setVisible(true);
						phno.setVisible(true);
						emailid.setVisible(false);
						sitename.setVisible(false);
						count = 1;
					} else {
						phno.setVisible(false);
						count = 0;
					}
				}
			}
		});
		webname.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent m) {
				if (m.getSource() == webname) {
					if (count == 0) {
						contactpanel.setVisible(true);
						sitename.setVisible(true);
						phno.setVisible(false);
						emailid.setVisible(false);
						count = 1;
					} else {
						sitename.setVisible(false);
						count = 0;
					}
				}
			}
		});

		// Coupon genertor
		coupongenerate.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent m) {
				if (m.getSource() == coupongenerate) {
					if (count == 0) {
						panel.setVisible(true);
						cg.setVisible(true);
						bill.setVisible(true);
						generate.setVisible(true);
						useridtext.setVisible(false);
						useridlabel.setVisible(false);
						newinvoicelabel.setVisible(false);
						newinvoicetext.setVisible(false);
						newinvoicebutton.setVisible(false);
						//useridtext.setVisible(true);
						//useridlabel.setVisible(true);
						contactpanel.setVisible(false);
						
						count = 1;
					} else {
						cg.setVisible(false);
						bill.setVisible(false);
						generate.setVisible(false);
						useridtext.setVisible(false);
						useridlabel.setVisible(false);
						
						count = 0;
					}
				}
			}
		});
		addnewbill.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent m) {
				if (m.getSource() ==addnewbill) {
					if (count == 0) {
						panel.setVisible(true);
						newinvoicetext.setVisible(true);
						newinvoicelabel.setVisible(true);
						newinvoicebutton.setVisible(true);
						useridtext.setVisible(true);
						useridlabel.setVisible(true);
						
						contactpanel.setVisible(false);
						stores.setVisible(false);
						count = 1;
					} else {
						cg.setVisible(false);
						bill.setVisible(false);
						generate.setVisible(false);
						
						newinvoicelabel.setVisible(false);
						newinvoicetext.setVisible(false);
						useridtext.setVisible(false);
						useridlabel.setVisible(false);
						newinvoicebutton.setVisible(false);
						count = 0;
					}
				}
			}
		});

		// SlideShow
		pic = new JLabel();
		pic.setBounds(965, 590, 250, 200);
		// Call The Function SetImageSize
		SetImageSize(6);
		// set a timer
		tm = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SetImageSize(x);
				x += 1;
				if (x >= list.length)
					x = 0;
			}
		});

		f.add(pic);
		tm.start();
		f.getContentPane().setBackground(Color.decode("#bdb67b"));
		f.setLocationRelativeTo(null);

		connection(); // Database Coonection calling method
	}

	// Constructor end

	// Function to resize the image
	public void SetImageSize(int i) {
		ImageIcon icon = new ImageIcon(list[i]);
		Image img = icon.getImage();
		Image newImg = img.getScaledInstance(pic.getWidth(), pic.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon newImc = new ImageIcon(newImg);
		pic.setIcon(newImc);
	}

	// Action Listener for Login and register button

	@SuppressWarnings("deprecation")
	@Override

	public void actionPerformed(ActionEvent e) {
		String ae = username2.getText();
		System.out.println(ae);

		if (e.getSource() == login || e.getSource() == login1) {

			loginpanel.setVisible(true);
			signuppanel.setVisible(false);
		} else if (e.getSource() == register) {
			signuppanel.setVisible(true);
			loginpanel.setVisible(false);
		}

		// checks if the button clicked
		else if (e.getSource() == signin) {
			char[] temp_pwd = p2.getPassword();
			String pwd = null;
			pwd = String.copyValueOf(temp_pwd);
			System.out.println("Username,Pwd:" + username2.getText() + "," + pwd);

			// The entered username and password are sent via "checkLogin()"
			// which return boolean
			if (username2.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Enter User name or Password", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
			else if (checkLogin(username2.getText(), pwd)) {
				// a pop-up box
				new AfterLogin();
				// JOptionPane.showMessageDialog(null, "You have logged in
				// successfully", "Success",
				// JOptionPane.INFORMATION_MESSAGE);
			} else {
				// a pop-up box
				JOptionPane.showMessageDialog(null, "Username or Password wrong", "Failed!!", JOptionPane.ERROR_MESSAGE);
			}
		}

		else if (e.getSource() == logout) {
			f.setVisible(true);
			logout.setVisible(false);
			show.setVisible(false);
			register.setVisible(true);
			login.setVisible(true);
		}

		else if (e.getSource() == signup) {
			try // try block
			{
				// check condition if fields are blank throw error message
				if (username.getText().equals("")) {
					JOptionPane.showMessageDialog(null, " name or password or Role is wrong", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else // else insert query is run properly
				{
					String IQuery = " insert into user (Id,password,conf_pass,email,First_name,Last_name)"
							+ " values (?, ?, ?, ?,?,?)";
					System.out.println(IQuery);// print on console
					System.out.println("Connecting to a selected database...");
					// STEP 3: Open a connection
					System.out.println("Connected database successfully...");

					PreparedStatement preparedStmt = con.prepareStatement(IQuery);
					preparedStmt.setString(1, username.getText());
					preparedStmt.setString(2, p.getText());
					preparedStmt.setString(3, p3.getText());
					preparedStmt.setString(4, mail.getText());
					preparedStmt.setString(5, fname.getText());
					preparedStmt.setString(6, lname.getText());

					// execute the preparedstatement
					preparedStmt.execute();
					// define SMessage variable
					String SMessage = "Record added for " + username.getText();
					EmailSender.send("emailexampl1200@gmail.com", "J.@8800.k", mail.getText(), "Thanks for Joining Us",
							"Welcome to GetCoupons enjoy discount on your every online purchase");
					// create dialog ox which is print message

					new AfterLogin(); // After Login Page Opens

					JOptionPane.showMessageDialog(null, SMessage, "Message", JOptionPane.PLAIN_MESSAGE);
				}
			} catch (SQLException se) {
				// handle errors for JDBC
				se.printStackTrace();
			} catch (Exception a) // catch block
			{
				a.printStackTrace();
			}
			signuppanel.setVisible(false);
			username.setText("");
			fname.setText("");
			lname.setText("");
			p.setText("");
			mail.setText("");
			p3.setText("");
		}
		// Cuopon Generator button
		else if (e.getSource() == generate) {
			try {
				String txt = cg.getText();
				if (txt.equals("")) {
					JOptionPane.showMessageDialog(null, " Enter a valid bill no", "Error", JOptionPane.ERROR_MESSAGE);
				} else if (verifyBill(cg.getText())) {
					// JOptionPane.showMessageDialog(null, "this Bill no not
					// exist");

					String query = "select * from generate where bill_no=?";
					PreparedStatement psr = con.prepareStatement(query);
					psr.setString(1, cg.getText());
					rs = psr.executeQuery();
					while (rs.next()) {
						d1 = rs.getString("bill_no");
						d2 = rs.getString("coupon");
						JOptionPane.showMessageDialog(null, d2);
					}
					String queryd = "insert into duplicate_data(bill_no,coupon)" + "values(?,?)";
					PreparedStatement q2 = con.prepareStatement(queryd);
					q2.setString(1, d1);
					q2.setString(2, d2);
					q2.execute();
					String queryr = "delete from generate where bill_no=?";
					PreparedStatement q1 = con.prepareStatement(queryr);
					q1.setString(1, cg.getText());
					q1.execute();
				} else {
					JOptionPane.showMessageDialog(null, "this Bill no not exist");

				}

				// JOptionPane.showMessageDialog(null,"JK"+cg.getText()+"123");
			} catch (SQLException e1) {
				//  Auto-generated catch block
				e1.printStackTrace();
			}

		}

		else if (e.getSource() == show) {
			try {
				
			if(verifyuser(loginusertext.getText())){
				
				System.out.println("Entered into show button loop");
				String queryshow = "select bill_no,coupon from generate where Id=? ";

				PreparedStatement pstt = con.prepareStatement(queryshow);
				pstt.setString(1,loginusertext.getText());
				rs = pstt.executeQuery();

				while (rs.next())
					System.out.println(rs.getString("bill_no") + "," + rs.getString("coupon"));

				// JOptionPane.showMessageDialog(null,rs.getRowId(1));
				}
				else{
					JOptionPane.showMessageDialog(null, "Enter valid user id");
				}
				} catch (SQLException e1) {
				//  Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		else if(e.getSource()==newinvoicebutton){
			if(newinvoicetext.getText().equals("")){
				JOptionPane.showMessageDialog(null, "Enter a invoice no first");
			}
			else if (verifyBill(newinvoicetext.getText())){
					JOptionPane.showMessageDialog(null, "Invoice no. already exist");
			
			}
			else if(verifyuser(useridtext.getText())){	
				try{
		
				String insertbill="insert into generate(Id,bill_no,coupon)"+" values(?,?,?)";
				PreparedStatement insertps=con.prepareStatement(insertbill);
				insertps.setString(1, useridtext.getText());
				insertps.setString(2, newinvoicetext.getText());
				insertps.setString(3, null);
				insertps.execute();
				JOptionPane.showMessageDialog(null, "Invoice add Successfully.......");
						
				}
				
				catch(SQLException in){
					in.printStackTrace();
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "user not exist");
			}
		}

	}

	public void connection() {
		try {

			// MAKE SURE YOU KEEP THE mysql_connector.jar file in java/lib
			// folder
			// ALSO SET THE CLASSPATH
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3308/Coupon", "root", "");
			pst = con.prepareStatement("select * from user where Id=? and password=?");
			ps = con.prepareStatement("Select * from generate where bill_no=?");
			idps=con.prepareStatement("select Id from user where Id=?");
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// ip:username,password
	// return boolean
	public Boolean checkLogin(String Id, String pass) {
		try {

			pst.setString(1, Id); // this replaces the 1st "?" in the query for
									// username
			pst.setString(2, pass); // this replaces the 2st "?" in the query
									// for password
			// executes the prepared statement
			rs = pst.executeQuery();
			if (rs.next()) {
				// TRUE iff the query founds any corresponding data
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			//  Auto-generated catch block
			System.out.println("error while validating" + e);
			return false;
		}
	}

	public Boolean verifyBill(String bill_no) {
		try {
			ps.setString(1, bill_no);
			rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}

	}
	public Boolean verifyuser(String Id){
		try{
			idps.setString(1,Id);
			rs=idps.executeQuery();
			if(rs.next()){
			System.out.println("Success");
			}
			else {
				return false;
			}
			return true;
		}catch(Exception e){
			System.out.println("Error");
			return false;
		}
	}

}
