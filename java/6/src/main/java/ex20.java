//        Изменение фигуры в графическом окне. В центре верхней
//        панели (JPanel) "Вывод треугольника" в графическом
//        контексте рисуется (с помощью метода drawPolygon())
//        треугольник.  В нижней панели (JPanel) "Параметры " +
//        "треугольника" задаются следующие компоненты: надпись
//        (JLabel)   "Цвет:", вращающийся список (JSpinner) со
//        значениями: "Черный" (цвет по умолчанию),  "Красный",
//        "Зеленый" и "Синий", надпись (JLabel)   "Номер вершины:",
//        вращающийся список (JSpinner) со значениями "1", "2" и "3",
//        надпись (JLabel)   "Координата X:", текстовое поле
//        (JTextField), надпись (JLabel)   "Координата Y:", текстовое
//        поле   (JTextField) и кнопка (JButton) "Изменить треугольник".
//        При наборе данных во вращающихся списках (в пикселях), вводе
//        данных в текстовых полях (в пикселях) и при нажатии кнопки
//        "Изменить треугольник" треугольник перерисовывается заданным
//        цветом и с заданным новым положением одной из вершин. Перед
//        выводом фигуры выполняется проверка, введены ли в текстовых
//        полях все данные и являются ли они целыми числами.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ex20 extends JComponent {
    private static Polygon polygon;
    private String num;
    private String xCoord;
    private String yCoord;
    private static JSpinner chooseColour;
    private final int [] xPoly = {0, 180, 250}; // 0 < x < 250
    private final int [] yPoly = {150, 0, 250}; // 0 < x < 250

    ex20()  {
        JFrame window = new JFrame("Керування виводом");
        window.setVisible(true);
        window.setBounds(700,250,350,450);
        window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        polygon = new Polygon(xPoly, yPoly, 3);

        JPanel upPanel = new JPanel(new FlowLayout());
        upPanel.add(new MyComponent());
        upPanel.setBorder(BorderFactory.createTitledBorder("Вивід трикутника"));
        mainPanel.add(upPanel, BorderLayout.NORTH);
        upPanel.setPreferredSize(new Dimension(460,300));

        JPanel downPanel = new JPanel();
        downPanel.setBorder(BorderFactory.createTitledBorder("Параметри трикутника"));
        mainPanel.add(downPanel, BorderLayout.CENTER);
        window.getContentPane().add(mainPanel);
        downPanel.setPreferredSize(new Dimension(350,120));

        String[] color ={"Чорний", "Червоний", "Зелений", "Синій"};
        JLabel colour = new JLabel("Колір:");
        downPanel.add(colour);
        chooseColour = new JSpinner(new SpinnerListModel(color));
        chooseColour.setPreferredSize(new Dimension(100, 20));
        downPanel.add(chooseColour);

        JLabel textPosLeftTopLabel2 = new JLabel("   Номер вершини:");
        downPanel.add(textPosLeftTopLabel2);
        String[] number ={"1", "2", "3"};
        JSpinner chooseNumberOfTop = new JSpinner(new SpinnerListModel(number));
        chooseNumberOfTop.setPreferredSize(new Dimension(50, 20));
        downPanel.add(chooseNumberOfTop);

        JLabel xCoordText = new JLabel("Координата X:");
        downPanel.add(xCoordText);
        JLabel pixels1 = new JLabel("px");
        JLabel pixels2 = new JLabel("px");
        JTextField xCoordInput = new JTextField("", 4);
        xCoordInput.setHorizontalAlignment(JTextField.RIGHT);
        downPanel.add(xCoordInput);
        downPanel.add(pixels2);

        JLabel yCoordText = new JLabel("   Координата Y:");
        downPanel.add(yCoordText);
        JTextField yCoordInput = new JTextField("", 4);
        yCoordInput.setHorizontalAlignment(JTextField.RIGHT);
        downPanel.add(yCoordInput);
        downPanel.add(pixels1);

        JButton button = new JButton("Змінити трикутник");
        downPanel.add(button);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                num   = (String) chooseNumberOfTop.getValue();
                xCoord = xCoordInput.getText();
                yCoord = yCoordInput.getText();
                try {
                    int yCord = Integer.parseInt(yCoord);
                    int xCord = Integer.parseInt(xCoord);
                    int numOfTop = Integer.parseInt(num);
                    if (numOfTop == 1){
                        xPoly[0] = xCord;
                        yPoly[0] = yCord;
                        polygon = new Polygon(xPoly, yPoly, 3);
                        window.repaint();
                    }
                    if (numOfTop == 2){
                        xPoly[1] = xCord;
                        yPoly[1] = yCord;
                        polygon = new Polygon(xPoly, yPoly, 3);
                        window.repaint();
                    }
                    if (numOfTop == 3){
                        xPoly[2] = xCord;
                        yPoly[2] = yCord;
                        polygon = new Polygon(xPoly, yPoly, 3);
                        window.repaint();
                    }
                }catch(NumberFormatException ex){
                    System.exit(0);
                }
            }
        });

        downPanel.revalidate();
        window.repaint();

    }

    static class MyComponent extends JComponent{
        @Override
        protected void paintComponent(Graphics g) {
            String colour = (String) chooseColour.getValue();
            if(colour.equals("Чорний")){
                g.setColor(Color.BLACK);
            }
            if(colour.equals("Червоний")){
                g.setColor(Color.RED);
            }
            if(colour.equals("Зелений")){
                g.setColor(Color.GREEN);
            }
            if(colour.equals("Синій")){
                g.setColor(Color.BLUE);
            }
            super.paintComponent(g);
            g.drawPolygon(polygon);
        }
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(250, 250);
        }
    }

    public static void main(String[] args) {
        ex20 obj = new ex20();
    }
}
