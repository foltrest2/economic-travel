package ui;

import java.io.File;
import java.io.IOException;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeType;
import model.TravelGuide;

public class economictravelGUI {


	private TravelGuide tg;

	@FXML
	private BorderPane basePane;

	@FXML
	private AnchorPane map;

	@FXML
	private Circle parquedelasaludV;

	@FXML
	private Circle platillosVoladoresV;

	@FXML

	private Circle unicentroV;
	@FXML
	private Circle jardinPlazaV;

	@FXML
	private Circle monumentoALaAviacionV;

	@FXML
	private Circle pascualGuerreroV;

	@FXML
	private Circle unidaddeportivaV;

	@FXML
	private Circle plazadetoroscañaveralejoV;

	@FXML
	private Circle hospitaluniversitarioV;

	@FXML
	private Circle iglesiaSanfranciscoV;

	@FXML
	private Circle catedralsanpedroV;
	@FXML
	private Circle elbochincheV;

	@FXML
	private Circle museocienciasnaturalesV;

	@FXML
	private Circle lomadelacruzV;

	@FXML
	private Circle gobernaciondelValleV;

	@FXML
	private Circle bibliotecaJoseGarcesV;

	@FXML
	private Circle museolamercedV;

	@FXML
	private Circle centroculturadecaliV;

	@FXML
	private Circle museodelorocalimaV;

	@FXML
	private Circle parquedelospoetasV;

	@FXML
	private Circle bulevardelrioV;

	@FXML
	private Circle teatromunicipalV;

	@FXML
	private Circle iglesialaermitaV;

	@FXML
	private Circle plazaCaycedoV;

	@FXML
	private Circle monumentoamariamulataV;

	@FXML
	private Circle zoologicodecaliV;

	@FXML
	private Circle museodelatertuliaV;

	@FXML
	private Circle sebastiandebelalczararV;

	@FXML
	private Circle hoteldanncarlton;

	@FXML
	private Circle elgatodelrioV;

	@FXML
	private Circle hotelintercontinentalV;

	@FXML
	private Circle cristoReyV;

	@FXML
	private Circle monumentoAlDeporteV;

	@FXML
	private Circle monumentoalasolidaridadempresarialV;

	@FXML
	private Circle chipichapeV;

	@FXML
	private Circle acuaparquedelacañaV;

	@FXML
	private Circle elplanetarioV;

	@FXML
	private Circle hoteltorredecaliV;

	@FXML
	private Circle miradortrescrucesV;
	@FXML
	private Circle jairoVarelaV;
	@FXML
	private Circle camV;
	@FXML
	private Circle iglesiaSanAntonioV;
	ImageView imav;
	Image i;
	File f;

