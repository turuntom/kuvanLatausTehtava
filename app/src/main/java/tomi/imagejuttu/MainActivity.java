package tomi.imagejuttu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    Button lisaaTagNappi, tyhjennaListaNappi, haeKuvaNappi;

    ArrayList<String> imageUrls;
    ArrayList<String> tagLista;

    EditText editText;
    TextView textView;

    final String baseUrl = "https://loremflickr.com/300/300";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)findViewById(R.id.editText);
        textView = (TextView)findViewById(R.id.textView);

        lisaaTagNappi = (Button) findViewById(R.id.button);
        tyhjennaListaNappi = (Button) findViewById(R.id.button2);
        haeKuvaNappi = (Button) findViewById(R.id.button3);

        listView = (ListView) findViewById(R.id.listView);
        imageUrls = new ArrayList<String>();
        tagLista = new ArrayList<String>();


        lisaaTagNappi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tagi = editText.getText().toString();
                tagLista.add(tagi);
                textView.setText(textView.getText().toString()+","+tagi);
                editText.setText("");
            }
        });

        tyhjennaListaNappi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tagLista.clear();
                textView.setText("");
            }
        });

        haeKuvaNappi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = baseUrl;
                for(String tagi : tagLista){
                    url += "/"+tagi;
                }
                imageUrls.add(url);

                KuvaAdapteri kuvaAdapteri = new KuvaAdapteri(getApplicationContext(),imageUrls);
                listView.setAdapter(kuvaAdapteri);
            }
        });

        KuvaAdapteri kuvaAdapteri = new KuvaAdapteri(this,imageUrls);

        listView.setAdapter(kuvaAdapteri);

    }
}
