package com.zappcompany.unitconverter.volume.inputdialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import android.widget.TextView;

import com.zappcompany.unitconverter.R;
import com.zappcompany.unitconverter.customview.Keyboard;

public class InputDialog {

    private Context mContext;

    public InputDialog(Context context) {
        mContext = context;
    }

    public void openInputDialog(final TextView textView) {
        AlertDialog.Builder alert = new AlertDialog.Builder(mContext);
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.alert_dialog_layout, null);
        final EditText input = view.findViewById(R.id.editText);
        Keyboard keyboard = view.findViewById(R.id.keyboard);
        input.setRawInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL);
        input.setTextIsSelectable(true);
        InputConnection ic = input.onCreateInputConnection(new EditorInfo());
        keyboard.setInputConnection(ic);
        alert.setView(view);

        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                String value = String.valueOf(input.getText());
                textView.setText(value);
            }
        });

        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                dialog.dismiss();
            }
        });

        alert.show();

    }
}
