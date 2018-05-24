package edu.wvup.acottri9.conversions;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * The type Main activity. This is where everything is displayed.
 */
public class MainActivity extends AppCompatActivity
{
	/**
	 * The constant converter.
	 */
	public static Converter converter;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        converter = new Converter(this);
        setContentView(R.layout.activity_main);
    }

    public void onStart( )
    {
        super.onStart( );
        updateView( );
    }

	/**
	 * Update the view based upon stored values in the converter.
	 */
	public void updateView( )
    {
        converter.setPreferences(this);

        TextView amountTV = findViewById( R.id.amount );
		
		TextView modeTV = findViewById(R.id.mode);


		if(converter.getMode() != ConvertModes.KELVINC && converter.getMode() != ConvertModes.KELVINF)
        {
            String newString = converter.getMode().name().substring(0,1).toUpperCase() + converter.getMode().name().toLowerCase().substring(1);
            modeTV.setText(newString);
        }
        else
        {
            modeTV.setText(R.string.degrees_kelvin);
        }


      	amountTV.setText(converter.getFormattedInitial());

		TextView totalTV = findViewById( R.id.total );

        totalTV.setText(converter.getFormattedOutput());

		/*
		if(converter.getMode() == ConvertModes.CELSIUS)
		{
			totalTV.setText(converter.getFormattedOutput());
		}
		else if(converter.getMode() == ConvertModes.FAHRENHEIT)
		{
			totalTV.setText(converter.getFormattedOutput());
		}
		else if(converter.getMode() == ConvertModes.KILOMETERS)
		{
			totalTV.setText(converter.getFormattedOutput());
		}
		else if(converter.getMode() == ConvertModes.MILES)
		{
			totalTV.setText(converter.getFormattedOutput());
		}
		else
		{
			totalTV.setText(R.string.none);
		}
		*/
    }

	/**
	 * Opens up the data activity so we can modify the data.
	 *
	 * @param v the view we want to go to
	 */
	public void modifyData( View v )
    {
        Intent myIntent = new Intent( this, DataActivity.class );
        this.startActivity( myIntent );
        overridePendingTransition( R.anim.slide_from_left, 0 );
    }
}
