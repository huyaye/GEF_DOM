

package simplemodelgef.xmleditor;

import org.eclipse.gef.requests.CreationFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


public class ObjectCreationFactory implements CreationFactory {

    private Document doc;

    public ObjectCreationFactory(Document doc) {
        this.doc = doc;
    }

    @Override
    public Object getNewObject() {
        return doc.createElement("newElement");
    }

    @Override
    public Object getObjectType() {
        return Element.class;
    }

}
