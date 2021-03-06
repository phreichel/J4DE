//*************************************************************************************************
package j4de.cfg;
//*************************************************************************************************

//*************************************************************************************************
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
//*************************************************************************************************

//*************************************************************************************************
@XmlRootElement
public class Sequence {

	//==============================================================================================
	private String       name   = null;
	private List<String> values = null;
	//==============================================================================================
	
	//==============================================================================================
	@XmlAttribute(required=true)
	public String getName() {
		return this.name;
	}
	//==============================================================================================

	//==============================================================================================
	public void setName(String name) {
		this.name = name;
	}
	//==============================================================================================

	//==============================================================================================
	@XmlElement(name="Value")
	public List<String> getValues() {
		return this.values;
	}
	//==============================================================================================

	//==============================================================================================
	public void setValues(List<String> values) {
		this.values = values;
	}
	//==============================================================================================
	
}
//*************************************************************************************************
