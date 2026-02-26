package deFeeter;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame {
    private JFrame frame;
    private JPanel text;
    private JLabel label;
    private JButton button;
    private JPanel click;
    public MyFrame() {
        initialize();
    }
    private void initialize() {
        frame = new JFrame();
        frame.setTitle("deFeeter - Made with Love");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);

        frame.setLayout(new BorderLayout(5, 5));

        TitleConstructor();
        ButtonConstructor();
    }

    private void TitleConstructor() {
        text = new JPanel();
        label = new JLabel("deFeeter");
        label.setFont(new Font("Sans-serif", Font.BOLD, 50));
        text.add(label);
        text.setBackground(Color.CYAN);
        JLabel txt = new JLabel("Because we need to kill the imperial system");
        txt.setFont(new Font("Dialog", Font.ITALIC, 10));
        text.add(txt);
        frame.add(text, BorderLayout.NORTH);


    }

    private void ButtonConstructor() {
        button = new JButton("Feet'Inches to Meters");
        click = new JPanel();
        button.setSize(300, 500);
        button.setFocusable(false);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        dFFrame dframe = new dFFrame();
                        dframe.show();
                    }
                });
            }
        });
        click.add(button);
        frame.add(click, BorderLayout.CENTER);
    }

    public void show() {
        frame.setVisible(true);
    }
}