	//constantes con las rutas de las imagenes de cada lugar
	private static String ACUAPARQUE = "imagenes\\acuaparque.jpg";
	private static String BIBLIOTECAJORGEGARCES = "imagenes\\bibliotecajorgegarces.jpg";
	private static String BULEVARDELRIO = "imagenes\\bulevardelrio.jpeg";
	private static String CAM = "imagenes\\cam.jpg";
	private static String CATEDRALMETROPOLITANA = "imagenes\\catedralmetropolitana.jpg";
	private static String CENTROCULTURALCALI = "imagenes\\centroculturalcali.jpg";
	private static String CHIPICHAPE = "imagenes\\chipichape.jpg";
	private static String CRISTOREY = "imagenes\\cristorey.jpg";
	private static String ELBOCHINCHE = "imagenes\\elbochinche.jpg";
	private static String ELGATODELRIO = "imagenes\\elgatodelrio.jpeg";
	private static String ELPLANETARIO = "imagenes\\elplanetario.jpg";
	private static String GOBERNACIONDELVALLE = "imagenes\\gobernaciondelvalle.jpg";
	private static String HOSPITALUNIVERSITARIO = "imagenes\\hospitaluniversitario.jpg";
	private static String HOTELDARNNCARLTON = "imagenes\\hoteldarnncarlton.jpg";
	private static String HOTELINTERCONTINENTAL = "imagenes\\hotelintercontinental.jpg";
	private static String HOTELTORREDECALI = "imagenes\\hoteltorredecali.jpeg";
	private static String IGLESIASANANTONIO = "imagenes\\iglesiasanantonio.jpg";
	private static String IGLESIASANFRANCISCO = "imagenes\\iglesiasanfrancisco.jpg";
	private static String JARDINPLAZA = "imagenes\\jardinplaza.jpg";
	private static String LAERMITA = "imagenes\\laermita.jpeg";
	private static String LOMADELACRUZ = "imagenes\\lomadelacruz.jpg";
	private static String MIRADORTRESCRUCES = "imagenes\\miradortrescruces.jpg";
	private static String MONUMENTOALAVIACION = "imagenes\\monumentoalaaviacion.jpg";
	private static String MONUMENTOALAMARIA = "imagenes\\monumentoalamariamulata.jpg";
	private static String MONUMENTOALASOLIDARIDAD = "imagenes\\monumentoalasolidaridad.jpg";
	private static String MONUMENTOALDEPORTE = "imagenes\\monumentoaldeporte.png";
	private static String MONUMENTOASEBASTIAN = "imagenes\\monumentosebastiandebelalcazar.jpg";
	private static String MUSEOARQUEOLOGICO = "imagenes\\museoarqueologicolamerced.jfif";
	private static String MUSEODELORO = "imagenes\\museodelorocalima.jpg";
	private static String MUSEODEPARTAMENTALCIENCIA = "imagenes\\museodepartamentalcienciasnaturales.jpg";
	private static String MUSEOTERTULIA = "imagenes\\museolatertulia.jfif";
	private static String PARQUEDELASALUD = "imagenes\\parquedelasalud.jpg";
	private static String PARQUEDELOSPOETAS = "imagenes\\parquedelospoetas.jpg";
	private static String PASCUALGUERRERO = "imagenes\\pascual guerrero.jpg";
	private static String PLAZACAICEDO = "imagenes\\plazacaicedo.jpg";
	private static String PLAZADETOROS = "imagenes\\plazadetoroscañaveralejo.jpg";
	private static String JAIROVARELA = "imagenes\\plazoletajairovarela.jpeg";
	private static String TEATROMUNICIPAL = "imagenes\\teatromunicipal.jfif";
	private static String UNICENTRO = "imagenes\\unicentro.jpeg";
	private static String UNIDADDEPORTIVA = "imagenes\\unidaddeportivapanamericana.png";
	private static String ZOOLOGICODECALI = "imagenes\\zoologicodecali.jpg";
	private static String PLATILLOSVOLADORES = "imagenes\\platillosvoladores.jpg";
	Line m;
	

	public economictravelGUI(TravelGuide t) {

		t=tg;
		m = new Line();

	}

