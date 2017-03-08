

package simplemodelgef.xmleditor;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Rectangle;


public class ObjectFigure extends Figure {

    private Label label;

    public ObjectFigure() {
        super();

        setLayoutManager(new XYLayout());

        this.label = new Label();
        add(this.label);
        setConstraint(label, new Rectangle(5, 17, -1, -1));
        setForegroundColor(ColorConstants.black);
        setBorder(new LineBorder(1));
        setOpaque(true);
    }

    public void setLayout(Rectangle rect) {
        getParent().setConstraint(this, rect);
    }

    public Label getLabel() {
        return this.label;
    }

}
