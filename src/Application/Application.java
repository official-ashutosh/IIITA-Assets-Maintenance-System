package Application;
import GUI.SplashScreen;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Font;

public class Application {
    public static void main(String[] args) {
        UIManager.put("defaultFont", new Font("SansSerif", Font.PLAIN, 13));

        FlatLaf.registerCustomDefaultsSource("themes");
        UIManager.put("Button.arc", 999);
        UIManager.put("TextComponent.arc", 999);
        UIManager.put("Label.foreground", Color.black);
        UIManager.put("ScrollBar.track", new Color(0x16222A));
        UIManager.put("ScrollBar.thumb", new Color(60, 60, 60));
        UIManager.put("ScrollBar.width", 5);
        UIManager.put("ScrollBar.thumbArc", 12);
        UIManager.put("OptionPane.messageForeground", Color.BLACK);

        FlatMacLightLaf.setup();

        SplashScreen ss = new SplashScreen();
        ss.setVisible(true);
    }
}
