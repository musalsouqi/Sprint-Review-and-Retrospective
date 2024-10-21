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
import java.awt.Desktop;
import java.net.URI;

public class SlideShow extends JFrame {

    // Declare Variables
    private JPanel slidePane;
    private JPanel textPane;
    private JPanel buttonPane;
    private CardLayout card;
    private CardLayout cardText;
    private JButton btnPrev;
    private JButton btnNext;
    private JLabel lblSlide;
    private JLabel lblTextArea;
    private String[] links = {
        "https://www.tripadvisor.com/AttractionProductReview-g297701-d17404271-Detox_Healing_Retreat_in_Bali-Ubud_Gianyar_Regency_Bali.html",
        "https://www.tripadvisor.com/Hotel_Review-g31352-d282453-Reviews-Amara_Resort_and_Spa-Sedona_Arizona.html",
        "https://www.tripadvisor.com/Hotel_Review-g23240074-d297164-Reviews-Amansala_Yoga_And_Wellness_Resort-Tulum_Beach_Tulum_Yucatan_Peninsula.html",
        "https://www.tripadvisor.com/Tourism-g293918-Ko_Samui_Surat_Thani_Province-Vacations.html",
        "https://www.tripadvisor.com/Hotel_Review-g1177889-d7686769-Reviews-The_Retreat_Costa_Rica_Wellness_Resort_Spa-Atenas_Province_of_Alajuela.html"
    };

    /**
     * Create the application.
     */
    public SlideShow() throws HeadlessException {
        initComponent();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initComponent() {
        // Initialize variables to empty objects
        card = new CardLayout();
        cardText = new CardLayout();
        slidePane = new JPanel();
        textPane = new JPanel();
        textPane.setBackground(Color.BLUE);
        textPane.setBounds(5, 470, 790, 50);
        textPane.setVisible(true);
        buttonPane = new JPanel();
        btnPrev = new JButton();
        btnNext = new JButton();
        lblSlide = new JLabel();
        lblTextArea = new JLabel();

        // Setup frame attributes
        setSize(800, 600);
        setLocationRelativeTo(null);
        setTitle("Detox/Wellness Travel SlideShow"); // Updated title
        getContentPane().setLayout(new BorderLayout(10, 50));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Setting the layouts for the panels
        slidePane.setLayout(card);
        textPane.setLayout(cardText);

        // Logic to add each of the slides and text
        for (int i = 0; i < links.length; i++) {
            lblSlide = new JLabel();
            lblTextArea = new JLabel();
            lblSlide.setText(getResizeIcon(i + 1)); // Load image based on the slide index
            lblTextArea.setText(getTextDescription(i + 1)); // Load text description based on the slide index
            
            int index = i; // Create a final variable for the inner class
            lblSlide.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    openWebpage(links[index]); // Open the associated link when the image is clicked
                }
            });
            
            slidePane.add(lblSlide, "card" + (i + 1));
            textPane.add(lblTextArea, "cardText" + (i + 1));
        }

        getContentPane().add(slidePane, BorderLayout.CENTER);
        getContentPane().add(textPane, BorderLayout.SOUTH);

        buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

        btnPrev.setText("Previous");
        btnPrev.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                goPrevious(); // Navigate to the previous slide
            }
        });
        buttonPane.add(btnPrev);

        btnNext.setText("Next");
        btnNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                goNext(); // Navigate to the next slide
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
     * changed image destinations to match my image file names
     */
    private String getResizeIcon(int i) {
        String image = ""; 
        if (i == 1) {
            image = "<html><body><img width='800' height='500' src='" + getClass().getResource("/resources/DetoxRetreat1.jpg") + "' /></body></html>";
        } else if (i == 2) {
            image = "<html><body><img width='800' height='500' src='" + getClass().getResource("/resources/DetoxRetreat2.jpg") + "' /></body></html>";
        } else if (i == 3) {
            image = "<html><body><img width='800' height='500' src='" + getClass().getResource("/resources/WellnessSpa.jpg") + "' /></body></html>";
        } else if (i == 4) {
            image = "<html><body><img width='800' height='500' src='" + getClass().getResource("/resources/FishingRetreat.jpg") + "' /></body></html>";
        } else if (i == 5) {
            image = "<html><body><img width='800' height='500' src='" + getClass().getResource("/resources/HealthResort.jpg") + "' /></body></html>";
        }
        return image;
    }
    
    /**
     * Method to get the text values
     * changed descriptions to match wellness and detox
     */
    private String getTextDescription(int i) {
        String text = ""; 
        if (i == 1) {
            text = "<html><body><font size='5'>#1 Detox & Healing Retreat in Bali</font> <br>This weight loss and detox program is a complete life reset. It is perfect for the person who is serious about losing weight for good - without diets, drugs or deprivation.</body></html>";
        } else if (i == 2) {
            text = "<html><body><font size='5'>#2 Yoga and Wellness Retreat</font> <br>Find your inner peace in a serene environment. Sit by our infinity pool and soak in the spirit of Sedona and star gaze nightly in courtyard with s’mores. Treat yourself to a massage or hot stone treatment at The Spa or sign up for our ever so popular yoga class.</body></html>";
        } else if (i == 3) {
            text = "<html><body><font size='5'>#3 Amansala Yoga And Wellness Resort</font> <br>Days start with a power walk on the beach, and include yoga, fantastic fitness classes, tours to see the highlights of the area, healthy natural food, massages, and much more.</body></html>";
        } else if (i == 4) {
            text = "<html><body><font size='5'>#4 Meditation Retreat</font> <br>Enhance mindfulness and tranquility. Once a fishing community, Koh Samui, Thailand's second largest island, has retained its charming sensibility. Spending time in Bophut is a wonderful way to soak up local culture.</body></html>";
        } else if (i == 5) {
            text = "<html><body><font size='5'>#5 The Retreat Costa Rica - Wellness Resort & Spa </font> <br>The Retreat Costa Rica is an award-winning, adults-only luxury wellness boutique hotel and spa, located on a 50-acre crystal quartz mountain overlooking the Pacific Ocean. </body></html>";
        }
        return text;
    }

    /**
     * Method to open the associated link in the browser
     */
    private void openWebpage(String urlString) {
        try {
            URI uri = new URI(urlString);
            Desktop.getDesktop().browse(uri);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Launch the application.
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
