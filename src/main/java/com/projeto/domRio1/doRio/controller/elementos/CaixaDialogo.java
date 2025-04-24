package com.projeto.domRio1.doRio.controller.elementos;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lombok.Getter;
import org.springframework.stereotype.Controller;
@Getter
@Controller
public class CaixaDialogo {
    @FXML
    private Label mensagem;

    @FXML
    private Label titulo;


    @FXML
    private Button btnfechar;

    @FXML
    private Button btnOk;

    public static boolean botaoClicado() {
        return true;
    }

    @FXML
    void btnfechar(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    public static boolean botaoRetorno = false;

    @FXML
    void btnOk(ActionEvent event) {
        botaoRetorno = true;
    }

    public static void addNew(String titulo, String msg, String confirma, String fechar) {
        abrir(titulo, msg, confirma, fechar);
    }

    public static void abrir(String titulo, String msg, String confirma, String fechar) {
        try {
            Stage stage = new Stage(StageStyle.UNDECORATED);
            FXMLLoader loader = new FXMLLoader(CaixaDialogo.class.getResource("/templates/views/caixa/CaixaDialogo.fxml"));
            stage.setScene(new Scene(loader.load()));
            stage.initModality(Modality.APPLICATION_MODAL);

            CaixaDialogo controller = loader.getController();
            controller.init(titulo, msg, confirma, fechar);

            stage.show();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void init(String titulo, String msg, String confirma, String fechar) {
        this.titulo.setText(titulo);
        this.mensagem.setText(msg);
        if(confirma == null){
            this.btnOk.setVisible(false);
            this.btnfechar.getStyleClass().add("botao-login");
        }else {
            this.btnOk.setText(confirma);
        }
        this.btnfechar.setText(fechar);
    }
}
