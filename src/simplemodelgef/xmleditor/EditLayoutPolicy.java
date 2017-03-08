

package simplemodelgef.xmleditor;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gef.requests.CreateRequest;


public class EditLayoutPolicy extends XYLayoutEditPolicy {

    @Override
    protected Command getCreateCommand(CreateRequest arg0) {
        return null;
    }

    @Override
    protected Command createChangeConstraintCommand(EditPart child, Object constraint) {
        ObjectChangeLayoutCommand command = null;
        if (child instanceof ObjectEditPart) {
            command = new ObjectChangeLayoutCommand();
            command.setFigure(((ObjectEditPart) child).getFigure());
            command.setConstraint((Rectangle) constraint);
        }

        return command;
    }

}
