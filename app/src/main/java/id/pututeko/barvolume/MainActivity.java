package id.pututeko.barvolume;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText edtWidth,edtHeight,edtLength;
    Button btnKalkulasi;
    TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtWidth    = (EditText)findViewById(R.id.edt_width);
        edtHeight   = (EditText)findViewById(R.id.edt_tinggi);
        edtLength   = (EditText)findViewById(R.id.edt_length);
        btnKalkulasi= (Button)findViewById(R.id.btn_kalkulasi);
        tvHasil     = (TextView)findViewById(R.id.tv_hasil);

        btnKalkulasi.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_kalkulasi){
            String inputLength   = edtLength.getText().toString().trim();
            String inputWidth    = edtWidth.getText().toString().trim();
            String inputHeight   = edtHeight.getText().toString().trim();

            boolean isEmptyFields = false;
            boolean isInvalidDouble = false;

            if (TextUtils.isEmpty(inputLength)){
                isEmptyFields =true;
                edtLength.setError("kolom ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(inputWidth)){
                isEmptyFields = true;
                edtWidth.setError("kolom ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(inputHeight)){
                isEmptyFields = true;
                edtHeight.setError("kolom ini tidak boleh kosong");
            }
            Double length = toDouble(inputLength);
            Double width  = toDouble(inputWidth);
            Double height = toDouble(inputHeight);

            if (height == null){
                isInvalidDouble = true;
                edtLength.setError("kolom ini harus berisi angka yang valid");
            }
            if (width == null){
                isInvalidDouble = true;
                edtWidth.setError("kolom ini harus berisi angka yang valid");
            }
            if (height == null){
                isInvalidDouble = true;
                edtHeight.setError("kolom ini harus berisi angka yang valid");
            }
            if (!isEmptyFields && !isInvalidDouble){
                double volum = length*width*height;
                tvHasil.setText(String.valueOf(volum));
            }

        }

    }

    private Double toDouble(String str) {
        try{
            return Double.valueOf(str);
        }catch (NumberFormatException e){
            return null;
        }
    }
}
