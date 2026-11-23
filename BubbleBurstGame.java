import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class BubbleBurstGame {
    private JFrame startFrame;
    private JFrame gameFrame;
    private JButton startButton;
    private JButton restartButton;
    private JSlider difficultySlider;
    private JPanel gamePanel;
    private int numBubbles;
    private ArrayList<Point> bubbleOrigins;
    private int currentRound;

    private Timer timer;
    private final int TIME_LIMIT = 60; // 60 seconds for the game

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BubbleBurstGame().createAndShowGUI();
            }
        });
    }

    private void createAndShowGUI() {
        // Start Frame
        startFrame = new JFrame("Bubble Burst");
        startButton = new JButton("Start");
        restartButton = new JButton("Restart");
        difficultySlider = new JSlider(JSlider.HORIZONTAL, 0, 2, 0); // Set min and max difficulty
        difficultySlider.setMajorTickSpacing(1);
        difficultySlider.setPaintTicks(true);
        difficultySlider.setPaintLabels(true);
        startButton.addActionListener(new StartButtonListener());
        restartButton.addActionListener(new RestartButtonListener());
        JPanel startPanel = new JPanel();
        startPanel.add(startButton);
        startPanel.add(restartButton);
        startPanel.add(new JLabel("Difficulty:"));
        startPanel.add(difficultySlider);
        startFrame.add(startPanel);
        startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startFrame.pack();
        startFrame.setVisible(true);

        // Game Frame
        gameFrame = new JFrame("Bubble Burst Game");
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setPreferredSize(new Dimension(600, 400));
        gamePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawBubbles(g);
            }
        };
        gamePanel.addMouseListener(new BubbleClickListener());
        gameFrame.add(gamePanel);
        gameFrame.pack();
    }

    private void drawBubbles(Graphics g) {
        if (bubbleOrigins != null) {
            g.setColor(Color.BLUE);
            for (Point point : bubbleOrigins) {
                g.fillOval(point.x - 10, point.y - 10, 20, 20);
            }
        }
    }

    private void startGame() {
        currentRound = 1;
        startButton.setEnabled(false);
        numBubbles = difficultySlider.getValue() + 4; 
        bubbleOrigins = new ArrayList<>();
        gameFrame.setVisible(true);
        startTimer();
        if (currentRound == 1) {
            JOptionPane.showMessageDialog(null, "Round 1: Click to place bubbles within the panel.");
        }
    }

    private void restartGame() {
        stopTimer();
        bubbleOrigins.clear();
        gamePanel.repaint();
        startButton.setEnabled(true);
    }

    private class StartButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            startGame();
        }
    }

    private class RestartButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            restartGame();
        }
    }

    private class BubbleClickListener extends MouseAdapter {
        public void mouseClicked(MouseEvent e) {
            if (currentRound == 1 && bubbleOrigins.size() < numBubbles) {
                Point clickPoint = e.getPoint();
                if (isValidBubblePosition(clickPoint)) {
                    bubbleOrigins.add(clickPoint);
                    gamePanel.repaint();
                    if (bubbleOrigins.size() == numBubbles) {
                        JOptionPane.showMessageDialog(null, "Round 1 is completed.");
                        currentRound++;
                        bubbleOrigins.clear();
                        generateRandomBubbles();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid bubble position. Please select another position.");
                }
            }
        }
    }

    private boolean isValidBubblePosition(Point point) {
        return point.x >= 10 && point.x <= gamePanel.getWidth() - 10 &&
                point.y >= 10 && point.y <= gamePanel.getHeight() - 10;
    }

    private void generateRandomBubbles() {
        Random random = new Random();
        for (; currentRound <= 10; currentRound++) {
            bubbleOrigins.clear();
            for (int i = 0; i < numBubbles; i++) {
                int x = random.nextInt(gamePanel.getWidth() - 20) + 10;
                int y = random.nextInt(gamePanel.getHeight() - 20) + 10;
                bubbleOrigins.add(new Point(x, y));
            }
            gamePanel.repaint();
            JOptionPane.showMessageDialog(null, "Round " + currentRound + " is completed.");
            if (currentRound < 10) {
                JOptionPane.showMessageDialog(null, "Round " + (currentRound + 1) + ": Click to place bubbles within the panel.");
            }
        }
        JOptionPane.showMessageDialog(null, "Game Over!");
        restartGame();
    }

    private void startTimer() {
        timer = new Timer(1000, new ActionListener() {
            int timeRemaining = TIME_LIMIT;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (timeRemaining > 0) {
                    timeRemaining--;
                } else {
                    ((Timer) e.getSource()).stop();
                    JOptionPane.showMessageDialog(null, "Time's up! Game Over!");
                    restartGame();
                }
            }
        });
        timer.start();
    }

    private void stopTimer() {
        if (timer != null && timer.isRunning()) {
            timer.stop();
        }
    }
}
