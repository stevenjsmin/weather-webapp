package pactera.uitl.html;

/**
 * Option elements for Dropbox that used by HTML Utils
 *
 * @author steven.min
 *
 */
public class Option {
    private String value;
    private String name;
    private boolean isSelected = false;

    public Option() {
    }

    public Option(String value) {
        this.value = value;
        this.name = value;
    }

    public Option(String value, String name) {
        this.value = value;
        this.name = name;
    }

    public Option(String value, String name, boolean isSelected) {
        this.value = value;
        this.name = name;
        this.isSelected = isSelected;
    }

    public Option(int value, String name, boolean isSelected) {
        this.value = Integer.toString(value);
        this.name = name;
        this.isSelected = isSelected;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

}
