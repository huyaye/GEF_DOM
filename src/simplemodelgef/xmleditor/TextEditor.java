

package simplemodelgef.xmleditor;

import org.eclipse.wst.sse.ui.StructuredTextEditor;
import org.eclipse.wst.xml.core.internal.provisional.document.IDOMModel;


public class TextEditor extends StructuredTextEditor {

    public IDOMModel getDomModel() {
        return (IDOMModel) getModel();
    }

}
