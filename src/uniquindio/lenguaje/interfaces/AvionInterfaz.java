package uniquindio.lenguaje.interfaces;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import uniquindio.lenguaje.mundo.Aerolinea;
import uniquindio.lenguaje.mundo.Avion;
import uniquindio.lenguaje.mundo.Pasajero;
import uniquindio.lenguaje.mundo.Silla;
import uniquindio.lenguaje.mundo.Vuelo;

public class AvionInterfaz extends Scene {
	private Button btnSillasOcupadas = new Button();
	private Button btnCantidadReca = new Button();
	private boolean editing = false;
	private AnchorPane panelVer = new AnchorPane();
	private Button btnNew = new Button();
	private TextField tfNombre = new TextField();
	private TextField tfCedula = new TextField();
	private TextField tfEdad = new TextField();
	private TextField tfEmail = new TextField();
	private TextField tfDireccion = new TextField();
	private Button[][] botonesEje = new Button[5][2];
	private Button[][] botonesEco = new Button[7][7];
	private Pasajero pasajeroActual = null;
	private AnchorPane panelAvion = new AnchorPane();
	private Button botonVer = new Button();
	private ComboBox<String> comboAviones = new ComboBox<String>();
	private Label labelVer = new Label();
	private Button botonAñadir = new Button();
	private Aerolinea aerolinea = new Aerolinea();
	private Vuelo vueloAc = aerolinea.getVueloMede();
	private Avion avion = aerolinea.getVueloMede().getAvion();
	static AnchorPane principalPanel = new AnchorPane();
	private VBox boxPane = new VBox();
	private GridPane gridEje = new GridPane();
	private GridPane gridEco = new GridPane();

	public AvionInterfaz() {
		super(principalPanel, 1000, 700);
		setRoot(principalPanel);
		organizarPestaña();
	}

