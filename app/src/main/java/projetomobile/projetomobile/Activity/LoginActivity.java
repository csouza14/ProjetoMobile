package projetomobile.projetomobile.Activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import projetomobile.projetomobile.DAO.ConfigFirebase;
import projetomobile.projetomobile.Entidades.User;
import projetomobile.projetomobile.R;

public class LoginActivity extends AppCompatActivity {
   private EditText edtEmail;
    private EditText edtSenha;
    private Button btnLogando;
    private FirebaseAuth autenticacao;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtSenha = (EditText) findViewById(R.id.edtSenha);
        btnLogando = (Button) findViewById(R.id.btnLogar);


        btnLogando.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!edtEmail.getText().toString().equals("")&& !edtSenha.getText().toString().equals("")){

                    user = new User();
                    user.setEmail(edtEmail.getText().toString());
                    user.setSenha(edtSenha.getText().toString());

                    ValidarLogin();

                }else {
                    Toast.makeText(LoginActivity.this,"Preencher campos E-mail e Senha", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void ValidarLogin(){
        autenticacao = ConfigFirebase.getFirebaseAutenticacao();
        autenticacao.signInWithEmailAndPassword(user.getEmail(), user.getSenha()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
            if (task.isSuccessful()){
                abrirTelaPrincipal();
                Toast.makeText(LoginActivity.this,"Login efetuado com Sucesso!!!!", Toast.LENGTH_SHORT).show();

            }else{
                Toast.makeText(LoginActivity.this,"Usuario ou senha invalido", Toast.LENGTH_SHORT).show();            }
            }
        });
    }

    public void abrirTelaPrincipal(){
        Intent intentAbrirTelaPrincipal = new Intent(LoginActivity.this,PrincipalActivity.class);
    startActivity(intentAbrirTelaPrincipal);
    }

}
