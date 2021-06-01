package ui;

import java.io.File;
import java.io.IOException;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DialogPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;
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
	private static String HOTELINTERNCONTINENTAL = "imagenes\\hotelintercontinental.jpg";
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
	private static String unicentro = "imagenes\\unicentro.jpeg";
	private static String UNIDADDEPORTIVA = "imagenes\\unidaddeportivapanamericana.png";
	private static String ZOOLOGICODECALI = "imagenes\\zoologicodecali.jpg";
	
	public economictravelGUI(TravelGuide t) {

		t=tg;
		
	}

	public void loadMainMenu() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Map.fxml"));
		fxmlLoader.setController(this);
		Parent mape = fxmlLoader.load();
		basePane.setCenter(mape);
		zoom(map);
		



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
		
		

	}

	@FXML
	void clickOnElPlanetario(MouseEvent event) {

	}

	@FXML
	void clickOnGobernaciondelValle(MouseEvent event) {

	}

	@FXML
	void clickOnHospitalUniversitario(MouseEvent event) {

	}

	@FXML
	void clickOnHotelIntercontinental(MouseEvent event) {

	}

	@FXML
	void clickOnHotelTorredeCali(MouseEvent event) {

	}

	@FXML
	void clickOnIglesiaLaErmita(MouseEvent event) {

	}

	@FXML
	void clickOnJairoVarela(MouseEvent event) {

	}

	@FXML
	void clickOnJardinPlaza(MouseEvent event) {

	}

	@FXML
	void clickOnLomaDeLaCruz(MouseEvent event) {

	}

	@FXML
	void clickOnMariaMulata(MouseEvent event) {

	}

	@FXML
	void clickOnMiradorTresCruces(MouseEvent event) {

	}

	@FXML
	void clickOnMonumentoALaAviacion(MouseEvent event) {

	}

	@FXML
	void clickOnMonumentoALaSolidaridadEmpresarial(MouseEvent event) {

	}

	@FXML
	void clickOnMonumentoAlDeporte(MouseEvent event) {

	}

	@FXML
	void clickOnMuseoCienciasNaturales(MouseEvent event) {

	}

	@FXML
	void clickOnMuseoDelOroCalima(MouseEvent event) {

	}

	@FXML
	void clickOnMuseoLaMerced(MouseEvent event) {

	}

	@FXML
	void clickOnParquedelasalud(MouseEvent event) {

	}

	@FXML
	void clickOnParquedelospoetas(MouseEvent event) {

	}

	@FXML
	void clickOnPascualGuerrero(MouseEvent event) {

	}

	@FXML
	void clickOnPlatillosVoladores(MouseEvent event) {

	}

	@FXML
	void clickOnPlazaCaycedo(MouseEvent event) {

	}

	@FXML
	void clickOnPlazadeToros(MouseEvent event) {

	}

	@FXML
	void clickOnSanAntonio(MouseEvent event) {

	}

	@FXML
	void clickOnSanFrancisco(MouseEvent event) {

	}

	@FXML
	void clickOnSebastiandebelalcazaar(MouseEvent event) {

	}

	@FXML
	void clickOnTeatroMunicipal(MouseEvent event) {

	}

	@FXML
	void clickOnUnicentro(MouseEvent event) {

	}

	@FXML
	void clickOnUnidadDeportiva(MouseEvent event) {

	}

	@FXML
	void clickOnZoologicodeCali(MouseEvent event) {

	}

	@FXML
	void clickOnhotelDarnnCarlton(MouseEvent event) {

	}

	@FXML
	void clickOnmuseodelatertulia(MouseEvent event) {

	}


}
