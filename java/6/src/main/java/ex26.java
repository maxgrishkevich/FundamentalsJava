//        Ввод текста в графическое окно приложения. В верхней панели
//        окна  (JPanel) "Параметры шрифта" заданы следующие
//        компоненты:  надпись (JLabel)   "Стиль:", раскрывающееся меню
//        (JComboBox) с пунктами: "Простой" (стиль по умолчанию),  "Жирный"
//        и "Курсив", надпись (JLabel)   "Размер:" и раскрывающееся меню
//        (JComboBox) с пунктами: "10pt" (стиль по умолчанию),  "12pt"
//        (размер по умолчанию) и "14pt". В текстовой панели (JTextPane)
//        "Ввод текста" окна приложения вводится текст, набираемый на
//        клавиатуре. При выборе одного из пунктов раскрывающегося меню
//        стиля  и ввода в текстовом поле целого числа – размера текста
//        содержимое текстовой панели выводится соответствующим цветом и/или
//        соответствующего размера. При вводе значения в текстовое поле
//        проверяется, является ли это значение целым числом, содержащим одну
//        или две цифры.

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class ex26 {
    private String myStyle, mySize;
    private final JComboBox<String> chooseStyle;
    private final JComboBox<String> chooseSize;

    public ex26() {
        JFrame window = new JFrame("Керування виводом");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setLocation(600, 100);
        window.setSize(380, 180);
        window.setResizable(false);
        window.setVisible(true);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        window.add(mainPanel);

        JPanel upPanel = new JPanel();
        upPanel.setBorder(BorderFactory.createTitledBorder("Параметри шрифта"));
        upPanel.setPreferredSize(new Dimension(200, 70));
        mainPanel.add(upPanel, BorderLayout.NORTH);

        JPanel downPanel = new JPanel();
        downPanel.setBorder(BorderFactory.createTitledBorder("Ввід тексту"));
        downPanel.setPreferredSize(new Dimension(200, 70));
        mainPanel.add(downPanel, BorderLayout.CENTER);

        JLabel style = new JLabel("Стиль: ");
        upPanel.add(style);
        String[] styles = {"Простий", "Жирний", "Курсив"};
        chooseStyle = new JComboBox<>(styles);
        upPanel.add(chooseStyle);
        chooseStyle.setPreferredSize(new Dimension(125, 20));
        JLabel size = new JLabel("Розмір: ");
        upPanel.add(size);
        String[] sizes = {"10pt", "12pt", "14pt"};
        chooseSize = new JComboBox<>(sizes);
        chooseSize.setSelectedItem("12pt");
        upPanel.add(chooseSize);
        chooseSize.setPreferredSize(new Dimension(80, 20));

        SimpleAttributeSet attributeSet = new SimpleAttributeSet();
        JTextPane textField = new JTextPane();
        textField.setCharacterAttributes(attributeSet, true);
        textField.setPreferredSize(new Dimension(250, 30));
        downPanel.add(textField);

        chooseStyle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent click) {
                textField.setCharacterAttributes(attributeSet, false);
                myStyle = (String) chooseStyle.getSelectedItem();
                if(Objects.equals(myStyle, "Простий")){
                    StyleConstants.setBold(attributeSet, false);
                    StyleConstants.setItalic(attributeSet, false);
                    textField.setCharacterAttributes(attributeSet, true);
                    upPanel.revalidate();
                }
                if(Objects.equals(myStyle, "Жирний")){
                    StyleConstants.setBold(attributeSet, true);
                    textField.setCharacterAttributes(attributeSet, true);
                    upPanel.revalidate();
                }
                if(Objects.equals(myStyle, "Курсив")){
                    StyleConstants.setItalic(attributeSet, true);
                    textField.setCharacterAttributes(attributeSet, true);
                    upPanel.revalidate();
                }
                textField.revalidate();
                mainPanel.revalidate();
            }
        });

        chooseSize.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent click) {
                mySize = (String) chooseSize.getSelectedItem();
                if(Objects.equals(mySize, "10pt")){
                    StyleConstants.setFontSize(attributeSet, 10);
                    textField.setCharacterAttributes(attributeSet, true);
                    upPanel.revalidate();
                }
                if(Objects.equals(mySize, "12pt")){
                    StyleConstants.setFontSize(attributeSet, 12);
                    textField.setCharacterAttributes(attributeSet, true);
                    upPanel.revalidate();
                }
                if(Objects.equals(mySize, "14pt")){
                    StyleConstants.setFontSize(attributeSet, 14);
                    textField.setCharacterAttributes(attributeSet, true);
                    upPanel.revalidate();
                }
                textField.revalidate();
                mainPanel.revalidate();
            }
        });

        window.revalidate();
    }

    public static void main(String[] args) { ex26 obj = new ex26(); }

}
