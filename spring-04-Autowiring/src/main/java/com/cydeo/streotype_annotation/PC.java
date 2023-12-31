package com.cydeo.streotype_annotation;

import com.cydeo.streotype_annotation.casefactory.Case;
import com.cydeo.streotype_annotation.monitorfactory.Monitor;
import com.cydeo.streotype_annotation.motherboardfactory.Motherboard;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Getter
@Component
//*****when we create a single const, we don't have to annotate with the autowired, even when we use
    //@allargsconstructor
public class PC {
    //@Autowired - making the DI by field annotation
    private Case theCase;
    //@Autowired
    private Monitor monitor;
    //@Autowired
    private Motherboard motherboard;


    //@Autowired this is constructor injection, then the field injection not needed
    public PC(Case theCase, Monitor monitor, Motherboard motherboard) {
        this.theCase = theCase;
        this.monitor = monitor;
        this.motherboard = motherboard;
    }

    public void powerUp() {
        theCase.pressPowerButton();
        drawLogo();
    }

    private void drawLogo() {
        // Fancy graphics
        monitor.drawPixelAt();
    }

}
