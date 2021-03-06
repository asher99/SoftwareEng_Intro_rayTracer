package unitTests;

import elements.Camera;
import org.junit.Test;
import primitives.*;
import scene.Scene;

import java.lang.Math.*;

import static org.junit.Assert.*;

public class CameraTest {

    @Test
    public void throughPixel() {

        /*
        Test 1: camera on origin, set on X axis where "up" is Z axis.
        the view plane is 3X3, and we check the left pixel in the upper line.
        we set the size of the pixels and the view plane distance values in a way the ray direction is (1,1,1).
        we have the result as unit vector.
         */

        Scene scene1 = new Scene("first test scene");
        scene1.setCameraScreenDistance(2);

        Point3D cameraPosition = new Point3D(0, 0, 0);
        Vector up = new Vector(0, 0, 1);
        Vector to = new Vector(1, 0, 0);
        scene1.setSceneCamera(new Camera(cameraPosition, up, to));
        Ray myRay = scene1.getSceneCamera().ConstractRaythroughPixel(3, 3, 3, 1, scene1.getCameraScreenDistance(), 6, 6);

        System.out.println(myRay);
        Point3D a = new Point3D(0, 0, 0);
        double sqrtOf3 = Math.sqrt(3);
        Vector vec = new Vector(sqrtOf3 / 3, sqrtOf3 / 3, sqrtOf3 / 3);
        Ray myTestRay = new Ray(a, vec);
        System.out.println(myTestRay);
        assertTrue(myRay.equals(myTestRay));

        // second test for even number
        Scene scene2 = new Scene("second test scene");
        scene2.setCameraScreenDistance(10);

        Point3D cameraPosition2 = new Point3D(7, 1, -3);
        Vector up2 = new Vector(6, 0, 3);
        Vector to2 = new Vector(1, 2, -2);
        scene2.setSceneCamera(new Camera(cameraPosition2, up2, to2));
        Ray myRay2 = scene2.getSceneCamera().ConstractRaythroughPixel(40, 40, 8, 39, scene2.getCameraScreenDistance(), 12, 12);

        System.out.println(myRay2);
        Point3D b = new Point3D(7, 1, -3);
        Vector vec2 = new Vector(-0.04259754999708888, 0.3216671361046757, -0.9458941284755191);
        Ray myTestRay2 = new Ray(b, vec2);


        assertTrue(myRay2.equals(myTestRay2));

    }


    @Test
    public void CenterOfPixel() {
        // test 1: general final test.
        Scene scene1 = new Scene("first scene test");

        int Nx = 40;
        int Ny = 40;
        int i = 8;
        int j = 39;
        double pixelHeight = 12.0 / Nx;
        double pixelWidth = 12.0 / Nx;
        Point3D cameraPosition2 = new Point3D(7, 1, -3);
        Vector up2 = new Vector(6, 0, 3);
        Vector to2 = new Vector(1, 2, -2);
        scene1.setSceneCamera(new Camera(cameraPosition2, up2, to2));

        Point3D pointCenter = new Point3D(17, 21, -23);
        Point3D temp = scene1.getSceneCamera().centerOfPixel(i, j, Nx, Ny, pixelHeight, pixelWidth, pointCenter);
        Point3D myPoint = new Point3D(13.153963078700363, 18.204915028125264, -27.718103432524558);
        assertTrue(myPoint.equals(temp));
        System.out.println(temp);

        // test 2 for odd numbers.
        Scene scene2 = new Scene("second scene test");
        scene2.setSceneCamera(new Camera(new Point3D(0, 0, 0), new Vector(0, 0, 1), new Vector(1, 0, 0)));
        Point3D output = scene2.getSceneCamera().centerOfPixel(1, 1, 3, 3, 2, 2, new Point3D(2, 0, 0));
        Point3D expected = new Point3D(2, -2, 2);
        assertTrue(output.equals(expected));
        System.out.println(output);

        //test 3 for even numbers.
        Scene scene3 = new Scene("third scene test");
        scene3.setSceneCamera(new Camera(new Point3D(0, 0, 0), new Vector(0, 0, 1), new Vector(1, 0, 0)));
        Point3D output2 = scene3.getSceneCamera().centerOfPixel(1, 1, 2, 2, 2, 2, new Point3D(2, 0, 0));
        Point3D expected2 = new Point3D(2, -1, 1);
        assertTrue(output2.equals(expected2));
        System.out.println(output2);


    }

    // i tested the method and it works. here i built calculator.
    @Test
    public void throughPixelCalculator() {

        Point3D cameraPosition = new Point3D(0, 0, 0);
        Vector up = new Vector(0, 0, 1);
        Vector to = new Vector(1, 0, 0);
        Camera myCamera = new Camera(cameraPosition, up, to);
        Ray myRay = myCamera.ConstractRaythroughPixel(11, 3, 6, 1, 4, 6, 11);

        System.out.println(myRay);
    }


}