/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package christmaskinect;

/**
 *
 * @author vandersonmr
 */
import SimpleOpenNI.*;
import java.util.ArrayList;
import java.util.LinkedList;
import processing.core.*;

public class ChristmasKinect extends PApplet {

    public SimpleOpenNI context;
    ArrayList<PVector> flocos = new ArrayList<>();

    @Override
    public void setup() {
        // context = new SimpleOpenNI(this);

        context = new SimpleOpenNI(this, SimpleOpenNI.RUN_MODE_MULTI_THREADED);

        // enable depthMap generation 
        context.enableScene();
        context.enableDepth();
        context.enableRGB();
        context.enableUser(1);


        background(200, 0, 0);

        stroke(0, 0, 255);
        strokeWeight(3);
        smooth();

        size(context.sceneWidth(), context.sceneHeight());

        for (int i = 0; i < 1000; i++) {
            PVector novoFloco = new PVector((float) (context.sceneWidth() * Math.random()), (float) (-100 * Math.random() - 100 * Math.random()));
            flocos.add(i, novoFloco);
        }
        
        

        // select the recording channels
        //context.addNodeToRecording(SimpleOpenNI.NODE_DEPTH,
        //        SimpleOpenNI.CODEC_16Z_EMB_TABLES);
        //context.addNodeToRecording(SimpleOpenNI.NODE_IMAGE,
        //        SimpleOpenNI.CODEC_JPEG);
    }

    @Override
    public void draw() {

        context.update();
        image(context.rgbImage(), 0, 0);
        noStroke();
        for (int i = 0; i < 1000; i++) {
            ellipse(flocos.get(i).x, flocos.get(i).y, 5, 5);


            if (flocos.get(i).y > context.sceneHeight()) {
                flocos.get(i).y = (float) (-150 * Math.random());
                flocos.get(i).x = (float) (context.sceneWidth() * Math.random());
            }


            int c = context.sceneImage().get((int) flocos.get(i).x, (int) flocos.get(i).y);
            if (c == 0 || c == -16777216) {
                flocos.get(i).y += 1 + Math.random() * 5;
            }



        }

    }
}