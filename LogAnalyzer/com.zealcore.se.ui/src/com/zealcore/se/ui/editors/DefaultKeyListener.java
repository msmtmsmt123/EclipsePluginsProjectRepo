/*
 * 
 */
package com.zealcore.se.ui.editors;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.widgets.Composite;

import com.zealcore.se.ui.ITimeCluster;

/**
 * The default implementation for receiving key events. The class that is
 * interested in processing a default key event subclasses this class, and the
 * object created with that class is registered with a component using the
 * component's <code>addKeyListener<code> method.
 * 
 * The default implementation for views is using the arrows to navigate.
 * LEFT/RIGHT = BACK/FORWARD
 * +/- = ZOOM-IN/OUT
 * 
 * 
 * @see KeyEvent
 */
final class DefaultKeyListener<T extends IZoomable & IStepable> extends
        KeyAdapter {

    private final T view;

    private final Composite owner;

    private DefaultKeyListener(final T view, final Composite owner) {
        this.view = view;
        this.owner = owner;

    }

    @SuppressWarnings("unchecked")
    public static <T extends IZoomable & IStepable> DefaultKeyListener valueOf(
            final T view, final Composite owner) {
        return new DefaultKeyListener(view, owner);
    }

    @Override
    public void keyPressed(final KeyEvent e) {

        if (!this.owner.isFocusControl()) {
            return;
        }

        if (e.keyCode == SWT.ARROW_RIGHT) {
            this.view.stepForward();
        }
        if (e.keyCode == SWT.ARROW_LEFT) {
            this.view.stepBack();
        }

        if (e.character == '+'||
        		(e.stateMask == SWT.NONE && e.keyCode == 122)) {
            this.view.zoomIn();
        }
        if (e.character == '-'||
        		(e.stateMask == SWT.SHIFT && e.keyCode == 122)) {
            this.view.zoomOut();
        }

        if (this.view instanceof ILogsetBrowser) {
            final ILogsetBrowser vsv = (ILogsetBrowser) this.view;
            final ITimeCluster viewset = vsv.getInput().getTimeCluster();
            if (e.keyCode == SWT.HOME) {
                viewset.setCurrentTime(viewset.getMin());
            } else if (e.keyCode == SWT.END) {
                viewset.setCurrentTime(viewset.getMax());
            }
        }
        super.keyPressed(e);
    }
}
