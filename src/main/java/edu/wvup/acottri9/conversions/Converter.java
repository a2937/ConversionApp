package edu.wvup.acottri9.conversions;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.text.DecimalFormat;

/**
 * A class designated to convert temperatures and distance.
 * Created by aaron on 2/2/2018.
 */
public class Converter
{

    private double initialValue;
	private static final String PREFERENCE_INITIAL = "initial_value";
    private static final String PREFERENCE_MODE = "mode";
    private ConvertModes mode; 
    private DecimalFormat df = new DecimalFormat("0.00");


    private final static double LITERS_TO_GALLON = 0.264f;

    private final static double GALLONS_TO_LITER = 3.785f;

    private final static double CM_PER_INCH=2.54;

    private final static double INCH_PER_CM=0.393701;

    private final static double KILOMETERS_TO_MILES = 0.621f;

    private final static double MILES_TO_KILOMETERS = 1.61f;

    private final static double POUNDS_TO_KILOGRAMS = 0.454f;

    private final static double KILOGRAMS_TO_POUNDS = 2.2f;

    private final static double DIFF_BETWEEN_CELSIUS_KELVIN = 273.15;
    /**
     *
     * Instantiates a new Converter.
     */
    public Converter()
    {
        setMode(1);
		setInitialValue(0.00);
    }

    /**
     * Instantiates a Converter from stored preferences
     *
     * @param context the context
     */
    public Converter( Context context )
    {
        SharedPreferences pref =
                PreferenceManager.getDefaultSharedPreferences( context );
        setMode( pref.getInt( PREFERENCE_MODE, 1));
		setInitialValue(pref.getFloat(PREFERENCE_INITIAL,0.00f));
    }

    /**
     * Gets the formatted input so it is ready
     * to be printed in a input string.
     * The mode is what we initially started with.
     * @return the formatted input
     */
    public String getFormattedInitial()
    {
        if(mode != ConvertModes.KELVINC && mode != ConvertModes.KELVINF)
        {
            return df.format(initialValue) + " " + mode.name().substring(0,1).toUpperCase() + mode.name().toLowerCase().substring(1);
        }
        else
        {
            return df.format(initialValue) + " " + "Kelvin";
        }

    }

    /**
     * Gets the formatted output
     * The mode is what we initially started with.
     * @return the formatted output
     */
    public String getFormattedOutput()
    {
        if (mode == ConvertModes.CELSIUS)
        {
            return df.format(convertCelsiusToFahrenheit(initialValue)) + " degrees Fahrenheit";
        }
        else if (mode == ConvertModes.FAHRENHEIT)
        {
            return df.format(convertFahrenheitToCelsius(initialValue)) + " degrees Celsius";
        }
        else if(mode == ConvertModes.KELVINC)
        {
            return df.format(convertCelsiusToKelvin(initialValue)) + " degrees Kelvin";
        }
        else if(mode == ConvertModes.KELVINF)
        {
            return df.format(convertFahrenheitToKelvin(initialValue)) + " degrees Kelvin";
        }
        else if (mode == ConvertModes.KILOMETERS)
        {
            return df.format(convertKmToMiles(initialValue)) + " Miles ";
        }
        else if (mode == ConvertModes.MILES)
        {
            return df.format(convertMilesToKm(initialValue)) + " Kilometers";
        }
        else if(mode == ConvertModes.INCHES)
        {
            return df.format(convertInchesToCentimeters(initialValue)) + " Centimeters";
        }
        else if(mode == ConvertModes.CENTIMETERS)
        {
            return df.format(convertCentimetersToInches(initialValue)) + " Inches";
        }
        else if(mode == ConvertModes.DECIMAL)
        {
            return df.format(BinaryToDecimal(Double.valueOf(initialValue).toString())) + " in binary";
        }
        else if(mode == ConvertModes.GALLONS)
        {
            return df.format(convertGallonsToLiters(initialValue)) + " Liters";
        }
        else if(mode == ConvertModes.LITERS)
        {
            return df.format(convertLitersToGallon(initialValue)) + " Gallons";
        }
        else if(mode == ConvertModes.POUNDS)
        {
            return df.format(convertPoundsToKilograms(initialValue)) + " Kilograms";
        }
        else if(mode == ConvertModes.KILOGRAMS)
        {
            return df.format(convertKilogramsToPounds(initialValue)) + " Pounds";
        }
        else
        {
            return "";
        }
    }

