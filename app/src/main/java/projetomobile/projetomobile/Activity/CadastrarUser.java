package projetomobile.projetomobile.Activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

/**
 * Created by Carina on 19/11/2017.
 */

public class CadastrarUser extends AppCompatActivity {
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
        edtCadEmail = (EditText) findViewById(R.id.edtEmail);
        edtCadSenha = (EditText) findViewById(R.id.edtSenha);
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
                    Toast.makeText(CadastrarUser.this, " As senhas não corresponde", Toast.LENGTH_LONG).show();
                }
            }
        });
    }


    private void cadastrarUser() {
        autenticacao = ConfigFirebase.getFirebaseAutenticacao();
        autenticacao.createUserWithEmailAndPassword(
                user.getEmail(),
                user.getSenha()
        ).addOnCompleteListener(CadastrarUser.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(CadastrarUser.this, "Usuario cadastrado com suceso! ", Toast.LENGTH_LONG).show();
                    String identificadorUser = Base64Custom.codificarBase64(user.getEmail());
                    FirebaseUser userFirebase = task.getResult().getUser();
                    user.setId(identificadorUser);
                    user.Salvar();

                    Preferencias preferencias = new Preferencias(CadastrarUser.this);
                    preferencias.SalvarUsuarioPreferencias(identificadorUser, user.getNome());
                    abrirLoginUser();

                } else {
                    String erroExecao = "";

                    try {
                        throw task.getException();
                    } catch (FirebaseAuthWeakPasswordException e) {
                        erroExecao = "Senha fraca, digite uma senha forte";

                    } catch (FirebaseAuthInvalidCredentialsException e) {
                        erroExecao = "O email digitado é inválido, digite um novo email!";
                    } catch (FirebaseAuthUserCollisionException e) {
                        erroExecao = "Esse email já existe";
                    } catch (Exception e) {
                        erroExecao = "Erro ao cadastrar...";
                        e.printStackTrace();
                    }
                    Toast.makeText(CadastrarUser.this, "Erro: " + erroExecao, Toast.LENGTH_LONG).show();


                }
            }
        });
    }


    public void abrirLoginUser() {
        Intent intent = new Intent(CadastrarUser.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}

