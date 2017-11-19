package projetomobile.projetomobile.Entidades;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

import projetomobile.projetomobile.DAO.ConfigFirebase;

/**
 * Created by Carina on 18/11/2017.
 */

public class User {


    private String id;
    private String email;
    private String senha;
    private String nome;
    private String sobrenome;
    private String aniversario;
    private String sexo;

    public User() {
    }


    public void Salvar(){
        DatabaseReference referenciaFirebase = ConfigFirebase.getFirebase();
        referenciaFirebase.child("usuario").child(String.valueOf(getId())).setValue(this);
    }

    @Exclude
    public Map<String, Object> toMap(){

    HashMap<String, Object> hashMapUser = new HashMap<>();
        hashMapUser.put("id", getId());
        hashMapUser.put("email", getEmail());
        hashMapUser.put("senha", getSenha());
        hashMapUser.put("nome", getNome());
        hashMapUser.put("sobrenome", getSobrenome());
        hashMapUser.put("aniversario", getAniversario());
        hashMapUser.put("sexo", getSexo());


        return hashMapUser;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getAniversario() {
        return aniversario;
    }

    public void setAniversario(String aniversario) {
        this.aniversario = aniversario;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }



}
