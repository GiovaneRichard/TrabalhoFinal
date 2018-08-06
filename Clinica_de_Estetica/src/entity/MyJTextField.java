package entity;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author giovane richard
 */
public class MyJTextField extends JTextField implements FocusListener{

    private static Color defaultBackground = new Color(233, 0, 0);
    private static Color focusedBackground = new Color(255, 255, 255);
    private static Border defaultBorder = BorderFactory.createLineBorder (Color.DARK_GRAY);
    private static Border focusedBorder = BorderFactory.createLineBorder(Color.DARK_GRAY, 1);
    //private static Font defaultFont = new Font (“Verdana”, Font.PLAIN, 12);
    //private static Font defaultReadonlyFont = new Font (“Verdana”, Font.BOLD, 12);
    private static Color defaultForeground = Color.BLACK;
    private static Color defaultReadonlyBackground = Color.WHITE;
    private static Border defaultReadonlyBorder = BorderFactory.createEmptyBorder();
    private static Border designTimeReadonlyBorder = BorderFactory.createEmptyBorder();
    
    
//    public CampoDeTexto () {
//    setFont(defaultFont);
//    setForeground(defaultForeground);
//    addFocusListener (this);
//}
    
    @Override
    public void focusGained(FocusEvent e) {
        defaultBackground = getBackground();
        defaultBorder = getBorder();
        setBackground(focusedBackground);
        setBorder(defaultBorder);
    }

    @Override
    public void focusLost(FocusEvent e) {
        setBackground(defaultBackground);
        setBorder(defaultBorder);
    }
    
}
