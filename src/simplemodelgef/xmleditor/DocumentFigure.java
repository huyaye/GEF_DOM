

package simplemodelgef.xmleditor;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Rectangle;


public class DocumentFigure extends Figure {
    private XYLayout layout;
    private Label labelName = new Label();

    public DocumentFigure() {
        super();

        layout = new XYLayout();
        setLayoutManager(layout);

        labelName.setForegroundColor(ColorConstants.blue);
        add(labelName);
        labelName.setText("Document");
        setConstraint(labelName, new Rectangle(5, 5, -1, -1));

        setForegroundColor(ColorConstants.black);
        setBorder(new LineBorder(5));
    }

    public void setLayout(Rectangle rect) {
        setBounds(rect);
    }

}
