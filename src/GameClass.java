import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GameClass implements ActionListener {

    JFrame frame = new JFrame();
    JPanel Tpanel = new JPanel();
    JPanel Bpanel = new JPanel();
    Random random = new Random();
    JButton[] button = new JButton[9];
    JLabel label = new JLabel();
    boolean player1;
    boolean player2;

    GameClass() {
        frame.setSize(650,650);
        frame.getContentPane().setBackground(new Color(140, 135, 255));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        label.setBackground(Color.BLUE);
        label.setForeground(Color.BLACK);
        label.setFont(new Font("Ariel", Font.ITALIC, 40));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setText("Tic-Tac-Toe");

        Bpanel.setLayout(new GridLayout(3,3));
        Bpanel.setBackground(Color.darkGray);

        Tpanel.setLayout(new BorderLayout());
        Tpanel.setBounds(0,0,1000,80);

        for(int i = 0; i < 9; i++) {
            button[i] = new JButton();
            Bpanel.add(button[i]);
            button[i].setBackground(new Color(56, 84, 150));
            button[i].setFont(new Font("Calibri", Font.PLAIN, 80));
            button[i].setFocusable(false);
            button[i].addActionListener(this);
        }

        Tpanel.add(label);
        frame.add(Tpanel, BorderLayout. NORTH);
        frame.add(Bpanel);

        turn1();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 9; i++) {
            if (e.getSource() == button[i]) {
                if (player1) {
                    if (button[i].getText() == "") {
                        button[i].setForeground(Color.BLACK);
                        button[i].setText("X");
                        player1 = false;
                        label.setText("O Turn");
                        display();
                    }
                } else {
                    if (button[i].getText() == "") {
                        button[i].setForeground(Color.YELLOW);
                        button[i].setText("O");
                        player1 = true;
                        label.setText("X Turn");
                        display();
                    }
                }
            }
        }
    }

    public void turn1() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        player1 = true;
        label.setText("X Turn");

    }

    public void display() {

            if ((button[0].getText() == "X") && (button[1].getText() == "X") && (button[2].getText() == "X")) {
                player1w(0, 1, 2);
            }
            if ((button[3].getText() == "X") && (button[4].getText() == "X") && (button[5].getText() == "X")) {
                player1w(3, 4, 5);
            }
            if ((button[6].getText() == "X") && (button[7].getText() == "X") && (button[8].getText() == "X")) {
                player1w(6, 7, 8);
            }
            if ((button[0].getText() == "X") && (button[3].getText() == "X") && (button[6].getText() == "X")) {
                player1w(0, 3, 6);
            }
            if ((button[1].getText() == "X") && (button[4].getText() == "X") && (button[7].getText() == "X")) {
                player1w(1, 4, 7);
            }
            if ((button[2].getText() == "X") && (button[5].getText() == "X") && (button[8].getText() == "X")) {
                player1w(2, 5, 8);
            }
            if ((button[0].getText() == "X") && (button[4].getText() == "X") && (button[8].getText() == "X")) {
                player1w(0, 4, 8);
            }
            if ((button[2].getText() == "X") && (button[4].getText() == "X") && (button[6].getText() == "X")) {
                player1w(2, 4, 6);
            }
            if ((button[0].getText() == "O") && (button[1].getText() == "O") && (button[2].getText() == "O")) {
                player2w(0, 1, 2);
            }
            if ((button[3].getText() == "O") && (button[4].getText() == "O") && (button[5].getText() == "O")) {
                player2w(3, 4, 5);
            }
            if ((button[6].getText() == "O") && (button[7].getText() == "O") && (button[8].getText() == "O")) {
                player2w(6, 7, 8);
            }
            if ((button[0].getText() == "O") && (button[3].getText() == "O") && (button[6].getText() == "O")) {
                player1w(0, 3, 6);
            }
            if ((button[1].getText() == "O") && (button[4].getText() == "O") && (button[7].getText() == "O")) {
                player2w(0, 4, 7);
            }
            if ((button[2].getText() == "O") && (button[5].getText() == "O") && (button[8].getText() == "O")) {
                player2w(2, 5, 8);
            }
            if ((button[0].getText() == "O") && (button[4].getText() == "O") && (button[8].getText() == "O")) {
                player2w(0, 4, 8);
            }
            if ((button[2].getText() == "O") && (button[4].getText() == "O") && (button[6].getText() == "O")) {
                player2w(2, 4, 6);
            }
            boolean draw = true;
            for (int i = 0; i < 9; i++) {
                if (button[i].getText().isEmpty()) {
                    draw = false;
                    break;
                }
            }

            if (draw) {
                drawGame();
            }

    }

    public void player1w(int num1, int num2, int num3) {
        button[num1].setBackground(Color.ORANGE);
        button[num2].setBackground(Color.ORANGE);
        button[num3].setBackground(Color.ORANGE);

        for(int i = 0; i < 9; i++) {
            button[i].setEnabled(false);
        }

        label.setText("X wins!");
        player1 = true;
    }

    public void player2w(int num1, int num2, int num3) {
        button[num1].setBackground(Color.CYAN);
        button[num2].setBackground(Color.CYAN);
        button[num3].setBackground(Color.CYAN);

        for (int i = 0; i < 9; i++) {
            button[i].setEnabled(false);
        }
        label.setText("O wins!");
        player2 = true;
    }

    public void drawGame() {
        for (int i = 0; i < 9; i++) {
            button[i].setEnabled(false);
        }
        label.setText("Draw!");
    }

}
