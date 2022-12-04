package CS150;

/**
 * <h1>  Traveling Alchemist the Almost MUD </h1>
 *
 *      In this assignment, we focus heavily on string and text manipulation. This is based on the old
 *      <a href="https://en.wikipedia.org/wiki/MUD">MUDs</a>
 *      or <u>M</u>uli - <u>U</u>ser <u>D</u>ungeons, which are some of the first examples of
 *      virtual worlds <a href="https://en.wikipedia.org/wiki/Online_text-based_role-playing_game">online</a>.
 *      This example also includes GIS positioning data (latitude and longitude)
 *      and a formula used to calculate distances in GIS applications. As such, through the game
 *      we are learning about GIS and also some of the first MMORPGs around.
 *
 *      <h2>What You'll Learn</h2>
 *      <ul>
 *          <li>String functions</li>
 *          <li>String concatenation</li>
 *          <li>Program flow control</li>
 *          <li>Pattern Matching</li>
 *      </ul>
 *
 *     <h2>How to win?</h2>
 *     This "game" is very limited due to the scope of the assignment. You are only writing the helper functions to it,
 *     but a fun way to challenge yourself will be to see if you can find a path to visit all the cities in the
 *     least amount of time possible. This is a well known problem in computer science, that we will talk about in class.
 *
 *     Why are you visiting the cities? To sell them your love potion #9 of course! or whatever reason you can think about.
 *     MUDs were often very open in their feel depending on how people played them.
 *
 * @author YOURNAME <br>
 *         YOUREMAIL <br>
 *         Computer Science Department <br>
 *         Colorado State University
 * @version 201990
 */


 /*
  * Step 1 - getCityInfo
For getCityInfo, you will be pulling a substring from a much larger String. The String may change, but in general, the format is

Fort Collins,40°35'6.9288"N,105°5'3.9084"W;Denver,39°44'31.3548"N,104°59'29.5116"W;Boulder,40°0'53.9424"N,105°16'13.9656"W
That looks complicated, but what we are really looking at the semi-colons. If we ignore the complexity, the String could simply look like:

SomeCity;AnotherCity;YetAnotherCity
This second String is easier to think about. The goal of getCityInfo is to take in the String of the city we are looking for - basically the first part of the city string, the list of cities, and the deliminator (which will be a semi-colon ; in the above case).

As such, if someone is looking for

fort
then

Fort Collins,40°35'6.9288"N,105°5'3.9084"W
is returned (notice, no semi-colon).

Let’s get started!

Writing getCityInfo
You have three parameters, the cityList, destination, and the deliminator. The method signature is already done for you, so best to find it in the code below. Also know that given a String, you can take its substring, and you can also search for the indexOf a certain character, which is essential for writing this.

First when writing this method, know we want it to be case-insensitive. While the choice is yours, we found .toLowerCase() to be useful (which is a String method) - as it forced the city name in cityList to be lowercase.

Understanding destination - this is the ‘start’ location of the substring. As such:
  int start = cityListLower.indexOf(destinationLower); 
will give you the starting index of the city name, assuming you have created a lowercase version of both cityList and destination.

The end index is trickier. .indexOf(String, int) will search for the index of the String starting at location int. This could be extremely useful in helping you find the deliminator after the start location! However, what if the city is the last one in the list? Notice there is no deliminator after the last city!

Taking both the start and end index, return the substring. Reminder that substrings the end index is exclusive so the end index provided will not be included in the substring.
HINT to make this method go easier, put in println’s throughout the method as you figure out the indices. It also helps to write down a String, and the write the index locations under the string, so you can see the relationships.

Testing getCityInfo
If you go to the testMethod in the file, you will see an example of how to test getCityInfo. Uncomment it. I would also put in other options searching for denver to test what you wrote with different input.

It is important to note that the cityInfo line can change: cities may not be there, the order of the cities may change, and new ones can be added.

Step 2 - getCityName
getCityName takes in a cityData String that consists of the format:

Fort Collins,40°35'6.9288"N,105°5'3.9084"W


<name>,<latitude>,<longitude>
And returns just the name portion of the String.



Does this look familiar? Look at what the last method you wrote returned. Since this format will be exactly the same for every cityData that is passed in, you can use substring, and index of to get the portion from the String.

Testing getCityName
Writing getCityName
This method returns a substring of the cityData from 0 to the indexOf of the deliminator that is passed into the method. You can do this method in one or three lines.

Testing getCityName
You will see a sample in testMethod that you need to uncomment. Feel free to try with other cityData info.

Step 3 - getCityLongitude
getCityLongitude takes in a cityData String that consists of the format:

<name>,<latitude>,<longitude>
and returns just the longitude portion of the String. In this case, you are returning from the deliminator to the end of the String. It is important to note that substring with one parameter takes from that location to the end of the line!

So String str = “hello world”; str.substring(5) returns world.

Writing getCityLongitude
Return the substring of the cityData from the .lastIndexOf() of the deliminator to the end of the String.

Testing getCityLongitude
You will see a sample in testMethod that you need to uncomment. Feel free to try with other cityData info.

Step 4 - getCityLatitude
getCityLongitude takes in a cityData String that consists of the format:

<name>,<latitude>,<longitude>
and returns just the latitude portion of the String.

This is harder as you are grabbing the middle of the String. However, reading what you did in getCityName, you know how to get the first indexOf the deliminator and the lastIndexOf the deliminator from reading getLongitude. Take those two ideas to figure out the range of your substring.

Writing getCityLatitude
Return the substring of the cityData from the indexOf of the deliminator to the to the lastIndexOf the deliminator. You will need to think of you OB1 errors on the first index since you do not want to include the deliminator in the substring. Think, do you want that location, or do you want that location+1?

Testing getCityLongitude
You will see a sample in testMethod that you need to uncomment. Feel free to try with other cityData info.

Step 5 - convertDegreesToDecimals
For convertDegreesToDecimals, you need to combine all the skills you practiced above. You are given a degree based coordinate. For example:

40°35'6.9288"N
You will know that has a set pattern to it. And you can use the DEGREE, MINUTE, SECOND constants at the top - to help figure out the splits in the pattern. It is safe to assume all degrees will be given in that format. Using the format to your advantage, you will calculate the decimal value of the coordinate which in the above examples case is:

40.585258
This is figured out by the following formula:

degree value + (minute value / 60) + (second value / 3600)  * 1 or -1 depending on direction
For example: 105°5’3.9084”W would be 105 + (5 / 60) + (3.9084/ 3600) and then you would multiply it by -1 to make it the negative coordinate.

Note that ‘S’ and ‘W’ are both the negative coordinates when looking at latitude and longitude.

Writing convertDegreesToDecimals
First split up the String into the different parts. Hint, I would print out the parts just to see if you split it correctly.
Convert each part to the double value by using Double.parseValue(String) where String changes based on what you are looking at. For example:
    String degree = strValue.substring(0, strValue.indexOf(DEGREE));
    double deg = Double.parseDouble(degree);
You will need to now do the following for seconds and minutes
Use the formula above to figure out the overall decimal value.
Look at the last character and if it is West or South you need to make it a negative value. If negative, multiple the result from the above formula by -1.
return the final value.
Testing getCityLongitude
You will see a sample in testMethod that you need to uncomment. Feel free to try with other coordinates.
  */