	public void loadMainMenu() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Map.fxml"));
		fxmlLoader.setController(this);
		Parent mape = fxmlLoader.load();
		basePane.setCenter(mape);
		zoom(map);
		m.setStrokeType(StrokeType.OUTSIDE);
		m.setFill(Color.BLACK);
		m.setStroke(Color.GREEN);
		m.setStrokeWidth(2);
        m.setStartX(camV.getLayoutX());
        m.setStartY(camV.getLayoutY());
        m.setEndX(chipichapeV.getLayoutX());
        m.setEndY(chipichapeV.getLayoutY());
        m.setVisible(true);
        map.getChildren().add(m);
	}


	public void move(AnchorPane m) {



	}

	public void zoom( AnchorPane pane) {
		pane.setOnScroll(
				new EventHandler<ScrollEvent>() {
					@Override
					public void handle(ScrollEvent event) {
						double zoomFactor = 1.05;
						double deltaY = event.getDeltaY();

						if (deltaY < 0){
							zoomFactor = 0.95;
						}
						pane.setScaleX(pane.getScaleX() * zoomFactor);
						pane.setScaleY(pane.getScaleY() * zoomFactor);
						event.consume();

					}

				});
	}

	@FXML
	void catedralsanpedro(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(CATEDRALMETROPOLITANA);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #5");
		alert.setContentText("Usted seleccionó la catedral metropolitana de San Pedro");
		alert.showAndWait();

	}

	@FXML
	void clickOnAcuaparquedelaCaña(MouseEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(ACUAPARQUE);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #1");
		alert.setContentText("Usted seleccionó acuaparque de la caña");
		alert.showAndWait();

	}

	@FXML
	void clickOnBibliotecaJoseGarces(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(BIBLIOTECAJORGEGARCES);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #2");
		alert.setContentText("Usted seleccionó la biblioteca departamental Jorge Garces Borrero");
		alert.showAndWait();

	}

	@FXML
	void clickOnBulevarDelRio(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(BULEVARDELRIO);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #3");
		alert.setContentText("Usted seleccionó el bulevar del Rio");
		alert.showAndWait();

	}

	@FXML
	void clickOnCam(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(CAM);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #4");
		alert.setContentText("Usted seleccionó el CAM");
		alert.showAndWait();


	}

	@FXML
	void clickOnCentroculturaldecali(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(CENTROCULTURALCALI);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #6");
		alert.setContentText("Usted seleccionó el centro cultural de Cali");
		alert.showAndWait();
	}

	@FXML
	void clickOnChipichape(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(CHIPICHAPE);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #40");
		alert.setContentText("Usted seleccionó el Centro Comercial Chipichape");
		alert.showAndWait();


	}

	@FXML
	void clickOnCristoRey(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(CRISTOREY);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #7");
		alert.setContentText("Usted seleccionó Cristo Rey");
		alert.showAndWait();

	}

	@FXML
	void clickOnElBochinche(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(ELBOCHINCHE);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #36");
		alert.setContentText("Usted seleccionó el restaurante El Bochinche");
		alert.showAndWait();

	}

	@FXML
	void clickOnElGatodelRio(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(ELGATODELRIO);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #8");
		alert.setContentText("Usted seleccionó El Gato del Rio");
		alert.showAndWait();

	}

	@FXML
	void clickOnElPlanetario(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(ELPLANETARIO);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #9");
		alert.setContentText("Usted seleccionó El Planetario");
		alert.showAndWait();

	}

	@FXML
	void clickOnGobernaciondelValle(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(GOBERNACIONDELVALLE);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #12");
		alert.setContentText("Usted seleccionó La Gobernación del Valle");
		alert.showAndWait();

	}

	@FXML
	void clickOnHospitalUniversitario(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(HOSPITALUNIVERSITARIO);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #13");
		alert.setContentText("Usted seleccionó El Hospital Universitario del Valle");
		alert.showAndWait();

	}

	@FXML
	void clickOnHotelIntercontinental(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(HOTELINTERCONTINENTAL);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #37");
		alert.setContentText("Usted seleccionó El Hotel Intercontinental");
		alert.showAndWait();

	}

	@FXML
	void clickOnHotelTorredeCali(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(HOTELTORREDECALI);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #14");
		alert.setContentText("Usted seleccionó El Hotel Torre de Cali");
		alert.showAndWait();

	}

	@FXML
	void clickOnIglesiaLaErmita(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(LAERMITA);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #15");
		alert.setContentText("Usted seleccionó La Iglesia La Ermita");
		alert.showAndWait();


	}

	@FXML
	void clickOnJairoVarela(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(JAIROVARELA);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #32");
		alert.setContentText("Usted seleccionó La Plazoleta Jairo Varela");
		alert.showAndWait();

	}

	@FXML
	void clickOnJardinPlaza(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(JARDINPLAZA);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #42");
		alert.setContentText("Usted seleccionó el Centro Comercial Jardin Plaza");
		alert.showAndWait();

	}

	@FXML
	void clickOnLomaDeLaCruz(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(LOMADELACRUZ);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #18");
		alert.setContentText("Usted seleccionó La Loma de la Cruz");
		alert.showAndWait();

	}

	@FXML
	void clickOnMariaMulata(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(MONUMENTOALAMARIA);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #22");
		alert.setContentText("Usted seleccionó El Monumento a Maria Mulata");
		alert.showAndWait();

	}

	@FXML
	void clickOnMiradorTresCruces(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(MIRADORTRESCRUCES);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #19");
		alert.setContentText("Usted seleccionó El Mirador Tres Cruces");
		alert.showAndWait();

	}

	@FXML
	void clickOnMonumentoALaAviacion(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(MONUMENTOALAVIACION);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #20");
		alert.setContentText("Usted seleccionó El Monumento a la Aviación");
		alert.showAndWait();

	}

	@FXML
	void clickOnMonumentoALaSolidaridadEmpresarial(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(MONUMENTOALASOLIDARIDAD);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #21");
		alert.setContentText("Usted seleccionó El Monumento a la Solidaridad Empresarial");
		alert.showAndWait();
	}

	@FXML
	void clickOnMonumentoAlDeporte(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(MONUMENTOALDEPORTE);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #23");
		alert.setContentText("Usted seleccionó el Monumento al Deporte");
		alert.showAndWait();

	}

	@FXML
	void clickOnMuseoCienciasNaturales(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(MUSEODEPARTAMENTALCIENCIA);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #27");
		alert.setContentText("Usted seleccionó El Museo Departamental de Ciencias Naturales");
		alert.showAndWait();

	}

	@FXML
	void clickOnMuseoDelOroCalima(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(MUSEODELORO);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #26");
		alert.setContentText("Usted seleccionó El Museo del oro Camila");
		alert.showAndWait();

	}

	@FXML
	void clickOnMuseoLaMerced(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(MUSEOARQUEOLOGICO);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #24");
		alert.setContentText("Usted seleccionó El Museo Arqueologico La Merced");
		alert.showAndWait();
		

	}
	

	@FXML
	void clickOnParquedelasalud(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(PARQUEDELASALUD);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #28");
		alert.setContentText("Usted seleccionó El Parque de la Salud");
		alert.showAndWait();

	}

	@FXML
	void clickOnParquedelospoetas(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(PARQUEDELOSPOETAS);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #29");
		alert.setContentText("Usted seleccionó El Parque de los Poetas");
		alert.showAndWait();

	}

	@FXML
	void clickOnPascualGuerrero(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(PASCUALGUERRERO);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #11");
		alert.setContentText("Usted seleccionó El Estadio Olimpico Pascual Guerrero");
		alert.showAndWait();

	}

	@FXML
	void clickOnPlatillosVoladores(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(PLATILLOSVOLADORES);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #39");
		alert.setContentText("Usted seleccionó El Restaurante Platillos Voladores");
		alert.showAndWait();

	}

	@FXML
	void clickOnPlazaCaycedo(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(PLAZACAICEDO);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #30");
		alert.setContentText("Usted seleccionó La Plaza Caicedo");
		alert.showAndWait();
	}
	

	@FXML
	void clickOnPlazadeToros(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(PLAZADETOROS);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #31");
		alert.setContentText("Usted seleccionó La Plaza de Toros Cañaveralejo");
		alert.showAndWait();

	}

	@FXML
	void clickOnSanAntonio(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(IGLESIASANANTONIO);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #16");
		alert.setContentText("Usted seleccionó La Iglesia San Antonio");
		alert.showAndWait();

	}

	@FXML
	void clickOnSanFrancisco(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(IGLESIASANFRANCISCO);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #17");
		alert.setContentText("Usted seleccionó La Iglesia San Francisco");
		alert.showAndWait();

	}

	@FXML
	void clickOnSebastiandebelalcazaar(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(MONUMENTOASEBASTIAN);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #33");
		alert.setContentText("Usted seleccionó El Monumento de Sebastian de Belalcazar");
		alert.showAndWait();

	}

	@FXML
	void clickOnTeatroMunicipal(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(TEATROMUNICIPAL);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #34");
		alert.setContentText("Usted seleccionó El Teatro Municipal");
		alert.showAndWait();

	}

	@FXML
	void clickOnUnicentro(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(UNICENTRO);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #41");
		alert.setContentText("Usted seleccionó El Centro Comercial Unicentro");
		alert.showAndWait();

	}

	@FXML
	void clickOnUnidadDeportiva(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(UNIDADDEPORTIVA);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #10");
		alert.setContentText("Usted seleccionó La Unidad Deportiva Panamericana");
		alert.showAndWait();

	}

	@FXML
	void clickOnZoologicodeCali(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(ZOOLOGICODECALI);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #35");
		alert.setContentText("Usted seleccionó El Zoologico de Cali");
		alert.showAndWait();

	}

	@FXML
	void clickOnhotelDarnnCarlton(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(HOTELDARNNCARLTON);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #38");
		alert.setContentText("Usted seleccionó El Hotel Darrn Carlton");
		alert.showAndWait();

	}

	@FXML
	void clickOnmuseodelatertulia(MouseEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		f = new File(MUSEOTERTULIA);
		i = new Image(f.toURI().toString());
		imav = new ImageView(i);
		alert.setGraphic(imav);
		alert.setHeaderText("Lugar #25");
		alert.setContentText("Usted seleccionó El Museo de Arte Moderno La Tertulia");
		alert.showAndWait();

	}


}
