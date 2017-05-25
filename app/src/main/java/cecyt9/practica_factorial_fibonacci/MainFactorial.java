package cecyt9.practica_factorial_fibonacci;

import android.app.Activity;
import android.os.SystemClock;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.view.*;


public class MainFactorial extends Activity {
    private EditText Numero;
    private TextView Imprecion;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_factorial);
        Numero = (EditText) findViewById(R.id.Numero);
        Imprecion = (TextView) findViewById(R.id.Imprimir);
    }

    public void calcularOperacion(View view) {
        int n = Integer.parseInt(Numero.getText().toString());
        Imprecion.append(n + "! = ");
        Factorial rs = new Factorial(n);
        rs.run();
    }
    public void calcularOperacion2(View view) {
        int n = Integer.parseInt(Numero.getText().toString());
        Imprecion.append(n + "f = ");
        Fibonacci rs = new Fibonacci(n);
        rs.run();
    }

    public int factorial(int n) {
        int res = 1;
        for (int i = 1; i <= n; i++) {
            res *= i;
            SystemClock.sleep(1000);
        }

        return res;

    }

    class Factorial extends Thread {
        private int n, res;

        public Factorial(int n) {

            this.n = n;
        }

        @Override
        public void run() {
            res = factorial(n);
            Imprecion.append(res + "\n");
        }
    }

    class Fibonacci extends Thread {
        private int n, res;

        public Fibonacci(int n) {
            this.n = n;
        }


        @Override
        public void run() {
            res = fibonacci(n);
            Imprecion.append(res + "\n");
        }
    }


    public int fibonacci(int factorial){
        int res = 0;
        if(factorial == 0){
            res = 0;
        }else
            for (int i = 0; i < factorial; i++) {
                res += Auxiliar(i);
            }
        return res;
    }

    public int Auxiliar(int aux)
    {
        if (aux>1){
            return Auxiliar(aux-1) + Auxiliar(aux-2);
        }
        else if (aux==1) {
            return 1;
        }
        else if (aux==0){
            return 0;
        }
        else{ //error
            System.out.println("Debes ingresar un tamaño mayor o igual a 1");
            return -1;
        }
    }
}