public class AlchemistHelper {
    public static final int EARTH_RADIUS  = 3961;  //radius of the earth at 39 degrees latitude in miles - to use Kilometers: 6373

    public static boolean RUN_TESTS = true;
    public static final String DEGREE = "°";
    public static final String MINUTE = "\'";
    public static final String SECOND = "\"";

    public static void testMethod() {
        System.out.println(getCityInfo("Fort Collins,40°35'6.9288\"N,105°5'3.9084\"W;Denver,39°44'31.3548\"N,104°59'29.5116\"W;Boulder,40°0'53.9424\"N,105°16'13.9656\"W;Salida,38°32'4.9848\"N,105°59'56.0436\"W;Loveland,40°23'55.8852\"N,105°3'9.5148\"W;Pueblo,38°16'35.2668\"N,104°36'16.5852\"W","fort", ";"));

        System.out.println(getCityName("Fort Collins,40°35'6.9288\"N,105°5'3.9084\"W", ","));
        System.out.println(getCityLongitude("Fort Collins,40°35'6.9288\"N,105°5'3.9084\"W", ","));
        System.out.println(getCityLatitude("Fort Collins,40°35'6.9288\"N,105°5'3.9084\"W", ","));

        double val =  convertDegreesToDecimals("40°35'6.9288\"N");
         double val2 = convertDegreesToDecimals("105°5'3.9084\"W");
         System.out.println(val + " should be  40.585258");
        System.out.println(val2 + " should be -105.084419 (check sign!)");
    }


