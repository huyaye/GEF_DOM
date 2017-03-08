

package simplemodelgef.xmleditor;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.palette.CreationToolEntry;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.ui.parts.GraphicalEditorWithFlyoutPalette;
import org.w3c.dom.Document;


public class DesignEditor extends GraphicalEditorWithFlyoutPalette {

    private Document doc;

    public DesignEditor() {
        setEditDomain(new DefaultEditDomain(this));
    }

    @Override
    public void doSave(IProgressMonitor arg0) {
        getEditDomain().getCommandStack().markSaveLocation();
    }

    @Override
    protected PaletteRoot getPaletteRoot() {
        PaletteRoot root = new PaletteRoot();

        PaletteGroup mainGroup = new PaletteGroup("UI Components");
        root.add(mainGroup);

        mainGroup.add(new CreationToolEntry("Component", "Add component", new ObjectCreationFactory(this.doc), null, null));

        return root;
    }

    @Override
    protected void configureGraphicalViewer() {
        super.configureGraphicalViewer();

        getGraphicalViewer().setEditPartFactory(new ObjectEditPartFactory());
    }

    public void setContents(Document doc) {
        this.doc = doc;
        getGraphicalViewer().setContents(doc.getDocumentElement());
    }

}
