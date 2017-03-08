

package simplemodelgef.xmleditor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.w3c.dom.Element;
import org.w3c.dom.Node;


public class ObjectEditPart extends AbstractGraphicalEditPart {

    private Random rand = new Random();

    @Override
    protected IFigure createFigure() {
        return new ObjectFigure();
    }

    @Override
    protected void createEditPolicies() {
        installEditPolicy(EditPolicy.LAYOUT_ROLE, new EditLayoutPolicy());
    }

    protected void refreshVisuals() {
        ObjectFigure figure = (ObjectFigure) getFigure();
        Element element = (Element) getModel();
        figure.getLabel().setText(element.getTagName());
        figure.setLayout(new Rectangle(rand.nextInt(100), rand.nextInt(100), 250, 150));
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
