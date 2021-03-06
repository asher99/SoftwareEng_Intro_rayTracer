package geometries;

import primitives.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * class RadialGeometry for Shapes identified by a radius.
 */
public abstract class RadialGeometry extends Geometry {

    protected double _radius;

    // ***************** Constructors ********************** //

    /**
     * default Constructor
     */
    public RadialGeometry() {
        _radius = 0.0000;
    }

    /**
     * constructor
     *
     * @param myRadius
     * @param e
     * @param m
     */
    public RadialGeometry(double myRadius, Color e, Material m) {
        super(e,m);
        _radius = myRadius;
    }

    /**
     * constructor with no color uses the default color.
     *
     * @param myRadius
     */
    public RadialGeometry(double myRadius) {
        super();
        _radius = myRadius;
    }

    /**
     * "copy" constructor
     *
     * @param g
     */
    public RadialGeometry(final RadialGeometry g) {
        super(g.getEmission(),g.getMaterial());
        _radius = g._radius;
    }

    // ***************** Getters/Setters ********************** //

    /**
     * getter
     *
     * @return
     */
    public double get_radius() {

        return _radius;
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
     * override the "getNormal" with corresponding abstract method.
     *
     * @param somePoint
     * @return
     */
    @Override
    public abstract Vector getNormal(Point3D somePoint);

    /**
     * receive a Ray and return all the points that Ray intersevt with the Geometry.
     *
     * @param myRay
     * @return
     */
    public abstract Map<Geometry, List<Point3D>> findIntersections(Ray myRay);


}
