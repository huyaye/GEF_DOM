

package simplemodelgef.xmleditor;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.w3c.dom.Element;


public class ObjectEditPartFactory implements EditPartFactory {

    @Override
    public EditPart createEditPart(EditPart context, Object model) {
        EditPart part = null;

        if (model instanceof Element) {
            if (((Element) model).getTagName().equals("document")) {
                part = new DocumentEditPart();
            } else {
                part = new ObjectEditPart();
            }
        }

        if (part != null) {
            part.setModel(model);
        }

        return part;
    }

}
