

package simplemodelgef.xmleditor;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.MultiPageEditorPart;
import org.w3c.dom.Document;


public class LayoutEditor extends MultiPageEditorPart {

    private DesignEditor designEditor;
    private TextEditor textEditor;

    @Override
    protected void createPages() {
        IEditorInput editorInput = getEditorInput();
        if (editorInput == null) {
            System.out.println("EditorInput is null");
            return;
        }

        setPartName(editorInput.getName());

        try {
            this.designEditor = new DesignEditor();
            addPage(0, this.designEditor, editorInput);
            setPageText(0, "Design");

            this.textEditor = new TextEditor();
            addPage(1, this.textEditor, editorInput);
            setPageText(1, "Source");

            Document doc = this.textEditor.getDomModel().getDocument();
            Document ownerDocument = doc.getFirstChild().getOwnerDocument();
            this.designEditor.setContents(ownerDocument);
        } catch (PartInitException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doSave(IProgressMonitor arg0) {
        this.textEditor.doSave(arg0);
        this.designEditor.doSave(arg0);
    }

    @Override
    public void doSaveAs() {
        this.textEditor.doSaveAs();
        this.designEditor.doSaveAs();
    }

    @Override
    public boolean isSaveAsAllowed() {
        return true;
    }

}
