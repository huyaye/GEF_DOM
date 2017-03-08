

package simplemodelgef.xmleditor;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;


public class ObjectChangeLayoutCommand extends Command {

    private IFigure figure;
    private Rectangle layout;

    @Override
    public void execute() {
        ((ObjectFigure) figure).setLayout(layout);
    }

    public void setFigure(IFigure figure) {
        this.figure = figure;
    }

    public void setConstraint(Rectangle layout) {
        this.layout = layout;
    }
}
