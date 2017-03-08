

package simplemodelgef.xmleditor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.w3c.dom.Element;
import org.w3c.dom.Node;


public class DocumentEditPart extends AbstractGraphicalEditPart {
    private Random rand = new Random();

    @Override
    protected IFigure createFigure() {
        return new DocumentFigure();
    }

    @Override
    protected void createEditPolicies() {
        installEditPolicy(EditPolicy.LAYOUT_ROLE, new EditLayoutPolicy());
    }

    protected void refreshVisuals() {

    }

    @Override
    protected List getModelChildren() {
        Element model = (Element) getModel();

        List<Element> childList = new ArrayList<Element>();
        for (Node child = model.getFirstChild(); child != null; child = child.getNextSibling()) {
            if (child instanceof Element) {
                childList.add((Element) child);
            }
        }

        return childList;
    }

}
