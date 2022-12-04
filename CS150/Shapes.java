package CS150;
public class Shapes {
   
    //TODO: circleArea
    // This method takes in a double representing the radius of a circle and returns the area of the circle
    // The area of a circle is pi*r^2
    public static double circleArea(double radius) {
        double area = Math.PI * Math.pow(radius, 2);
        return area;
    }

    
    //TODO: sphereVolume
    // This method takes in a double representing the radius of a sphere and returns the volume of the sphere
    // The volume of a sphere is 4/3*pi*r^3
    public static double sphereVolume(double radius) {
        double volume = (4.0/3.0) * Math.PI * Math.pow(radius, 3);
        return volume;
    }
    
    //TODO: triangleArea
    // This method takes in two doubles representing the base and height a triangle and returns the area of the triangle
    // The area of a triangle is 1/2*b*h
    public static double triangleArea(double base, double height) {
        double area = (1.0/2.0) * base * height;
        return area;
    }
    
    //TODO: pyramidVolume
    /*
     * This method is a public static method that returns a double. It is called pyramidVolume and has three parameters that are all doubles. The parameters represent the length, the width and the height.
        In the method you can simply return the equation: (length * width * height) / 3.
     */
    public static double pyramidVolume(double length, double width, double height) {
        double volume = (length * width * height) / 3;
        return volume;
    }

    
    //TODO: round
    // This method takes in a double and returns the double rounded to the nearest integer
    // For example, round(3.4) should return 3 and round(3.5) should return 4
    public static int round(double num) {
        int rounded = (int) Math.round(num);
        return rounded;
    }
 
    public static void main(String[] args) {
       System.out.println("Testing circleArea()");
       System.out.println(circleArea(2.3)); //should print 16.619025137490002
       System.out.println(circleArea(5)); // should print 78.53981633974483
       System.out.println(circleArea(7.8)); // should print 191.134497044403
       
       System.out.println("Testing sphereVolume()");
       System.out.println(sphereVolume(2.3)); //should print 50.965010421636
       System.out.println(sphereVolume(5)); // should print 523.5987755982989
       System.out.println(sphereVolume(7.8)); // should print 1987.798769261791
       
       System.out.println("Testing triangleArea()");
       System.out.println(triangleArea(2, 3)); //should print 3.0
       System.out.println(triangleArea(3.4, 8.7)); // should print 14.79
       System.out.println(triangleArea(3.0, 4.4)); // should print 6.6000000000000005
       
       System.out.println("Testing pyramidVolume()");
       System.out.println(pyramidVolume(2, 3, 4)); //should print 8.0
       System.out.println(pyramidVolume(3.4, 8.7, 2.1)); // should print 20.706
       System.out.println(pyramidVolume(3.0, 4.4, 2)); // should print 8.8
       
       System.out.println("Testing round()");
       System.out.println(round(2.3)); //should print 2
       System.out.println(round(7.8)); // should print 8
       System.out.println(round(6.0)); // should print 6
    }
    
 }