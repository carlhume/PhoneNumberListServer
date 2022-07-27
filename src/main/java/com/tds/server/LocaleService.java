package com.tds.server;

import java.sql.*;
import java.util.HashMap;
import java.util.Hashtable;

public class LocaleService {

    private static final String DATABASE_CONNECTION_URL = "jdbc:mysql://localhost:3306/phone_directory";
    private static final String DATABASE_USERNAME = "";
    private static final String DATABASE_PASSWORD = "";

    public LocaleData [] getTop20LocalesWithNumbersToCall() {

        LocaleData [] localeData = new LocaleData[20];

        String SELECT_TOP_20 = "select count( distinct( phone_number ) ) as phone_number_count, locality from Contacts, Addresses where Contact.address_id=Addresses.address_id and substrin( phone_number, 5, 7 ) not in ( select phone_number from DNCL ) group by locality order by phone_number_count desc limit 20";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet results = null;

        try {
            int counter = 0;
            connection = DriverManager.getConnection( DATABASE_CONNECTION_URL, DATABASE_USERNAME, DATABASE_PASSWORD );
            statement = connection.prepareStatement( SELECT_TOP_20 );
            results = statement.executeQuery();
            while( results.next() ) {
                LocaleData data = new LocaleData();
                data.setName( results.getString( "locality" ) );
                data.setLocaleId( (int)(Math.random() * 10000) );
                data.setPhoneNumberCount( results.getInt( "phone_number_count" ) );
                data.setGeometry( getGeometryForLocality( data.getName() ) );
                localeData[counter] = data;
                counter++;
            }
        } catch ( SQLException e ) {
            e.printStackTrace();
        } finally {
            if (results != null) {
                try {
                    results.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return localeData;

    }

    private static Hashtable<String, Geometry> locations = new Hashtable<>();
    static {
        locations.put( "Ottawa", new Geometry( "Feature", new double[] { 45.4215, -75.6972 } ) );
        locations.put( "Nepean", new Geometry( "Feature", new double[] { 45.3349, -75.7241 } ) );
        locations.put( "Kingston", new Geometry( "Feature", new double[] { 44.2312, -76.4860 } ) );
        locations.put( "Orleans", new Geometry( "Feature", new double[] { 45.4558, -75.5047 } ) );
        locations.put( "Gloucester", new Geometry( "Feature", new double[] { 45.4473, -75.5943 } ) );
        locations.put( "Kanata", new Geometry( "Feature", new double[] { 45.3088, -75.8987 } ) );
        locations.put( "Belleville", new Geometry( "Feature", new double[] { 44.1628, -77.3832 } ) );
        locations.put( "Stittsville", new Geometry( "Feature", new double[] { 45.2585, -75.9208 } ) );
        locations.put( "Trenton", new Geometry( "Feature", new double[] { 44.0997, -77.5782 } ) );
        locations.put( "Brockville", new Geometry( "Feature", new double[] { 44.5895, -75.6843 } ) );
        locations.put( "Pembroke", new Geometry( "Feature", new double[] { 45.8267, -77.1109 } ) );
        locations.put( "Smiths Falls", new Geometry( "Feature", new double[] { 44.9037, -76.0216 } ) );
        locations.put( "Vanier", new Geometry( "Feature", new double[] { 45.4371, -75.6590 } ) );
        locations.put( "Carleton Place", new Geometry( "Feature", new double[] { 45.1406, -76.1465 } ) );
        locations.put( "Perth", new Geometry( "Feature", new double[] { 44.8988, -76.2486 } ) );
        locations.put( "Arnprior", new Geometry( "Feature", new double[] { 45.4347, -76.3518 } ) );
        locations.put( "Renfrew", new Geometry( "Feature", new double[] { 45.4749, -76.6877 } ) );
        locations.put( "Napanee", new Geometry( "Feature", new double[] { 44.2148, -76.9643 } ) );
        locations.put( "Picton", new Geometry( "Feature", new double[] { 44.0073, -77.1424 } ) );
        locations.put( "Kemptville", new Geometry( "Feature", new double[] { 45.0164, -75.6459 } ) );
    }

    private Geometry getGeometryForLocality( String name ) {
        return locations.get( name );
    }

}
