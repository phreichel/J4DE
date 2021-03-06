//*************************************************************************************************
package j4de.cfg;
//*************************************************************************************************


//*************************************************************************************************
import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
//*************************************************************************************************

//*************************************************************************************************
@XmlRootElement
public class Domain {

	//==============================================================================================
	private String         name       = null;
	private List<Property> properties = null;
	private List<Sequence> sequences  = null;
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
	@XmlElement(name="Property")
	public List<Property> getProperties() {
		return this.properties;
	}
	//==============================================================================================

	//==============================================================================================
	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}
	//==============================================================================================

	//==============================================================================================
	@XmlElement(name="Sequence")
	public List<Sequence> getSequences() {
		return this.sequences;
	}
	//==============================================================================================

	//==============================================================================================
	public void setSequences(List<Sequence> sequences) {
		this.sequences = sequences;
	}
	//==============================================================================================
	
}
//*************************************************************************************************
