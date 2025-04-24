package com.projeto.domRio1.doRio.controller;

import com.projeto.domRio1.doRio.DoRioApplication;
import com.projeto.domRio1.doRio.controller.elementos.CaixaDialogo;
import com.projeto.domRio1.doRio.model.Usuario;
import com.projeto.domRio1.doRio.utils.Menu;
import com.projeto.domRio1.doRio.utils.SessaoUsuario;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.springframework.stereotype.Controller;

import java.io.IOException;

@Controller
public class MainController {
    @FXML
    private VBox sideBar;

    @FXML
    private StackPane contentView;

    @FXML
    private Label nomeUsuario;

    @FXML
    private void initialize() {
        loadView(Menu.Inicial);
        nomeUsuario.setText(SessaoUsuario.getUsuario().getNome());
    }

    @FXML
    private void clickMenu(MouseEvent event) {

        Node node = (Node) event.getSource();

        if(node.getId().equals("Exit")) {
            // need to confirm
            CaixaDialogo.addNew(" ", "Dejesa sair do sistema?", "Sim", "Cancelar");
            //Dialog.DialogBuilder.builder()
                    //.title("Confirm")
                    //.message("Do you want to exit POS?")
                    //.okActionListener(() -> sideBar.getScene().getWindow().hide())
                    //.build().show();
        } else {

            Menu menu = Menu.valueOf(node.getId());
            loadView(menu);
        }
    }

    public void loadView(Menu menu) {
        try {

            for(Node node : sideBar.getChildren()) {

                node.getStyleClass().remove("active");

                if(node.getId().equals(menu.name())) {
                    node.getStyleClass().add("active");
                }
            }


            contentView.getChildren().clear();
            FXMLLoader loader = new FXMLLoader(getClass().getResource(menu.getFxml()));

            loader.setControllerFactory(DoRioApplication.getApplicationContext()::getBean);

            Parent view = loader.load();

            //AbstractController controller = loader.getController();
            //controller.setTitle(menu);

            contentView.getChildren().add(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void show() {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(MainController.class.getResource("/templates/views/MainFrame.fxml"));
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void abrirMain(Stage stageLogin) {

        try {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(LoginController.class.getResource("/templates/views/MainFrame.fxml"));
            loader.setControllerFactory(DoRioApplication.getApplicationContext()::getBean);

            Parent view = loader.load();
            stage.setScene(new Scene(view));
            stage.show();
            stageLogin.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
