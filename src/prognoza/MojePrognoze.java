package prognoza;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.XMLGregorianCalendar;

public class MojePrognoze {
	private ObjectFactory objectFactory;
	private Prognoze prognoze;
	
	MojePrognoze() {
	 this.objectFactory = new ObjectFactory();
	 this.prognoze = objectFactory.createPrognoze();
	}
	
	void make(XMLGregorianCalendar dohvacena, String dan, XMLGregorianCalendar vrijeme) {
		Prognoze.Prognoza prognoza = new Prognoze.Prognoza();
		prognoza.setDohvacena(dohvacena);
		Prognoze.Prognoza.Datum datum = new Prognoze.Prognoza.Datum();
		datum.setDan(dan);
		datum.setVrijeme(vrijeme);
		prognoza.setDatum(datum);
		this.prognoze.getPrognoza().add(prognoza);
	}
	
	void marshal() {
		try {
			JAXBContext jc = JAXBContext.newInstance(ObjectFactory.class.getPackage().getName(), ObjectFactory.class.getClassLoader());
			Marshaller m = jc.createMarshaller();
			m.marshal(this.prognoze, System.out );
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}