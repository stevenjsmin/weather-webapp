package pactera.uitl.html;

/**
 *  Properties for html element
 *
 * @author steven.min
 *
 */
public class Properties {
	private String id;
	private String name;
	private String cssStyle;
	private String cssClass;
	private String onchange;
	private String onclick;
	private boolean multipleSelect;

	public Properties() {
	}

	public Properties(String id) {
		this.id = id;
		this.name = id;
	}

	public Properties(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCssStyle() {
		return cssStyle;
	}

	public void setCssStyle(String cssStyle) {
		this.cssStyle = cssStyle;
	}

	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

	public String getOnchange() {
		return onchange;
	}

	public void setOnchange(String onchange) {
		this.onchange = onchange;
	}

	public String getOnclick() {
		return onclick;
	}

	public void setOnclick(String onclick) {
		this.onclick = onclick;
	}

	public boolean isMultipleSelect() {
		return multipleSelect;
	}

	public void setMultipleSelect(boolean multipleSelect) {
		this.multipleSelect = multipleSelect;
	}

}
