//*************************************************************************************************
package j4de.cfg;
//*************************************************************************************************

//*************************************************************************************************
import java.io.File;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.List;
import javax.xml.bind.JAXB;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
//*************************************************************************************************

//*************************************************************************************************
@XmlRootElement
public class Configuration {

	//==============================================================================================
	private List<Domain> domains = null;
	//==============================================================================================

	//==============================================================================================
	@XmlElement(name="Domain", nillable=false, required=false)
	public List<Domain> getDomains() {
		return this.domains;
	}
	//==============================================================================================
	
	//==============================================================================================
	public void setDomains(List<Domain> domains) {
		this.domains = domains;
	}
	//==============================================================================================

	//==============================================================================================
	public static Configuration read(URL source) {
		return JAXB.unmarshal(source, Configuration.class);
	}
	//==============================================================================================

	//==============================================================================================
	public static void main(String[] args) {
		try {
			File pwd = new File(".");
			URL base = pwd.toURI().toURL();
			Configuration cfg = read(new URL(base, "data/configuration.xml"));
			List<Domain> domains =  cfg.getDomains();
			if (domains != null) {
				for (Domain domain : domains) {
					System.out.println(domain.getName() + " {");
					List<Property> properties =  domain.getProperties();
					if (properties != null) {
						for (Property property : properties) {
							System.out.println("\t" + property.getName() + "=" + property.getValue());
						}
					}
					List<Sequence> sequences =  domain.getSequences();
					if (sequences != null) {
						for (Sequence sequence : sequences) {
							System.out.println("\t" + sequence.getName() + " [");
							List<String> values =  sequence.getValues();
							if (values != null) {
								for (String value : values) {
									System.out.println("\t\t" + value);
								}
							}
							System.out.println("\t]");
						}
					}
					System.out.println("}");
				}
			}
		}
		catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	//==============================================================================================
	
}
//*************************************************************************************************
