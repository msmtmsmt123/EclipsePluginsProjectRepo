package com.ifx.dave.monitor.ui.controller;

import com.ifx.dave.monitor.ui.MainWindow;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ToggleButton;

/**
 * All the Action items are implemented
 * here which are coming below the LineCharts
 * @author Hazra
 *
 */
public class OscilloscopeControllerTab4 {

    public OscilloscopeControllerTab4() {
        executeRun_Stop();
    }

    private void executeRun_Stop() {
        final ToggleButton runToggleBtn = MainWindow.getController().getRuntoggle_tab4();
        final AnimationTimer timer = MainWindow.getController().getLineChartControllerTab4().getTimer_Tab4();
        runToggleBtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if(runToggleBtn.isSelected() && timer != null) {
                    // Toggle Button ON
                    timer.start();
                }else if(!runToggleBtn.isSelected() && timer != null) {
                    // Toggle Button OFF
                    timer.stop();
                }
            }
        });
    }
}
