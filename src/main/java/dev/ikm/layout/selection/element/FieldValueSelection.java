package dev.ikm.layout.selection.element;

import dev.ikm.layout.selection.SelectableIndexedElement;
import dev.ikm.layout.selection.SemanticVersionSelection;
import dev.ikm.tinkar.terms.ConceptFacade;

public record FieldValueSelection(int index, SemanticVersionSelection.FieldValue selection) implements SelectableIndexedElement {

    public ConceptFacade conceptForEnum() {
        return this.selection.conceptForEnum();
    }
}
