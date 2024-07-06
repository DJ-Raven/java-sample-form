package sample.model.other;

import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author RAVEN
 */
public class ModelProfile {

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public File getPath() {
        return path;
    }

    public void setPath(File path) {
        this.path = path;
    }

    public ModelProfile(File path) {
        this.path = path;
    }

    public ModelProfile(byte[] bytes) {
        if (bytes != null) {
            icon = new ImageIcon(bytes);
        }
    }

    public ModelProfile(Icon icon) {
        this.icon = icon;
    }

    private Icon icon;
    private File path;
}