    private double convertFahrenheitToKelvin(double fahrenheit)
    {
        return (fahrenheit + 459.67) * (5/9);
    }

    private double convertCelsiusToKelvin(double celsius)
    {
        return celsius + DIFF_BETWEEN_CELSIUS_KELVIN;
    }

    private double convertKelvinToCelsisu(double Kelvin)
    {
        return Kelvin - DIFF_BETWEEN_CELSIUS_KELVIN;
    }

    private double convertKilogramsToPounds(double kilograms)
    {
        return kilograms * KILOGRAMS_TO_POUNDS;
    }

    private double convertPoundsToKilograms(double pounds) 
    {
        return pounds * POUNDS_TO_KILOGRAMS; 
    }
    

    private double convertLitersToGallon(double liters)
    {
        return liters * LITERS_TO_GALLON;

    }

    private double BinaryToDecimal(String initialValue)
    {
        String binaryString = Double.valueOf(initialValue).toString();
        int integerInitial =  Double.valueOf(initialValue).intValue();

        int binaryLength = String.valueOf(integerInitial).length();
        String flippedBinary = reverse(binaryString);

        int result = 0;

        for(int i=0;i< binaryLength;i++)
        {
            int decimal = 0;
            if((flippedBinary.charAt(i))!='0')
            {
                decimal = (int) Math.pow(2,i);
            }
            result += decimal;
        }
        return result;
    }

    private String reverse(String input)
    {
        char[] in = input.toCharArray();
        int begin=0;
        int end=in.length-1;
        char temp;
        while(end>begin)
        {
            temp = in[begin];
            in[begin]=in[end];
            in[end] = temp;
            end--;
            begin++;
        }
        return new String(in);
    }

    /**
     * Convert Fahrenheit to celsius double.
     *
     * @param tempFahrenheit the temp Fahrenheit
     * @return the double
     */
    private double convertFahrenheitToCelsius(double tempFahrenheit)
    {
       return (tempFahrenheit - 32) * 5/9;
    }


    private double convertInchesToCentimeters(double inches)
    {
        return inches * CM_PER_INCH;
    }

    private double convertCentimetersToInches(double centimeters)
    {
        return centimeters * INCH_PER_CM;
    }

    /**
     * Convert celsius to Fahrenheit double.
     *
     * @param tempCelsius the temp celsius
     * @return the double
     */
    private double convertCelsiusToFahrenheit(double tempCelsius)
    {
        return (tempCelsius * 1.8) + 32;
    }

    /**
     * Convert miles to km double.
     *
     * @param miles the temp miles
     * @return the double
     */
    private double convertMilesToKm(double miles)
    {
        return miles * MILES_TO_KILOMETERS;
    }

    /**
     * Convert km to miles double.
     *
     * @param Km the temp km
     * @return the double
     */
    private double convertKmToMiles(double Km)
    {
        return Km * KILOMETERS_TO_MILES;
    }

    private double convertGallonsToLiters(double gallons)
    {
        return gallons * GALLONS_TO_LITER;
    }



    /**
     * Writes converter data to preferences
     *
     * @param context the context
     */
    public void setPreferences( Context context )
    {
        SharedPreferences pref =
                PreferenceManager.getDefaultSharedPreferences( context );
        SharedPreferences.Editor editor = pref.edit( );
        editor.putInt( PREFERENCE_MODE, 1 );
        editor.putFloat(PREFERENCE_INITIAL,(float)0.00);
        editor.apply( );
    }

    /**
     * Gets the convert mode.
     *
     * @return the mode
     */
    public ConvertModes getMode()
    {
        return mode;
    }

    /**
     * Sets convert mode.
     *
     * @param mode the mode
     */
    public void setMode(int mode)
    {
        this.mode = ConvertModes.values()[mode];
    }


    public double getInitialValue()
    {
        return initialValue;
    }

    public void setInitialValue(double initialValue) 
    {
        this.initialValue = initialValue;
    }
}
