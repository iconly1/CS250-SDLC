import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;

/**
 * This class manages the SlideShow, handling image and text updates based on user interactions.
 * It supports adding, removing, and updating slides with custom text and images.
 * Author: Ian Coxon (Turtle)
 * Date: 2024-04-14
 */

public class SlideShow extends JFrame {

	//Declare Variables
	private JPanel slidePane;
	private JPanel textPane;
	private JPanel buttonPane;
	private CardLayout card;
	private CardLayout cardText;
	private JButton btnPrev;
	private JButton btnNext;
	private JLabel lblSlide;
	private JLabel lblTextArea;

	/**
	 * Create the application.
	 */
	/**
	 * Constructor for SlideShow initializes the data structures and sets initial configuration.
	 */
	public SlideShow() throws HeadlessException {
		initComponent();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initComponent() {
		//Initialize variables to empty objects
		card = new CardLayout();
		cardText = new CardLayout();
		slidePane = new JPanel();
		textPane = new JPanel();
		textPane.setBackground(Color.ORANGE);
		textPane.setBounds(5, 470, 790, 50);
		textPane.setVisible(true);
		buttonPane = new JPanel();
		btnPrev = new JButton();
		btnNext = new JButton();
		lblSlide = new JLabel();
		lblTextArea = new JLabel();

		//Setup frame attributes
		setSize(800, 600);
		setLocationRelativeTo(null);
		setTitle("Top 5 Destinations SlideShow");
		getContentPane().setLayout(new BorderLayout(10, 50));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Setting the layouts for the panels
		slidePane.setLayout(card);
		textPane.setLayout(cardText);

		//logic to add each of the slides and text
		for (int i = 1; i <= 5; i++) {
			lblSlide = new JLabel();
			lblTextArea = new JLabel();
			lblSlide.setText(getResizeIcon(i));
			lblTextArea.setText(getTextDescription(i));
			slidePane.add(lblSlide, "card" + i);
			textPane.add(lblTextArea, "cardText" + i);
		}

		getContentPane().add(slidePane, BorderLayout.CENTER);
		getContentPane().add(textPane, BorderLayout.SOUTH);

		buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

		btnPrev.setText("Previous");
		btnPrev.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				goPrevious();
			}
		});
		buttonPane.add(btnPrev);

		btnNext.setText("Next");
		btnNext.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				goNext();
			}
		});
		buttonPane.add(btnNext);

		getContentPane().add(buttonPane, BorderLayout.SOUTH);
	}

	/**
	 * Previous Button Functionality
	 */
	private void goPrevious() {
		card.previous(slidePane);
		cardText.previous(textPane);
	}

	/**
	 * Next Button Functionality
	 */
	private void goNext() {
		card.next(slidePane);
		cardText.next(textPane);
	}

	/**
	 * Method to get the images
	 * update 4/14/2024
	 * added new images as directed
	 */

	private String getResizeIcon(int i) {
		String image = "";
		switch (i) {
			case 1:
				image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/TestImage1.jpg") + "'</body></html>";
				break;
			case 2:
				image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/TestImage2.jpg") + "'</body></html>";
				break;
			case 3:
				image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/TestImage3.jpg") + "'</body></html>";
				break;
			case 4:
				image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/TestImage4.jpg") + "'</body></html>";
				break;
			case 5:
				image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/TestImage5.jpg") + "'</body></html>";
				break;
			// Add additional cases as necessary
		}
		return image;
	}

	/**
	 * Method to get the text values
	 * update 4-14-2024
	 * descriptions changed to meet requirements
	 */
	private String getTextDescription(int i) {
		String text = "";
		switch (i) {
			case 1:
				text = "<html><body><font size='5'>Breathe in nature at a luxurious mountain retreat.</font><br>Experience the serenity of the great outdoors.</body></html>";
				break;
			case 2:
				text = "<html><body><font size='5'>Discover tranquility with wellness mountain getaways.</font><br>Find balance and peace in a breathtaking setting.</body></html>";
				break;
			case 3:
				text = "<html><body><font size='5'>Embrace the healing power of water at natural hot springs.</font><br>Relax in the therapeutic waters surrounded by nature.</body></html>";
				break;
			case 4:
				text = "<html><body><font size='5'>Unwind at a rustic cabin escape.</font><br>Reconnect with yourself in a cozy, serene environment.</body></html>";
				break;
			case 5:
				text = "<html><body><font size='5'>Luxuriate in an exclusive cottage bed & breakfast.</font><br>Indulge in comfort and elegance in a peaceful country setting.</body></html>";
				break;
			// Add additional cases as necessary
		}
		return text;
	}

	/**
	 * The main method to launch the SlideShow application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				SlideShow ss = new SlideShow();
				ss.setVisible(true);
			}
		});
	}
}