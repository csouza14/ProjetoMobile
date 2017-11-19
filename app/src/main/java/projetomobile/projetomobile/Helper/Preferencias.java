package projetomobile.projetomobile.Helper;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Carina on 18/11/2017.
 */

public class Preferencias {
    private Context context;
    private SharedPreferences preferences;
    private String NOME_ARQUIVO = "ProjetoMobile.Preferencias";
    private int MODE = 0;
    private SharedPreferences.Editor editor;

    private final String CHAVE_INDENTIFICADOR = "identificadorUsuarioLogado";
    private final String CHAVE_NOME = "nomeUsuarioLogado";

    public Preferencias(Context context) {
        this.context = context;
        preferences = context.getSharedPreferences(NOME_ARQUIVO, MODE);
        editor = preferences.edit();

    }

    public void SalvarUsuarioPreferencias(String identificadorUsuario, String nomeUsuario) {
        editor.putString(CHAVE_INDENTIFICADOR, identificadorUsuario);
        editor.putString(CHAVE_NOME, nomeUsuario);
        editor.commit();

    }

    public String getIdentificador() {
        return preferences.getString(CHAVE_INDENTIFICADOR, null);
    }

    public String getNome() {
        return preferences.getString(CHAVE_NOME, null);
    }
}