	public void organizarPestaña() {
		final String nombre = tfNombre.getText();
		final String id = tfCedula.getText();
		final String edad = tfEdad.getText();
		final String direccion = tfDireccion.getText();
		final String email = tfEmail.getText();
		btnNew.setVisible(false);
		btnNew.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				final String nombre = tfNombre.getText();
				final String id = tfCedula.getText();
				final String edad = tfEdad.getText();
				final String direccion = tfDireccion.getText();
				final String email = tfEmail.getText();
				pasajeroActual = new Pasajero(nombre, id, edad, email, direccion);
				tfCedula.setText("");
				tfNombre.setText("");
				panelAvion.setVisible(true);
				tfDireccion.setText("");
				tfEdad.setText("");
				tfEmail.setText("");

			}
		});

		btnCantidadReca.setText("Dinero recaudado");
		btnSillasOcupadas.setText("Avión con más sillas ocupadas");
		btnSillasOcupadas.setLayoutX(17);
		btnSillasOcupadas.setLayoutY(140);
		btnCantidadReca.setLayoutX(17);
		btnCantidadReca.setLayoutY(200);
		tfCedula.setVisible(false);
		tfDireccion.setVisible(false);
		panelVer.getChildren().add(btnCantidadReca);
		panelVer.getChildren().add(btnSillasOcupadas);
		tfEdad.setVisible(false);
		tfEmail.setVisible(false);
		tfNombre.setVisible(false);
		btnCantidadReca.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				JOptionPane.showMessageDialog(null, "El dinero recaudado para el trayecto de " + vueloAc.getDestino()
						+ " es: " + vueloAc.getDineroRecaudado());

			}
		});

		btnSillasOcupadas.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (aerolinea.getVueloMasOcupado() != null) {
					JOptionPane.showMessageDialog(null,
							"El avión con más sillas ocupadas es el que ocupa el trayecto "
									+ aerolinea.getVueloMasOcupado().getDestino());

				} else {
					JOptionPane.showMessageDialog(null, "Ambos vuelos están vacios");
				}

			}
		});
		String css = "-fx-border-radius: 5;\n" + "-fx-border-color:  #A9A9A9;";
		labelVer.setText("Destino:");
		labelVer.setLayoutX(14);
		labelVer.setLayoutY(30);
		labelVer.setFont(Font.font(15));
		panelVer.setStyle(css);
		panelVer.setPrefWidth(330);
		panelVer.setPrefHeight(370);
		panelVer.setLayoutX(24);
		panelVer.setLayoutY(154);
		panelVer.getChildren().add(labelVer);
		panelVer.getChildren().add(comboAviones);
		comboAviones.setLayoutX(14);
		comboAviones.setLayoutY(56);
		comboAviones.setItems(getList());
		comboAviones.setPromptText("Medellín");
		panelVer.getChildren().add(btnNew);
		panelVer.getChildren().add(tfNombre);
		panelVer.getChildren().add(tfCedula);
		panelVer.getChildren().add(tfDireccion);
		panelVer.getChildren().add(tfEdad);
		panelVer.getChildren().add(tfEmail);
		comboAviones.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (comboAviones.getValue().equalsIgnoreCase("Medellín")) {
					avion = aerolinea.getVueloMede().getAvion();
					vueloAc = aerolinea.getVueloMede();
					iniciarPanelEco();
					iniciarPanelEje();
				} else if (comboAviones.getValue().equalsIgnoreCase("Bogotá")) {
					avion = aerolinea.getVueloBogo().getAvion();
					vueloAc = aerolinea.getVueloBogo();
					iniciarPanelEco();
					iniciarPanelEje();
				}

			}
		});
		panelAvion.setLayoutX(450);
		panelAvion.setLayoutY(100);
		panelAvion.setPrefWidth(485);
		panelAvion.setPrefHeight(500);
		panelAvion.setStyle("-fx-background-color: white");
		panelAvion.setStyle("-fx-background-image: url(/uniquindio/lenguaje/imagenes/avionPequeño.png)");
		principalPanel.setStyle("-fx-background-color: white");
		Label label2 = new Label();
		label2.setText("                ");
		Label label3 = new Label();
		label3.setText("                           ");
		gridEje.add(label3, 0, 0);
		iniciarPanelEje();
		iniciarPanelEco();
		Label label = new Label();
		label.setText("                              ");

		gridEco.add(label2, 0, 0);
		boxPane.getChildren().add(gridEje);
		boxPane.setLayoutX(65);
		boxPane.setLayoutY(18);
		boxPane.getChildren().add(label);
		boxPane.getChildren().add(gridEco);
		panelAvion.getChildren().add(boxPane);
		principalPanel.getChildren().add(panelAvion);
		principalPanel.getChildren().add(panelVer);
		principalPanel.getChildren().add(crearVentanaSuperior());
	}

	public void iniciarPanelEje() {
		for (int i = 0; i < botonesEje.length; i++) {
			for (int j = 0; j < botonesEje[i].length; j++) {
				final Silla silla = avion.getSillasEje()[j][i];

				botonesEje[i][j] = new Button();
				botonesEje[i][j].setStyle("-fx-background-color: white");
				final Button btn = botonesEje[i][j];
				if (silla == null) {

					botonesEje[i][j].setText("   ");
					botonesEje[i][j].setDisable(true);
				} else {
					if (silla.isOcupada() == false) {
						botonesEje[i][j].setGraphic(new ImageView(
								new Image("/uniquindio/lenguaje/imagenes/silla-ejec-libre.png", 24, 24, false, true)));
					} else {
						botonesEje[i][j].setGraphic(new ImageView(
								new Image("/uniquindio/lenguaje/imagenes/silla-ejec-asig.png", 24, 24, false, true)));
					}

				}

				botonesEje[i][j].setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						if (editing) {
							if (pasajeroActual == null) {
								JOptionPane.showMessageDialog(null, "Inserte un pasajero");
							} else {
								if (silla.isOcupada()) {
									JOptionPane.showMessageDialog(null, "Silla ocupada.");
								} else {
									btn.setGraphic(new ImageView(new Image(
											"/uniquindio/lenguaje/imagenes/silla-ejec-asig.png", 24, 24, false, true)));
									silla.setOcupada(true);
									new java.util.Timer().schedule( 
									        new java.util.TimerTask() {
									            @Override
									            public void run() {
									            	panelAvion.setVisible(false);
									            }
									        }, 
									        2000
									);
									silla.setPasajero(pasajeroActual);
									vueloAc.añadirPasajero(pasajeroActual);
									pasajeroActual = null;
								}
							}

						} else {
							if (silla.isOcupada()) {

								Pasajero pasa = silla.getPasajero();
								JOptionPane.showMessageDialog(null,
										"Silla asignada al pasajero: \n" + "Nombre: " + pasa.getNombre() + "\n"
												+ "Cédula: " + pasa.getId() + "\n" + "Edad: " + pasa.getEdad() + "\n"
												+ "Dirección: " + pasa.getDireccion() + "\n" + "Email: "
												+ pasa.getEmail() + "");
							} else {
								JOptionPane.showMessageDialog(null, "Silla desocupada.");
							}

						}
					}

				});
				gridEje.add(botonesEje[i][j], i + 5, j + 5);
			}

		}

	}

	public ObservableList<String> getList() {
		ObservableList<String> list = FXCollections.observableArrayList();
		list.add("Medellín");
		list.add("Bogotá");
		return list;
	}

	public void iniciarPanelEco() {
		for (int i = 0; i < botonesEco.length; i++) {
			for (int j = 0; j < botonesEco[i].length; j++) {
				final Silla silla = avion.getSillasEco()[j][i];

				botonesEco[i][j] = new Button();

				botonesEco[i][j].setPrefWidth(21);
				botonesEco[i][j].setPrefHeight(20);
				final Button btn = botonesEco[i][j];
				String css = "-fx-background-color: white;\n" + "-fx-border-style: none;\n" + "-fx-border-width: 0;";
				botonesEco[i][j].setStyle(css);
				if (silla == null) {

					botonesEco[i][j].setText("");
					botonesEco[i][j].setDisable(true);
				} else {

					if (silla.isOcupada() == false) {
						botonesEco[i][j].setFocusTraversable(false);
						botonesEco[i][j].setGraphic(new ImageView(
								new Image("/uniquindio/lenguaje/imagenes/silla-econ-libre.png", 24, 24, false, true)));
					} else {
						botonesEco[i][j].setGraphic(new ImageView(
								new Image("/uniquindio/lenguaje/imagenes/silla-econ-asig.png", 24, 24, false, true)));
					}

				}

				botonesEco[i][j].setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						if (editing) {
							if (pasajeroActual == null) {
								JOptionPane.showMessageDialog(null, "Inserte un pasajero");
							} else {
								if (silla.isOcupada()) {
									JOptionPane.showMessageDialog(null, "Silla ocupada.");
								} else {
									btn.setGraphic(new ImageView(new Image(
											"/uniquindio/lenguaje/imagenes/silla-econ-asig.png", 24, 24, false, true)));
									silla.setOcupada(true);
									vueloAc.añadirPasajero(pasajeroActual);
									new java.util.Timer().schedule( 
									        new java.util.TimerTask() {
									            @Override
									            public void run() {
									            	panelAvion.setVisible(false);
									            }
									        }, 
									        2000
									);
									
									silla.setPasajero(pasajeroActual);
									pasajeroActual = null;
								}
							}

						} else {
							if (silla.isOcupada()) {
								Pasajero pasa = silla.getPasajero();
								JOptionPane.showMessageDialog(null,
										"Silla asignada al pasajero: \n" + "Nombre: " + pasa.getNombre() + "\n"
												+ "Cédula: " + pasa.getId() + "\n" + "Edad: " + pasa.getEdad() + "\n"
												+ "Dirección: " + pasa.getDireccion() + "\n" + "Email: "
												+ pasa.getEmail() + "");
							} else {
								JOptionPane.showMessageDialog(null, "Silla desocupada.");
							}
						}
					}
				});
				gridEco.add(botonesEco[i][j], i + 5, j + 5);
			}

		}
	}

	public AnchorPane crearVentanaSuperior() {
		AnchorPane anchor = new AnchorPane();
		HBox box = new HBox();

		botonAñadir.setText("Editar");
		botonVer.setText("Ver");
		botonVer.setStyle("-fx-background-color: #90EE90");
		botonAñadir.setStyle("-fx-background-color: #D8DEE5");
		box.setPrefWidth(312);
		box.setPrefHeight(30);
		botonAñadir.setCursor(Cursor.HAND);
		botonVer.setCursor(Cursor.HAND);

		botonVer.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				botonVer.setStyle("-fx-background-color: #90EE90");
				botonAñadir.setStyle("-fx-background-color: #D8DEE5");
				editing = false;
				panelVer.setPrefWidth(330);
				panelVer.setPrefHeight(370);
				btnNew.setVisible(false);
				tfCedula.setVisible(false);
				tfDireccion.setVisible(false);
				tfEdad.setVisible(false);
				tfEmail.setVisible(false);
				tfNombre.setVisible(false);
				btnCantidadReca.setVisible(true);
				btnSillasOcupadas.setVisible(true);
				panelAvion.setVisible(true);
			}
		});

		botonAñadir.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				botonVer.setStyle("-fx-background-color: #D8DEE5");
				botonAñadir.setStyle("-fx-background-color: #90EE90");
				editing = true;
				panelAvion.setVisible(false);
				btnCantidadReca.setVisible(false);
				btnSillasOcupadas.setVisible(false);
				tfCedula.setText("");
				tfNombre.setText("");
				tfDireccion.setText("");
				tfEdad.setText("");
				tfEmail.setText("");
				panelVer.setPrefWidth(330);
				panelVer.setPrefHeight(370);
				btnNew.setVisible(true);
				btnNew.setText("Añadir");
				btnNew.setLayoutX(139);
				btnNew.setLayoutY(314);
				tfNombre.setPromptText("Nombre:");
				tfNombre.setLayoutX(15);
				tfNombre.setLayoutY(100);

				tfCedula.setPromptText("Cédula:");
				tfCedula.setLayoutX(15);
				tfCedula.setLayoutY(140);

				tfDireccion.setPromptText("Dirección:");
				tfDireccion.setLayoutX(15);
				tfDireccion.setLayoutY(180);

				tfEdad.setPromptText("Edad:");
				tfEdad.setLayoutX(15);
				tfEdad.setLayoutY(220);

				tfEmail.setPromptText("Email:");
				tfEmail.setLayoutX(15);
				tfEmail.setLayoutY(260);

				tfCedula.setVisible(true);
				tfDireccion.setVisible(true);
				tfEdad.setVisible(true);
				tfEmail.setVisible(true);
				tfNombre.setVisible(true);
			}
		});

		box.getChildren().add(botonVer);
		box.getChildren().add(botonAñadir);

		anchor.getChildren().add(box);
		anchor.setPrefWidth(1280);
		anchor.setPrefHeight(30);

		return anchor;
	}

}
