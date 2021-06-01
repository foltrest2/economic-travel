package ui;

import java.io.IOException;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
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

	}

	@FXML
	void clickOnAcuaparquedelaCaña(MouseEvent event) {

	}

	@FXML
	void clickOnBibliotecaJoseGarces(MouseEvent event) {

	}

	@FXML
	void clickOnBulevarDelRio(MouseEvent event) {

	}

	@FXML
	void clickOnCam(MouseEvent event) {

	}

	@FXML
	void clickOnCentroculturaldecali(MouseEvent event) {

	}

	@FXML
	void clickOnChipichape(MouseEvent event) {

	}

	@FXML
	void clickOnCristoRey(MouseEvent event) {

	}

	@FXML
	void clickOnElBochinche(MouseEvent event) {

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
