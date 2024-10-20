package dev.ikm.layout;

import javafx.collections.ObservableMap;
import javafx.geometry.*;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

/**
 * KometPlugin is an interface enabling service discovery and providing methods
 * to enable layout and configuration of user interacting plugins that extend the
 * JavaFx Scene Graph Node.
 */
public interface KometPlugin {
    default <SGN extends Node> SGN sceneGraphNode() {
        return (SGN) this;
    };

    default ObservableMap<Object, Object> properties() {
        return sceneGraphNode().getProperties();
    }
    
    /**
     * Sets the column index for the pane in the GridPane layout.
     *
     * @param columnIndex the column index to set for the pane
     */
    default void setColumnIndex(int columnIndex) {
        GridPane.setColumnIndex(sceneGraphNode(), columnIndex);
    }

    /**
     * Retrieves the column index for this pane in the GridPane layout.
     *
     * @return the column index of the pane
     */
    default int getColumnIndex() {
        return GridPane.getColumnIndex(sceneGraphNode());
    }

    /**
     * Sets the row index for the pane in the GridPane layout.
     *
     * @param rowIndex the row index to set for the pane
     */
    default void setRowIndex(int rowIndex) {
        GridPane.setRowIndex(sceneGraphNode(), rowIndex);
    }

    /**
     * Retrieves the row index for this pane in the GridPane layout.
     *
     * @return the row index of the pane
     */
    default int getRowIndex() {
        return GridPane.getRowIndex(sceneGraphNode());
    }

    /**
     * Sets the column span for the pane in the GridPane layout.
     *
     * @param colspan the number of columns the pane should span
     */
    default void setColspan(int colspan) {
        GridPane.setColumnSpan(sceneGraphNode(), colspan);
    }

    /**
     * Retrieves the column span for the pane in the GridPane layout.
     *
     * @return the number of columns the pane spans
     */
    default int getColspan() {
        return GridPane.getColumnSpan(sceneGraphNode());
    }

    /**
     * Sets the row span for the pane in the GridPane layout.
     *
     * @param rowspan the number of rows the pane should span
     */
    default void setRowspan(int rowspan) {
        GridPane.setRowSpan(sceneGraphNode(), rowspan);
    }

    /**
     * Retrieves the row span for the pane in the GridPane layout.
     *
     * @return the number of rows the pane spans
     */
    default int getRowspan() {
        return GridPane.getRowSpan(sceneGraphNode());
    }

    /**
     * Sets the horizontal grow priority for the pane in the GridPane layout.
     *
     * @param priority the horizontal grow priority to set for the pane
     */
    default void setHgrow(Priority priority) {
        GridPane.setHgrow(sceneGraphNode(), priority);
    }

    /**
     * Retrieves the horizontal grow priority for the pane in the GridPane layout.
     *
     * @return the horizontal grow priority of the pane
     */
    default Priority getHgrow() {
        return GridPane.getHgrow(sceneGraphNode());
    }

    /**
     * Sets the vertical grow priority for the pane in the GridPane layout.
     *
     * @param priority the vertical grow priority to set for the pane
     */
    default void setVgrow(Priority priority) {
        GridPane.setVgrow(sceneGraphNode(), priority);
    }

    /**
     * Retrieves the vertical grow priority for the pane in the GridPane layout.
     *
     * @return the vertical grow priority of the pane
     */
    default Priority getVgrow() {
        return GridPane.getVgrow(sceneGraphNode());
    }
    
    /**
     * Sets the alignment for the pane in the GridPane layout.
     *
     * @param alignment the positional alignment to set for the pane
     */
    default void setAlignment(Pos alignment) {
        GridPane.setHalignment(sceneGraphNode(), HPos.valueOf(alignment.name()));
        GridPane.setValignment(sceneGraphNode(), VPos.valueOf(alignment.name()));
    }

    /**
     * Retrieves the alignment of the pane within the GridPane layout.
     *
     * This method checks the horizontal and vertical alignment settings of the
     * pane. If both the horizontal and vertical alignments are not null and
     * they have the same name, the method returns the corresponding {@code Pos}
     * value.
     *
     * @return the positional alignment of the pane, or null if the alignments are not set or they differ
     */
    default Pos getAlignment() {
        HPos halignment = GridPane.getHalignment(sceneGraphNode());
        VPos valignment = GridPane.getValignment(sceneGraphNode());

        if (halignment != null && valignment != null && halignment.name().equals(valignment.name())) {
            return Pos.valueOf(halignment.name());
        }
        return null;
    }
    
    /**
     * Sets the content bias for the pane within the GridPane layout.
     *
     * @param contentBias the orientation bias to set for the content
     */
    default void setContentBias(Orientation contentBias) {
        GridPane.setHalignment(sceneGraphNode(), contentBias == Orientation.HORIZONTAL ? HPos.CENTER : HPos.LEFT);
        GridPane.setValignment(sceneGraphNode(), contentBias == Orientation.VERTICAL ? VPos.CENTER : VPos.TOP);
    }

    /**
     * Determines the bias of the content based on the alignment settings within the GridPane layout.
     *
     * If the horizontal alignment is CENTER and the vertical alignment is not CENTER,
     * the method returns HORIZONTAL orientation. If the vertical alignment is CENTER
     * and the horizontal alignment is not CENTER, the method returns VERTICAL orientation.
     *
     * @return the content bias as an Orientation (HORIZONTAL, VERTICAL), or null if neither condition is met.
     */
    default Orientation getContentBias() {
        HPos halignment = GridPane.getHalignment(sceneGraphNode());
        VPos valignment = GridPane.getValignment(sceneGraphNode());

        if (halignment == HPos.CENTER && valignment != VPos.CENTER) {
            return Orientation.HORIZONTAL;
        } else if (valignment == VPos.CENTER && halignment != HPos.CENTER) {
            return Orientation.VERTICAL;
        }
        return null;
    }

    /**
     * Sets the insets (margins) for the pane in the GridPane layout.
     *
     * @param top the amount of space to be applied to the top of the pane
     * @param right the amount of space to be applied to the right of the pane
     * @param bottom the amount of space to be applied to the bottom of the pane
     * @param left the amount of space to be applied to the left of the pane
     */
    default void setInsets(double top, double right, double bottom, double left) {
        setInsets(new Insets(top, right, bottom, left));
    }

    /**
     * Sets the insets (margins) for the pane in the GridPane layout.
     *
     * @param insets the Insets object containing the top, right, bottom, and left margins
     */
    default void setInsets(Insets insets) {
        GridPane.setMargin(sceneGraphNode(), insets);
    }

    /**
     * Retrieves the insets (margins) for the pane in the GridPane layout.
     *
     * The insets determine the amount of space to be applied around the pane.
     *
     * @return the Insets object containing the top, right, bottom, and left margins of the pane
     */
    default Insets getInsets() {
        return GridPane.getMargin(sceneGraphNode());
    }
}
