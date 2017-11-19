package projetomobile.projetomobile.Activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;

import projetomobile.projetomobile.DAO.ConfigFirebase;
import projetomobile.projetomobile.Entidades.User;
import projetomobile.projetomobile.Helper.Base64Custom;
import projetomobile.projetomobile.Helper.Preferencias;
import projetomobile.projetomobile.R;

public class CadastroActivity extends AppCompatActivity {

    private EditText edtCadEmail;
    private EditText edtCadSenha;
    private EditText edtConfirmaSenha;
    private EditText edtCadNome;
    private EditText edtCadSobrenome;
    private EditText edtCadAniversario;
    private RadioButton rbMas;
    private RadioButton rbFem;
    private Button btnGravar;
    private User user;
    private FirebaseAuth autenticacao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        edtCadEmail = (EditText) findViewById(R.id.edtCadEmail);
        edtCadSenha = (EditText) findViewById(R.id.edtCadSenha);
        edtConfirmaSenha = (EditText) findViewById(R.id.edtCadConfirmarSenha);
        edtCadNome = (EditText) findViewById(R.id.edtCadNome);
        edtCadSobrenome = (EditText) findViewById(R.id.edtCadSobrenome);
        edtCadAniversario = (EditText) findViewById(R.id.edtCadAniversario);
        rbMas = (RadioButton) findViewById(R.id.rbmas);
        rbFem = (RadioButton) findViewById(R.id.rbfem);
        btnGravar = (Button) findViewById(R.id.btnGravar);

        btnGravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtCadSenha.getText().toString().equals(edtConfirmaSenha.getText().toString())) {

                    user = new User();
                    user.setEmail(edtCadEmail.getText().toString());
                    user.setSenha(edtCadSenha.getText().toString());
                    user.setNome(edtCadNome.getText().toString());
                    user.setSobrenome(edtCadSobrenome.getText().toString());
                    user.setAniversario(edtCadAniversario.getText().toString());

                    if (rbFem.isChecked()) {
                        user.setSexo("Feminino");
                    } else {
                        user.setSexo("Masculino");
                    }

                    cadastrarUser();

                } else {
                    Toast.makeText(CadastroActivity.this, " As senhas não sao correspondente", Toast.LENGTH_LONG).show();
                }
            }
        });
    }


    private void cadastrarUser() {
        autenticacao = ConfigFirebase.getFirebaseAutenticacao();
        autenticacao.createUserWithEmailAndPassword(
                user.getEmail(),
                user.getSenha()
        ).addOnCompleteListener(CadastroActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(CadastroActivity.this, "Usuario cadastrado com sucesso! ", Toast.LENGTH_LONG).show();
                    String identificadorUser = Base64Custom.codificarBase64(user.getEmail());
                    FirebaseUser userFirebase = task.getResult().getUser();
                    user.setId(identificadorUser);
                    user.salvar();

                    Preferencias preferencias = new Preferencias(CadastroActivity.this);
                    preferencias.SalvarUsuarioPreferencias(identificadorUser, user.getNome());
                   abrirLoginUser();

                } else {
                    String erroExcecao = "";

                    try {
                        throw task.getException();
                    } catch (FirebaseAuthWeakPasswordException e) {
                        erroExcecao = "Senha fraca, digite uma senha forte";

                    } catch (FirebaseAuthInvalidCredentialsException e) {
                        erroExcecao = "O email digitado é inválido, digite um novo email!";
                    } catch (FirebaseAuthUserCollisionException e) {
                        erroExcecao = "Esse email já existe";
                    } catch (Exception e) {
                        erroExcecao = "Erro ao cadastrar...";
                        e.printStackTrace();
                    }
                    Toast.makeText(CadastroActivity.this, "Erro: " + erroExcecao, Toast.LENGTH_LONG).show();


                }
            }
        });
    }


    public void abrirLoginUser() {
        Intent intent = new Intent(CadastroActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}

