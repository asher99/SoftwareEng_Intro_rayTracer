package geometries;

import primitives.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * class Geometry for geometrial shapes.
 */
public abstract class Geometry {


    //represent Geometry color
    public Color emmission;

    // ***************** Constructors ********************** //
    //default constructor
    public Geometry(){};

    // copy constructor
    public Geometry(final Geometry g){};

    // ***************** Operations ******************** //
    // return the normal to a shape
    protected Vector getNormal(Point3D somePoint){
        return null;
    }

    // receive a Ray and return all the points that Ray intersevt with the Geometry.
    public abstract List<Point3D> findIntersections(Ray myRay);
}
