package edu.wvup.acottri9.conversions;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import java.text.DecimalFormat;

/**
 * This is where the user inputs the mode.
 * Created by aaron on 2/3/2018.
 */
public class DataActivity extends AppCompatActivity
{
    private DecimalFormat df = new DecimalFormat("0.00");

    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        updateView();
    }

	/**
	 * Update the view based upon the converter class.
	 */
	public void updateView()
    {
        Converter converter = MainActivity.converter;
		if(converter.getMode() == ConvertModes.CELSIUS)
		{
			RadioButton rbCelsius = findViewById(R.id.celsius);
			rbCelsius.setChecked(true);
		}
		else if(converter.getMode() == ConvertModes.FAHRENHEIT)
		{
			RadioButton rbFahrenheit = findViewById(R.id.fahrenheit);
			rbFahrenheit.setChecked(true);
		}
		else if(converter.getMode() == ConvertModes.KILOMETERS)
		{
			RadioButton rbKm = findViewById(R.id.kilometers);
			rbKm.setChecked(true);
		}
		else if(converter.getMode() == ConvertModes.MILES)
		{
			RadioButton rbM = findViewById(R.id.miles);
			rbM.setChecked(true);
		}
		else if(converter.getMode() == ConvertModes.CENTIMETERS)
        {
            RadioButton rbCM = findViewById(R.id.centimeters);
            rbCM.setChecked(true);
        }
		else if(converter.getMode() == ConvertModes.INCHES)
        {
            RadioButton rbIN = findViewById(R.id.inches);
            rbIN.setChecked(true);
        }
        else if(converter.getMode() == ConvertModes.POUNDS)
        {
            RadioButton rbPounds = findViewById(R.id.pounds);
            rbPounds.setChecked(true);
        }
        else if(converter.getMode() == ConvertModes.KILOGRAMS)
        {
            RadioButton rbKilograms = findViewById(R.id.kilograms);
            rbKilograms.setChecked(true);
        }
        else if(converter.getMode() == ConvertModes.LITERS)
        {
            RadioButton rbLiters = findViewById(R.id.liters);
            rbLiters.setChecked(true);
        }
        else if(converter.getMode() == ConvertModes.GALLONS)
        {
            RadioButton rbG = findViewById(R.id.gallons);
            rbG.setChecked(true);
        }
        else if(converter.getMode() == ConvertModes.KELVINC)
        {
            RadioButton rbKC = findViewById(R.id.kelvinC);
            rbKC.setChecked(true);
        }
        else if(converter.getMode() == ConvertModes.KELVINF)
        {
            RadioButton rbKF = findViewById(R.id.kelvinF);
            rbKF.setChecked(true);
        }

		else
		{
			//do nothing
		}

        EditText amountET = findViewById(R.id.data_amount);
		String realNumber = df.format(converter.getInitialValue());
        amountET.setText(realNumber);
    }

	/**
	 * Update converter object by setting the mode and intitial mode.
	 */
	public void updateConverterObject()
    {
	 	Converter converter = MainActivity.converter;
		RadioButton rbCelsius = findViewById(R.id.celsius);
        RadioButton rbFahrenheit = findViewById(R.id.fahrenheit);
		RadioButton rbMiles = findViewById(R.id.miles);
        RadioButton rbKm = findViewById(R.id.kilometers);
        RadioButton rbCM = findViewById(R.id.centimeters);
        RadioButton rbIN = findViewById(R.id.inches);
        RadioButton rbG = findViewById(R.id.gallons);
        RadioButton rbLiters = findViewById(R.id.liters);
        RadioButton rbPounds = findViewById(R.id.pounds);
        RadioButton rbKilograms = findViewById(R.id.kilograms);

        RadioButton rbKC = findViewById(R.id.kelvinC);
        RadioButton rbKF = findViewById(R.id.kelvinF);
		if(rbCelsius.isChecked())
		{
			converter.setMode(ConvertModes.CELSIUS.ordinal());
		}
		else if(rbFahrenheit.isChecked())
		{
			converter.setMode(ConvertModes.FAHRENHEIT.ordinal());
		}
		else if(rbMiles.isChecked())
		{
			converter.setMode(ConvertModes.MILES.ordinal());
		}
		else if(rbKm.isChecked())
		{
			converter.setMode(ConvertModes.KILOMETERS.ordinal());
		}
		else if(rbCM.isChecked())
        {
            converter.setMode(ConvertModes.CENTIMETERS.ordinal());
        }
        else if(rbIN.isChecked())
        {
            converter.setMode(ConvertModes.INCHES.ordinal());
        }
        else if(rbG.isChecked())
        {
            converter.setMode(ConvertModes.GALLONS.ordinal());
        }
        else if(rbKC.isChecked())
        {
            converter.setMode(ConvertModes.KELVINC.ordinal());
        }
        else if(rbKF.isChecked())
        {
            converter.setMode(ConvertModes.KELVINF.ordinal());
        }
        else if(rbLiters.isChecked())
        {
            converter.setMode(ConvertModes.LITERS.ordinal());
        }
        else if(rbPounds.isChecked())
        {
            converter.setMode(ConvertModes.POUNDS.ordinal());
        }
        else if(rbKilograms.isChecked())
        {
            converter.setMode(ConvertModes.KILOGRAMS.ordinal());
        }

		else
		{
			
		}
	    EditText amountET = findViewById(R.id.data_amount);
        String amountString = amountET.getText().toString();
		try
        {
            double amount = Double.parseDouble(amountString);
            converter.setInitialValue(amount);
        }
        catch (NumberFormatException nfe) 
		{
            converter.setInitialValue(0);
        }
    }

	/**
	 * Returns us to @MainActivity
	 *
	 * @param v the view object we are going to.
	 */
	public void goBack(View v)
    {
        updateConverterObject();
        this.finish();
        overridePendingTransition(R.anim.fade_in_and_scale, 0);
    }
}