    /**
     * Get the city info by using a substring of a city name. For example if the parameter destination equaled
     * 
     * <pre>
     * 
     *     fort
     *
     *     then
     *     Fort Collins,40°35'6.9288"N,105°5'3.9084"W
     *
     *     will be returned
     * 
     * </pre>
     *
     * You can assume the start of the city is typed, and someone isn't using 'collins' to find fort collins.
     * You will want to use the CITY_DELIMINATOR constant in this method, and the cities class variable. Useful
     * string methods to look at
     * 
     * <ul>
     *     <li>length()</li>
     *     <li>indexOf(char)</li>
     *     <li>subString(int)</li>
     *     <li>toLowerCase()</li>
     * 
     * </ul>
     * @param cityList a list of cities separated by deliminator
     * @param destination the substring of a city name to be matched so the full city data can be pulled from the cities string. It should be lowercase.
     * @param deliminator the separator of the cities
     * @return a full city data line (EX: Fort Collins,40°35'6.9288"N,105°5'3.9084"W)
     */

     /*Writing getCityInfo
You have three parameters, the cityList, destination, and the deliminator. The method signature is already done for you, so best to find it in the code below. Also know that given a String, you can take its substring, and you can also search for the indexOf a certain character, which is essential for writing this.

First when writing this method, know we want it to be case-insensitive. While the choice is yours, we found .toLowerCase() to be useful (which is a String method) - as it forced the city name in cityList to be lowercase.

Understanding destination - this is the ‘start’ location of the substring. As such:
  int start = cityListLower.indexOf(destinationLower); 
will give you the starting index of the city name, assuming you have created a lowercase version of both cityList and destination.

The end index is trickier. .indexOf(String, int) will search for the index of the String starting at location int. This could be extremely useful in helping you find the deliminator after the start location! However, what if the city is the last one in the list? Notice there is no deliminator after the last city!

Taking both the start and end index, return the substring. Reminder that substrings the end index is exclusive so the end index provided will not be included in the substring.
HINT to make this method go easier, put in println’s throughout the method as you figure out the indices. It also helps to write down a String, and the write the index locations under the string, so you can see the relationships.
 */
    public static String getCityInfo(String cityList, String destination, String deliminator) {
        String cityListLower = cityList.toLowerCase();
        String destinationLower = destination.toLowerCase();
        int start = cityListLower.indexOf(destinationLower);
        int end = cityListLower.indexOf(deliminator, start);
        if (end == -1) {
            end = cityListLower.length();
        }
        return cityList.substring(start, end);
    }


    /**
     * Returns the name of a city, based on the 'city data' line from the traveling alchemist came.
     * The typical line looks like the following:
     *
     * <pre>
     *     Fort Collins,40°35'6.9288"N,105°5'3.9084"W
     * </pre>
     *
     *  with the comma being the deliminator (notice, it is a passed in parameter). The returned result
     *  will be
     *
     *  <pre>
     *      Fort Collins
     *  </pre>
     *
     *  It is safe to assume the city always starts the string, and goes until the deliminator.
     *
     * @param cityData a city string in the format of Name,Latitude,Longitude
     * @return the name of the city
     */
    //Writing getCityName
    //This method returns a substring of the cityData from 0 to the indexOf of the deliminator that is passed into the method. You can do this method in one or three lines.
    public static String getCityName(String cityData, String deliminator) {
        return cityData.substring(0, cityData.indexOf(deliminator));
    }


    /**
     * Returns the Longitude of a city, based on the 'city data' line from the traveling alchemist came.
     * The typical line looks like the following:
     *
     * <pre>
     *     Fort Collins,40°35'6.9288"N,105°5'3.9084"W
     * </pre>
     *
     *  with the comma being the deliminator (notice, it is a passed in parameter). The returned result
     *  will be
     *
     *  <pre>
     *      105°5'3.9084"W
     *  </pre>
     *
     * It is safe to assume the Longitude is always the last in the city data string.
     *
     * @param cityData a city string in the format of Name,Latitude,Longitude
     * @param deliminator the deliminator in which the city is split by. Usually commas
     * @return the name of the city
     */
    //Writing getCityLongitude
    //This method returns a substring of the cityData from the indexOf of the deliminator that is passed into the method to the end of the string. You can do this method in one or three lines.
    public static String getCityLongitude(String cityData, String deliminator) {
        return cityData.substring(cityData.indexOf(deliminator) + 1);
    }


