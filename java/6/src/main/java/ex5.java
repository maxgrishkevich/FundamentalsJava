//        Вывод строки заданным шрифтом и заданного цвета в графическом окне.
//        В верхней панели (JPanel) "Управление выводом" задается
//        надпись (JLabel) "Текст:" и текстовое поле (JTextField),
//        надпись (JLabel) "Гарнитура:", вращающийся список  (JSpinner)
//        со значениями "Times New Roman" (шрифт по умолчанию),
//        "Arial" и "Verdana",  надпись (JLabel) "Цвет:" и вращающийся
//        список  (JSpinner) со значениями "Черный" (цвет по умолчанию),
//        "Красный", "Зеленый" и "Синий", а также кнопка (JButton)
//        "Вывести строку". В нижней панели (JPanel) "Вывод строки"
//        выводится в графическом контексте (с помощью метода drawString())
//        в произвольном месте пустая строка. При задании текста строки в
//        текстовом поле, параметров строки во вращающихся списках  верхней
//        панели и нажатии кнопки "Вывод строки" строка заданного содержимого
//        и цвета выводится заданным шрифтом в нижней панели.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ex5 extends JFrame {
    private String myText, myFont, myColour;
    private final JSpinner chooseFont;
    private final JSpinner chooseColour;
    private final JTextField outputText;

    public ex5() {
        JFrame window = new JFrame("Керування виводом");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setLocation(600, 100);
        window.setSize(380, 230);
        window.setResizable(false);
        window.setVisible(true);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        window.add(mainPanel);

        JPanel upPanel = new JPanel();
        upPanel.setBorder(BorderFactory.createTitledBorder("Параметри тексту"));
        upPanel.setPreferredSize(new Dimension(200, 115));
        mainPanel.add(upPanel, BorderLayout.NORTH);

        JLabel text = new JLabel("Текст: ");
        upPanel.add(text);
        outputText = new JTextField(28);
        upPanel.add(outputText);

        JLabel font = new JLabel("Гарнітура: ");
        upPanel.add(font);
        String[] fonts = {"Times New Roman", "Arial", "Verdana"};
        SpinnerListModel modelFont = new SpinnerListModel(fonts);
        chooseFont = new JSpinner(modelFont);
        upPanel.add(chooseFont);
        chooseFont.setPreferredSize(new Dimension(125, 20));
        JLabel colour = new JLabel("Колір: ");
        upPanel.add(colour);
        String[] colours = {"Чорний", "Червоний", "Зелений", "Синій"};
        SpinnerListModel modelColour = new SpinnerListModel(colours);
        chooseColour = new JSpinner(modelColour);
        upPanel.add(chooseColour);
        chooseColour.setPreferredSize(new Dimension(80, 20));

        JButton button = new JButton("Вивести строку");
        upPanel.add(button);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent click) {
                myText = outputText.getText();
                myFont = (String) chooseFont.getValue();
                myColour = (String) chooseColour.getValue();
                mainPanel.add(new MyComponent());
                mainPanel.revalidate();
            }
        });

        window.revalidate();
    }

    class MyComponent extends JComponent {
        @Override
        protected void paintComponent(Graphics g){
            Font font = new Font(myFont, Font.BOLD, 20);
            Graphics2D g2 = (Graphics2D) g;
            g2.setFont(font);
            if(myColour.equals("Чорний")){
                g2.setColor(Color.BLACK);
            }
            if(myColour.equals("Червоний")){
                g2.setColor(Color.RED);
            }
            if(myColour.equals("Зелений")){
                g2.setColor(Color.GREEN);
            }
            if(myColour.equals("Синій")){
                g2.setColor(Color.BLUE);
            }
            g2.drawString(myText, 10, 40);
        }
    }

    public static void main(String[] args) { ex5 obj = new ex5(); }

}