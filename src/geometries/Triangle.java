package geometries;

import primitives.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * class Triangle for triangle in space.
 * the triangle is represnted by three points in space.
 */
public class Triangle extends Plane {

    private Point3D a;
    private Point3D b;
    private Point3D c;

    // ***************** Constructors ********************** //

    /**
     * constructor with three points and color
     *
     * @param myA
     * @param myB
     * @param myC
     * @param e
     * @param m
     */
    public Triangle(Point3D myA, Point3D myB, Point3D myC, Color e, Material m) {
        super(myA, myB, myC, e, m);
        a = myA;
        b = myB;
        c = myC;

    }

    /**
     * constructor with no color gives the default color
     *
     * @param myA
     * @param myB
     * @param myC
     */
    public Triangle(Point3D myA, Point3D myB, Point3D myC) {
        super(myA, myB, myC);
        a = myA;
        b = myB;
        c = myC;

    }
    // ***************** Getters/Setters ********************** //

    /**
     * getter
     *
     * @return
     */
    public Point3D getA() {
        return a;
    }

    /**
     * getter
     *
     * @return
     */
    public Point3D getB() {
        return b;
    }

    /**
     * getter
     *
     * @return
     */
    public Point3D getC() {
        return c;
    }

    /**
     * getter
     *
     * @return
     */
    public Color getEmission() {
        return super.getEmission();
    }

    // ***************** Operations ******************** //

    /**
     * return the parent Plane normal
     *
     * @param somePoint
     * @return
     */
    @Override
    public Vector getNormal(Point3D somePoint) {
        return super.getNormal(somePoint);
    }


    /**
     * check if a Triangle object is equal to this one.
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof Triangle) || obj == null)
            return false;

        // checks if all points in both triangles are equal in every possible combination
        return (a.equals(((Triangle) obj).a) && b.equals(((Triangle) obj).b) && c.equals(((Triangle) obj).c)) ||
                (a.equals(((Triangle) obj).a) && b.equals(((Triangle) obj).c) && c.equals(((Triangle) obj).b)) ||
                (a.equals(((Triangle) obj).b) && b.equals(((Triangle) obj).c) && c.equals(((Triangle) obj).a)) ||
                (a.equals(((Triangle) obj).b) && b.equals(((Triangle) obj).a) && c.equals(((Triangle) obj).c)) ||
                (a.equals(((Triangle) obj).c) && b.equals(((Triangle) obj).b) && c.equals(((Triangle) obj).a)) ||
                (a.equals(((Triangle) obj).c) && b.equals(((Triangle) obj).a) && c.equals(((Triangle) obj).b));
    }

    /**
     * toString
     *
     * @return
     */
    @Override
    public String toString() {
        return a.toString() + "," + b.toString() + "," + a.toString() + ",";
    }

    /**
     * @param myRay a ray that may intersect the Plane.
     * @return Map with the intersection point, if exist. the key is this Geometry.
     */
    @Override
    public Map<Geometry, List<Point3D>> findIntersections(Ray myRay) {

        // first, get the point where the Ray intersect with the Plane that include the Triangle.
        // we may had no point such that, so an exception is possible.
        try {
            Map<Geometry, List<Point3D>> superOutput = super.findIntersections(myRay);
            Point3D pointOnPlane = superOutput.get(this).get(0);

            // defined vectors from the point represnt the Ray to each one od the Triangle vertices.
            Vector V1 = new Vector(myRay.getPoint(), a);
            Vector V2 = new Vector(myRay.getPoint(), b);
            Vector V3 = new Vector(myRay.getPoint(), c);

            // now we can define three normals and create a virtual pyramid.
            Vector N1 = Vector.crossProduct(V1, V2);
            Vector N2 = Vector.crossProduct(V2, V3);
            Vector N3 = Vector.crossProduct(V3, V1);

            // to make sure the ray goes through the pyramid, we calculate the projection of the ray
            // on each normal to the pyramid we calculate before.
            // if all projections have the same sign (+/-) so we know the ray hit the Triangle!
            double projection1 = Vector.dotProduct(N1, new Vector(myRay.getPoint(), pointOnPlane));
            double projection2 = Vector.dotProduct(N2, new Vector(myRay.getPoint(), pointOnPlane));
            double projection3 = Vector.dotProduct(N3, new Vector(myRay.getPoint(), pointOnPlane));

            // time to determine where the ray pass:
            if (projection1 > 0 && projection2 > 0 && projection3 > 0 ||
                    projection1 < 0 && projection2 < 0 && projection3 < 0) {

                return superOutput;
            } else return null;

        } catch (NullPointerException e) {
            return null;
        }
    }

}