    /**
     * Returns the Latitude of a city, based on the 'city data' line from the traveling alchemist came.
     * The typical line looks like the following:
     *
     * <pre>
     *     Fort Collins,40°35'6.9288"N,105°5'3.9084"W
     * </pre>
     *
     *  with the comma being the deliminator (notice, it is a passed in parameter). The returned result
     *  will be
     *
     *  <pre>
     *      40°35'6.9288"N
     *  </pre>
     *
     * It is safe to assume the Latitude is always the middle value in the city data string.
     *
     * @param cityData a city string in the format of Name,Latitude,Longitude
     * @param deliminator the deliminator in which the city is split by. Usually commas
     * @return the name of the city
     */
    //Writing getCityLatitude
    //This method returns a substring of the cityData from the indexOf of the deliminator that is passed into the method to the indexOf of the second deliminator. You can do this method in one or three lines.
    public static String getCityLatitude(String cityData, String deliminator) {
        return cityData.substring(cityData.indexOf(deliminator) + 1, cityData.indexOf(deliminator, cityData.indexOf(deliminator) + 1));
    }

    

    /**
     * Convert a latitude or longitude stored in coordinate degrees, minutes, seconds, direction format to decimal (double)
     * format. For example, 40°35'6.9288"N would return 40.585258 and 105°5'3.9084"W would return -105.084419.
     * You will note that West values and South values return negative values.
     *
     * <p>
     * For simple coordinate conversion you take the degree part of the value, add the minute part divided by 60
     * and then add the second part divided by 3600. For example, 105°5'3.9084"W would be 105 + (5 / 60) + (3.9084/ 3600)
     * and then you would multiply it by -1 to make it the negative coordinate.
     * </p>
     *
     * <p>
     *     You will want to use the DEGREE, MINUTE ane SECOND constants while looking at indexOf and substring.
     *     Double.parseDouble(stringValue) will return the double of the number once you *only* have a number.
     * </p>
     *
     * <p>
     *     This is another method where your instructor put in printlns while working on it to make sure
     *     he was getting the proper substrings.
     * </p>
     *
     * @param strValue A coordinate in the format of degree°minute'second"cardinal_direction or example 105°5'3.9084"W
     * @return the decimal value of that coordinate as a double.
        */
    //Writing convertCoordinate

    public static double convertDegreesToDecimals(String strValue) {
        double degree = Double.parseDouble(strValue.substring(0, strValue.indexOf(DEGREE)));
        double minute = Double.parseDouble(strValue.substring(strValue.indexOf(DEGREE) + 1, strValue.indexOf(MINUTE)));
        double second = Double.parseDouble(strValue.substring(strValue.indexOf(MINUTE) + 1, strValue.indexOf(SECOND)));
        double direction = strValue.substring(strValue.indexOf(SECOND) + 1).equals("N") || strValue.substring(strValue.indexOf(SECOND) + 1).equals("E") ? 1 : -1;
        return (degree + (minute / 60) + (second / 3600)) * direction;
    }


    // do not edit - but worth looking at especially if you have the GIS/SIM minor
    /**
     *  This is a complex math formula used in GIS system data
     *     https://andrew.hedges.name/experiments/haversine/
     *     dlon = lon2 - lon1
     *     dlat = lat2 - lat1
     *     a = (sin(dlat/2))^2 + cos(lat1) * cos(lat2) * (sin(dlon/2))^2
     *     c = 2 * atan2( sqrt(a), sqrt(1-a) )
     *     d = R * c (where R is the radius of the Earth)
     * @param lat1 start point latitude
     * @param lon1 start point longitude
     * @param lat2 end point latitude
     * @param lon2 end point longitude
     * @return the distance as a double
     */
    public static double haversine(double lat1, double lon1, double lat2, double lon2) {
        double dlat = Math.toRadians(lat2 - lat1);
        double dlon = Math.toRadians(lon2 - lon1);
        double a = Math.pow(Math.sin(dlat/2), 2) +
                Math.cos(Math.toRadians(lat1)) *
                        Math.cos(Math.toRadians(lat2)) *
                        Math.pow(Math.sin(dlon/2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        return EARTH_RADIUS * c;
    }
}
